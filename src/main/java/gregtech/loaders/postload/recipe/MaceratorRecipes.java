package gregtech.loaders.postload.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class MaceratorRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.addPulveriserRecipe(
            GT_ModHandler.getModItem("IC2", "blockMiningPipe", 2L),
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), },
            new int[] { 10000 },
            100,
            16);

        GT_Values.RA.addPulveriserRecipe(
            new ItemStack(Items.flint, 2, 0),
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L) },
            null,
            200,
            2);

        GT_Values.RA.addPulveriserRecipe(
            ItemList.GalliumArsenideCrystal.get(1L),
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2) },
            new int[] { 10000 },
            100,
            4);
        GT_Values.RA.addPulveriserRecipe(
            ItemList.GalliumArsenideCrystalSmallPart.get(1L),
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1) },
            new int[] { 10000 },
            25,
            4);

        // recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {
            GT_Values.RA.addPulveriserRecipe(
                OreDictionary.getOres("sand").get(i),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L) },
                new int[] { 10000, 2500, 2000, 1500 },
                200,
                8);

        }

        if (Loader.isModLoaded("TConstruct")) {

            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 4),
                new ItemStack[] { Materials.Ardite.getDust(1) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1),
                new ItemStack[] { Materials.Ardite.getDust(9) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "SearedBrick", 1L, 1),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Cobalt, 2L),
                    Materials.Cobalt.getDust(1) },
                new int[] { 10000, 1000 },
                400,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "SearedBrick", 1L, 2),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Ardite, 2L),
                    Materials.Ardite.getDust(1) },
                new int[] { 10000, 1000 },
                400,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "GravelOre", 1L, 4),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Aluminium, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 1L) },
                new int[] { 10000, 1000 },
                400,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 12),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 14),
                new ItemStack[] { GT_ModHandler.getModItem("TConstruct", "materials", 1L, 42) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 7),
                new ItemStack[] { GT_ModHandler.getModItem("TConstruct", "materials", 9L, 42) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 0),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 9L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "materials", 1L, 5),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 9L) },
                new int[] { 10000 },
                300,
                2);

            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 10),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 9L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "woodPattern", 1L, GT_Values.W),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L) },
                new int[] { 10000 },
                200,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "Pattern", 1L, GT_Values.W),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L) },
                new int[] { 10000 },
                200,
                2);

            // Oreberries
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 0),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iron, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 1),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 2),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Copper, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 3),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tin, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 4),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Aluminium, 1L) },
                new int[] { 10000 },
                300,
                2);
        }

        if (Loader.isModLoaded("Avaritia")) {
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_11, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_13, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_cat, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_blocks, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_chirp, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_far, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_mellohi, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_mall, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_stal, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_strad, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_ward, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.record_wait, 1, 0),
                new ItemStack[] { GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 7) },
                new int[] { 10000 },
                300,
                2);
        }

        if (Loader.isModLoaded("AdvancedSolarPanel")) {
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1L, 0),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L) },
                new int[] { 10000 },
                300,
                2);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1L, 9),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L) },
                new int[] { 10000 },
                30,
                2);
        }

        if (Loader.isModLoaded("GalacticraftCore")) {
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 3),
                new ItemStack[] { ItemList.MoonStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1) },
                new int[] { 10000, 1250 },
                400,
                30);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 4),
                new ItemStack[] { ItemList.MoonStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1) },
                new int[] { 10000, 1250 },
                400,
                30);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "tile.moonBlock", 1L, 5),
                new ItemStack[] { ItemList.MoonStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1) },
                new int[] { 10000, 1250 },
                400,
                30);
        }

        if (Loader.isModLoaded("GalacticraftMars")) {
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 4),
                new ItemStack[] { ItemList.MarsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                new int[] { 10000, 1000 },
                400,
                64);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 5),
                new ItemStack[] { ItemList.MarsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                new int[] { 10000, 1000 },
                400,
                64);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 6),
                new ItemStack[] { ItemList.MarsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                new int[] { 10000, 1000 },
                400,
                64);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.mars", 1L, 9),
                new ItemStack[] { ItemList.MarsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                new int[] { 10000, 1000 },
                400,
                64);
        }

        if (Loader.isModLoaded("GalacticraftMars")) {
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 0),
                new ItemStack[] { ItemList.AsteroidsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1) },
                new int[] { 10000, 1000, 500 },
                400,
                120);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 1),
                new ItemStack[] { ItemList.AsteroidsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1) },
                new int[] { 10000, 1000, 500 },
                400,
                120);
            GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "tile.asteroidsBlock", 1L, 2),
                new ItemStack[] { ItemList.AsteroidsStoneDust.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1) },
                new int[] { 10000, 1000, 500 },
                400,
                120);
        }

    }
}
