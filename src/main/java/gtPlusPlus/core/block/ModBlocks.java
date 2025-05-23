package gtPlusPlus.core.block;

import gtPlusPlus.core.block.machine.*;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;

import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.block.fuel.BlockCactusCharcoal;
import gtPlusPlus.core.block.fuel.BlockCactusCoke;
import gtPlusPlus.core.block.fuel.BlockSugarCharcoal;
import gtPlusPlus.core.block.fuel.BlockSugarCoke;
import gtPlusPlus.core.block.general.BlockCompressedObsidian;
import gtPlusPlus.core.block.general.BlockFluidTankInfinite;
import gtPlusPlus.core.block.general.BlockHellFire;
import gtPlusPlus.core.block.general.BlockLightGlass;
import gtPlusPlus.core.block.general.BlockMiningExplosives;
import gtPlusPlus.core.block.general.antigrief.BlockWitherProof;
import gtPlusPlus.core.fluids.FluidRegistryHandler;

public final class ModBlocks {

    public static Block blockCircuitProgrammer;
    public static Block blockVolumetricFlaskSetter;

    public static Block blockFishTrap;
    public static Block blockDecayablesChest;

    public static Block blockCasingsMisc;
    public static Block blockCasings2Misc;
    public static Block blockCasings3Misc;
    public static Block blockCasings4Misc;
    public static Block blockCasings5Misc;
    public static Block blockCasings6Misc;
    public static Block blockCasingsTieredGTPP;
    public static Block blockSpecialMultiCasings;
    public static Block blockSpecialMultiCasings2;
    public static Block blockCustomMachineCasings;
    public static Block blockCustomPipeGearCasings;

    public static Block MatterFabricatorEffectBlock;

    public static Fluid fluidSludge = new Fluid("fluid.sludge");
    public static Block blockFluidSludge;

    public static Block blockMiningExplosive;

    public static Block blockHellfire;
    public static Block blockInfiniteFLuidTank;
    public static Block blockProjectTable;
    public static Block blockWitherGuard;
    public static Block blockCompressedObsidian;

    public static Block blockCactusCharcoal;
    public static Block blockCactusCoke;
    public static Block blockSugarCharcoal;
    public static Block blockSugarCoke;

    public static Block blockCustomJukebox;

    public static Block blockPooCollector;

    public static Block blockPestKiller;

    public static void init() {
        Logger.INFO("Initializing Blocks.");

        registerBlocks();
    }

    public static void registerBlocks() {

        Logger.INFO("Registering Blocks.");
        MatterFabricatorEffectBlock = new BlockLightGlass(false);

        // Fluids
        FluidRegistryHandler.registerFluids();

        // Workbench
        blockFishTrap = new BlockFishTrap();
        blockInfiniteFLuidTank = new BlockFluidTankInfinite();
        blockMiningExplosive = new BlockMiningExplosives();
        blockHellfire = new BlockHellFire();
        blockProjectTable = new BlockProjectTable();
        blockWitherGuard = new BlockWitherProof();
        blockCompressedObsidian = new BlockCompressedObsidian();

        blockCactusCharcoal = new BlockCactusCharcoal();
        blockCactusCoke = new BlockCactusCoke();
        blockSugarCharcoal = new BlockSugarCharcoal();
        blockSugarCoke = new BlockSugarCoke();

        blockCircuitProgrammer = new BlockCircuitProgrammer();

        //blockDecayablesChest = new BlockDecayablesChest();

        blockCustomJukebox = new BlockSuperJukebox();

        blockPooCollector = new BlockPooCollector();

        blockPestKiller = new BlockPestKiller();

        blockVolumetricFlaskSetter = new BlockFlaskSetter();

    }
}
