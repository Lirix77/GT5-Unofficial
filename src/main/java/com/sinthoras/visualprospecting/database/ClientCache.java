package com.sinthoras.visualprospecting.database;

import com.sinthoras.visualprospecting.Config;
import com.sinthoras.visualprospecting.Tags;
import com.sinthoras.visualprospecting.Utils;
import com.sinthoras.visualprospecting.VP;
import com.sinthoras.visualprospecting.hooks.ProspectingNotificationEvent;
import com.sinthoras.visualprospecting.network.ProspectingRequest;
import gregtech.common.blocks.TileEntityOres;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static gregtech.GTMod.GT_FML_LOGGER;

public class ClientCache extends WorldCache {

    public static final ClientCache instance = new ClientCache();

    protected File getStorageDirectory() {
        final EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        return new File(
            Utils.getSubDirectory(Tags.CLIENT_DIR),
            player.getDisplayName() + "_" + player.getPersistentID().toString());
    }


    private void notifyNewOreVein(com.sinthoras.visualprospecting.database.OreVeinPosition oreVeinPosition) {
        final String location = "(" + (oreVeinPosition.getBlockX() + 8) + "," + (oreVeinPosition.getBlockZ() + 8) + ")";
        final IChatComponent veinNotification = new ChatComponentTranslation(
                "visualprospecting.vein.prospected",
                oreVeinPosition.veinType.getVeinName(),
                location);
        veinNotification.getChatStyle().setItalic(true);
        veinNotification.getChatStyle().setColor(EnumChatFormatting.GRAY);
        Minecraft.getMinecraft().thePlayer.addChatMessage(veinNotification);

        final String oreNames = String.join(", ", oreVeinPosition.veinType.getOreMaterialNames());
        final IChatComponent oresNotification = new ChatComponentTranslation(
                "visualprospecting.vein.contents",
                oreNames);
        oresNotification.getChatStyle().setItalic(true);
        oresNotification.getChatStyle().setColor(EnumChatFormatting.GRAY);
        Minecraft.getMinecraft().thePlayer.addChatMessage(oresNotification);
    }

    public void putOreVeins(List<com.sinthoras.visualprospecting.database.OreVeinPosition> oreVeinPositions) {
        if (oreVeinPositions.size() == 1) {
            final com.sinthoras.visualprospecting.database.OreVeinPosition oreVeinPosition = oreVeinPositions.get(0);
            if (putOreVein(oreVeinPosition) != com.sinthoras.visualprospecting.database.DimensionCache.UpdateResult.AlreadyKnown) {
                MinecraftForge.EVENT_BUS.post(new ProspectingNotificationEvent.OreVein(oreVeinPosition));
                notifyNewOreVein(oreVeinPosition);
            }
        } else if (oreVeinPositions.size() > 1) {
            int newOreVeins = 0;
            for (com.sinthoras.visualprospecting.database.OreVeinPosition oreVeinPosition : oreVeinPositions) {
                if (putOreVein(oreVeinPosition) != com.sinthoras.visualprospecting.database.DimensionCache.UpdateResult.AlreadyKnown) {
                    MinecraftForge.EVENT_BUS.post(new ProspectingNotificationEvent.OreVein(oreVeinPosition));
                    newOreVeins++;
                }
            }
            if (newOreVeins > 0) {
                final IChatComponent oreVeinNotification = new ChatComponentTranslation(
                        "visualprospecting.veins.prospected",
                        newOreVeins);
                oreVeinNotification.getChatStyle().setItalic(true);
                oreVeinNotification.getChatStyle().setColor(EnumChatFormatting.GRAY);
                Minecraft.getMinecraft().thePlayer.addChatMessage(oreVeinNotification);
            }
        }
    }

    public void toggleOreVein(int dimensionId, int chunkX, int chunkZ) {
        super.toggleOreVein(dimensionId, chunkX, chunkZ);
    }

    public void putUndergroundFluids(List<com.sinthoras.visualprospecting.database.UndergroundFluidPosition> undergroundFluids) {
        int newUndergroundFluids = 0;
        int updatedUndergroundFluids = 0;
        for (com.sinthoras.visualprospecting.database.UndergroundFluidPosition undergroundFluidPosition : undergroundFluids) {
            com.sinthoras.visualprospecting.database.DimensionCache.UpdateResult updateResult = putUndergroundFluids(undergroundFluidPosition);
            if (updateResult == com.sinthoras.visualprospecting.database.DimensionCache.UpdateResult.New) {
                MinecraftForge.EVENT_BUS
                        .post(new ProspectingNotificationEvent.UndergroundFluid(undergroundFluidPosition));
                newUndergroundFluids++;
            } else if (updateResult == com.sinthoras.visualprospecting.database.DimensionCache.UpdateResult.Updated) {
                MinecraftForge.EVENT_BUS
                        .post(new ProspectingNotificationEvent.UndergroundFluid(undergroundFluidPosition));
                updatedUndergroundFluids++;
            }
        }

        IChatComponent undergroundFluidsNotification = null;
        if (newUndergroundFluids > 0 && updatedUndergroundFluids > 0) {
            undergroundFluidsNotification = new ChatComponentTranslation(
                    "visualprospecting.undergroundfluid.prospected.newandupdated",
                    newUndergroundFluids,
                    updatedUndergroundFluids);
        } else {
            if (newUndergroundFluids > 0) {
                undergroundFluidsNotification = new ChatComponentTranslation(
                        "visualprospecting.undergroundfluid.prospected.onlynew",
                        newUndergroundFluids);
            }
            if (updatedUndergroundFluids > 0) {
                undergroundFluidsNotification = new ChatComponentTranslation(
                        "visualprospecting.undergroundfluid.prospected.onlyupdated",
                        updatedUndergroundFluids);
            }
        }

        if (undergroundFluidsNotification == null) return;
        undergroundFluidsNotification.getChatStyle().setItalic(true).setColor(EnumChatFormatting.GRAY);
        Minecraft.getMinecraft().thePlayer.addChatMessage(undergroundFluidsNotification);
    }

    public void onOreInteracted(World world, int blockX, int blockY, int blockZ, EntityPlayer entityPlayer) {
        if (world.isRemote && Config.enableProspecting && Minecraft.getMinecraft().thePlayer == entityPlayer) {
            final TileEntity tTileEntity = world.getTileEntity(blockX, blockY, blockZ);
            if (tTileEntity instanceof TileEntityOres ore) {
                final short oreMetaData = ore.mMetaData;
                if (!Utils.isSmallOreId(oreMetaData) && oreMetaData != 0) {
                    final int chunkX = Utils.coordBlockToChunk(blockX);
                    final int chunkZ = Utils.coordBlockToChunk(blockZ);
                    final com.sinthoras.visualprospecting.database.OreVeinPosition oreVeinPosition = getOreVein(entityPlayer.dimension, chunkX, chunkZ);
                    final short materialId = Utils.oreIdToMaterialId(oreMetaData);
                    if (!oreVeinPosition.veinType.containsOre(materialId) && ProspectingRequest.canSendRequest()) {
                        VP.network.sendToServer(
                                new ProspectingRequest(entityPlayer.dimension, blockX, blockY, blockZ, materialId));
                    }
                }
            }
        }
    }

    public void resetPlayerProgression() {
        Utils.deleteDirectoryRecursively(worldCache);
        // noinspection ResultOfMethodCallIgnored
        worldCache.mkdirs();
        reset();
    }

    public List<com.sinthoras.visualprospecting.database.OreVeinPosition> getAllOreVeins() {
        List<OreVeinPosition> allOreVeins = new ArrayList<>();
        for (com.sinthoras.visualprospecting.database.DimensionCache dimension : dimensions.values()) {
            allOreVeins.addAll(dimension.getAllOreVeins());
        }
        return allOreVeins;
    }

    public List<com.sinthoras.visualprospecting.database.UndergroundFluidPosition> getAllUndergroundFluids() {
        List<UndergroundFluidPosition> allUndergroundFluids = new ArrayList<>();
        for (DimensionCache dimension : dimensions.values()) {
            allUndergroundFluids.addAll(dimension.getAllUndergroundFluids());
        }
        return allUndergroundFluids;
    }

    private static void convertOldCache(File oldCache, File newCache) {
        if (!oldCache.exists()) return;
        File[] files = oldCache.listFiles();
        if (files != null && files.length > 0 && newCache.exists()) {
            for (File file : files) {
                if (!file.isDirectory()) continue;
                try {
                    FileUtils.copyDirectoryToDirectory(file, newCache);
                } catch (IOException ignored) {}
            }
            Utils.deleteDirectoryRecursively(oldCache);
        } else {
            // noinspection ResultOfMethodCallIgnored
            oldCache.renameTo(newCache);
        }
    }
}
