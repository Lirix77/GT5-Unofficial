package gregtech.loaders.postload.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class FluidSolidifierRecipes implements Runnable {

    @Override
    public void run() {
        if (Loader.isModLoaded("EnderIO")) {
            GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                Materials.Concrete.getMolten(36L),
                GT_ModHandler.getModItem("EnderIO", "itemMaterial", 1L, 1),
                20, 4);
        }
        GT_Values.RA.addFluidSolidifierRecipe(
            ItemList.Shape_Mold_Block.get(0L),
            Materials.ConstructionFoam.getFluid(800),
            Materials.ConstructionFoam.getBlocks(1),
            16, 4);
        GT_Values.RA.addFluidSolidifierRecipe(
            ItemList.Shape_Mold_Ball.get(0L),
            Materials.Sodium.getFluid(1000),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
            16, 4);

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                Materials.Glue.getFluid(144L),
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 36),
                100, 8);
            GT_Values.RA.addFluidSolidifierRecipe(
                GT_Utility.getIntegratedCircuit(1),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                GT_ModHandler.getModItem("TConstruct", "blankPattern", 1L, 1),
                32, 48);

            GT_Values.RA.addFluidSolidifierRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                Materials.Tin.getMolten(16L),
                GT_ModHandler.getModItem("TConstruct", "SpeedBlock", 1, 0),
                100, 30);
            GT_Values.RA.addFluidSolidifierRecipe(
                GT_ModHandler.getModItem("TConstruct", "largePlate", 1, 6),
                Materials.Steel.getMolten(288L),
                GT_ModHandler.getModItem("TConstruct", "materials", 1, 43),
                400, 120);
            if (Loader.isModLoaded("ExtraUtilities")) {
                GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1, 12),
                    Materials.Tin.getMolten(144L),
                    GT_ModHandler.getModItem("TConstruct", "SpeedBlock", 9, 0),
                    100, 120);
                GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1, 12),
                    Materials.Electrum.getMolten(48L),
                    GT_ModHandler.getModItem("TConstruct", "SpeedBlock", 9, 0),
                    100, 120);
            }
        }
    }
}
