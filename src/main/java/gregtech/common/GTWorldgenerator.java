package gregtech.common;

import static gregtech.api.enums.GTValues.debugOrevein;
import static gregtech.api.enums.GTValues.debugWorldGen;
import static gregtech.api.enums.GTValues.oreveinAttempts;
import static gregtech.api.enums.GTValues.oreveinMaxPlacementAttempts;
import static gregtech.api.enums.GTValues.oreveinPercentage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import galacticgreg.GalacticGreg;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.world.WorldEvent;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.net.GTPacketSendOregenPattern;
import gregtech.api.objects.XSTR;
import gregtech.api.util.GTLog;
import gregtech.api.world.GTWorldgen;
import gregtech.common.blocks.TileEntityOres;
import gregtech.common.config.Worldgen;

public class GTWorldgenerator implements IWorldGenerator {

    private static int mEndAsteroidProbability = 300;
    private static int mSize = 100;
    private static int endMinSize = 50;
    private static int endMaxSize = 200;
    private static boolean endAsteroids = true;
    public static List<Runnable> mList = new ArrayList<>();
    public static HashSet<Long> ProcChunks = new HashSet<>();
    // This is probably not going to work. Trying to create a fake orevein to put into hashtable when there will be no
    // ores in a vein.
    public static WorldgenGTOreLayer noOresInVein = new WorldgenGTOreLayer(
        new OreMixBuilder().name("NoOresInVein")
            .disabledByDefault()
            .heightRange(0, 255)
            .weight(0)
            .density(255)
            .size(16)
            .primary(Materials.Aluminium)
            .secondary(Materials.Aluminium)
            .inBetween(Materials.Aluminium)
            .sporadic(Materials.Aluminium));

    public static Hashtable<Long, WorldgenGTOreLayer> validOreveins = new Hashtable<>(1024);
    public boolean mIsGenerating = false;
    public static final Object listLock = new Object();
    public static OregenPattern oregenPattern = OregenPattern.AXISSYMMETRICAL;

    public GTWorldgenerator() {
        endAsteroids = Worldgen.endAsteroids.generateEndAsteroids;
        endMinSize = Worldgen.endAsteroids.EndAsteroidMinSize;
        endMaxSize = Worldgen.endAsteroids.EndAsteroidMaxSize;
        mEndAsteroidProbability = Worldgen.endAsteroids.EndAsteroidProbability;
        GameRegistry.registerWorldGenerator(this, 1073741823);
        if (debugWorldGen) {
            GTLog.out.println("GTWorldgenerator created");
        }
    }

    @Override
    public void generate(Random aRandom, int aX, int aZ, World aWorld, IChunkProvider aChunkGenerator,
        IChunkProvider aChunkProvider) {
        GalacticGreg.Logger
            .trace("Triggered generate GT Main: [ChunkGenerator %s]", aChunkGenerator.toString());
        synchronized (listLock) {
            mList.add(
                new WorldGenContainer(
                    new XSTR(Math.abs(aRandom.nextInt()) + 1),
                    aX,
                    aZ,
                    aWorld.provider.dimensionId,
                    aWorld,
                    aChunkGenerator,
                    aChunkProvider,
                    aWorld.getBiomeGenForCoords(aX * 16 + 8, aZ * 16 + 8).biomeName));
            if (debugWorldGen) GTLog.out.println(
                "ADD WorldSeed:" + aWorld.getSeed()
                    + " DimId"
                    + aWorld.provider.dimensionId
                    + " chunk x:"
                    + aX
                    + " z:"
                    + aZ
                    + " SIZE: "
                    + mList.size());
        }

        if (!this.mIsGenerating) {
            this.mIsGenerating = true;
            int mList_sS = mList.size();
            mList_sS = Math.min(mList_sS, 5); // Run a maximum of 5 chunks at a time through worldgen. Extra chunks get
                                              // done later.
            for (int i = 0; i < mList_sS; i++) {
                WorldGenContainer toRun = (WorldGenContainer) mList.get(0);
                if (debugWorldGen) GTLog.out.println(
                    "RUN WorldSeed:" + aWorld.getSeed()
                        + " DimId"
                        + aWorld.provider.dimensionId
                        + " chunk x:"
                        + toRun.mX
                        + " z:"
                        + toRun.mZ
                        + " SIZE: "
                        + mList.size()
                        + " i: "
                        + i);
                synchronized (listLock) {
                    mList.remove(0);
                }
                toRun.run();
            }
            this.mIsGenerating = false;
        }
    }

    public static boolean isOreChunk(int chunkX, int chunkZ) {
        if (oregenPattern == OregenPattern.EQUAL_SPACING) {
            return Math.floorMod(chunkX, 3) == 1 && Math.floorMod(chunkZ, 3) == 1;
        }
        // add next if statement here or convert to switch when expanding OregenPattern enum

        // AXISSYMMETRICAL
        return Math.abs(chunkX) % 3 == 1 && Math.abs(chunkZ) % 3 == 1;
    }

    public static class OregenPatternSavedData extends WorldSavedData {

        private static final String NAME = "GregTech_OregenPattern";
        private static final String KEY = "oregenPattern";

        public OregenPatternSavedData(String p_i2141_1_) {
            super(p_i2141_1_);
        }

        public static void loadData(World world) {
            if (world.getWorldInfo()
                .getWorldTotalTime() == 0L) {
                // The world has just been created -> use newest pattern
                oregenPattern = OregenPattern.values()[OregenPattern.values().length - 1];
            } else {
                // This is an old world. Use legacy pattern for now, readFromNBT may change this if
                // GregTech_OregenPattern.dat is present
                oregenPattern = OregenPattern.AXISSYMMETRICAL;
            }

            // load OregenPatternSavedData
            WorldSavedData instance = world.mapStorage
                .loadData(OregenPatternSavedData.class, OregenPatternSavedData.NAME);
            if (instance == null) {
                instance = new OregenPatternSavedData(NAME);
                world.mapStorage.setData(OregenPatternSavedData.NAME, instance);
            }
            instance.markDirty();
        }

        @SubscribeEvent
        public void onWorldLoad(WorldEvent.Load event) {
            final World world = event.world;
            if (!world.isRemote && world.provider.dimensionId == 0) {
                loadData(world);
            }
        }

        @SubscribeEvent
        public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            if (event.player instanceof EntityPlayerMP player) {
                GTValues.NW.sendToPlayer(new GTPacketSendOregenPattern(oregenPattern), player);
            }
        }

        @Override
        public void readFromNBT(NBTTagCompound p_76184_1_) {
            if (p_76184_1_.hasKey(KEY)) {
                int ordinal = p_76184_1_.getByte(KEY);
                ordinal = MathHelper.clamp_int(ordinal, 0, OregenPattern.values().length - 1);
                oregenPattern = OregenPattern.values()[ordinal];
            }
        }

        @Override
        public void writeToNBT(NBTTagCompound p_76187_1_) {
            // If we have so many different OregenPatterns that byte isn't good enough something is wrong
            p_76187_1_.setByte(KEY, (byte) oregenPattern.ordinal());
        }

    }

    public enum OregenPattern {
        // The last value is used when creating a new world
        AXISSYMMETRICAL,
        EQUAL_SPACING
    }

    public static class WorldGenContainer implements Runnable {

        public final Random mRandom;
        public final int mX;
        public final int mZ;
        public final int mDimensionType;
        public final World mWorld;
        public final IChunkProvider mChunkGenerator;
        public final IChunkProvider mChunkProvider;
        public final String mBiome;
        // Used for outputting orevein weights and bins
        // static int test=0;

        // Local class to track which orevein seeds must be checked when doing chunkified worldgen
        static class NearbySeeds {

            public int mX;
            public int mZ;

            NearbySeeds(int x, int z) {
                this.mX = x;
                this.mZ = z;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof NearbySeeds that)) return false;
                if (this.mX != that.mX) return false;
                return this.mZ == that.mZ;
            }

            @Override
            public int hashCode() {
                int result = this.mX;
                result = 31 * result + this.mZ;
                return result;
            }
        }

        public static ArrayList<GTWorldgenerator.WorldGenContainer.NearbySeeds> seedList = new ArrayList<>();

        // aX and aZ are now the by-chunk X and Z for the chunk of interest
        public WorldGenContainer(Random aRandom, int aX, int aZ, int aDimensionType, World aWorld,
            IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider, String aBiome) {
            this.mRandom = aRandom;
            this.mX = aX;
            this.mZ = aZ;
            this.mDimensionType = aDimensionType;
            this.mWorld = aWorld;
            this.mChunkGenerator = aChunkGenerator;
            this.mChunkProvider = aChunkProvider;
            this.mBiome = aBiome;
        }

        // How to evaluate oregen distribution
        // - Enable debugOreveins
        // - Fly around for a while, or teleport jumping ~320 blocks at a time, with
        // a 15-30s pause for worldgen to catch up
        // - Do this across a large area, at least 2000x2000 blocks for good numbers
        // - Open logs\gregtech.log
        // - Using notepad++, do a Search | Find - enter "Added" for the search term
        // - Select Find All In Current Document
        // - In the Search window, right-click and Select All
        // - Copy and paste to a new file
        // - Delete extraneous stuff at top, and blank line at bottom. Line count is
        // # of total oreveins
        // - For simple spot checks, use Find All in Current Document for specific
        // oremixes, ie ore.mix.diamond, to check how many appear in the list.
        // - For more complex work, import file into Excel, and sort based on oremix
        // column. Drag select the oremix names, in the bottom right will be how many
        // entries to add in a seperate tab to calculate %ages.
        //
        // When using the ore weights, discount or remove the high altitude veins since
        // their high weight are offset by their rareness. I usually just use zero for them.
        // Actual spawn rates will vary based upon the average height of the stone layers
        // in the dimension. For example veins that range above and below the average height
        // will be less, and veins that are completely above the average height will be much less.

        public void worldGenFindVein(int oreseedX, int oreseedZ) {
            // Explanation of oreveinseed implementation.
            // (long)this.mWorld.getSeed()<<16) Deep Dark does two oregen passes, one with getSeed set to +1 the
            // original world seed. This pushes that +1 off the low bits of oreseedZ, so that the hashes are far apart
            // for the two passes.
            // ((this.mWorld.provider.dimensionId & 0xffL)<<56) Puts the dimension in the top bits of the hash, to
            // make sure to get unique hashes per dimension
            // ((long)oreseedX & 0x000000000fffffffL) << 28) Puts the chunk X in the bits 29-55. Cuts off the top few
            // bits of the chunk so we have bits for dimension.
            // ( (long)oreseedZ & 0x000000000fffffffL )) Puts the chunk Z in the bits 0-27. Cuts off the top few bits
            // of the chunk so we have bits for dimension.
            long oreveinSeed = (this.mWorld.getSeed() << 16)
                ^ (((this.mWorld.provider.dimensionId & 0xffL) << 56) | (((long) oreseedX & 0x000000000fffffffL) << 28)
                    | ((long) oreseedZ & 0x000000000fffffffL)); // Use an RNG that is identical every time it is
                                                                // called for
            // this oreseed.
            XSTR oreveinRNG = new XSTR(oreveinSeed);
            int oreveinPercentageRoll = oreveinRNG.nextInt(100); // Roll the dice, see if we get an orevein here at all
            int noOrePlacedCount = 0;
            String tDimensionName = "";
            if (debugOrevein) {
                tDimensionName = this.mWorld.provider.getDimensionName();
            }

            if (debugOrevein) GTLog.out.println(
                " Finding oreveins for oreveinSeed=" + oreveinSeed
                    + " mX="
                    + this.mX
                    + " mZ="
                    + this.mZ
                    + " oreseedX="
                    + oreseedX
                    + " oreseedZ="
                    + oreseedZ
                    + " worldSeed="
                    + this.mWorld.getSeed());

            // Search for a valid orevein for this dimension
            if (!validOreveins.containsKey(oreveinSeed)) {
                if ((oreveinPercentageRoll < oreveinPercentage) && (WorldgenGTOreLayer.sWeight > 0)
                    && (!WorldgenGTOreLayer.sList.isEmpty())) {
                    int placementAttempts = 0;
                    boolean oreveinFound = false;
                    int i;

                    // Used for outputting orevein weights and bins
                    /*
                     * if( test==0 ) { test = 1; GTLog.out.println( "sWeight = " + GT_Worldgen_GT_Ore_Layer.sWeight );
                     * for (GT_Worldgen_GT_Ore_Layer tWorldGen : GT_Worldgen_GT_Ore_Layer.sList) { GTLog.out.println( (
                     * tWorldGen).mWorldGenName + " mWeight = " + ( tWorldGen).mWeight + " mSize = " + (tWorldGen).mSize
                     * ); } }
                     */
                    for (i = 0; (i < oreveinAttempts) && (!oreveinFound)
                        && (placementAttempts < oreveinMaxPlacementAttempts); i++) {
                        int tRandomWeight = oreveinRNG.nextInt(WorldgenGTOreLayer.sWeight);
                        for (WorldgenGTOreLayer tWorldGen : WorldgenGTOreLayer.sList) {
                            tRandomWeight -= (tWorldGen).mWeight;
                            if (tRandomWeight <= 0) {
                                try {
                                    // Adjust the seed so that this layer has a series of unique random numbers.
                                    // Otherwise multiple attempts at this same oreseed will get the same offset and X/Z
                                    // values. If an orevein failed, any orevein with the
                                    // same minimum heights would fail as well. This prevents that, giving each orevein
                                    // a unique height each pass through here.
                                    int placementResult = tWorldGen.executeWorldgenChunkified(
                                        this.mWorld,
                                        new XSTR(oreveinSeed ^ (tWorldGen.mPrimaryMeta)),
                                        this.mBiome,
                                        this.mDimensionType,
                                        this.mX * 16,
                                        this.mZ * 16,
                                        oreseedX * 16,
                                        oreseedZ * 16,
                                        this.mChunkGenerator,
                                        this.mChunkProvider);
                                    switch (placementResult) {
                                        case WorldgenGTOreLayer.ORE_PLACED -> {
                                            if (debugOrevein) GTLog.out.println(
                                                " Added near oreveinSeed=" + oreveinSeed
                                                    + " "
                                                    + (tWorldGen).mWorldGenName
                                                    + " tries at oremix="
                                                    + i
                                                    + " placementAttempts="
                                                    + placementAttempts
                                                    + " dimensionName="
                                                    + tDimensionName);
                                            validOreveins.put(oreveinSeed, tWorldGen);
                                            oreveinFound = true;
                                        }
                                        case WorldgenGTOreLayer.NO_ORE_IN_BOTTOM_LAYER -> placementAttempts++;

                                        // SHould do retry in this case until out of chances
                                        case WorldgenGTOreLayer.NO_OVERLAP -> {
                                            if (debugOrevein) GTLog.out.println(
                                                " Added far oreveinSeed=" + oreveinSeed
                                                    + " "
                                                    + (tWorldGen).mWorldGenName
                                                    + " tries at oremix="
                                                    + i
                                                    + " placementAttempts="
                                                    + placementAttempts
                                                    + " dimensionName="
                                                    + tDimensionName);
                                            validOreveins.put(oreveinSeed, tWorldGen);
                                            oreveinFound = true;
                                        }
                                        case WorldgenGTOreLayer.NO_OVERLAP_AIR_BLOCK -> {
                                            if (debugOrevein) GTLog.out.println(
                                                " No overlap and air block in test spot=" + oreveinSeed
                                                    + " "
                                                    + (tWorldGen).mWorldGenName
                                                    + " tries at oremix="
                                                    + i
                                                    + " placementAttempts="
                                                    + placementAttempts
                                                    + " dimensionName="
                                                    + tDimensionName);
                                            // SHould do retry in this case until out of chances
                                            placementAttempts++;
                                        }
                                    }
                                    break; // Try the next orevein
                                } catch (Throwable e) {
                                    if (debugOrevein) GTLog.out.println(
                                        "Exception occurred on oreVein" + tWorldGen
                                            + " oreveinSeed="
                                            + oreveinSeed
                                            + " mX="
                                            + this.mX
                                            + " mZ="
                                            + this.mZ
                                            + " oreseedX="
                                            + oreseedX
                                            + " oreseedZ="
                                            + oreseedZ);
                                    e.printStackTrace(GTLog.err);
                                }
                            }
                        }
                    }
                    // Only add an empty orevein if unable to place a vein at the oreseed chunk.
                    if ((!oreveinFound) && (this.mX == oreseedX) && (this.mZ == oreseedZ)) {
                        if (debugOrevein) GTLog.out.println(
                            " Empty oreveinSeed=" + oreveinSeed
                                + " mX="
                                + this.mX
                                + " mZ="
                                + this.mZ
                                + " oreseedX="
                                + oreseedX
                                + " oreseedZ="
                                + oreseedZ
                                + " tries at oremix="
                                + i
                                + " placementAttempts="
                                + placementAttempts
                                + " dimensionName="
                                + tDimensionName);
                        validOreveins.put(oreveinSeed, noOresInVein);
                    }
                } else if (oreveinPercentageRoll >= oreveinPercentage) {
                    if (debugOrevein) GTLog.out.println(
                        " Skipped oreveinSeed=" + oreveinSeed
                            + " mX="
                            + this.mX
                            + " mZ="
                            + this.mZ
                            + " oreseedX="
                            + oreseedX
                            + " oreseedZ="
                            + oreseedZ
                            + " RNG="
                            + oreveinPercentageRoll
                            + " %="
                            + oreveinPercentage
                            + " dimensionName="
                            + tDimensionName);
                    validOreveins.put(oreveinSeed, noOresInVein);
                }
            } else {
                // oreseed is located in the previously processed table
                if (debugOrevein) GTLog.out
                    .print(" Valid oreveinSeed=" + oreveinSeed + " validOreveins.size()=" + validOreveins.size() + " ");
                WorldgenGTOreLayer tWorldGen = validOreveins.get(oreveinSeed);
                oreveinRNG.setSeed(oreveinSeed ^ (tWorldGen.mPrimaryMeta)); // Reset RNG to only be based on oreseed X/Z
                                                                            // and type of vein
                int placementResult = tWorldGen.executeWorldgenChunkified(
                    this.mWorld,
                    oreveinRNG,
                    this.mBiome,
                    this.mDimensionType,
                    this.mX * 16,
                    this.mZ * 16,
                    oreseedX * 16,
                    oreseedZ * 16,
                    this.mChunkGenerator,
                    this.mChunkProvider);
                switch (placementResult) {
                    case WorldgenGTOreLayer.NO_ORE_IN_BOTTOM_LAYER -> {
                        if (debugOrevein) GTLog.out.println(" No ore in bottom layer");
                    }
                    case WorldgenGTOreLayer.NO_OVERLAP -> {
                        if (debugOrevein) GTLog.out.println(" No overlap");
                    }
                }
            }
        }

        @Override
        public void run() {
            long startTime = System.nanoTime();
            Chunk tChunk = this.mWorld.getChunkFromChunkCoords(this.mX, this.mZ);

            int oreveinMaxSize;

            // Do GT_Stones and GT_small_ores oregen for this chunk
            try {
                for (GTWorldgen tWorldGen : GregTechAPI.sWorldgenList) {
                    /*
                     * if (debugWorldGen) GTLog.out.println( "tWorldGen.mWorldGenName="+tWorldGen.mWorldGenName );
                     */
                    tWorldGen.executeWorldgen(
                        this.mWorld,
                        this.mRandom,
                        this.mBiome,
                        this.mDimensionType,
                        this.mX * 16,
                        this.mZ * 16,
                        this.mChunkGenerator,
                        this.mChunkProvider);
                }
            } catch (Throwable e) {
                e.printStackTrace(GTLog.err);
            }
            long leftOverTime = System.nanoTime();

            // Determine bounding box on how far out to check for oreveins affecting this chunk
            // For now, manually reducing oreveinMaxSize when not in the Underdark for performance
            if (this.mWorld.provider.getDimensionName()
                .equals("Underdark")) {
                oreveinMaxSize = 32; // Leave Deep Dark/Underdark max oregen at 32, instead of 64
            } else {
                oreveinMaxSize = 32;
            }

            int wXbox = this.mX - (oreveinMaxSize / 16);
            int eXbox = this.mX + (oreveinMaxSize / 16 + 1); // Need to add 1 since it is compared using a <
            int nZbox = this.mZ - (oreveinMaxSize / 16);
            int sZbox = this.mZ + (oreveinMaxSize / 16 + 1);

            // Search for orevein seeds and add to the list;
            for (int x = wXbox; x < eXbox; x++) {
                for (int z = nZbox; z < sZbox; z++) {
                    // Determine if this X/Z is an orevein seed
                    if (isOreChunk(x, z)) {
                        if (debugWorldGen) GTLog.out.println("Adding seed x=" + x + " z=" + z);
                        seedList.add(new NearbySeeds(x, z));
                    }
                }
            }

            // Now process each oreseed vs this requested chunk
            for (; !seedList.isEmpty(); seedList.remove(0)) {
                if (debugWorldGen)
                    GTLog.out.println("Processing seed x=" + seedList.get(0).mX + " z=" + seedList.get(0).mZ);
                worldGenFindVein(seedList.get(0).mX, seedList.get(0).mZ);
            }

            long oregenTime = System.nanoTime();

            // Asteroid Worldgen
            int tDimensionType = this.mWorld.provider.dimensionId;
            // String tDimensionName = this.mWorld.provider.getDimensionName();
            // if (((tDimensionType == 1) && endAsteroids && ((mEndAsteroidProbability <= 1) ||
            // (aRandom.nextInt(mEndAsteroidProbability) == 0))) || ((tDimensionName.equals("Asteroids")) && gcAsteroids
            // && ((mGCAsteroidProbability <= 1) || (aRandom.nextInt(mGCAsteroidProbability) == 0)))) {
            if ((tDimensionType == 1 /* the end */) && endAsteroids) {
                XSTR random = new XSTR(
                    mWorld.getSeed() + mX * mX * 91777L + mZ * mZ * 137413L + mX * mZ * 1853L + mX * 3L + mZ * 17L);

                if (mEndAsteroidProbability <= 1 || random.nextInt(mEndAsteroidProbability) == 0) {
                    generateAsteroid(mWorld, random, mX, mZ);
                }
            }

            if (tChunk != null) {
                tChunk.isModified = true;
            }
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            if (debugWorldGen) {
                GTLog.out.println(
                    " Oregen took " + (oregenTime - leftOverTime)
                        + " Leftover gen took "
                        + (leftOverTime - startTime)
                        + " Worldgen took "
                        + duration
                        + " nanoseconds");
            }
        }

        private void generateAsteroid(World world, Random random, int chunkX, int chunkZ) {
            short primaryMeta = 0;
            short secondaryMeta = 0;
            short betweenMeta = 0;
            short sporadicMeta = 0;
            if ((WorldgenGTOreLayer.sWeight > 0) && (!WorldgenGTOreLayer.sList.isEmpty())) {
                boolean temp = true;
                int tRandomWeight;
                for (int i = 0; (i < oreveinAttempts) && (temp); i++) {
                    tRandomWeight = random.nextInt(WorldgenGTOreLayer.sWeight);
                    for (WorldgenGTOreLayer tWorldGen : WorldgenGTOreLayer.sList) {
                        tRandomWeight -= tWorldGen.mWeight;
                        if (tRandomWeight <= 0) {
                            try {
                                if (tWorldGen.mEndAsteroid) {
                                    primaryMeta = tWorldGen.mPrimaryMeta;
                                    secondaryMeta = tWorldGen.mSecondaryMeta;
                                    betweenMeta = tWorldGen.mBetweenMeta;
                                    sporadicMeta = tWorldGen.mSporadicMeta;
                                    temp = false;
                                    break;
                                }
                            } catch (Throwable e) {
                                e.printStackTrace(GTLog.err);
                            }
                        }
                    }
                }
            }
            // if(GT_Values.D1)GT_FML_LOGGER.info("do asteroid gen: "+this.mX+" "+this.mZ);
            int tX = chunkX * 16 + random.nextInt(16);
            int tY = 50 + random.nextInt(200 - 50);
            int tZ = chunkZ * 16 + random.nextInt(16);
            mSize = endMinSize + random.nextInt(endMaxSize - endMinSize + 1);

            if ((world.getBlock(tX, tY, tZ)
                .isAir(world, tX, tY, tZ))) {
                float randomRadian = random.nextFloat() * (float) Math.PI;
                double xBase = tX + 8 + MathHelper.sin(randomRadian) * mSize / 8.0F;
                double xFactor = tX + 8 - MathHelper.sin(randomRadian) * mSize / 8.0F;
                double zBase = tZ + 8 + MathHelper.cos(randomRadian) * mSize / 8.0F;
                double zFactor = tZ + 8 - MathHelper.cos(randomRadian) * mSize / 8.0F;
                double yBase = tY + random.nextInt(3) - 2;
                double yFactor = tY + random.nextInt(3) - 2;

                for (int i = 0; i <= mSize; i++) {
                    double xCenter = xBase + (xFactor - xBase) * i / mSize;
                    double yCenter = yBase + (yFactor - yBase) * i / mSize;
                    double zCenter = zBase + (zFactor - zBase) * i / mSize;
                    double randomDistance = random.nextDouble() * mSize / 16.0D;
                    double halfLength = (MathHelper.sin(i * (float) Math.PI / mSize) + 1.0F) * randomDistance + 1.0D;
                    double halfHeight = (MathHelper.sin(i * (float) Math.PI / mSize) + 1.0F) * randomDistance + 1.0D;
                    int tMinX = MathHelper.floor_double(xCenter - halfLength / 2.0D);
                    int tMinY = MathHelper.floor_double(yCenter - halfHeight / 2.0D);
                    int tMinZ = MathHelper.floor_double(zCenter - halfLength / 2.0D);
                    int tMaxX = MathHelper.floor_double(xCenter + halfLength / 2.0D);
                    int tMaxY = MathHelper.floor_double(yCenter + halfHeight / 2.0D);
                    int tMaxZ = MathHelper.floor_double(zCenter + halfLength / 2.0D);

                    for (int eX = tMinX; eX <= tMaxX; eX++) {
                        double xChance = (eX + 0.5D - xCenter) / (halfLength / 2.0D);
                        if (xChance * xChance < 1.0D) {
                            for (int eY = tMinY; eY <= tMaxY; eY++) {
                                double yChance = (eY + 0.5D - yCenter) / (halfHeight / 2.0D);
                                if (xChance * xChance + yChance * yChance < 1.0D) {
                                    for (int eZ = tMinZ; eZ <= tMaxZ; eZ++) {
                                        double zChance = (eZ + 0.5D - zCenter) / (halfLength / 2.0D);
                                        if (xChance * xChance + yChance * yChance + zChance * zChance >= 1.0D) {
                                            continue;
                                        }
                                        if (!world.getBlock(tX, tY, tZ)
                                            .isAir(world, tX, tY, tZ)) {
                                            continue;
                                        }
                                        int ranOre = random.nextInt(50);
                                        if (ranOre < 3) {
                                            TileEntityOres.setOreBlock(world, eX, eY, eZ, primaryMeta, false);
                                        } else if (ranOre < 6) {
                                            TileEntityOres.setOreBlock(world, eX, eY, eZ, secondaryMeta, false);
                                        } else if (ranOre < 8) {
                                            TileEntityOres.setOreBlock(world, eX, eY, eZ, betweenMeta, false);
                                        } else if (ranOre < 10) {
                                            TileEntityOres.setOreBlock(world, eX, eY, eZ, sporadicMeta, false);
                                        } else {
                                            world.setBlock(eX, eY, eZ, Blocks.end_stone, 0, 0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
