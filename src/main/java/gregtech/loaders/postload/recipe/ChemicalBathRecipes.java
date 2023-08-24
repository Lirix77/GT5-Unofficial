package gregtech.loaders.postload.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ChemicalBathRecipes implements Runnable {

    @Override
    public void run() {
        // - Chlorine cleaning of pistons
        GT_Values.RA.addChemicalBathRecipe(
            new ItemStack(Blocks.sticky_piston, 1, 0),
            Materials.Chlorine.getGas(10L),
            new ItemStack(Blocks.piston, 1, 0),
            GT_Values.NI,
            GT_Values.NI,
            null,
            30,
            30);
        // Cooling Hot Khantal MV
        GT_Values.RA.addChemicalBathRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L),
            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
            new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kanthal, 1L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            1200,
            120);
        // Cooling Hot Tantalum MV
        GT_Values.RA.addChemicalBathRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L),
            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
            new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 1L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            1800,
            120);
        // Cooling Hot Silicon MV
        GT_Values.RA.addChemicalBathRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Silicon, 1L),
            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
            new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silicon, 1L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            600,
            120);
        // Cooling Hot SiliconSG MV
        GT_Values.RA.addChemicalBathRecipe(
            GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L),
            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
            new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
            GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.SiliconSG, 1L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            800,
            120);

        GT_Values.RA.addChemicalBathRecipe(
            ItemList.Circuit_Parts_GlassFiber.get(1L),
            Materials.Epoxid.getMolten(144L),
            Materials.EpoxidFiberReinforced.getPlates(1),
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000 },
            240,
            16);
        GT_Values.RA.addChemicalBathRecipe(
            GT_ModHandler.getIC2Item("carbonFiber", 1),
            Materials.Epoxid.getMolten(144L),
            Materials.EpoxidFiberReinforced.getPlates(1),
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000 },
            240,
            16);

        GT_Values.RA.addChemicalBathRecipe(
            GT_ModHandler.getModItem("IC2", "itemBiochaff", 1L, 0),
            Materials.Water.getFluid(750L),
            GT_ModHandler.getModItem("Forestry", "mulch", 8L, 0),
            GT_ModHandler.getModItem("Forestry", "mulch", 4L, 0),
            GT_ModHandler.getModItem("Forestry", "mulch", 4L, 0),
            new int[] { 10000, 3300, 2000 },
            500,
            30);

        if (Loader.isModLoaded("EnderIO")) {

        }
    }
}
