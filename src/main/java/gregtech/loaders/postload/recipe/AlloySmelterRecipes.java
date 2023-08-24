package gregtech.loaders.postload.recipe;

import net.minecraft.init.Blocks;
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
import gregtech.api.util.GT_Utility;

public class AlloySmelterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Netherrack, 1L),
            ItemList.Shape_Mold_Ingot.get(0),
            new ItemStack(Items.netherbrick),
            200, 2);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);
        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GreenSapphire, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 2L),
            ItemList.AluminoSilicateWool.get(2L),
            1200,
            15);

        GT_Values.RA.addAlloySmelterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1),
            ItemList.Shape_Mold_Ball.get(0),
            ItemList.Circuit_Parts_Glass_Tube.get(1L),
            120,
            16);
        GT_Values.RA.addAlloySmelterRecipe(
            new ItemStack(Blocks.obsidian, 1, 0),
            ItemList.Shape_Mold_Ingot.get(0L),
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2L),
            130,
            3);

        GT_Values.RA.addAlloySmelterRecipe(
            GT_ModHandler.getModItem("IC2", "itemPartIridium", 2L),
            ItemList.Shape_Mold_Casing.get(0),
            ItemList.IridiumAlloyItemCasing.get(3),
            1200,
            256);

        if (Loader.isModLoaded("EnderIO")) {
            // EnderIO Fused Quartz and Glass
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.CertusQuartz.getDust(2),
                Materials.Glass.getDust(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.NetherQuartz.getDust(2),
                Materials.Glass.getDust(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.CertusQuartz.getDust(2),
                Materials.Quartzite.getDust(2),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.NetherQuartz.getDust(2),
                Materials.Quartzite.getDust(2),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.CertusQuartz.getDust(1),
                Materials.BorosilicateGlass.getDust(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                500,
                90);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.NetherQuartz.getDust(1),
                Materials.BorosilicateGlass.getDust(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                500,
                90);

            GT_Values.RA.addAlloySmelterRecipe(
                Materials.Glass.getDust(3),
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.Quartzite.getDust(4),
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                Materials.BorosilicateGlass.getDust(1),
                GT_Utility.getIntegratedCircuit(1),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 2L, 1),
                500,
                90);

            GT_Values.RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1),
                Materials.Glowstone.getDust(4),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 3),
                500,
                30);
            GT_Values.RA.addAlloySmelterRecipe(
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1),
                new ItemStack(Blocks.glowstone),
                GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 3),
                500,
                30);

            for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {
                GT_Values.RA.addAlloySmelterRecipe(
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1),
                    OreDictionary.getOres("dyeBlack").get(i).splitStack(4),
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 5),
                    500,
                    30);
            }
        }

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addAlloySmelterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_ModHandler.getModItem("TConstruct", "materials", 4L, 14),
                100,
                120);
        }

    }

}
