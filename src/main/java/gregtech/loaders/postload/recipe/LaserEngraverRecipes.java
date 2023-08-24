package gregtech.loaders.postload.recipe;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class LaserEngraverRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer2.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)),
            ItemList.Circuit_Wafer_NAND.get(1L),
            900,
            480,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer3.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)),
            ItemList.Circuit_Wafer_NAND.get(4L),
            600,
            1920,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer4.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)),
            ItemList.Circuit_Wafer_NAND.get(8L),
            600,
            7680,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer5.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1)),
            ItemList.Circuit_Wafer_NAND.get(16L),
            600,
            30720,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer2.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)),
            ItemList.Circuit_Wafer_NOR.get(1L),
            900,
            480,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer3.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)),
            ItemList.Circuit_Wafer_NOR.get(4L),
            600,
            1920,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer4.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)),
            ItemList.Circuit_Wafer_NOR.get(8L),
            600,
            7680,
            true);
        GT_Values.RA.addLaserEngraverRecipe(
            ItemList.Circuit_Silicon_Wafer5.get(1L),
            GT_Utility.copyAmount(0, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1)),
            ItemList.Circuit_Wafer_NOR.get(16L),
            600,
            30720,
            true);

        // GC/GS Wafer
        if (Loader.isModLoaded("GalacticraftCore")) {
            GT_Values.RA.addLaserEngraverRecipe(
                ItemList.Circuit_Silicon_Wafer.get(1L),
                ItemList.ReinforcedGlassLense.get(0),
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 13),
                200, 256);
            GT_Values.RA.addLaserEngraverRecipe(
                ItemList.Circuit_Silicon_Wafer2.get(1L),
                ItemList.ReinforcedGlassLense.get(0),
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 1L, 14),
                200, 480);
        }
    }
}
