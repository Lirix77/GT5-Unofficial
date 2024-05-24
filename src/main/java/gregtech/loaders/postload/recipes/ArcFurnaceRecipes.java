package gregtech.loaders.postload.recipes;

import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.recipe.RecipeMaps.arcFurnaceRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.RECYCLE;
import static gregtech.api.util.GT_RecipeConstants.UniversalArcFurnace;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Block_TungstenSteelReinforced.get(1))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TungstenSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Concrete, 1))
            .duration(8 * SECONDS)
            .eut(96)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Fluid.get(1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 19L))
            .duration(9 * SECONDS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Item.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 12L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 7L))
            .duration(9 * SECONDS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Fluid_Pipe.get(1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L))
            .duration(10 * TICKS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Long_Distance_Pipeline_Item_Pipe.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 1L),
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 1L))
            .duration(10 * TICKS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Cupronickel.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cupronickel, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 2))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Kanthal.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kanthal, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cupronickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 3))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Nichrome.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nichrome, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kanthal, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 4))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_TungstenSteel.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TPV, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Nichrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 5))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_HSSG.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.TPV, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 6))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_HSSS.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSS, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 7))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Naquadah.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HSSS, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 8))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_NaquadahAlloy.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 9))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_Trinium.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 10))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_ElectrumFlux.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectrumFlux, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Trinium, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 11))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Casing_Coil_AwakenedDraconium.get(1L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DraconiumAwakened, 8),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectrumFlux, 1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 12))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 0))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 2L))
            .duration(7 * SECONDS + 10 * TICKS)
            .eut(90)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 1))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 3))
            .duration(7 * SECONDS + 10 * TICKS)
            .eut(90)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 2))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 12L),
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Iron, 6))
            .duration(7 * SECONDS + 10 * TICKS)
            .eut(90)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 13))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 2L))
            .duration(9 * SECONDS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 14))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 3))
            .duration(9 * SECONDS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(getModItem(Railcraft.ID, "machine.beta", 1L, 15))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 12L),
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 6L))
            .duration(9 * SECONDS)
            .eut((int) TierEU.RECIPE_MV)
            .metadata(RECYCLE, true)
            .addTo(UniversalArcFurnace);

        GT_Values.RA.stdBuilder()
            .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3))
            .fluidInputs(Materials.Oxygen.getGas(2000L))
            .duration(60 * SECONDS)
            .eut((int) TierEU.RECIPE_LV)
            .addTo(arcFurnaceRecipes);

    }
}
