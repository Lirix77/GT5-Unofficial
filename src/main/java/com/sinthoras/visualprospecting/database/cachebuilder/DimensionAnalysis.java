package com.sinthoras.visualprospecting.database.cachebuilder;

import com.sinthoras.visualprospecting.Config;
import com.sinthoras.visualprospecting.Utils;
import com.sinthoras.visualprospecting.VP;
import com.sinthoras.visualprospecting.database.ServerCache;
import com.sinthoras.visualprospecting.database.veintypes.VeinType;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class DimensionAnalysis {

    public final int dimensionId;
    public final String dimensionName;

    public DimensionAnalysis(int dimensionId) {
        this.dimensionId = dimensionId;
        this.dimensionName = getDimensionName();
    }

    private interface IChunkHandler {

        void processChunk(NBTTagList root, int chunkX, int chunkZ);
    }

    public void processMinecraftWorld(Collection<File> regionFiles) {
        if (regionFiles.isEmpty()) return;
        final Map<Long, Integer> veinBlockY = new ConcurrentHashMap<>();
        final long dimensionSizeMB = regionFiles.stream().mapToLong(File::length).sum() >> 20;

        if (dimensionSizeMB <= Config.maxDimensionSizeMBForFastScanning) {
            com.sinthoras.visualprospecting.database.cachebuilder.AnalysisProgressTracker.announceFastDimension(dimensionId);
            com.sinthoras.visualprospecting.database.cachebuilder.AnalysisProgressTracker.setNumberOfRegionFiles(regionFiles.size());

            final Map<Long, com.sinthoras.visualprospecting.database.cachebuilder.DetailedChunkAnalysis> chunksForSecondIdentificationPass = new ConcurrentHashMap<>();

            regionFiles.parallelStream().forEach(regionFile -> {
                executeForEachGeneratedOreChunk(regionFile, (root, chunkX, chunkZ) -> {
                    final com.sinthoras.visualprospecting.database.cachebuilder.ChunkAnalysis chunk = new com.sinthoras.visualprospecting.database.cachebuilder.ChunkAnalysis(dimensionName);
                    chunk.processMinecraftChunk(root);

                    if (chunk.matchesSingleVein()) {
                        ServerCache.instance
                                .notifyOreVeinGeneration(dimensionId, chunkX, chunkZ, chunk.getMatchedVein());
                        veinBlockY.put(Utils.chunkCoordsToKey(chunkX, chunkZ), chunk.getVeinBlockY());
                    } else {
                        final com.sinthoras.visualprospecting.database.cachebuilder.DetailedChunkAnalysis detailedChunk = new com.sinthoras.visualprospecting.database.cachebuilder.DetailedChunkAnalysis(
                                dimensionId,
                                dimensionName,
                                chunkX,
                                chunkZ);
                        detailedChunk.processMinecraftChunk(root);
                        chunksForSecondIdentificationPass.put(Utils.chunkCoordsToKey(chunkX, chunkZ), detailedChunk);
                    }
                });
            });

            chunksForSecondIdentificationPass.values().parallelStream().forEach(chunk -> {
                chunk.cleanUpWithNeighbors(veinBlockY);
                ServerCache.instance
                        .notifyOreVeinGeneration(dimensionId, chunk.chunkX, chunk.chunkZ, chunk.getMatchedVein());
            });
        } else {
            com.sinthoras.visualprospecting.database.cachebuilder.AnalysisProgressTracker.announceSlowDimension(dimensionId);
            com.sinthoras.visualprospecting.database.cachebuilder.AnalysisProgressTracker.setNumberOfRegionFiles(regionFiles.size() * 2);

            regionFiles.parallelStream().forEach(regionFile -> {
                executeForEachGeneratedOreChunk(regionFile, (root, chunkX, chunkZ) -> {
                    final com.sinthoras.visualprospecting.database.cachebuilder.ChunkAnalysis chunk = new ChunkAnalysis(dimensionName);
                    chunk.processMinecraftChunk(root);

                    if (chunk.matchesSingleVein()) {
                        ServerCache.instance
                                .notifyOreVeinGeneration(dimensionId, chunkX, chunkZ, chunk.getMatchedVein());
                        veinBlockY.put(Utils.chunkCoordsToKey(chunkX, chunkZ), chunk.getVeinBlockY());
                    }
                });
            });

            regionFiles.parallelStream().forEach(regionFile -> {
                executeForEachGeneratedOreChunk(regionFile, (root, chunkX, chunkZ) -> {
                    if (ServerCache.instance.getOreVein(dimensionId, chunkX, chunkZ).veinType == VeinType.NO_VEIN) {
                        final com.sinthoras.visualprospecting.database.cachebuilder.DetailedChunkAnalysis detailedChunk = new DetailedChunkAnalysis(
                                dimensionId,
                                dimensionName,
                                chunkX,
                                chunkZ);
                        detailedChunk.processMinecraftChunk(root);
                        detailedChunk.cleanUpWithNeighbors(veinBlockY);
                        ServerCache.instance.notifyOreVeinGeneration(
                                dimensionId,
                                detailedChunk.chunkX,
                                detailedChunk.chunkZ,
                                detailedChunk.getMatchedVein());
                    }
                });
            });
        }
    }

    private void executeForEachGeneratedOreChunk(File regionFile, IChunkHandler chunkHandler) {
        try {
            if (!Pattern.matches("^r\\.-?\\d+\\.-?\\d+\\.mca$", regionFile.getName())) {
                VP.warn("Invalid region file found! " + regionFile.getCanonicalPath() + " continuing");
                return;
            }
            final String[] parts = regionFile.getName().split("\\.");
            final int regionChunkX = Integer.parseInt(parts[1]) << 5;
            final int regionChunkZ = Integer.parseInt(parts[2]) << 5;
            try (com.sinthoras.visualprospecting.database.cachebuilder.RegionReader region = new RegionReader(regionFile)) {
                for (int localChunkX = 0; localChunkX < VP.chunksPerRegionFileX; localChunkX++) {
                    for (int localChunkZ = 0; localChunkZ < VP.chunksPerRegionFileZ; localChunkZ++) {
                        final int chunkX = regionChunkX + localChunkX;
                        final int chunkZ = regionChunkZ + localChunkZ;

                        // Only process ore chunks
                        if (chunkX == Utils.mapToCenterOreChunkCoord(chunkX)
                                && chunkZ == Utils.mapToCenterOreChunkCoord(chunkZ)) {
                            final NBTTagList chunkTiles = region.getChunkTiles(localChunkX, localChunkZ);

                            if (chunkTiles != null) {
                                chunkHandler.processChunk(chunkTiles, chunkX, chunkZ);
                            }
                        }
                    }
                }
            }
            com.sinthoras.visualprospecting.database.cachebuilder.AnalysisProgressTracker.regionFileProcessed();
        } catch (DataFormatException | IOException e) {
            AnalysisProgressTracker.notifyCorruptFile(regionFile);
        }
    }

    private String getDimensionName() {
        WorldServer world = DimensionManager.getWorld(dimensionId);
        if (world == null) return "";
        WorldProvider provider = world.provider;
        return provider == null ? "" : provider.getDimensionName();
    }
}
