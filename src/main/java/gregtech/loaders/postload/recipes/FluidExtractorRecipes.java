package gregtech.loaders.postload.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class FluidExtractorRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Dye_SquidInk.get(1L))
            .fluidOutputs(getFluidStack("squidink", 144))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Dye_Indigo.get(1L))
            .fluidOutputs(getFluidStack("indigo", 144))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Crop_Drop_Indigo.get(1L))
            .fluidOutputs(getFluidStack("indigo", 144))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Crop_Drop_MilkWart.get(1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Milk, 1L))
            .outputChances(1000)
            .fluidOutputs(GT_ModHandler.getMilk(150L))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Crop_Drop_OilBerry.get(1L))
            .fluidOutputs(Materials.Oil.getFluid(100L))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Crop_Drop_UUMBerry.get(1L))
            .fluidOutputs(Materials.UUMatter.getFluid(4L))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Crop_Drop_UUABerry.get(1L))
            .fluidOutputs(Materials.UUAmplifier.getFluid(4L))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.fish, 1, 0))
            .fluidOutputs(Materials.FishOil.getFluid(40L))
            .duration(16 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.fish, 1, 1))
            .fluidOutputs(Materials.FishOil.getFluid(60L))
            .duration(16 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.fish, 1, 2))
            .fluidOutputs(Materials.FishOil.getFluid(70L))
            .duration(16 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.fish, 1, 3))
            .fluidOutputs(Materials.FishOil.getFluid(30L))
            .duration(16 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.coal, 1, 1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L))
            .outputChances(1000)
            .fluidOutputs(Materials.WoodTar.getFluid(100L))
            .duration(1 * SECONDS + 10 * TICKS)
            .eut(16)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L))
            .itemOutputs(ItemList.IC2_Plantball.get(1L))
            .outputChances(100)
            .fluidOutputs(Materials.Creosote.getFluid(5L))
            .duration(16 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HydratedCoal, 1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
            .outputChances(10000)
            .fluidOutputs(Materials.Water.getFluid(100L))
            .duration(1 * SECONDS + 12 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Monazite, 1L))
            .fluidOutputs(Materials.Helium.getGas(200L))
            .duration(3 * SECONDS + 4 * TICKS)
            .eut(64)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1L, 0))
            .fluidOutputs(Materials.ReinforceGlass.getMolten(144))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.ReinforcedGlassPLate.get(1))
            .fluidOutputs(Materials.ReinforceGlass.getMolten(72))
            .duration(2 * SECONDS + 10 * TICKS)
            .eut(TierEU.RECIPE_EV)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.ReinforcedGlassLense.get(0))
            .fluidOutputs(Materials.ReinforceGlass.getMolten(54))
            .duration(2 * SECONDS + 10 * TICKS)
            .eut(TierEU.RECIPE_EV)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Fluid.get(1L))
            .fluidOutputs(Materials.Steel.getMolten(19 * 144))
            .duration(20 * SECONDS)
            .eut(90)
            .recipeCategory(RecipeCategories.fluidExtractorRecycling)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Item.get(1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 7L))
            .outputChances(10000)
            .fluidOutputs(Materials.Tin.getMolten(12 * 144))
            .duration(20 * SECONDS)
            .eut(90)
            .recipeCategory(RecipeCategories.fluidExtractorRecycling)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Fluid_Pipe.get(4L))
            .fluidOutputs(Materials.Steel.getMolten(189))
            .duration(2 * SECONDS)
            .eut(90)
            .recipeCategory(RecipeCategories.fluidExtractorRecycling)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Item_Pipe.get(16L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 3L))
            .outputChances(10000)
            .fluidOutputs(Materials.Steel.getMolten(324))
            .duration(20 * SECONDS)
            .eut(90)
            .recipeCategory(RecipeCategories.fluidExtractorRecycling)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_ModHandler.getIC2Item("TritiumCell", 1))
            .itemOutputs(GT_ModHandler.getIC2Item("fuelRod", 1))
            .outputChances(10000)
            .fluidOutputs(Materials.Tritium.getGas(32))
            .duration(16 * TICKS)
            .eut(64)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L))
            .fluidOutputs(Materials.Glass.getMolten(72))
            .duration(30 * SECONDS)
            .eut(28)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.wheat_seeds, 1, 32767))
            .fluidOutputs(Materials.SeedOil.getFluid(10))
            .duration(1 * SECONDS + 12 * TICKS)
            .eut(2)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.melon_seeds, 1, 32767))
            .fluidOutputs(Materials.SeedOil.getFluid(10))
            .duration(1 * SECONDS + 12 * TICKS)
            .eut(2)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.pumpkin_seeds, 1, 32767))
            .fluidOutputs(Materials.SeedOil.getFluid(10))
            .duration(1 * SECONDS + 12 * TICKS)
            .eut(2)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Crop_Drop_Rape.get(1))
            .fluidOutputs(Materials.SeedOil.getFluid(125))
            .duration(1 * SECONDS + 12 * TICKS)
            .eut(2)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.snowball, 1, 0))
            .fluidOutputs(Materials.Water.getFluid(250L))
            .duration(1 * SECONDS + 12 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.snow, 1, 0))
            .fluidOutputs(Materials.Water.getFluid(1000L))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L))
            .fluidOutputs(Materials.Ice.getSolid(1000L))
            .duration(6 * SECONDS + 8 * TICKS)
            .eut(4)
            .addTo(fluidExtractionRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Forestry.ID, "phosphor", 1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L))
            .outputChances(1000)
            .fluidOutputs(Materials.Lava.getFluid(800L))
            .duration(12 * SECONDS + 16 * TICKS)
            .eut(128)
            .addTo(fluidExtractionRecipes);

        // Beecombs fluid extractor recipes
        if (BartWorks.isModLoaded()) {
            // xenon
            GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(GregTech.ID, "gt.comb", 1L, 134))
                .fluidOutputs(getFluidStack("xenon", 250))
                .duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_IV)
                .addTo(fluidExtractionRecipes);

            // neon
            GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(GregTech.ID, "gt.comb", 1L, 135))
                .fluidOutputs(getFluidStack("neon", 250))
                .duration(15 * TICKS)
                .eut(TierEU.RECIPE_IV)
                .addTo(fluidExtractionRecipes);

            // krpton
            GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(GregTech.ID, "gt.comb", 1L, 136))
                .fluidOutputs(getFluidStack("krypton", 250))
                .duration(1 * SECONDS + 5 * TICKS)
                .eut(TierEU.RECIPE_IV)
                .addTo(fluidExtractionRecipes);
        }
    }
}
