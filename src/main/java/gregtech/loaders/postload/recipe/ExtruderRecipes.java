package gregtech.loaders.postload.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ExtruderRecipes implements Runnable {

    @Override
    public void run() {
        registerTinkerParts();

        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L),
            ItemList.Shape_Extruder_Rod.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnnealedCopper, 2L),
            200,
            90);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
            ItemList.Shape_Extruder_Rod.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2L),
            200,
            90);

        GT_Values.RA.addExtruderRecipe(
            Materials.BorosilicateGlass.getIngots(1),
            ItemList.Shape_Extruder_Wire.get(0),
            ItemList.Circuit_Parts_GlassFiber.get(8L),
            160,
            96);

        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
            ItemList.Shape_Extruder_Pipe_Tiny.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.WroughtIron, 2L),
            4,
            120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
            ItemList.Shape_Extruder_Pipe_Small.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.WroughtIron, 1L),
            8,
            120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 3L),
            ItemList.Shape_Extruder_Pipe_Medium.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.WroughtIron, 1L),
            24,
            120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 6L),
            ItemList.Shape_Extruder_Pipe_Large.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.WroughtIron, 1L),
            48,
            120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 12L),
            ItemList.Shape_Extruder_Pipe_Huge.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.WroughtIron, 1L),
            96,
            120);

        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
            ItemList.Shape_Extruder_Pipe_Tiny.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.NetherStar, 2L),
            4, 120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
            ItemList.Shape_Extruder_Pipe_Small.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.NetherStar, 1L),
            8, 120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 3L),
            ItemList.Shape_Extruder_Pipe_Medium.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.NetherStar, 1L),
            24, 120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 6L),
            ItemList.Shape_Extruder_Pipe_Large.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NetherStar, 1L),
            48, 120);
        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 12L),
            ItemList.Shape_Extruder_Pipe_Huge.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.NetherStar, 1L),
            96, 120);

        GT_Values.RA.addExtruderRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 2L),
            ItemList.Shape_Extruder_Hoe.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.StainlessSteel, 1L),
            150,
            120);
    }

    public static void registerTinkerParts() {
        if (Loader.isModLoaded("TConstruct")) {
            // Tool Rods
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 316),
                97,
                30);

            // Pickaxe Heads
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 316),
                195,
                30);

            // Shovel Heads
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 316),
                195,
                30);

            // Axe Heads
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 316),
                195,
                30);

            // Sword Blade
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 316),
                195,
                30);

            // Wide Guards
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 316),
                97,
                30);

            // Hand Guards
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 316),
                97,
                30);

            // Crossbars
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 316),
                97,
                30);

            // Bindings
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 316),
                97,
                30);
            // Fryingpan Heads (Time for Dream to duck!)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 316),
                195,
                30);

            // Sign Heads (To write on a wall)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 316),
                195,
                30);

            // Knife Blades (There are no winners in a knife fight)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 316),
                97,
                30);

            // Chisel Heads (Stonework galore)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 316),
                97,
                30);

            // Tough Tool Rods (The Tougher the Better)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 2),
                1503,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 6),
                537,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 3, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 7),
                735,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 10),
                4800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 11),
                3639,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 12),
                7200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 13),
                1080,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 14),
                2280,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 15),
                3303,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 16),
                2400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 18),
                3999,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 314),
                600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 314),
                600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 3L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 315),
                45000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 3L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 316),
                585,
                30);

            // Tough Bindings (To keep the toughness together)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 2),
                1503,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 6),
                537,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 3, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 7),
                735,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 10),
                4800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 11),
                3639,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 12),
                7200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 13),
                1080,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 14),
                2280,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 15),
                3303,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 16),
                2400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 18),
                3999,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 314),
                600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 314),
                600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 3L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 315),
                45000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 3L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 316),
                585,
                30);

            // Large Plates (Different from Small Plates)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 2),
                4008,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 6),
                1432,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 8, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 7),
                1960,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 10),
                12800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 11),
                9704,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 12),
                19200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 13),
                2880,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 14),
                7680,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 15),
                8808,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 16),
                6400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 18),
                10664,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 315),
                120000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 316),
                1560,
                30);

            // Broad Axe Heads (Cutting down a tree with every strike)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 2),
                4008,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 6),
                1432,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 8, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 7),
                1960,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 10),
                12800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 11),
                9704,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 12),
                19200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 13),
                2880,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 14),
                7680,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 15),
                8808,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 16),
                6400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 18),
                10664,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 315),
                120000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 316),
                1560,
                30);

            // Scythe Heads (Cutting down a a farm with every strike, or Deaths favorite weapon)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 2),
                4008,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 6),
                1432,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 8, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 7),
                1960,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 10),
                12800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 11),
                9704,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 12),
                19200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 13),
                2880,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 14),
                7680,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 15),
                8808,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 16),
                6400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 18),
                10664,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 315),
                120000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 316),
                1560,
                30);

            // Excavator Heads (Getting Dirty digging a hole)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 2),
                4008,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 6),
                1432,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 8, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 7),
                1960,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 10),
                12800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 11),
                9704,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 12),
                19200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 13),
                2880,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 14),
                7680,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 15),
                8808,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 16),
                6400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 18),
                10664,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 315),
                120000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 316),
                1560,
                30);

            // Large Sword Blades (Who has the largest sword?)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 2),
                4008,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 6),
                1432,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 8, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 7),
                1960,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 10),
                12800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 11),
                9704,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 12),
                19200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 13),
                2880,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 14),
                7680,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 15),
                8808,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 16),
                6400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 18),
                10664,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 315),
                120000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 316),
                1560,
                30);

            // Hammer Heads (It's Clobbering Time!)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 2),
                4008,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 6),
                1432,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 8, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 7),
                1960,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 10),
                12800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 11),
                9704,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 12),
                19200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 13),
                2880,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 14),
                7680,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 15),
                8808,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 16),
                6400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 18),
                10664,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 8L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 314),
                1600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 8L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 315),
                120000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 8L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 316),
                1560,
                30);

            // Full Guards (To guard your grip)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 2),
                1503,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 6),
                537,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 3, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 7),
                735,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 10),
                4800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 11),
                3639,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 12),
                7200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 13),
                1080,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 14),
                2280,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 15),
                3303,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 16),
                2400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(3),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 18),
                3999,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 314),
                600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 3L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 314),
                600,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 3L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 315),
                45000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 3L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 316),
                585,
                30);

            // Arrowheads (Hey, flying metal)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 2),
                501,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 6),
                179,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 7),
                245,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 10),
                1600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 11),
                1213,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 12),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 13),
                360,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 14),
                760,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 15),
                1101,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 16),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 18),
                1333,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 314),
                200,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 315),
                15000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 316),
                195,
                30);

            // Shurikens (Hey, Oriental flying metal)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 2),
                250,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 6),
                90,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 1, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 7),
                122,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 10),
                800,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 11),
                606,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 12),
                1200,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 13),
                180,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 14),
                380,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 15),
                550,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 16),
                400,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(1),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 18),
                666,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 314),
                100,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 315),
                7500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 1L, 8),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 316),
                97,
                30);

            // Crossbow Limbs (The Dragon's worst enemy)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 2),
                2004,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 6),
                716,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 4, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 7),
                980,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 10),
                6400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 11),
                4852,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 12),
                9600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 13),
                1440,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 14),
                3040,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 15),
                4404,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 16),
                3200,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 18),
                5332,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 4L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 314),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 4L, 2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 314),
                800,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 4L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 315),
                60000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 4L, 8),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 316),
                780,
                30);

            // Crossbow Body (The Dragon's worst enemy, part 2)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 2),
                2505,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 6),
                895,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 5, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 7),
                1225,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 10),
                8000,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 11),
                6065,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 12),
                12000,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 13),
                1800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 14),
                3800,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 15),
                5505,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 16),
                4000,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(5),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 18),
                6665,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 5L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 314),
                1000,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 5L, 2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 314),
                1000,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 5L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 315),
                75000,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 5L, 8),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 316),
                975,
                30);

            // Bow Limbs (A skeletons favorite weapon, in pieces.)
            GT_Values.RA.addExtruderRecipe(
                Materials.Iron.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 2),
                752,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Obsidian.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 6),
                269,
                120);
            GT_Values.RA.addExtruderRecipe(
                new ItemStack(Items.netherbrick, 2, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 7),
                368,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Cobalt.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 10),
                2400,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Ardite.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 11),
                1820,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Manyullyn.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 12),
                3600,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Copper.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 13),
                540,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Bronze.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 14),
                1140,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.Alumite.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 15),
                1652,
                120);
            GT_Values.RA.addExtruderRecipe(
                Materials.Steel.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 16),
                1200,
                30);
            GT_Values.RA.addExtruderRecipe(
                Materials.PigIron.getIngots(2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 18),
                2000,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 2L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 314),
                300,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 2L, 2),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 314),
                300,
                30);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 2L, 0),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 315),
                22500,
                120);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "decorativeBlock1", 2L, 8),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 316),
                293,
                30);
        }

        if (Loader.isModLoaded("Avaritia") && (Loader.isModLoaded("TConstruct"))) {
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "toolRod", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "pickaxeHead", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "shovelHead", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 4),
                GT_ModHandler.getModItem("TConstruct", "hatchetHead", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 5),
                GT_ModHandler.getModItem("TConstruct", "swordBlade", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 6),
                GT_ModHandler.getModItem("TConstruct", "wideGuard", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 7),
                GT_ModHandler.getModItem("TConstruct", "handGuard", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 8),
                GT_ModHandler.getModItem("TConstruct", "crossbar", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 9),
                GT_ModHandler.getModItem("TConstruct", "binding", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 10),
                GT_ModHandler.getModItem("TConstruct", "frypanHead", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 2L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 11),
                GT_ModHandler.getModItem("TConstruct", "signHead", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 12),
                GT_ModHandler.getModItem("TConstruct", "knifeBlade", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 13),
                GT_ModHandler.getModItem("TConstruct", "chiselHead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 14),
                GT_ModHandler.getModItem("TConstruct", "toughRod", 1L, 500),
                400,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 15),
                GT_ModHandler.getModItem("TConstruct", "toughBinding", 1L, 500),
                400,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 500),
                800,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 16),
                GT_ModHandler.getModItem("TConstruct", "heavyPlate", 1L, 500),
                1000,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 500),
                800,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 17),
                GT_ModHandler.getModItem("TConstruct", "broadAxeHead", 1L, 500),
                1000,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 500),
                800,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 18),
                GT_ModHandler.getModItem("TConstruct", "scytheBlade", 1L, 500),
                1000,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 500),
                800,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 19),
                GT_ModHandler.getModItem("TConstruct", "excavatorHead", 1L, 500),
                1000,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 500),
                800,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 20),
                GT_ModHandler.getModItem("TConstruct", "largeSwordBlade", 1L, 500),
                1000,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 8L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 500),
                800,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 16L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 21),
                GT_ModHandler.getModItem("TConstruct", "hammerHead", 1L, 500),
                1000,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 500),
                300,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 22),
                GT_ModHandler.getModItem("TConstruct", "fullGuard", 1L, 500),
                400,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 3L, 4),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 6L, 500),
                GT_ModHandler.getModItem("TConstruct", "metalPattern", 0L, 25),
                GT_ModHandler.getModItem("TConstruct", "arrowhead", 1L, 500),
                300,
                122880);

            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 500),
                150,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 1L, 500),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 0),
                GT_ModHandler.getModItem("TConstruct", "ShurikenPart", 1L, 500),
                200,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 4L, 4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 500),
                400,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 8L, 500),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 1),
                GT_ModHandler.getModItem("TConstruct", "CrossbowLimbPart", 1L, 500),
                500,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 5L, 4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 500),
                600,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 10L, 500),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 2),
                GT_ModHandler.getModItem("TConstruct", "CrossbowBodyPart", 1L, 500),
                750,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 2L, 4),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 500),
                350,
                122880);
            GT_Values.RA.addExtruderRecipe(
                GT_ModHandler.getModItem("TConstruct", "toolShard", 3L, 500),
                GT_ModHandler.getModItem("TConstruct", "Cast", 0L, 3),
                GT_ModHandler.getModItem("TConstruct", "BowLimbPart", 1L, 500),
                450,
                122880);
        }

    }
}
