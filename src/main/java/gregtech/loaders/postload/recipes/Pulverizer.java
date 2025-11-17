package gregtech.loaders.postload.recipes;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTModHandler.getIC2Item;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;
import gtnhlanth.common.register.WerkstoffMaterialPool;

public class Pulverizer implements Runnable {

    @Override
    public void run() {
        // recycling Long Distance Pipes
        {
            GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Long_Distance_Pipeline_Fluid.get(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 19))
                .duration(15 * SECONDS)
                .eut(4)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Long_Distance_Pipeline_Item.get(1))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 12),
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 7))
                .duration(15 * SECONDS)
                .eut(4)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Long_Distance_Pipeline_Fluid_Pipe.get(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 2))
                .duration(10 * TICKS)
                .eut(4)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Long_Distance_Pipeline_Item_Pipe.get(1))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tin, 1),
                    GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Steel, 1))
                .duration(10 * TICKS)
                .eut(4)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);
        }

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.quartz_block, 1))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 4))
            .duration(19 * SECONDS + 12 * TICKS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.quartz_block, 1, 1))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 4))
            .duration(19 * SECONDS + 12 * TICKS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.quartz_block, 1, 2))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 4))
            .duration(19 * SECONDS + 12 * TICKS)
            .eut(4)
            .addTo(maceratorRecipes);

        // marbe dust( stone dust
        GTValues.RA.stdBuilder()
            .itemInputs(GTOreDictUnificator.get(OrePrefixes.block, Materials.Marble, 1))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Marble, 1))
            .duration(8 * SECONDS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.reeds, 1))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1))
            .duration(2 * SECONDS + 10 * TICKS)
            .eut(2)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Cupronickel.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cupronickel, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 2))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Kanthal.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cupronickel, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 3))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Nichrome.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 4))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_TungstenSteel.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 5))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_HSSG.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 6))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_HSSS.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 7))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Naquadah.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 8))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_NaquadahAlloy.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 9))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Trinium.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 10))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_ElectrumFlux.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 11))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_AwakenedDraconium.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 8),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 12))
            .duration(1 * MINUTES + 15 * SECONDS)
            .eut(80)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Infinity.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 9L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 4L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 24L))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_UHV)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Hypogen.get(1))
            .itemOutputs(
                MaterialsElements.STANDALONE.HYPOGEN.getDust(9),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 4L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 48L))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_UEV)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Eternal.get(1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, MaterialsUEVplus.SpaceTime, 9L),
                MaterialsElements.STANDALONE.HYPOGEN.getDust(4),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 64L),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 64L))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_UIV)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        if (Railcraft.isModLoaded()) {
            // recycling RC Tanks
            // Iron

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2))
                .duration(15 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 1))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1),
                    GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 3))
                .duration(15 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 2))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 12),
                    GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iron, 3))
                .duration(15 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            // Steel

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 13))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2))
                .duration(15 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 14))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1),
                    GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 3))
                .duration(15 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 15))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 12),
                    GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Steel, 3))
                .duration(15 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);

        }

        if (AppliedEnergistics2.isModLoaded()) {
            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1L, 32767))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 45))
                .duration(20 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyChest", 1L, 32767))
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 8L, 45))
                .duration(20 * SECONDS)
                .eut(2)
                .recipeCategory(RecipeCategories.maceratorRecycling)
                .addTo(maceratorRecipes);
        }

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.blaze_rod, 1))
            .itemOutputs(new ItemStack(Items.blaze_powder, 3), new ItemStack(Items.blaze_powder, 1))
            .outputChances(10000, 5000)
            .duration(20 * SECONDS)
            .eut(2)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.web, 1, 0))
            .itemOutputs(new ItemStack(Items.string, 1), new ItemStack(Items.string, 1))
            .outputChances(10000, 5000)
            .duration(20 * SECONDS)
            .eut(2)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.red_mushroom, 1, 32767))
            .itemOutputs(ItemList.IC2_Grin_Powder.get(1L))
            .duration(20 * SECONDS)
            .eut(2)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.poisonous_potato, 1))
            .itemOutputs(ItemList.IC2_Grin_Powder.get(1L))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.spider_eye, 1))
            .itemOutputs(ItemList.IC2_Grin_Powder.get(1L))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.bone, 1))
            .itemOutputs(new ItemStack(Items.dye, 4, 15))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.IC2_EnergyCrystal.get(1))
            .itemOutputs(getIC2Item("energiumDust", 9))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(getIC2Item("biochaff", 1))
            .itemOutputs(new ItemStack(Blocks.dirt, 1))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.quartz_stairs, 1))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 6))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.item_frame, 1, 32767))
            .itemOutputs(
                new ItemStack(Items.leather, 1),
                GTOreDictUnificator.getDust(Materials.Wood, OrePrefixes.stick.mMaterialAmount * 4L))
            .outputChances(10000, 9500)
            .duration(20 * SECONDS)
            .eut(2)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.bow, 1, 0))
            .itemOutputs(
                new ItemStack(Items.string, 3),
                GTOreDictUnificator.getDust(Materials.Wood, OrePrefixes.stick.mMaterialAmount * 3))
            .outputChances(10000, 9500)
            .duration(20 * SECONDS)
            .eut(2)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(Materials.Brick.getIngots(1))
            .itemOutputs(Materials.Brick.getDustSmall(1))
            .duration(20 * SECONDS)
            .eut(2)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Blocks.brick_stairs, 1, 0))
            .itemOutputs(Materials.Brick.getDustSmall(6))
            .duration(20 * SECONDS)
            .eut(2)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(ItemList.Machine_Bricked_BlastFurnace.get(1))
            .itemOutputs(Materials.Brick.getDust(8), Materials.Iron.getDust(1))
            .duration(20 * SECONDS)
            .eut(2)
            .recipeCategory(RecipeCategories.maceratorRecycling)
            .addTo(maceratorRecipes);

        if (HardcoreEnderExpansion.isModLoaded()) {
            GTValues.RA.stdBuilder()
                .itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_ore", 1))
                .itemOutputs(
                    GTOreDictUnificator.get(OrePrefixes.crushed, Materials.HeeEndium, 2),
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1))
                .outputChances(10000, 5000)
                .duration(20 * SECONDS)
                .eut(2)
                .addTo(maceratorRecipes);
        }

        // LUAG gems
        GTValues.RA.stdBuilder()
            .itemInputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.gemChipped, 1))
            .itemOutputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.dustSmall, 1))
            .duration(25 * TICKS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.gemFlawed, 1))
            .itemOutputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.dustSmall, 2))
            .duration(50 * TICKS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.gem, 1))
            .itemOutputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.dust, 1))
            .duration(5 * SECONDS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.gemFlawless, 1))
            .itemOutputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.dust, 2))
            .duration(10 * SECONDS)
            .eut(4)
            .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.gemExquisite, 1))
            .itemOutputs(WerkstoffMaterialPool.CeriumDopedLutetiumAluminiumGarnet.get(OrePrefixes.dust, 4))
            .duration(20 * SECONDS)
            .eut(4)
            .addTo(maceratorRecipes);
    }
}
