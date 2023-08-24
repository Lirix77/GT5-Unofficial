package gregtech.loaders.postload.recipe;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;

public class FluidExtractorRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addFluidExtractionRecipe(
            ItemList.GalliumArsenideCrystal.get(1L),
            GT_Values.NI,
            Materials.GalliumArsenide.getMolten(144L),
            10000,
            24, 37);
        GT_Values.RA.addFluidExtractionRecipe(
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NI,
            Materials.Air.getGas(2000L),
            10000,
            30, 30);
        GT_Values.RA.addFluidExtractionRecipe(
            new ItemStack(Blocks.sand,1,0),
            GT_Values.NI,
            Materials.Glass.getMolten(144L),
            10000,
            200, 48);
        GT_Values.RA.addFluidExtractionRecipe(
            new ItemStack(Blocks.obsidian,1,0),
            GT_Values.NI,
            Materials.Obsidian.getMolten(288L),
            10000,
            600, 30);
        GT_Values.RA.addFluidExtractionRecipe(
            new ItemStack(Blocks.sand,1,1),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
            Materials.Glass.getMolten(72L),
            5000,
            200, 48);
        if (Loader.isModLoaded("EnderIO")) {
            GT_Values.RA.addFluidExtractionRecipe(
                GT_ModHandler.getModItem("EnderIO", "itemMaterial", 1L, 1),
                GT_Values.NI,
                Materials.Concrete.getMolten(36L),
                10000,
                24, 24);
        }
        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addFluidExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 14),
                GT_Values.NI,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                10000,
                24,
                48);

            GT_Values.RA.addFluidExtractionRecipe(
                new ItemStack(Items.ender_pearl, 1, 0),
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("ender"), 250),
                10000,
                100,
                30);
            GT_Values.RA.addFluidExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 10),
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("ender"), 2250),
                10000,
                200,
                48);

            GT_Values.RA.addFluidExtractionRecipe(
                new ItemStack(Items.slime_ball, 1, 0),
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("glue"), 144),
                10000,
                100,
                16);
            GT_Values.RA.addFluidExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0),
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("glue"), 144),
                10000,
                100,
                16);
            GT_Values.RA.addFluidExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 1),
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("glue"), 144),
                10000,
                100,
                16);
            GT_Values.RA.addFluidExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 36),
                GT_Values.NI,
                new FluidStack(FluidRegistry.getFluid("glue"), 144),
                10000,
                100,
                16);
        }
    }
}
