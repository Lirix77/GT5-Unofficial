package gregtech.loaders.postload.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class CuttingMachineRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.wooden_pressure_plate, 1, 0),
            new ItemStack(Blocks.wooden_button, 2, 0),
            GT_Values.NI,
            50, 4);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.stone_pressure_plate, 1, 0),
            new ItemStack(Blocks.stone_button, 2, 0),
            GT_Values.NI,
            50, 4);
        for (int i = 0; i < 16; i++) {
            GT_Values.RA.addCutterRecipe(
                new ItemStack(Blocks.stained_glass, 3, i),
                new ItemStack(Blocks.stained_glass_pane, 8, i),
                GT_Values.NI, 50, 8);
        }
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.glass), new ItemStack(Blocks.glass_pane, 3, 0),
            GT_Values.NI, 50, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.stone), new ItemStack(Blocks.stone_slab, 2, 0), GT_Values.NI, 25, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.sandstone), new ItemStack(Blocks.stone_slab, 2, 1), GT_Values.NI, 25, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.stone_slab, 2, 3), GT_Values.NI, 25, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.brick_block), new ItemStack(Blocks.stone_slab, 2, 4), GT_Values.NI, 25, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.stonebrick), new ItemStack(Blocks.stone_slab, 2, 5), GT_Values.NI, 25, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.nether_brick), new ItemStack(Blocks.stone_slab, 2, 6), GT_Values.NI, 25, 8);
        GT_Values.RA.addCutterRecipe(
            new ItemStack(Blocks.glowstone), GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 4L),
            GT_Values.NI, 100, 16);

        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_ILC.get(1L),
            ItemList.Circuit_Chip_ILC.get(8L),
            GT_Values.NI,
            900, 64);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_Ram.get(1L),
            ItemList.Circuit_Chip_Ram.get(32L),
            GT_Values.NI,
            900, 96);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_NAND.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_NAND.get(32L),
            GT_Values.NI,
            900, 192, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_NOR.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_NOR.get(16L),
            GT_Values.NI,
            900, 192, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_CPU.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_CPU.get(8L),
            GT_Values.NI,
            900, 120, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_Simple_SoC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_Simple_SoC.get(6L),
            GT_Values.NI,
            900, 64, false);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_SoC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_SoC.get(6L),
            GT_Values.NI,
            900, 480, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_SoC2.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_SoC2.get(6L),
            GT_Values.NI,
            900, 1024, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_ULPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_ULPIC.get(6L),
            GT_Values.NI,
            900, 120, false);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_LPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_LPIC.get(4L),
            GT_Values.NI,
            900, 480, false);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_PIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_PIC.get(4L),
            GT_Values.NI,
            900, 1920, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_HPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_HPIC.get(2L),
            GT_Values.NI,
            900, 7860, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_UHPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_UHPIC.get(2L),
            GT_Values.NI,
            900, 30720, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_NPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_NPIC.get(2L),
            GT_Values.NI,
            900, 122880, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_PPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_PPIC.get(2L),
            GT_Values.NI,
            900, 500000, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_QPIC.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_QPIC.get(2L),
            GT_Values.NI,
            900, 2000000, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_NanoCPU.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_NanoCPU.get(8L),
            GT_Values.NI,
            900, 480, true);
        GT_Values.RA.addCutterRecipe(
            ItemList.Circuit_Wafer_QuantumCPU.get(1L),
            GT_Values.NI,
            ItemList.Circuit_Chip_QuantumCPU.get(4L),
            GT_Values.NI,
            900, 1920, true);

        GT_Values.RA.addCutterRecipe(
            GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 1L, 0),
            ItemList.ReinforcedGlassPLate.get(2L),
            GT_Values.NI,
            1200, 30);

        GT_Values.RA.addCutterRecipe(
            ItemList.NandChipBoard.get(1),
            ItemList.NandChip.get(8),
            null,
            100, 480, true);

        if (Loader.isModLoaded("appliedenergistics2")) {
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("appliedenergistics2", "tile.BlockQuartz", 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 4L),
                GT_Values.NI,
                100, 8);
            GT_Values.RA.addCutterRecipe(
                new ItemStack(Blocks.quartz_block, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 4L),
                GT_Values.NI,
                100, 8);
        }

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "GlassBlock", 1L),
                GT_ModHandler.getModItem("TConstruct", "GlassPane", 3L),
                GT_Values.NI,
                50, 8);
            // Cutting Saw
            GT_Values.RA.addCutterRecipe(
                new ItemStack(Blocks.crafting_table, 1),
                GT_ModHandler.getModItem("TConstruct", "CraftingStation", 1L),
                GT_Values.NI,
                4800, 30);
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "CraftingStation", 1L),
                GT_ModHandler.getModItem("TConstruct", "CraftingSlab", 1L),
                GT_Values.NI,
                4800, 30);

            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1),
                Materials.Water.getFluid(1000),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L),
                GT_Values.NI,
                4800, 30);
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1),
                GT_ModHandler.getDistilledWater(750L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L),
                GT_Values.NI,
                4800, 30);
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 1),
                Materials.Lubricant.getFluid(250),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L),
                GT_Values.NI,
                2400, 30);
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2),
                Materials.Water.getFluid(1000),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L),
                GT_Values.NI,
                9600, 30);
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2),
                GT_ModHandler.getDistilledWater(750L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L),
                GT_Values.NI,
                9600, 30);
            GT_Values.RA.addCutterRecipe(
                GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 2),
                Materials.Lubricant.getFluid(250),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L),
                GT_Values.NI,
                4800, 30);
        }
    }
}
