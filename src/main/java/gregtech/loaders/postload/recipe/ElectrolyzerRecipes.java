package gregtech.loaders.postload.recipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ElectrolyzerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 13L),
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            Materials.Water.getFluid(6000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            156,
            120);

        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Topaz, 10L),
            ItemList.Cell_Empty.get(5L),
            GT_Values.NF,
            Materials.Fluorine.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 3L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            160,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueTopaz, 13L),
            ItemList.Cell_Empty.get(8L),
            GT_Values.NF,
            Materials.Fluorine.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            208,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pollucite, 7L),
            ItemList.Cell_Empty.get(2L),
            GT_Values.NF,
            Materials.Water.getFluid(1000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 2L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            210,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 13L),
            ItemList.Cell_Empty.get(4L),
            GT_Values.NF,
            Materials.Fluorine.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            260,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 20L),
            ItemList.Cell_Empty.get(8L),
            GT_Values.NF,
            Materials.Hydrogen.getGas(6000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 8L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            210,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 20L),
            ItemList.Cell_Empty.get(10L),
            GT_Values.NF,
            Materials.Fluorine.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 4L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 10L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            260,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 16L),
            ItemList.Cell_Empty.get(7L),
            GT_Values.NF,
            Materials.Hydrogen.getGas(1000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 7L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            280,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 16L),
            ItemList.Cell_Empty.get(4L),
            GT_Values.NF,
            Materials.Fluorine.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L),
            GT_Values.NI,
            null,
            280,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 14L),
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 4L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            364,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 13L),
            ItemList.Cell_Empty.get(4L),
            GT_Values.NF,
            Materials.Hydrogen.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 4L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            378,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 13L),
            ItemList.Cell_Empty.get(4L),
            GT_Values.NF,
            Materials.Hydrogen.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 4L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            378,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 21L),
            ItemList.Cell_Empty.get(8L),
            GT_Values.NF,
            Materials.Hydrogen.getGas(2000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 4L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 4L),
            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L),
            GT_Values.NI,
            null,
            420,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 41L),
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            Materials.Oxygen.getGas(18000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 27L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 9L),
            GT_Values.NI,
            GT_Values.NI,
            null,
            944,
            120);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            Materials.Oxygen.getGas(3000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            null,
            100,
            480);
        GT_Values.RA.addElectrolyzerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 10L),
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            Materials.Fluorine.getGas(6000L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            null,
            100,
            480);
    }
}
