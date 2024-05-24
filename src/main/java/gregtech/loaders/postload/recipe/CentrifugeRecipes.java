package gregtech.loaders.postload.recipe;

import gregtech.api.enums.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.Loader;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.util.GT_RecipeBuilder.*;

public class CentrifugeRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.addCentrifugeRecipe(
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NI,
            Materials.RedMud.getFluid(1000L),
            Materials.Water.getFluid(500L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 5L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumOxide, 1L),
            new int[] { 10000, 10000, 9000, 7500, 5000, 2500 },
            600,
            120);

        GT_Values.RA.addCentrifugeRecipe(
            new ItemStack(Items.fire_charge, 1, 0),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            new ItemStack(Items.blaze_powder, 1, 0),
            new ItemStack(Items.gunpowder, 1, 0),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000, 10000, 10000 },
            400,
            8);

        GT_Values.RA.addCentrifugeRecipe(
            ItemList.MoonStoneDust.get(36L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Olivine, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 4L),
            new int[] { 5000, 2000, 1000, 750, 500, 250 },
            3240,
            120);
        GT_Values.RA.addCentrifugeRecipe(
            ItemList.MarsStoneDust.get(36L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 4L),
            new int[] { 5000, 3000, 1000, 750, 500, 250 },
            2430,
            480);
        GT_Values.RA.addCentrifugeRecipe(
            ItemList.AsteroidsStoneDust.get(36L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 4L),
            new int[] { 5000, 3000, 1000, 750, 500, 150 },
            6480,
            480);


        GT_Values.RA.addCentrifugeRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 9L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cassiterite, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
            new int[] { 9000, 3000, 2000, 1500, 1000, 750 },
            2160,
            16);

        GT_Values.RA.addCentrifugeRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust.get(Materials.DeepIron), 4L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000, 10000 },
            800,
            30720);

        GT_Values.RA.addCentrifugeRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2),
            GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2),
            GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 2),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 5000, 2000, 1000 },
            1200,
            1920);

        GT_Values.RA.addCentrifugeRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 8L),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000, 10000 },
            800,
            30);

        GT_Values.RA.addCentrifugeRecipe(
            ItemList.Cell_Air.get(5L),
            GT_Values.NI,
            GT_Values.NF,
            Materials.Nitrogen.getGas(3900L),
            Materials.Oxygen.getCells(1),
            ItemList.Cell_Empty.get(4L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000, 10000 },
            1600,
            8);

        GT_Values.RA.addCentrifugeRecipe(
            GT_ModHandler.getModItem("IC2", "itemCellHydrant", 1L, GT_Values.W),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            ItemList.Cell_Empty.get(1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000 },
            100,
            2);

        GT_Values.RA.addCentrifugeRecipe(
            Materials.SolderingAlloy.getDust(10),
            null,
            null,
            null,
            Materials.Tin.getDust(9),
            Materials.Antimony.getDust(1),
            null,
            null,
            null,
            null,
            new int[] { 10000, 10000 },
            300,
            30);

        if (Loader.isModLoaded("TConstruct")) {
            // Centrifuge
            GT_Values.RA.addCentrifugeRecipe(
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Glue.getFluid(50),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                5);
            GT_Values.RA.addCentrifugeRecipe(
                new ItemStack(Items.slime_ball, 1, 0),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Glue.getFluid(50),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                5);
            GT_Values.RA.addCentrifugeRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 2),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Glue.getFluid(200),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 8L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                5);
            GT_Values.RA.addCentrifugeRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 1),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Glue.getFluid(200),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 8L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                5);
            GT_Values.RA.addCentrifugeRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 0),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Glue.getFluid(200),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 8L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                5);
            GT_Values.RA.addCentrifugeRecipe(
                GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 1L, 0),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Glue.getFluid(25),
                new ItemStack(Blocks.dirt, 1, 32767),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 1L),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000, 10000, 1000 },
                300,
                5);

            GT_Values.RA.stdBuilder().itemInputs(ItemList.MoonStoneDust.get(36L))
                .itemOutputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 9L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Olivine, 9L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 4L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 4L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungstate, 4L))
                .outputChances(5000, 2000, 1000, 750, 500, 250).duration(2 * MINUTES + 42 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(centrifugeRecipes);

            GT_Values.RA.stdBuilder().itemInputs(ItemList.MarsStoneDust.get(36L))
                .itemOutputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 9L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 9L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 9L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 4L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 4L))
                .outputChances(5000, 3000, 1000, 750, 500, 250).duration(2 * MINUTES + SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);
        }
    }
}
