package gregtech.loaders.postload.recipe;

import static gregtech.api.enums.GT_Values.W;
import static gregtech.api.enums.Materials.Xenoxene;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.*;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.items.GT_MetaGenerated_Tool_01;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class AssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy, Materials.Tin };

    ItemStack missing = new ItemStack(Blocks.fire);

    @Override
    public void run() {

        // New organized methods -- Most of these still need RA2 conversions done, but at least they're in more workable
        // chunks.
        makeEnderIORecipes();
        makeAE2Recipes();
        makeTinkersConstructRecipes();
        makeForestryRecipes();
        makeCoilRecipes();
        makePistonRecipes();
        makeMixedMetalIngotRecipes();
        makeReinforcedIronPlateRecipes();
        makeSolderingAlloyRecipes();
        makeElectricMachinePartRecipes();
        makeCircuitPartRecipes();

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Polybenzimidazole, 1L),
                GT_ModHandler.getIC2Item("carbonMesh", 1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Duct_Tape.get(2L)).fluidInputs(Materials.AdvancedGlue.getFluid(200))
            .duration(6 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Hull_LV.get(1), ItemList.Duct_Tape.get(2), GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Hatch_Maintenance.get(1)).fluidInputs(Materials.AdvancedGlue.getFluid(200))
            .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);


        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 64L),
                ItemList.MicaInsulatorFoil.get(48L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L))
            .fluidInputs(Materials.Trinium.getMolten(1440L)).duration(50 * SECONDS).eut(9001)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 32L),
                ItemList.MicaInsulatorFoil.get(32L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(576L))
            .duration(50 * SECONDS).eut(9001).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16L),
                ItemList.MicaInsulatorFoil.get(16L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(288L))
            .duration(50 * SECONDS).eut(9001).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 8L),
                ItemList.MicaInsulatorFoil.get(8L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(144L))
            .duration(50 * SECONDS).eut(9001).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 4L),
                ItemList.MicaInsulatorFoil.get(4L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(72L))
            .duration(50 * SECONDS).eut(9001).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUIV, 2L),
                ItemList.MicaInsulatorFoil.get(2L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(36L))
            .duration(50 * SECONDS).eut(9001).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUMV, 1L),
                ItemList.MicaInsulatorFoil.get(1L))
            .itemOutputs(ItemList.Casing_Coil_Superconductor.get(1L)).fluidInputs(Materials.Trinium.getMolten(18L))
            .duration(50 * SECONDS).eut(9001).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.SteelBars.get(4L)).duration(20 * SECONDS).eut(48).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.AluminiumBars.get(4L)).duration(20 * SECONDS).eut(64)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.StainlessSteelBars.get(4L)).duration(20 * SECONDS).eut(96)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.TitaniumBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Tungsten, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.TungstenBars.get(4L)).duration(20 * SECONDS).eut(192)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.TungstenSteelBars.get(4L)).duration(20 * SECONDS).eut(256)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.ChromeBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.IridiumBars.get(4L)).duration(20 * SECONDS).eut(1024)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.OsmiumBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.NeutroniumBars.get(4L)).duration(20 * SECONDS).eut(4096)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.RedstoneAlloy, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.RedstoneAlloyBars.get(4L)).duration(20 * SECONDS).eut(48)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ElectricalSteel, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.ElectricalSteelBars.get(4L)).duration(20 * SECONDS).eut(64)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ConductiveIron, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.ConductiveIronBars.get(4L)).duration(20 * SECONDS).eut(160)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnergeticAlloy, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.EnergeticAlloyBars.get(4L)).duration(20 * SECONDS).eut(384)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.VibrantAlloy, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.VibrantAlloyBars.get(4L)).duration(20 * SECONDS).eut(768)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.PulsatingIron, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.PulsatingIronBars.get(4L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.SoulariumBars.get(4L)).duration(20 * SECONDS).eut(64)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderiumBase, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.EnderiumBaseBars.get(4L)).duration(20 * SECONDS).eut(256)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Enderium, 3L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.EnderiumBars.get(4L)).duration(20 * SECONDS).eut(1024)
            .addTo(sAssemblerRecipes);


        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 3L))
            .itemOutputs(ItemList.WoodenCasing.get(1L)).fluidInputs(Materials.Iron.getMolten(32L))
            .duration(5 * SECONDS).eut(8).addTo(sAssemblerRecipes);

        // IC2 Charging Batteries
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatREDischarged", 4L, W),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeRE", 1L, 0))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeAdv", 1L, 0))
            .fluidInputs(Materials.SolderingAlloy.getMolten(288L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeCrystal", 1L, 0))
            .fluidInputs(Materials.SolderingAlloy.getMolten(576L)).duration(40 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1L, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBatChargeLamaCrystal", 1L, 0))
            .fluidInputs(Materials.SolderingAlloy.getMolten(1440L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hull_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4L),
                ItemList.Electric_Motor_MV.get(4L),
                ItemList.Electric_Pump_MV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Cobalt, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OilDrill1.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.OilDrill1.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 8L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L),
                ItemList.Electric_Motor_HV.get(4L),
                ItemList.Electric_Pump_HV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.BlueSteel, 8L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OilDrill2.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(288))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.OilDrill2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 12L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L),
                ItemList.Electric_Motor_EV.get(4L),
                ItemList.Electric_Pump_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 12L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OilDrill3.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(576))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.OilDrill3.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 16L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                ItemList.Electric_Motor_IV.get(4L),
                ItemList.Electric_Pump_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 16L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OilDrill4.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(1440))
            .duration(20 * SECONDS).eut(7860).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hull_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L),
                ItemList.Electric_Motor_EV.get(4L),
                ItemList.Electric_Pump_EV.get(4L),
                ItemList.Conveyor_Module_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Tungsten, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OreDrill1.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(72))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.OreDrill1.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                ItemList.Electric_Motor_IV.get(4L),
                ItemList.Electric_Pump_IV.get(4L),
                ItemList.Conveyor_Module_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Iridium, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OreDrill2.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(144))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.OreDrill2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L),
                ItemList.Electric_Motor_LuV.get(4L),
                ItemList.Electric_Pump_LuV.get(4L),
                ItemList.Conveyor_Module_LuV.get(4L),
                GT_OreDictUnificator.get(
                    OrePrefixes.gearGt,
                    Materials.Chrome,
                    4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OreDrill3.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(288))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.OreDrill3.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Europium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L),
                ItemList.Electric_Motor_ZPM.get(4L),
                ItemList.Electric_Pump_ZPM.get(4L),
                ItemList.Conveyor_Module_ZPM.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.MysteriousCrystal, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.OreDrill4.get(1L)).fluidInputs(Materials.SolderingAlloy.getMolten(576))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

        // LV Turbines

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Iron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
            .itemOutputs(
                GT_MetaGenerated_Tool_01.INSTANCE
                    .getToolWithStats(170, 1, Materials.Iron, Materials.Steel, null))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.WroughtIron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
            .itemOutputs(
                GT_MetaGenerated_Tool_01.INSTANCE
                    .getToolWithStats(170, 1, Materials.WroughtIron, Materials.Steel, null))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Bronze, 4L),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
            .itemOutputs(
                GT_MetaGenerated_Tool_01.INSTANCE
                    .getToolWithStats(170, 1, Materials.Bronze, Materials.Steel, null))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Steel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L))
            .itemOutputs(
                GT_MetaGenerated_Tool_01.INSTANCE
                    .getToolWithStats(170, 1, Materials.Steel, Materials.Steel, null))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        // UEV-UXV casings+hulls

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 8L),
                GT_Utility.getIntegratedCircuit(8))
            .itemOutputs(ItemList.Casing_UEV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 8L),
                GT_Utility.getIntegratedCircuit(8))
            .itemOutputs(ItemList.Casing_UIV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, MaterialsUEVplus.SpaceTime, 8L),
                GT_Utility.getIntegratedCircuit(8))
            .itemOutputs(ItemList.Casing_UMV.get(1L)).duration(2 * SECONDS + 10 * TICKS).eut(16)
            .addTo(sAssemblerRecipes);

        if (GoodGenerator.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(
                    GT_OreDictUnificator
                        .get(OrePrefixes.plate, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, 4L),
                    GT_OreDictUnificator.get("plateShirabon", 4),
                    GT_Utility.getIntegratedCircuit(8)).itemOutputs(ItemList.Casing_UXV.get(1L))
                .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(sAssemblerRecipes);

        }

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Draconium, 2L),
                ItemList.Casing_UEV.get(1L))
            .itemOutputs(ItemList.Hull_UEV.get(1L)).fluidInputs(Materials.Polybenzimidazole.getMolten(576L))
            .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.NetherStar, 2L),
                ItemList.Casing_UIV.get(1L))
            .itemOutputs(ItemList.Hull_UIV.get(1L)).fluidInputs(Materials.Polybenzimidazole.getMolten(576L))
            .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.Quantium, 2L),
                ItemList.Casing_UMV.get(1L))
            .itemOutputs(ItemList.Hull_UMV.get(1L)).fluidInputs(Materials.Polybenzimidazole.getMolten(576L))
            .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.BlackPlutonium, 2L),
                ItemList.Casing_UXV.get(1L))
            .itemOutputs(ItemList.Hull_UXV.get(1L)).fluidInputs(MaterialsKevlar.Kevlar.getMolten(576L))
            .duration(2 * SECONDS + 10 * TICKS).eut(16).addTo(sAssemblerRecipes);

        // Hermetic casings

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Plastic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_1.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.PolyvinylChloride, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_2.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_3.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_4.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_5.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_6.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NiobiumTitanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_7.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Enderium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_8.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_9.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MysteriousCrystal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 8L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Casing_Tank_10.get(1L)).duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.RawLapotronCrystal.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L))
            .itemOutputs(GT_ModHandler.getIC2Item("lapotronCrystal", 1L, 26)).duration(16 * SECONDS)
            .eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Firebrick.get(24),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L))
            .itemOutputs(ItemList.Casing_Firebricks.get(4L))
            .fluidInputs(Materials.Concrete.getMolten(4608)).duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Firebrick.get(24),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L))
            .itemOutputs(ItemList.Casing_Firebricks.get(4L)).fluidInputs(Materials.Concrete.getMolten(4608L))
            .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.brick_block), Materials.AnyBronze.getPlates(6))
            .itemOutputs(ItemList.Casing_BronzePlatedBricks.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                Materials.Steel.getPlates(4),
                Materials.Iron.getPlates(2),
                ItemList.Casing_BronzePlatedBricks.get(1L))
            .itemOutputs(ItemList.Casing_Pyrolyse.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        // Extreme Engine Intake Casing
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Casing_RobustTungstenSteel.get(1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 4))
            .itemOutputs(ItemList.Casing_ExtremeEngineIntake.get(4)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        // Filter Machine Casing for cleanroom
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
                ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 1L),
                ItemList.Component_Filter.get(2L),
                ItemList.SteelBars.get(2L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Casing_Vent.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.string, 3, 0), GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(new ItemStack(Blocks.wool, 1, 0)).duration(5 * SECONDS).eut(4).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hull_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                GT_ModHandler.getModItem(IronChests.ID, "BlockIronChest", 1L, 0))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockPersonal", 1L, 0))
            .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        // Covers

        GT_Values.RA.stdBuilder()
            .itemInputs(
                Materials.Aluminium.getPlates(4),
                Materials.Glass.getPlates(1),
                Materials.Glowstone.getDust(1),
                new ItemStack(Items.dye, 1, 1),
                new ItemStack(Items.dye, 1, 10),
                new ItemStack(Items.dye, 1, 4))
            .itemOutputs(ItemList.Cover_Screen.get(1L)).duration(5 * SECONDS).eut(5).addTo(sAssemblerRecipes);
        // Nukes

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMachine", 1L, 12))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockReactorChamber", 1L))
            .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Titanium, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockReactorChamber", 3L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Platinum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockGenerator", 1L, 5))
            .duration(60 * SECONDS).eut(960).addTo(sAssemblerRecipes);

        if (AdvancedSolarPanel.isModLoaded()) {
            // Irradiant Glass Pane
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4L, 2),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 4L, 0),
                    Materials.Glowstone.getPlates(1),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4L, 5))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

            // Irradiant Uranium
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    Materials.Uranium.getIngots(1),
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0))
                .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 2))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);
        }
        // Solar Light Splitter
        if (SuperSolarPanels.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(SuperSolarPanels.ID, "bluecomponent", 3L, 0),
                    GT_ModHandler.getModItem(SuperSolarPanels.ID, "redcomponent", 3L, 0),
                    GT_ModHandler.getModItem(SuperSolarPanels.ID, "greencomponent", 3L, 0),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "solarsplitter", 1L, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        }
        // Heat Exchangers

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
            .duration(3 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 1L, 1))
            .duration(3 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1))
            .fluidInputs(Materials.StainlessSteel.getMolten(72)).duration(SECONDS + 10 * TICKS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitch", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1L, 1))
            .duration(3 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Heat Vents

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                new ItemStack(Blocks.iron_bars, 2))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1)).duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentCore", 1L, 1))
            .duration(15 * SECONDS).eut(256).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                ItemList.IC2_Industrial_Diamond.get(1L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1),
                ItemList.StainlessSteelBars.get(4L))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1L, 1))
            .duration(15 * SECONDS).eut(256).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentGold", 1L, 1))
            .fluidInputs(Materials.StainlessSteel.getMolten(72)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Tin, 2L),
                ItemList.SteelBars.get(2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVent", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentSpread", 1L))
            .duration(15 * SECONDS).eut(256).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 4L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchCore", 2L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentCore", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensator", 1L, 1))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lapis, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.RedAlloy, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentGold", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchSpread", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensator", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensator", 1L, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorCondensatorLap", 1L, 1))
            .duration(45 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        // Reactor Plating

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 1L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4L))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlating", 1L)).duration(20 * SECONDS)
            .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Copper, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlating", 1L))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1L))
            .duration(30 * SECONDS).eut(256).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(23),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlating", 1L))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingExplosive", 1L))
            .duration(30 * SECONDS).eut(256).addTo(sAssemblerRecipes);
        // LV and MV Energy Hatches

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(4),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                ItemList.Electric_Pump_LV.get(1),
                ItemList.Hull_LV.get(1),
                ItemList.LV_Coil.get(2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1))
            .itemOutputs(ItemList.Hatch_Energy_LV.get(1)).fluidInputs(Materials.Lubricant.getFluid(2000))
            .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(4),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                ItemList.Electric_Pump_MV.get(1),
                ItemList.Hull_MV.get(1),
                ItemList.MV_Coil.get(2),
                ItemList.Circuit_Chip_ULPIC.get(2))
            .itemOutputs(ItemList.Hatch_Energy_MV.get(1)).fluidInputs(Materials.Lubricant.getFluid(2000))
            .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        // Neutron reflector recipes

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 16L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1))
            .requiresCleanRoom().duration(60 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 8L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1))
            .requiresCleanRoom().duration(45 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 4L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1))
            .requiresCleanRoom().duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0))
            .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflector", 1L, 1),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0))
            .requiresCleanRoom().duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorReflectorThick", 1L, 0),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom().duration(45 * SECONDS)
            .eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 36L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 64L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 32L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 32L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom()
            .duration(2 * MINUTES + 37 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 36L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 64L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 32L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.Neutron_Reflector.get(1L)).requiresCleanRoom()
            .duration(3 * MINUTES + 7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        // Wood Plates
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 64),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 64))
            .fluidInputs(Materials.Glue.getFluid(144L)).duration(2 * MINUTES).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        if (GTPlusPlus.isModLoaded()) { // GT++, remember to remove later
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WroughtIron, 1L),
                    ItemList.SteelBars.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "blockFishTrap", 1L, 0)).duration(10 * SECONDS)
                .eut(64).addTo(sAssemblerRecipes);
        }

        if (ExtraBees.isModLoaded()) {
            ItemStack alveary = GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 0);

            // Mutator
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 12),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 2L),
                    GT_ModHandler.getModItem(ExtraBees.ID, "hiveFrame.soul", 1L, 0))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 0))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Frame Housing
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 10),
                    GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L),
                    GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0),
                    GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0),
                    GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0),
                    GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 1))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Rain Shield
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 8),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockRubber", 4L),
                    new ItemStack(Blocks.brick_block, 1, 0))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 2))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Alveary Lighting
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 2),
                    new ItemStack(Blocks.stained_glass, 4, W),
                    new ItemStack(Blocks.redstone_lamp, 1, 0))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 3))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Electrical Stimulator
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 2L),
                    GT_ModHandler.getModItem(Forestry.ID, "chipsets", 2L, 2),
                    ItemList.Electric_Motor_HV.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 4))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Hatchery
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 3),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2L),
                    ItemList.Conveyor_Module_MV.get(2L),
                    GT_ModHandler.getModItem(Forestry.ID, "apiculture", 1L, 0))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 5))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Alveary Transmission
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 3L),
                    ItemList.Hull_HV.get(1L))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 6))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // Alveary Unlighting
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    alveary,
                    GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 8),
                    GT_ModHandler.getModItem(ExtraUtilities.ID, "curtains", 4L, 0),
                    new ItemStack(Blocks.wool, 1, 15))
                .itemOutputs(GT_ModHandler.getModItem(ExtraBees.ID, "alveary", 1L, 7))
                .fluidInputs(Materials.Honey.getFluid(7500L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

        }

        if (Gendustry.isModLoaded()) {
            // pollen collection kit
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(Gendustry.ID, "Labware", 1),
                    GT_ModHandler.getModItem(Minecraft.ID, "string", 1),
                    GT_ModHandler.getModItem(Minecraft.ID, "paper", 1))
                .itemOutputs(GT_ModHandler.getModItem(Gendustry.ID, "PollenKit", 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        }

        if (ExtraUtilities.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 9L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(ExtraUtilities.ID, "bedrockiumIngot", 1L, 0))
                .duration(TICKS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Unstable, 9L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(ExtraUtilities.ID, "unstableingot", 1L, 2))
                .duration(TICKS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

        }

        if (ExtraUtilities.isModLoaded() && IronChests.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(IronChests.ID, "BlockIronChest", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(ExtraUtilities.ID, "filing", 1L, 0))
                .fluidInputs(Materials.Plastic.getMolten(144L)).duration(15 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);
        }

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Infinity, 1L),
                ItemList.Hull_UEV.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UEV.get(1L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(2304L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UEV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, MaterialsUEVplus.TranscendentMetal, 1L),
                ItemList.Hull_UIV.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UIV.get(1L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(2304L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UIV)
            .addTo(sAssemblerRecipes);

        // crafting input slave
        GT_Values.RA.stdBuilder()
            .itemInputs(ItemList.Hatch_CraftingInput_Bus_ME_ItemOnly.get(1L), ItemList.Sensor_UV.get(1L))
            .itemOutputs(ItemList.Hatch_CraftingInput_Bus_Slave.get(1)).duration(10 * SECONDS)
            .eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        // Gear Box Casings
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Bronze, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Gearbox_Bronze.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Gearbox_Steel.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Gearbox_Titanium.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        // EBF Controller
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getIC2Item("ironFurnace", 3L),
                ItemList.Casing_HeatProof.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 3),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2))
            .itemOutputs(ItemList.Machine_Multi_BlastFurnace.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        // Vacuum Freezer Controller
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Pump_HV.get(3L),
                ItemList.Casing_FrostProof.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 3),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
            .itemOutputs(ItemList.Machine_Multi_VacuumFreezer.get(1)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        // Large Chemical Reactor
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(3L),
                ItemList.Casing_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 2L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Machine_Multi_LargeChemicalReactor.get(1)).duration(10 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        if (GraviSuite.isModLoaded() && GalacticraftMars.isModLoaded()) {
            // Gravitational Engine
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 2),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 4, 1),
                    ItemList.Transformer_LuV_IV.get(1),
                    GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 2, 2))
                .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
            // IV Transformer
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 4),
                    GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 1),
                    ItemList.Circuit_Chip_PIC.get(2),
                    ItemList.Hull_IV.get(1))
                .itemOutputs(ItemList.Transformer_LuV_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(sAssemblerRecipes);
            // Tesla Coil
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1),
                    ItemList.Circuit_Nanoprocessor.get(2),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemRecipePart", 5, 0),
                    ItemList.Transformer_HV_MV.get(1))
                .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
            // MV Transformer
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                    ItemList.Hull_MV.get(1),
                    ItemList.Circuit_Parts_InductorSMD.get(2))
                .itemOutputs(ItemList.Transformer_HV_MV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(sAssemblerRecipes);
            // Cooling Core With NaK
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 2, 1),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 2, 1),
                    Materials.CallistoIce.getPlates(1),
                    ItemList.Reactor_Coolant_NaK_3.get(2),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 2, 0))
                .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
            // Cooling Core With Helium
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 2, 1),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 2, 1),
                    Materials.CallistoIce.getPlates(1),
                    ItemList.Reactor_Coolant_He_3.get(2),
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 2, 0))
                .itemOutputs(GT_ModHandler.getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
            // Fluid Manipulator
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    ItemList.Large_Fluid_Cell_Steel.get(1),
                    GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, Materials.Steel, 4),
                    ItemList.Electric_Motor_HV.get(4))
                .itemOutputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "item.null", 1, 6)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        }
        // Quantum Tank V
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Bio), 4),
                Materials.Americium.getPlates(2),
                ItemList.Electric_Pump_UV.get(1),
                ItemList.Field_Generator_UV.get(1),
                ItemList.Casing_Tank_10.get(1))
            .itemOutputs(ItemList.Quantum_Tank_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);
        // Quantum Tank IV
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Infinite), 4),
                Materials.Europium.getPlates(2),
                ItemList.Electric_Pump_ZPM.get(1),
                ItemList.Field_Generator_ZPM.get(1),
                ItemList.Casing_Tank_9.get(1))
            .itemOutputs(ItemList.Quantum_Tank_EV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);
        // Quantum Chest V
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Bio), 4),
                Materials.Americium.getPlates(3),
                ItemList.Field_Generator_UV.get(1),
                ItemList.Automation_ChestBuffer_UEV.get(1L))
            .itemOutputs(ItemList.Quantum_Chest_IV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);
        // Ultra High Voltage Chest Buffer
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Conveyor_Module_UEV.get(1),
                GT_OreDictUnificator.get(OrePrefixes.circuit.get(Materials.Bio), 1),
                ItemList.Hull_UEV.get(1),
                GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Wood, 1))
            .itemOutputs(ItemList.Automation_ChestBuffer_UEV.get(1L)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        if (HardcoreEnderExpansion.isModLoaded()) {
            // Biome Compass
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    Materials.HeeEndium.getPlates(1),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HeeEndium, 1),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.HeeEndium, 2),
                    GT_OreDictUnificator.get(OrePrefixes.ring, Materials.HeeEndium, 2),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0))
                .itemOutputs(GT_ModHandler.getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        }
        if (StorageDrawers.isModLoaded()) {
            // Alternate Storage Template Recipe
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    ItemList.Electric_Piston_LV.get(1),
                    GT_OreDictUnificator.get("drawerBasic", 1),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(StorageDrawers.ID, "upgradeTemplate", 3, 0))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        }
        // Ender-Quantum Component
        if (SuperSolarPanels.isModLoaded() && (AdvancedSolarPanel.isModLoaded())) {
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.InfinityCatalyst, 1),
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 4, 3),
                    Materials.ElectrumFlux.getPlates(4))
                .itemOutputs(GT_ModHandler.getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1, 0))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        }
        // 4A Zpm to LuV transformer
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.VanadiumGallium, 4),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Naquadah, 1),
                ItemList.Circuit_Chip_HPIC.get(2),
                ItemList.Hull_LuV.get(1))
            .itemOutputs(ItemList.Transformer_ZPM_LuV.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);
        if (GTPlusPlus.isModLoaded()) {
            // 16A Zpm to LuV transformer
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.VanadiumGallium, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Naquadah, 1),
                    ItemList.Transformer_ZPM_LuV.get(1),
                    ItemList.Casing_Coil_TungstenSteel.get(1))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 883))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

            // Hastelloy-X Structural Block
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    ItemList.Casing_EV.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2),
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "itemGearHastelloyX", 1L),
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "blockFrameGtHastelloyC276", 1L),
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "itemRingInconel792", 2L))
                .itemOutputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "gtplusplus.blockcasings.2", 1L, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);
        }
        // Ultimate Time Anomaly
        if (KekzTech.isModLoaded()) {
            // LSC controller
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.battery, Materials.Master, 4),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2),
                    ItemList.Circuit_Chip_PIC.get(2))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.blockmachines", 1, 13106))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        }
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, MaterialsUEVplus.SpaceTime, 1),
                ItemList.Hull_UMV.get(1),
                GT_Utility.getIntegratedCircuit(4))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(2304))
            .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UMV.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UMV)
            .addTo(sAssemblerRecipes);
        // Spacetime quadruple is temp replacement until Universium Pipes.
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.pipeQuadruple, MaterialsUEVplus.SpaceTime, 4),
                ItemList.Hull_UXV.get(1),
                GT_Utility.getIntegratedCircuit(4))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(2304))
            .itemOutputs(ItemList.Hatch_Input_Multi_2x2_UXV.get(1)).duration(30 * SECONDS).eut(TierEU.RECIPE_UXV)
            .addTo(sAssemblerRecipes);
        // Diamond Gear
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Diamond, 1L))
            .fluidInputs(Materials.Lubricant.getFluid(250L)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);
    }

    private void makeElectricMachinePartRecipes() {
        // Motors

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
            .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
            .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
            .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
            .itemOutputs(ItemList.Electric_Motor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L))
            .itemOutputs(ItemList.Electric_Motor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnnealedCopper, 2L))
            .itemOutputs(ItemList.Electric_Motor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Silver, 2L))
            .itemOutputs(ItemList.Electric_Motor_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackSteel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L))
            .itemOutputs(ItemList.Electric_Motor_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L))
            .itemOutputs(ItemList.Electric_Motor_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Pumps

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
            .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
            .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1))
            .itemOutputs(ItemList.Electric_Pump_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
            .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
            .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1))
            .itemOutputs(ItemList.Electric_Pump_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
            .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
            .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1))
            .itemOutputs(ItemList.Electric_Pump_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
            .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
            .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1))
            .itemOutputs(ItemList.Electric_Pump_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1))
            .itemOutputs(ItemList.Electric_Pump_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1))
            .itemOutputs(ItemList.Electric_Pump_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Conveyors

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
            .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
            .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1))
            .itemOutputs(ItemList.Conveyor_Module_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1))
            .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1))
            .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1))
            .itemOutputs(ItemList.Conveyor_Module_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
            .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
            .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1))
            .itemOutputs(ItemList.Conveyor_Module_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
            .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
            .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1))
            .itemOutputs(ItemList.Conveyor_Module_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1))
            .itemOutputs(ItemList.Conveyor_Module_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1))
            .itemOutputs(ItemList.Conveyor_Module_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Pistons

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1))
            .itemOutputs(ItemList.Electric_Piston_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1))
            .itemOutputs(ItemList.Electric_Piston_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1))
            .itemOutputs(ItemList.Electric_Piston_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1))
            .itemOutputs(ItemList.Electric_Piston_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1))
            .itemOutputs(ItemList.Electric_Piston_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Robot Arms

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_LV.get(2L),
                ItemList.Electric_Piston_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3))
            .itemOutputs(ItemList.Robot_Arm_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_MV.get(2L),
                ItemList.Electric_Piston_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 3))
            .itemOutputs(ItemList.Robot_Arm_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_HV.get(2L),
                ItemList.Electric_Piston_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3))
            .itemOutputs(ItemList.Robot_Arm_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_EV.get(2L),
                ItemList.Electric_Piston_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3))
            .itemOutputs(ItemList.Robot_Arm_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Electric_Motor_IV.get(2L),
                ItemList.Electric_Piston_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3))
            .itemOutputs(ItemList.Robot_Arm_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Emitter

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2))
            .itemOutputs(ItemList.Emitter_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2))
            .itemOutputs(ItemList.Emitter_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2))
            .itemOutputs(ItemList.Emitter_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.QuantumEye.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2))
            .itemOutputs(ItemList.Emitter_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.QuantumStar.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2))
            .itemOutputs(ItemList.Emitter_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Sensor

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L))
            .itemOutputs(ItemList.Sensor_LV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L))
            .itemOutputs(ItemList.Sensor_MV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L))
            .itemOutputs(ItemList.Sensor_HV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.QuantumEye.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L))
            .itemOutputs(ItemList.Sensor_EV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.QuantumStar.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L))
            .itemOutputs(ItemList.Sensor_IV.get(1L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
        // Field Generator

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Field_Generator_LV.get(1)).fluidInputs(Materials.RedSteel.getMolten(288))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Field_Generator_MV.get(1)).fluidInputs(Materials.TungstenSteel.getMolten(288))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.QuantumEye.get(1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Field_Generator_HV.get(1)).fluidInputs(Materials.NiobiumTitanium.getMolten(576))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                GT_Utility.getIntegratedCircuit(13))
            .itemOutputs(ItemList.Field_Generator_EV.get(1)).fluidInputs(Materials.HSSG.getMolten(576))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.QuantumStar.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Field_Generator_IV.get(1L)).fluidInputs(Materials.HSSS.getMolten(576))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

    }

    private void makeCircuitPartRecipes() {
        // Circuits and Boards

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(8L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 1152)).duration(MINUTES + 20 * SECONDS).eut(8)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(8L)).fluidInputs(Materials.Glue.getFluid(576L))
            .duration(MINUTES + 20 * SECONDS).eut(8).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(16L))
            .fluidInputs(Materials.Plastic.getMolten(288L)).duration(MINUTES + 20 * SECONDS).eut(8)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(16L))
            .fluidInputs(Materials.Polytetrafluoroethylene.getMolten(144L)).duration(MINUTES + 20 * SECONDS)
            .eut(8).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(24L)).fluidInputs(Materials.Epoxid.getMolten(144L))
            .duration(MINUTES + 20 * SECONDS).eut(8).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Board_Coated_Basic.get(32L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(72L)).duration(MINUTES + 20 * SECONDS).eut(8)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Circuit_Board_Phenolic.get(8L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(2 * MINUTES).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Circuit_Board_Phenolic.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(2 * MINUTES).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Circuit_Board_Phenolic.get(16L)).fluidInputs(Materials.BisphenolA.getFluid(144))
            .duration(2 * MINUTES).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Circuit_Board_Phenolic.get(24L)).fluidInputs(Materials.Epoxid.getMolten(144L))
            .duration(2 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Glass_Tube.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(2L)).fluidInputs(Materials.Redstone.getMolten(144L))
            .duration(8 * SECONDS).eut(8).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(4L)).fluidInputs(Materials.RedAlloy.getMolten(72L))
            .duration(8 * SECONDS).eut(8).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(8L))
            .fluidInputs(Materials.RedstoneAlloy.getMolten(72L)).duration(8 * SECONDS).eut(8)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(8L)).fluidInputs(Materials.RedAlloy.getMolten(72L))
            .duration(8 * SECONDS).eut(8).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Vacuum_Tube.get(16L))
            .fluidInputs(Materials.RedstoneAlloy.getMolten(72L)).duration(8 * SECONDS).eut(8)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(4L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L)).fluidInputs(Materials.Glue.getFluid(288))
            .duration(16 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(ItemList.Circuit_Parts_Resistor.get(8L))
            .fluidInputs(FluidRegistry.getFluidStack("glue", 576)).duration(16 * SECONDS).eut(16)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(4L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(2L)).fluidInputs(Materials.Glass.getMolten(288L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(2L))
            .fluidInputs(FluidRegistry.getFluidStack("glass.molten", 1000)).duration(30 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(2L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(1L))
            .fluidInputs(FluidRegistry.getFluidStack("glass.molten", 1000)).duration(30 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(1L)).fluidInputs(Materials.Glass.getMolten(288L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(4L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(8L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Coil.get(2L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Coil.get(4L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Coil.get(4L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(60).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Coil.get(8L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(60).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Capacitor.get(12L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_Capacitor.get(8L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 8),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.Circuit_Parts_Transistor.get(6L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);
        // All SMD Component recipes.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_ResistorSMD.get(16L)).fluidInputs(Materials.Plastic.getMolten(288L))
            .duration(16 * SECONDS).eut(96).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_ResistorSMD.get(32L)).fluidInputs(Materials.Plastic.getMolten(288L))
            .duration(16 * SECONDS).eut(96).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(6L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(ItemList.Circuit_Parts_Diode.get(16L)).fluidInputs(Materials.Plastic.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_DiodeSMD.get(64L)).fluidInputs(Materials.Plastic.getMolten(576L))
            .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 8),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_TransistorSMD.get(16L))
            .fluidInputs(Materials.Plastic.getMolten(288L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 8),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_TransistorSMD.get(32L))
            .fluidInputs(Materials.Plastic.getMolten(288L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);
        // Normal SMD

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(16L))
            .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(24L))
            .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(32L))
            .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_CapacitorSMD.get(48L))
            .fluidInputs(Materials.Plastic.getMolten(144L)).duration(16 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.ConductiveIron, 8),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(24L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 8),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(32L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 8),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(48L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Iridium, 8),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_InductorSMD.get(64L)).fluidInputs(Materials.Plastic.getMolten(36L))
            .duration(16 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
        // ASMD

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphene, 2),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Parts_ResistorASMD.get(64L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Parts_DiodeASMD.get(64L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumGallium, 2),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSG, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Parts_TransistorASMD.get(64L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSS, 2),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Parts_CapacitorASMD.get(64L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(15 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Samarium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSE, 32),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6))
            .itemOutputs(ItemList.Circuit_Parts_InductorASMD.get(64L))
            .fluidInputs(Materials.Polybenzimidazole.getMolten(576L)).duration(8 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);
        // xSMD
        // Resistor

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Naquadria, 4L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilPikyonium64B", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9))
            .itemOutputs(ItemList.Circuit_Parts_ResistorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
            .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);
        // Transistor

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlackPlutonium, 4L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilArceusAlloy2B", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9))
            .itemOutputs(ItemList.Circuit_Parts_TransistorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
            .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);
        // Capacitor

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Draconium, 4L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilCinobiteA243", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9))
            .itemOutputs(ItemList.Circuit_Parts_CapacitorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
            .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);
        // Diode

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tritanium, 4L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemFoilLafiumCompound", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9))
            .itemOutputs(ItemList.Circuit_Parts_DiodeXSMD.get(64L)).fluidInputs(Xenoxene.getFluid(144L))
            .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);
        // Inductor

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedfoil", 4L, 10105),
                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedfoil", 1L, 10102),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9))
            .itemOutputs(ItemList.Circuit_Parts_InductorXSMD.get(32L)).fluidInputs(Xenoxene.getFluid(144L))
            .duration(8 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

    }

    private void makeEnderIORecipes() {
        if (!EnderIO.isModLoaded()) {
            return;
        }

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L),
                Materials.Glowstone.getDust(4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 2)).duration(25 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        for (int i = 0; i < OreDictionary.getOres("dyeBlack").size(); i++) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L),
                    OreDictionary.getOres("dyeBlack").get(i).splitStack(4))
                .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 4)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        }

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 7))
            .fluidInputs(Materials.Plastic.getMolten(288)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Aluminium, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 0))
            .fluidInputs(Materials.Plastic.getMolten(288)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tantalum, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 1))
            .fluidInputs(Materials.EnergeticAlloy.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.EnderEye, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 8))
            .fluidInputs(Materials.EnergeticSilver.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Chrome, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 2))
            .fluidInputs(Materials.EnergeticAlloy.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.EnderEye, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 4),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 9))
            .fluidInputs(Materials.EnergeticSilver.getMolten(576)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                ItemList.QuantumEye.get(1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 3))
            .fluidInputs(Materials.CrystallineAlloy.getMolten(864)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                ItemList.QuantumEye.get(1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 3))
            .fluidInputs(Materials.CrystallineAlloy.getMolten(864)).duration(10 * SECONDS).eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EndSteel, 1),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 4))
            .fluidInputs(Materials.MelodicAlloy.getMolten(1152)).duration(10 * SECONDS).eut(TierEU.RECIPE_IV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.VanadiumGallium, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                ItemList.QuantumStar.get(1L),
                GT_ModHandler.getModItem(EnderIO.ID, "itemMaterial", 1L, 13),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 5))
            .fluidInputs(Materials.StellarAlloy.getMolten(1440)).duration(10 * SECONDS).eut(TierEU.RECIPE_LuV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedbolt", 4L, 10024),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Manganese, 4),
                ItemList.Gravistar.get(1L),
                GT_ModHandler.getModItem(EnderIO.ID, "itemFrankenSkull", 1L, 5),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 2),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 6))
            .fluidInputs(Materials.Neutronium.getMolten(1440)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 5),
                ItemList.Gravistar.get(1L),
                GT_ModHandler.getModItem(EnderIO.ID, "itemFrankenSkull", 1L, 5),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StellarAlloy, 2))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemBasicCapacitor", 1L, 6))
            .fluidInputs(Materials.Neutronium.getMolten(1152)).duration(10 * SECONDS).eut(TierEU.RECIPE_ZPM)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(Minecraft.ID, "skull", 1L, 0),
                GT_ModHandler.getModItem(Minecraft.ID, "rotten_flesh", 2L, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 1))
            .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "itemFrankenSkull", 1L, 5))
            .fluidInputs(Materials.Soularium.getMolten(288)).duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM)
            .addTo(sAssemblerRecipes);

    }

    private void makeAE2Recipes() {
        if (!AppliedEnergistics2.isModLoaded()) {
            return;
        }

        // AE2 Illuminated Panel Assembler Recipe

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Cover_Screen.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 180))
            .fluidInputs(Materials.SolderingAlloy.getMolten(144L)).duration(5 * SECONDS).eut(4)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(Blocks.glass_pane, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 39))
            .duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hatch_Output_Bus_HV.get(1L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1L, 440),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Hatch_Output_Bus_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hatch_Output_HV.get(1L),
                GT_ModHandler.getModItem(AE2FluidCraft.ID, "part_fluid_interface", 1L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Hatch_Output_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        // Stocking Input Bus (ME)
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hatch_Input_Bus_HV.get(1L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1L),
                // Acceleration Card
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4L, 30),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.Hatch_Input_Bus_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        // Stocking Input Hatch (ME)
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Hatch_Input_Multi_2x2_UV.get(4L),
                GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_interface", 1L),
                ItemList.Circuit_Chip_NeuroCPU.get(1L),
                ItemList.Electric_Pump_UV.get(1L),
                // 4096k Me Fluid Storage Component
                GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_part", 4L, 6),
                // Hyper-Acceleration Card
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 56))
            .itemOutputs(ItemList.Hatch_Input_ME.get(1)).duration(15 * SECONDS).eut(TierEU.RECIPE_UV)
            .addTo(sAssemblerRecipes);

        // Cell Workbench
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                ItemList.Cover_Screen.get(1),
                GT_ModHandler.getModItem(Minecraft.ID, "crafting_table", 1),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCellWorkbench", 1))
            .fluidInputs(Materials.Titanium.getMolten(36L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        // Controller
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Energy Cells
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fluix, 1),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockFluix", 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 2L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 5, 0),
                ItemList.Battery_Buffer_4by4_EV.get(1L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Void Cell
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 3L),
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemVoidStorageCell", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Quantum Link
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 22),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumRing", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 9),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 1, 0),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockQuantumLinkChamber", 1))
            .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Spatial Pylon
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Fluix, 2L),
                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Fluix, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Spatial IO
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialPylon", 1),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockSpatialIOPort", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // ME IO Port
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 3, 16),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 2, 0),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockIOPort", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // ME Chest
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                GT_ModHandler.getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        // ME Drive
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockChest", 1),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockDrive", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Interface
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 16),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                ItemList.Casing_EV.get(1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Crafting Unit
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockCraftingUnit", 1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Formation Core
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CertusQuartz, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 22),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 43)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Annihilation Core
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NetherQuartz, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 22),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 12),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 44)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Wireless Receiver
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 2L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 2, 140),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 9),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
        // Molecular Assembler
        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.Machine_EV_Assembler.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4L),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 43),
                GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 44),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockMolecularAssembler", 1))
            .fluidInputs(Materials.Glass.getMolten(288L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        if (AE2FluidCraft.isModLoaded()) {
            // Dual Interface
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                    GT_ModHandler.getModItem(AppliedEnergistics2.ID, "tile.BlockInterface", 1),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_interface", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
            // Fluid Storage Housing
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                    GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                    GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 1)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);
            // Multi Fluid Storage Housing
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                    GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 2)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.CertusQuartz, 2L),
                    GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(GT_ModHandler.getModItem(AE2FluidCraft.ID, "fluid_storage_housing", 1, 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        }
        if (AE2Stuff.isModLoaded()) {
            // Wireless Connector
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                    GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 4, 12),
                    GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 24),
                    GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 41),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(AE2Stuff.ID, "tile.wireless", 1)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(sAssemblerRecipes);
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L))
                .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1L, 39))
                .duration(5 * SECONDS).eut(16).addTo(sAssemblerRecipes);

        }
    }

    private void makeTinkersConstructRecipes() {
        if (!TinkerConstruct.isModLoaded()) {
            return;
        }

        // Assembler

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 1),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockITNT", 1L, 0),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "explosive.slime", 1L, 0))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 0),
                GT_ModHandler.getModItem(TinkerConstruct.ID, "explosive.slime", 1L, 0),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "explosive.slime", 1L, 2))
            .duration(30 * SECONDS).eut(64).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 4L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "heartCanister", 1L, 0)).duration(2 * MINUTES)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

    }

    private void makeForestryRecipes() {
        if (!Forestry.isModLoaded()) {
            return;
        }

        ItemStack alveary = GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 0);

        // Apiary
        List<ItemStack> fence = OreDictionary.getOres("fenceWood");
        for (ItemStack stack : fence) {
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(Forestry.ID, "frameImpregnated", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 2L),
                    GT_ModHandler.getModItem(Forestry.ID, "beeCombs", 1L, W),
                    GT_ModHandler.getModItem(Forestry.ID, "apiculture", 2L, 2),
                    stack.splitStack(2))
                .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "apiculture", 1L, 0))
                .fluidInputs(Materials.SeedOil.getFluid(1000L)).duration(60 * SECONDS).eut(64)
                .addTo(sAssemblerRecipes);
        }

        // Scented Paneling

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 2L),
                GT_ModHandler.getModItem(Forestry.ID, "royalJelly", 1L, 0),
                GT_ModHandler.getModItem(Forestry.ID, "oakStick", 3L, 0),
                GT_ModHandler.getModItem(Forestry.ID, "beeswax", 2L, 0),
                GT_ModHandler.getModItem(Forestry.ID, "pollen", 1L, W))
            .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "craftingMaterial", 1L, 6))
            .fluidInputs(Materials.Honey.getFluid(1000L)).duration(60 * SECONDS).eut(64).addTo(sAssemblerRecipes);
        // Swarmer

        GT_Values.RA.stdBuilder()
            .itemInputs(
                alveary,
                GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 5),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.RoseGold, 2L),
                GT_ModHandler.getModItem(Forestry.ID, "royalJelly", 2L, 0),
                GT_ModHandler.getModItem(Forestry.ID, "frameProven", 1L, 0))
            .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 2))
            .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);
        // Alveary Fan

        GT_Values.RA.stdBuilder()
            .itemInputs(
                alveary,
                GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 11),
                ItemList.SteelBars.get(3L),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1L),
                ItemList.Electric_Motor_MV.get(1L))
            .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 3))
            .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);
        // Alveary Heater

        GT_Values.RA.stdBuilder()
            .itemInputs(
                alveary,
                GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 7),
                ItemList.SteelBars.get(1L),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemRecipePart", 3L),
                ItemList.Electric_Motor_MV.get(1L))
            .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 4))
            .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);
        // Alveary Hygroregulator

        GT_Values.RA.stdBuilder()
            .itemInputs(
                alveary,
                GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 6),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                //GT_ModHandler.getModItem(BuildCraftFactory.ID, "tankBlock", 2L, 0),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L))
            .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 5))
            .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        // Alveary Sieve

        GT_Values.RA.stdBuilder()
            .itemInputs(
                alveary,
                GT_ModHandler.getModItem(Forestry.ID, "thermionicTubes", 4L, 9),
                GT_ModHandler.getModItem(Forestry.ID, "craftingMaterial", 4L, 3),
                GT_ModHandler.getModItem(Forestry.ID, "pollenFertile", 1L, GT_Values.W))
            .itemOutputs(GT_ModHandler.getModItem(Forestry.ID, "alveary", 1L, 7))
            .fluidInputs(Materials.Honey.getFluid(5000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

    }

    private void makeReinforcedIronPlateRecipes() {

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 4),
                ItemList.AluminiumIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedAluminiumIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 4),
                ItemList.TitaniumIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedTitaniumIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 4),
                ItemList.TungstenIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedTungstenIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                ItemList.TungstenSteelIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedTungstenSteelIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4),
                ItemList.ChromeIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedChromeIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartIridium", 4),
                GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6))
            .itemOutputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 7))
            .duration(5 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MysteriousCrystal, 4),
                ItemList.NaquadriaIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedNaquadriaIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_UV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4),
                ItemList.NeutroniumIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedNeutroniumIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_UHV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 4),
                ItemList.BedrockiumIronPlate.get(1))
            .itemOutputs(ItemList.ReinforcedBedrockiumIronPlate.get(1)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_UEV).addTo(sAssemblerRecipes);

    }

    private void makeMixedMetalIngotRecipes() {

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 1L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 2L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 3L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 4L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 5L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 6L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 6L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 8L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 8L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 8L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 10L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 10L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 10L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 12L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 12L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 12L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 14L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 14L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 14L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 16L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 16L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 16L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 18L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 18L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 18L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 20L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 20L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AstralSilver, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 20L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 22L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 24L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 26L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 28L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 30L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 32L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 34L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 36L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 38L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 40L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 42L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 44L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSS, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 48L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 52L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 56L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1))
            .itemOutputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemIngot", 64L, 4)).duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

    }

    private void makePistonRecipes() {
        // Vanilla Piston Assembler recipe
        List<ItemStack> fenceWood = OreDictionary.getOres("fenceWood");
        for (ItemStack oreStack : fenceWood) {

            ItemStack stack = oreStack.splitStack(1);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Blocks.cobblestone, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                    stack,
                    ItemList.Plank_Oak.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Blocks.cobblestone, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                    stack,
                    ItemList.Plank_Spruce.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Blocks.cobblestone, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                    stack,
                    ItemList.Plank_Birch.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Blocks.cobblestone, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                    stack,
                    ItemList.Plank_Jungle.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Blocks.cobblestone, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                    stack,
                    ItemList.Plank_Acacia.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Blocks.cobblestone, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                    stack,
                    ItemList.Plank_DarkOak.get(6L),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            if (Forestry.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Larch.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Teak.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Acacia_Green.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Lime.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Chestnut.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Wenge.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Baobab.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Sequoia.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Kapok.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Ebony.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Mahagony.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Balsa.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Willow.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Walnut.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Greenheart.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Cherry.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Mahoe.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Poplar.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Palm.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Papaya.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Pine.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Plum.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Maple.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

                GT_Values.RA.stdBuilder()
                    .itemInputs(
                        new ItemStack(Blocks.cobblestone, 1, 0),
                        GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1L),
                        stack,
                        ItemList.Plank_Citrus.get(6L),
                        GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Redstone.getMolten(72L))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

            }
        }
    }

    private void makeCoilRecipes() {

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                ItemList.AluminoSilicateWool.get(12L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L)).fluidInputs(Materials.Tin.getMolten(288L))
            .duration(5 * SECONDS).eut(7).addTo(sAssemblerRecipes);
        // TODO: Rework other stuff (that depends on certain Heat Levels, mostly LuV+ stuff) so this can be wrapped into
        // a oneliner.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                ItemList.AluminoSilicateWool.get(16L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L)).fluidInputs(Materials.Tin.getMolten(144L))
            .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Kanthal, 8L),
                ItemList.AluminoSilicateWool.get(24L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_Kanthal.get(1L)).fluidInputs(Materials.Cupronickel.getMolten(144L))
            .duration(15 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Nichrome, 8L),
                ItemList.AluminoSilicateWool.get(32L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_Nichrome.get(1L)).fluidInputs(Materials.Kanthal.getMolten(144L))
            .duration(20 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TPV, 8L),
                ItemList.AluminoSilicateWool.get(40L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_TungstenSteel.get(1L)).fluidInputs(Materials.Nichrome.getMolten(144L))
            .duration(25 * SECONDS).eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSG, 8L),
                ItemList.AluminoSilicateWool.get(48L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_HSSG.get(1L)).fluidInputs(Materials.TPV.getMolten(144L))
            .duration(30 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSS, 8L),
                ItemList.AluminoSilicateWool.get(52L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_HSSS.get(1L)).fluidInputs(Materials.HSSG.getMolten(144L))
            .duration(35 * SECONDS).eut(TierEU.RECIPE_IV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 8L),
                ItemList.AluminoSilicateWool.get(56L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_Naquadah.get(1L)).fluidInputs(Materials.HSSS.getMolten(144L))
            .duration(40 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 8L),
                ItemList.AluminoSilicateWool.get(58L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_NaquadahAlloy.get(1L)).fluidInputs(Materials.Naquadah.getMolten(144L))
            .duration(45 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Trinium, 8L),
                ItemList.AluminoSilicateWool.get(60L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_Trinium.get(1L)).fluidInputs(Materials.NaquadahAlloy.getMolten(144L))
            .duration(50 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.ElectrumFlux, 8L),
                ItemList.AluminoSilicateWool.get(62L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_ElectrumFlux.get(1L)).fluidInputs(Materials.Trinium.getMolten(144L))
            .duration(55 * SECONDS).eut(TierEU.RECIPE_UV).addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.DraconiumAwakened, 8L),
                ItemList.AluminoSilicateWool.get(64L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Casing_Coil_AwakenedDraconium.get(1L))
            .fluidInputs(Materials.ElectrumFlux.getMolten(144L)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
            .addTo(sAssemblerRecipes);
    }

    private void makeSolderingAlloyRecipes() {
        for (Materials tMat : solderingMaterials) { // TODO dream things using soldering go in here!

            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            // solar 1EU

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    ItemList.Circuit_Silicon_Wafer.get(2),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                    GT_ModHandler.getIC2Item("reinforcedGlass", 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2L),
                    ItemList.AluminiumIronPlate.get(1))
                .itemOutputs(ItemList.Cover_SolarPanel.get(1L)).fluidInputs(tMat.getMolten(72L * tMultiplier / 2L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sAssemblerRecipes);
            // solar 8EU

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                    ItemList.Cover_SolarPanel.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 2L),
                    ItemList.Circuit_Silicon_Wafer.get(1),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.GalliumArsenide, 1L),
                    ItemList.ReinforcedAluminiumIronPlate.get(1))
                .itemOutputs(ItemList.Cover_SolarPanel_8V.get(1L))
                .fluidInputs(tMat.getMolten(72L * tMultiplier / 2L)).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);
        }
    }
}
