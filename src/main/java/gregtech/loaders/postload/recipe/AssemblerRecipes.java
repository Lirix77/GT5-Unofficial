package gregtech.loaders.postload.recipe;

import static gregtech.api.enums.GT_Values.W;
import static gregtech.api.enums.Materials.Xenoxene;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.items.GT_MetaGenerated_Tool_01;

public class AssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy, Materials.Tin };

    @Override
    public void run() {
        makeCoilRecipes();
        registerMixedMetalIngotRecipes();
        registerReinforcedIronAlloyPlates();
        registerSolderingAlloyRecipes();
        registerGregTechRecipes();

        if (Loader.isModLoaded("Forestry")) {
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    ItemList.Casing_LV.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 4L))
                .itemOutputs(ItemList.FR_Casing_Sturdy.get(1L))
                .duration(SECONDS)
                .eut(TierEU.RECIPE_LV)
                .addTo(sAssemblerRecipes);
        }

        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorLuV, 64L),
            ItemList.MicaInsulatorFoil.get(48L),
            Materials.Trinium.getMolten(1440L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000,
            9001);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorZPM, 32L),
            ItemList.MicaInsulatorFoil.get(32L),
            Materials.Trinium.getMolten(576L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000,
            9001);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUV, 16L),
            ItemList.MicaInsulatorFoil.get(16L),
            Materials.Trinium.getMolten(288L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000,
            9001);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUHV, 8L),
            ItemList.MicaInsulatorFoil.get(8L),
            Materials.Trinium.getMolten(144L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000,
            9001);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUEV, 4L),
            ItemList.MicaInsulatorFoil.get(4L),
            Materials.Trinium.getMolten(72L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000,
            9001);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUIV, 2L),
            ItemList.MicaInsulatorFoil.get(2L),
            Materials.Trinium.getMolten(36L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000,
            9001);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.SuperconductorUMV, 1L),
            ItemList.MicaInsulatorFoil.get(1L),
            Materials.Trinium.getMolten(18L),
            ItemList.Casing_Coil_Superconductor.get(1L),
            1000, 9001);

        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.SteelBars.get(4L),
            400, 48);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.AluminiumBars.get(4L),
            400, 64);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.StainlessSteelBars.get(4L),
            400, 96);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.TitaniumBars.get(4L),
            400, 120);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Tungsten, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.TungstenBars.get(4L),
            400, 192);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.TungstenSteelBars.get(4L),
            400, 256);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.ChromeBars.get(4L),
            400, 480);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.IridiumBars.get(4L),
            400, 1024);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Osmium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.OsmiumBars.get(4L),
            400, 1920);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Neutronium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.NeutroniumBars.get(4L),
            400, 4096);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.RedstoneAlloy, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.RedstoneAlloyBars.get(4L),
            400, 48);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ElectricalSteel, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.ElectricalSteelBars.get(4L),
            400, 64);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.ConductiveIron, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.ConductiveIronBars.get(4L),
            400, 160);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnergeticAlloy, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.EnergeticAlloyBars.get(4L),
            400, 384);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.VibrantAlloy, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.VibrantAlloyBars.get(4L),
            400, 768);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.PulsatingIron, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.PulsatingIronBars.get(4L),
            400, 120);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Soularium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.SoulariumBars.get(4L),
            400, 64);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderiumBase, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.EnderiumBaseBars.get(4L),
            400, 256);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Enderium, 3L),
            GT_Utility.getIntegratedCircuit(3),
            ItemList.EnderiumBars.get(4L),
            400, 1024);

        // IC2 Charging Batteries
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("IC2", "itemBatREDischarged", 4L, W),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1L),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.SolderingAlloy.getMolten(144L),
            GT_ModHandler.getModItem("IC2", "itemBatChargeRE", 1L, 0),
            200, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, W),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Copper, 1L),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.SolderingAlloy.getMolten(288L),
            GT_ModHandler.getModItem("IC2", "itemBatChargeAdv", 1L, 0),
            400, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemBatCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt04, Materials.Gold, 1L),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.SolderingAlloy.getMolten(576L),
            GT_ModHandler.getModItem("IC2", "itemBatChargeCrystal", 1L, 0),
            800, 480);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "itemBatLamaCrystal", 1L, W),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt08, Materials.Aluminium, 1L),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.SolderingAlloy.getMolten(1440L),
            GT_ModHandler.getModItem("IC2", "itemBatChargeLamaCrystal", 1L, 0),
            1200, 1920);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Hull_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Steel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4L),
                ItemList.Electric_Motor_MV.get(4L), ItemList.Electric_Pump_MV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Cobalt, 4L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(144),
            ItemList.OilDrill1.get(1L),
            400, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.OilDrill1.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 8L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4L),
                ItemList.Electric_Motor_HV.get(4L), ItemList.Electric_Pump_HV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.BlueSteel, 8L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(288),
            ItemList.OilDrill2.get(1L),
            400, 480);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.OilDrill2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 12L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L),
                ItemList.Electric_Motor_EV.get(4L), ItemList.Electric_Pump_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Titanium, 12L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(576),
            ItemList.OilDrill3.get(1L),
            400, 1920);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.OilDrill3.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 16L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                ItemList.Electric_Motor_IV.get(4L), ItemList.Electric_Pump_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.TungstenSteel, 16L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(1440),
            ItemList.OilDrill4.get(1L),
            400, 7860);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Hull_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Titanium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4L),
                ItemList.Electric_Motor_EV.get(4L), ItemList.Electric_Pump_EV.get(4L),
                ItemList.Conveyor_Module_EV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Tungsten, 4L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(72),
            ItemList.OreDrill1.get(1L),
            400, 1920);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.OreDrill1.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.TungstenSteel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4L),
                ItemList.Electric_Motor_IV.get(4L), ItemList.Electric_Pump_IV.get(4L),
                ItemList.Conveyor_Module_IV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Iridium, 4L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(144),
            ItemList.OreDrill2.get(1L),
            400, 7680);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.OreDrill2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Osmiridium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4L),
                ItemList.Electric_Motor_LuV.get(4L), ItemList.Electric_Pump_LuV.get(4L),
                ItemList.Conveyor_Module_LuV.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Chrome, 4L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(288),
            ItemList.OreDrill3.get(1L),
            400, 30720);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.OreDrill3.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Tritanium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4L),
                ItemList.Electric_Motor_ZPM.get(4L), ItemList.Electric_Pump_ZPM.get(4L),
                ItemList.Conveyor_Module_ZPM.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.MysteriousCrystal, 4L),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.SolderingAlloy.getMolten(576),
            ItemList.OreDrill4.get(1L),
            400, 122880);

        // LV Turbines
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Iron, 4L),
            GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L),
            GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(170, 1, Materials.Iron, Materials.Steel, null),
            320, 30);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.WroughtIron, 4L),
            GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L),
            GT_MetaGenerated_Tool_01.INSTANCE
                .getToolWithStats(170, 1, Materials.WroughtIron, Materials.Steel, null),
            320, 30);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Bronze, 4L),
            GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L),
            GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(170, 1, Materials.Bronze, Materials.Steel, null),
            320, 30);
        GT_Values.RA.addAssemblerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.turbineBlade, Materials.Steel, 4L),
            GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L),
            GT_MetaGenerated_Tool_01.INSTANCE.getToolWithStats(170, 1, Materials.Steel, Materials.Steel, null),
            320, 30);

        // Hermetic casings
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Plastic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_1.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.PolyvinylChloride, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_2.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Polytetrafluoroethylene, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_3.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_4.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_5.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.TungstenSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_6.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.NiobiumTitanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_7.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Enderium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_8.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Naquadah, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_9.get(1L),
            100, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.MysteriousCrystal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 8L),
                GT_Utility.getIntegratedCircuit(4) },
            GT_Values.NF,
            ItemList.Casing_Tank_10.get(1L),
            100, 16);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.Glass.getMolten(72L),
            GT_ModHandler.getModItem("irontank", "goldDiamondUpgrade", 1L, 0),
            600,
            120);

        GT_Values.RA.addAssemblerRecipe(
            ItemList.Firebrick.get(24),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L),
            Materials.Concrete.getMolten(4608L),
            ItemList.Casing_Firebricks.get(4L),
            200, 30);
        GT_Values.RA.addAssemblerRecipe(
            ItemList.Firebrick.get(24),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 8L),
            Materials.Concrete.getMolten(4608L),
            ItemList.Casing_Firebricks.get(4L),
            200, 30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { new ItemStack(Blocks.brick_block), Materials.AnyBronze.getPlates(6) },
            GT_Values.NF,
            ItemList.Casing_BronzePlatedBricks.get(1L),
            200, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { Materials.Steel.getPlates(4), Materials.Iron.getPlates(2),
                ItemList.Casing_BronzePlatedBricks.get(1L) },
            GT_Values.NF,
            ItemList.Casing_Pyrolyse.get(1L),
            200, 30);

        // Filter Machine Casing for cleanroom
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.StainlessSteel, 1L),
                ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Aluminium, 1L),
                ItemList.Component_Filter.get(2L), ItemList.StainlessSteelBars.get(2L),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            ItemList.Casing_Vent.get(1L),
            600,
            120);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack(Items.string, 3, 0),
            GT_Utility.getIntegratedCircuit(1),
            new ItemStack(Blocks.wool, 1, 0),
            100,
            4);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Hull_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                GT_ModHandler.getModItem("IronChest", "BlockIronChest", 1L, 0) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "blockPersonal", 1L, 0),
            200,
            30);

        // Circuits and Boards
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Glue.getFluid(576L),
            ItemList.Circuit_Board_Coated_Basic.get(8L),
            1600,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Plastic.getMolten(288L),
            ItemList.Circuit_Board_Coated_Basic.get(16L),
            1600,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polytetrafluoroethylene.getMolten(144L),
            ItemList.Circuit_Board_Coated_Basic.get(16L),
            1600,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Epoxid.getMolten(144L),
            ItemList.Circuit_Board_Coated_Basic.get(24L),
            1600,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polybenzimidazole.getMolten(72L),
            ItemList.Circuit_Board_Coated_Basic.get(32L),
            1600,
            8);
        if(Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                    GT_Utility.getIntegratedCircuit(1) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Board_Phenolic.get(8L),
                2400,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 8),
                    GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Copper, 32),
                    GT_Utility.getIntegratedCircuit(6) },
                FluidRegistry.getFluidStack("glue", 1152),
                ItemList.Circuit_Board_Coated_Basic.get(8L),
                1600,
                8);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                    GT_Utility.getIntegratedCircuit(5) },
                FluidRegistry.getFluidStack("glue", 576),
                ItemList.Circuit_Parts_Resistor.get(12L),
                320,
                16);
        }
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Board_Phenolic.get(8L),
            2400,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.BisphenolA.getFluid(144),
            ItemList.Circuit_Board_Phenolic.get(16L),
            2400,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 8),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.Epoxid.getMolten(144L),
            ItemList.Circuit_Board_Phenolic.get(24L),
            2400,
            30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Parts_Glass_Tube.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.Redstone.getMolten(144L),
            ItemList.Circuit_Parts_Vacuum_Tube.get(2L),
            160,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.RedAlloy.getMolten(72L),
            ItemList.Circuit_Parts_Vacuum_Tube.get(4L),
            160,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.RedstoneAlloy.getMolten(72L),
            ItemList.Circuit_Parts_Vacuum_Tube.get(8L),
            160,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.RedAlloy.getMolten(72L),
            ItemList.Circuit_Parts_Vacuum_Tube.get(8L),
            160,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Parts_Glass_Tube.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.RedstoneAlloy.getMolten(72L),
            ItemList.Circuit_Parts_Vacuum_Tube.get(16L),
            160,
            8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(4L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(4L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(4L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(4L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(8L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(8L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(8L),
            320,
            16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lignite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4),
                GT_Utility.getIntegratedCircuit(5) },
            Materials.Glue.getFluid(288),
            ItemList.Circuit_Parts_Resistor.get(8L),
            320,
            16);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Diode.get(4L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4) },
            Materials.Glass.getMolten(288L),
            ItemList.Circuit_Parts_Diode.get(2L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4) },
            FluidRegistry.getFluidStack("glass.molten", 1000),
            ItemList.Circuit_Parts_Diode.get(2L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Diode.get(2L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4) },
            FluidRegistry.getFluidStack("glass.molten", 1000),
            ItemList.Circuit_Parts_Diode.get(1L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4) },
            Materials.Glass.getMolten(288L),
            ItemList.Circuit_Parts_Diode.get(1L),
            600,
            30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Diode.get(4L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                ItemList.Circuit_Silicon_Wafer.get(1L), GT_Utility.getIntegratedCircuit(4) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Diode.get(8L),
            600,
            30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_Coil.get(2L),
            320,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_Coil.get(4L),
            320,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_Coil.get(4L),
            320,
            60);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.NickelZincFerrite, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_Coil.get(8L),
            320,
            60);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Capacitor.get(12L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Plastic, 1),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Capacitor.get(8L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tin, 8),
                GT_Utility.getIntegratedCircuit(2) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Transistor.get(6L),
            320,
            30);

        // All SMD Component recipes.
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 4),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(288L),
            ItemList.Circuit_Parts_ResistorSMD.get(16L),
            320,
            96);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(288L),
            ItemList.Circuit_Parts_ResistorSMD.get(32L),
            320,
            96);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Diode.get(6L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 4),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(4) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_Diode.get(16L),
            600,
            30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(576L),
            ItemList.Circuit_Parts_DiodeSMD.get(64L),
            1200,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 8),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(288L),
            ItemList.Circuit_Parts_TransistorSMD.get(16L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Gallium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 8),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(288L),
            ItemList.Circuit_Parts_TransistorSMD.get(32L),
            320,
            120);
        // Normal SMD
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_CapacitorSMD.get(16L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Aluminium, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_CapacitorSMD.get(24L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_CapacitorSMD.get(32L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.PolyvinylChloride, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tantalum, 2),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(144L),
            ItemList.Circuit_Parts_CapacitorSMD.get(48L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.ConductiveIron, 8),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_InductorSMD.get(24L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 8),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_InductorSMD.get(32L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tantalum, 8),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_InductorSMD.get(48L),
            320,
            120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Neodymium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Iridium, 8),
                GT_Utility.getIntegratedCircuit(3) },
            Materials.Plastic.getMolten(36L),
            ItemList.Circuit_Parts_InductorSMD.get(64L),
            320,
            120);
        // ASMD
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphene, 2),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polybenzimidazole.getMolten(576L),
            ItemList.Circuit_Parts_ResistorASMD.get(64L),
            300,
            1920);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polybenzimidazole.getMolten(576L),
            ItemList.Circuit_Parts_DiodeASMD.get(64L),
            300,
            1920);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VanadiumGallium, 2),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSG, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polybenzimidazole.getMolten(576L),
            ItemList.Circuit_Parts_TransistorASMD.get(64L),
            300,
            1920);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Polybenzimidazole, 4),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.HSSS, 2),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polybenzimidazole.getMolten(576L),
            ItemList.Circuit_Parts_CapacitorASMD.get(64L),
            300,
            1920);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Samarium, 1),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.HSSE, 32),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 4),
                GT_Utility.getIntegratedCircuit(6) },
            Materials.Polybenzimidazole.getMolten(576L),
            ItemList.Circuit_Parts_InductorASMD.get(64L),
            160,
            1920);
        // xSMD

        // Resistor
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Naquadria, 4L),
                GT_ModHandler.getModItem("miscutils", "itemFoilPikyonium64B", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9) },
            Xenoxene.getFluid(144L),
            ItemList.Circuit_Parts_ResistorXSMD.get(32L),
            160,
            120000);

        // Transistor
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.BlackPlutonium, 4L),
                GT_ModHandler.getModItem("miscutils", "itemFoilArceusAlloy2B", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9) },
            Xenoxene.getFluid(144L),
            ItemList.Circuit_Parts_TransistorXSMD.get(32L),
            160,
            120000);

        // Capacitor
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Draconium, 4L),
                GT_ModHandler.getModItem("miscutils", "itemFoilCinobiteA243", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9) },
            Xenoxene.getFluid(144L),
            ItemList.Circuit_Parts_CapacitorXSMD.get(32L),
            160,
            120000);

        // Diode
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Tritanium, 4L),
                GT_ModHandler.getModItem("miscutils", "itemFoilLafiumCompound", 2L),
                GT_OreDictUnificator
                    .get(OrePrefixes.foil, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9) },
            Xenoxene.getFluid(144L),
            ItemList.Circuit_Parts_DiodeXSMD.get(64L),
            160,
            120000);
        // Inductor
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                // hikarium foil
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedfoil", 4L, 10105),
                // artherium-sn foil
                GT_ModHandler.getModItem("bartworks", "gt.bwMetaGeneratedfoil", 1L, 10102),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 1L),
                GT_Utility.getIntegratedCircuit(9) },
            Xenoxene.getFluid(144L),
            ItemList.Circuit_Parts_InductorXSMD.get(32L),
            160,
            120000);

        // Field Generator
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.RedSteel.getMolten(288),
            ItemList.Field_Generator_LV.get(1),
            600, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 4),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.TungstenSteel.getMolten(288),
            ItemList.Field_Generator_MV.get(1),
            600, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.QuantumEye.get(1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 4),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.NiobiumTitanium.getMolten(576),
            ItemList.Field_Generator_HV.get(1),
            600, 480);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherStar, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                GT_Utility.getIntegratedCircuit(13) },
            Materials.HSSG.getMolten(576),
            ItemList.Field_Generator_EV.get(1),
            600, 1920);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.QuantumStar.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 4),
                GT_Utility.getIntegratedCircuit(1) },
            Materials.HSSS.getMolten(576),
            ItemList.Field_Generator_IV.get(1L),
            600, 7680);

        // Motors
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnnealedCopper, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.SteelMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Silver, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlackSteel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.NeodymiumMagnetic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt04, Materials.Graphene, 4L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Tungsten, 2L) },
            GT_Values.NF,
            ItemList.Electric_Motor_IV.get(1L),
            20, 30);

        // Pumps
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Bronze, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Titanium, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Silicone, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_IV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.StyreneButadieneRubber, 2),
                GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.TungstenSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Pump_IV.get(1L),
            20, 30);

        // Conveyors
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silicone, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_IV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_IV.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StyreneButadieneRubber, 6),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 1) },
            GT_Values.NF,
            ItemList.Conveyor_Module_IV.get(1L),
            20, 30);

        // Pistons
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1) },
            GT_Values.NF,
            ItemList.Electric_Piston_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Aluminium, 1) },
            GT_Values.NF,
            ItemList.Electric_Piston_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Piston_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Titanium, 1) },
            GT_Values.NF,
            ItemList.Electric_Piston_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 3),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2),
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.TungstenSteel, 1) },
            GT_Values.NF,
            ItemList.Electric_Piston_IV.get(1L),
            20, 30);

        // Robot Arms
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_LV.get(2L), ItemList.Electric_Piston_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 3) },
            GT_Values.NF,
            ItemList.Robot_Arm_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_MV.get(2L), ItemList.Electric_Piston_MV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Aluminium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 3) },
            GT_Values.NF,
            ItemList.Robot_Arm_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_HV.get(2L), ItemList.Electric_Piston_HV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 3) },
            GT_Values.NF,
            ItemList.Robot_Arm_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_EV.get(2L), ItemList.Electric_Piston_EV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 3) },
            GT_Values.NF,
            ItemList.Robot_Arm_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.Electric_Motor_IV.get(2L), ItemList.Electric_Piston_IV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 3) },
            GT_Values.NF,
            ItemList.Robot_Arm_IV.get(1L),
            20, 30);

        // Emitter
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2) },
            GT_Values.NF,
            ItemList.Emitter_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderPearl, 1),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.AnyCopper, 2) },
            GT_Values.NF,
            ItemList.Emitter_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2) },
            GT_Values.NF,
            ItemList.Emitter_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.QuantumEye.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Aluminium, 2) },
            GT_Values.NF,
            ItemList.Emitter_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.QuantumStar.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 4),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tungsten, 2) },
            GT_Values.NF,
            ItemList.Emitter_IV.get(1L),
            20, 30);

        // Sensor
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gem, Materials.CertusQuartz, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L), },
            GT_Values.NF,
            ItemList.Sensor_LV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Electrum, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L), },
            GT_Values.NF,
            ItemList.Sensor_MV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.gem, Materials.EnderEye, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L), },
            GT_Values.NF,
            ItemList.Sensor_HV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.QuantumEye.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Platinum, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L), },
            GT_Values.NF,
            ItemList.Sensor_EV.get(1L),
            20, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { ItemList.QuantumStar.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L), },
            GT_Values.NF,
            ItemList.Sensor_IV.get(1L),
            20, 30);

        // Covers
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { Materials.Aluminium.getPlates(4), Materials.Glass.getPlates(1),
                Materials.Glowstone.getDust(1), new ItemStack(Items.dye, 1, 1), new ItemStack(Items.dye, 1, 10),
                new ItemStack(Items.dye, 1, 4) },
            GT_Values.NF,
            ItemList.Cover_Screen.get(1L),
            100, 5);

        // Irradiant Glass Pane
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 4L, 2),
                GT_ModHandler.getModItem("IC2", "blockAlloyGlass", 4L, 0), Materials.Glowstone.getPlates(1),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 4L, 5),
            100, 480);

        // Solar Light Splitter
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("supersolarpanel", "bluecomponent", 3L, 0),
                GT_ModHandler.getModItem("supersolarpanel", "redcomponent", 3L, 0),
                GT_ModHandler.getModItem("supersolarpanel", "greencomponent", 3L, 0),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("supersolarpanel", "solarsplitter", 1L, 0),
            100, 480);

        // Heat Exchangers
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1),
            60, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorHeatSwitchCore", 1L, 1),
            60, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1) },
            Materials.StainlessSteel.getMolten(72),
            GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1),
            30, 480);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2L),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitch", 1L, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1L, 1),
            60, 480);

        // Heat Vents
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21), ItemList.Electric_Motor_LV.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                ItemList.SteelBars.get(2L) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1),
            200, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 2L),
                GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorVentCore", 1L, 1),
            300, 256);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21), ItemList.IC2_Industrial_Diamond.get(1L),
                GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1),
                ItemList.SteelBars.get(4L) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1),
            300, 256);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 2L),
                GT_ModHandler.getModItem("IC2", "reactorVentDiamond", 1L, 1) },
            Materials.StainlessSteel.getMolten(72),
            GT_ModHandler.getModItem("IC2", "reactorVentGold", 1L, 1),
            400, 480);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Tin, 2L),
                ItemList.SteelBars.get(2L), GT_ModHandler.getModItem("IC2", "reactorVent", 1L, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorVentSpread", 1L),
            300, 256);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 4L),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchCore", 2L, 1),
                GT_ModHandler.getModItem("IC2", "reactorVentCore", 1L, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorCondensator", 1L, 1),
            600, 480);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lapis, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.RedAlloy, 2L),
                GT_ModHandler.getModItem("IC2", "reactorVentGold", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorHeatSwitchSpread", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorCondensator", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorCondensator", 1L, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorCondensatorLap", 1L, 1),
            900, 480);
        // Easier chest upgrades
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                GT_Utility.getIntegratedCircuit(2), },
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Iron, 1L),
            300, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                GT_Utility.getIntegratedCircuit(2), },
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Steel, 1L),
            400, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                GT_Utility.getIntegratedCircuit(2), },
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L),
            500, 64);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                GT_Utility.getIntegratedCircuit(2), },
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L),
            500, 64);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                GT_Utility.getIntegratedCircuit(2), },
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.chest, Materials.Diamond, 1L),
            600, 120);
        // Reactor Plating
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(22),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 1L),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4L) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorPlating", 1L),
            400, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(21),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Copper, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Silver, 1L),
                GT_ModHandler.getModItem("IC2", "reactorPlating", 1L) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorPlatingHeat", 1L),
            600, 256);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(23),
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Lead, 2L),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 2L),
                GT_ModHandler.getModItem("IC2", "reactorPlating", 1L) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorPlatingExplosive", 1L),
            600, 256);

        // LV and MV Energy Hatches
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(4),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2),
                ItemList.Electric_Pump_LV.get(1), ItemList.Hull_LV.get(1), ItemList.LV_Coil.get(2),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1) },
            Materials.Lubricant.getFluid(2000),
            ItemList.Hatch_Energy_LV.get(1),
            200, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(4),
                GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 1),
                ItemList.Electric_Pump_MV.get(1), ItemList.Hull_MV.get(1), ItemList.MV_Coil.get(2),
                ItemList.Circuit_Chip_ULPIC.get(2) },
            Materials.Lubricant.getFluid(2000),
            ItemList.Hatch_Energy_MV.get(1),
            200, 120);

        // Neutron reflector recipes
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 16L),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
            1200, 480, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 8L),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
            900, 480, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 4L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 4L),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
            400, 480, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 2L),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
            600, 1920, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 2L),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_ModHandler.getModItem("IC2", "reactorReflector", 1L, 1),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
            600, 1920, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
                GT_ModHandler.getModItem("IC2", "reactorReflectorThick", 1L, 0),
                GT_Utility.getIntegratedCircuit(1) },
            GT_Values.NF,
            ItemList.Neutron_Reflector.get(1L),
            900, 7680, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.TungstenCarbide, 36L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 64L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 32L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 32L),
                GT_Utility.getIntegratedCircuit(2) },
            GT_Values.NF,
            ItemList.Neutron_Reflector.get(1L),
            3150, 30720, true);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Iridium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Beryllium, 36L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 64L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 32L),
                GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 48L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 64L),
                GT_Utility.getIntegratedCircuit(2) },
            GT_Values.NF,
            ItemList.Neutron_Reflector.get(1L),
            3750, 30720, true);

        // Wood Plates
        sAssemblerRecipes.addRecipe(
            false,
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 64),
                GT_Utility.getIntegratedCircuit(2) },
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 64) },
            null,
            new FluidStack[] { Materials.Glue.getFluid(144L) },
            null,
            2400,
            30,
            0);

        if (Loader.isModLoaded("miscutils")) { // GT++, remember to remove later
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WroughtIron, 1L),
                    ItemList.SteelBars.get(6L), GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                GT_ModHandler.getModItem("miscutils", "blockFishTrap", 1L, 0),
                200, 64);
        }

        if (Loader.isModLoaded("TConstruct")) {

            // Assembler
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 1),
                    GT_ModHandler.getModItem("IC2", "blockITNT", 1L, 0), GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "explosive.slime", 1L, 0),
                600, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 0),
                    GT_ModHandler.getModItem("TConstruct", "explosive.slime", 1L, 0),
                    GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "explosive.slime", 1L, 2),
                600, 64);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Aluminium, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 4L),
                    GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "heartCanister", 1L, 0),
                2400, 480);
        }

        if (Loader.isModLoaded("appliedenergistics2") && Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_ModHandler.getModItem("TConstruct", "GlassPane", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L) },
                GT_Values.NF,
                GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 39),
                100, 16);
        }

        if (Loader.isModLoaded("appliedenergistics2")) {
            // AE2 Illuminated Panel Assembler Recipe
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Cover_Screen.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L) },
                Materials.SolderingAlloy.getMolten(144L),
                GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiPart", 1L, 180),
                100, 4);

            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { new ItemStack(Blocks.glass_pane, 1, 0),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 2L) },
                GT_Values.NF,
                GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 39),
                100, 16);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Output_Bus_HV.get(1L),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiPart", 1L, 440),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 4L, 30),
                    GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                ItemList.Hatch_Output_Bus_ME.get(1),
                300, 480);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Output_HV.get(1L),
                    GT_ModHandler.getModItem("ae2fc", "part_fluid_interface", 1L),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 4L, 30),
                    GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                ItemList.Hatch_Output_ME.get(1),
                300, 480);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { ItemList.Hatch_Input_Bus_HV.get(1L),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiPart", 1L, 440),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 4L, 30),
                    GT_Utility.getIntegratedCircuit(1) },
                GT_Values.NF,
                ItemList.Hatch_Input_Bus_ME.get(1),
                300, 480);
        }

        if (Loader.isModLoaded("ExtraUtilities")) {
            GT_Values.RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 9L),
                GT_Utility.getIntegratedCircuit(1),
                Materials.UUMatter.getMolten(1000L),
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 1L, 0),
                1, 122880);
            GT_Values.RA.addAssemblerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Unstable, 9L),
                GT_Utility.getIntegratedCircuit(1),
                Materials.UUMatter.getMolten(1000L),
                GT_ModHandler.getModItem("ExtraUtilities", "unstableingot", 1L, 2),
                1, 122880);
        }

        if (Loader.isModLoaded("ExtraUtilities") && Loader.isModLoaded("IronChest")) {
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_ModHandler.getModItem("IronChest", "BlockIronChest", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4L),
                    GT_Utility.getIntegratedCircuit(1) },
                Materials.Plastic.getMolten(144L),
                GT_ModHandler.getModItem("ExtraUtilities", "filing", 1L, 0),
                300, 120);
        }
    }

    private static final void registerReinforcedIronAlloyPlates() {
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_ModHandler.getModItem("IC2", "itemPartCarbonPlate", 4),
                ItemList.AluminiumIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedAluminiumIronPlate.get(1),
            100, 120);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.SiliconSG, 4),
                ItemList.TitaniumIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedTitaniumIronPlate.get(1),
            100, 480);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 4),
                ItemList.TungstenIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedTungstenIronPlate.get(1),
            100, 1920);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 4),
                ItemList.TungstenSteelIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedTungstenSteelIronPlate.get(1),
            100, 7680);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4),
                ItemList.ChromeIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedChromeIronPlate.get(1),
            100, 30720);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_ModHandler.getModItem("IC2", "itemPartIridium", 4),
                GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 6) },
            GT_Values.NF,
            GT_ModHandler.getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 7),
            100, 122880);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MysteriousCrystal, 4),
                ItemList.NaquadriaIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedNaquadriaIronPlate.get(1),
            100, 491520);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 4),
                ItemList.NeutroniumIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedNeutroniumIronPlate.get(1),
            100, 1966080);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_ModHandler.getModItem("IC2", "itemPartAlloy", 4),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 4),
                ItemList.BedrockiumIronPlate.get(1) },
            GT_Values.NF,
            ItemList.ReinforcedBedrockiumIronPlate.get(1),
            100, 7864320);
    }

    private static void registerGregTechRecipes() {
        if (Loader.isModLoaded("Forestry")) {

            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Copper, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 0),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnnealedCopper, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 0),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Tin, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 1),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Bronze, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 2),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Iron, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 3),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.WroughtIron, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 3),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Gold, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 4),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 5),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Obsidian, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 6),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Blaze, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 7),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Rubber, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 8),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Emerald, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 9),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Apatite, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 10),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Lapis, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 11),
                200, 30);
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] {
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderEye, 2L)
                },
                Materials.Glass.getMolten(576L),
                GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 12),
                200, 30);

            ItemStack alveary = GT_ModHandler.getModItem("Forestry", "alveary", 1L, 0);
            // Apiary
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_ModHandler.getModItem("Forestry", "frameImpregnated", 1L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.slab, Materials.Wood, 2L),
                    GT_ModHandler.getModItem("Forestry", "beeCombs", 1L, W),
                    GT_ModHandler.getModItem("Forestry", "apiculture", 2L, 2),
                    new ItemStack(Blocks.fence, 1, 0).splitStack(2)},
                Materials.SeedOil.getFluid(1000L),
                GT_ModHandler.getModItem("Forestry", "apiculture", 1L, 0),
                1200, 64);

            // Scented Paneling
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 2L),
                    GT_ModHandler.getModItem("Forestry", "royalJelly", 1L, 0),
                    GT_ModHandler.getModItem("Forestry", "oakStick", 3L, 0),
                    GT_ModHandler.getModItem("Forestry", "beeswax", 2L, 0),
                    GT_ModHandler.getModItem("Forestry", "pollen", 1L, W) },
                Materials.Honey.getFluid(1000L),
                GT_ModHandler.getModItem("Forestry", "craftingMaterial", 1L, 6),
                1200, 64);

            // Swarmer
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 5),
                    GT_OreDictUnificator.get(OrePrefixes.foil, Materials.RoseGold, 2L),
                    GT_ModHandler.getModItem("Forestry", "royalJelly", 2L, 0),
                    GT_ModHandler.getModItem("Forestry", "frameImpregnated", 1L, 0) },
                Materials.Honey.getFluid(2500L),
                GT_ModHandler.getModItem("Forestry", "alveary", 1L, 2),
                1200, 120);

            // Alveary Fan
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 11),
                    ItemList.SteelBars.get(3L),
                    GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1L),
                    ItemList.Electric_Motor_MV.get(1L) },
                Materials.Honey.getFluid(2500L),
                GT_ModHandler.getModItem("Forestry", "alveary", 1L, 3),
                1200, 120);

            // Alveary Heater
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 7),
                    ItemList.SteelBars.get(1L), GT_ModHandler.getModItem("IC2", "itemRecipePart", 3L),
                    ItemList.Electric_Motor_MV.get(1L) },
                Materials.Honey.getFluid(2500L),
                GT_ModHandler.getModItem("Forestry", "alveary", 1L, 4),
                1200, 120);

            // Alveary Hygroregulator
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 6),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L),
                    GT_ModHandler.getModItem("extracells", "certustank", 2L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L) },
                Materials.Honey.getFluid(2500L),
                GT_ModHandler.getModItem("Forestry", "alveary", 1L, 5),
                1200, 120);

            // Alveary Stabiliser
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 4),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                    ItemList.Component_Filter.get(2L),
                    GT_ModHandler.getModItem("Forestry", "royalJelly", 1L, 0) },
                Materials.Honey.getFluid(2500L),
                GT_ModHandler.getModItem("Forestry", "alveary", 1L, 6),
                1200, 120);

            // Alveary Sieve
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 3),
                    GT_ModHandler.getModItem("Forestry", "craftingMaterial", 4L, 3),
                    GT_ModHandler.getModItem("Forestry", "pollenFertile", 1L) },
                Materials.Honey.getFluid(2500L),
                GT_ModHandler.getModItem("Forestry", "alveary", 1L, 7),
                1200, 120);
        }
        if (Loader.isModLoaded("ExtraBees")) {
            ItemStack alveary = GT_ModHandler.getModItem("Forestry", "alveary", 1L, 0);

            // Mutator
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 12),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 2L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 2L),
                    GT_ModHandler.getModItem("ExtraBees", "hiveFrame.soul", 1L, 0) },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 0),
                1200, 120);

            // Frame Housing
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 10),
                    GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L),
                    GT_ModHandler.getModItem("Forestry", "frameImpregnated", 1L, 0),
                    GT_ModHandler.getModItem("Forestry", "frameImpregnated", 1L, 0),
                    GT_ModHandler.getModItem("Forestry", "frameImpregnated", 1L, 0),
                    GT_ModHandler.getModItem("Forestry", "frameImpregnated", 1L, 0) },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 1),
                1200, 120);

            // Rain Shield
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 8),
                    GT_ModHandler.getModItem("IC2", "blockRubber", 4L),
                    new ItemStack(Blocks.brick_block, 1, 0), },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 2),
                1200, 120);

            // Alveary Lighting
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 2),
                    new ItemStack(Blocks.stained_glass, 4, W),
                    new ItemStack(Blocks.redstone_lamp, 1, 0) },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 3),
                1200, 120);

            // Electrical Stimulator
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 2L),
                    GT_ModHandler.getModItem("Forestry", "chipsets", 2L, 2),
                    ItemList.Electric_Motor_HV.get(1L) },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 4),
                1200, 120);

            // Hatchery
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 3),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Redstone, 2L),
                    ItemList.Conveyor_Module_MV.get(2L),
                    GT_ModHandler.getModItem("Forestry", "apiculture", 1L, 0) },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 5),
                1200, 120);

            // Alveary Transmission
            GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { alveary, GT_ModHandler.getModItem("Forestry", "thermionicTubes", 4L, 0),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 3L),
                    ItemList.Hull_HV.get(1L) },
                Materials.Honey.getFluid(3750L),
                GT_ModHandler.getModItem("ExtraBees", "alveary", 1L, 6),
                1200, 120);
        }
    }

    private static void registerMixedMetalIngotRecipes() {
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyIron, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Nickel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 1L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 2L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Invar, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 3L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 4L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 4L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 4L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 4L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 4L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 4L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 5L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 5L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 5L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 5L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnyBronze, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 6L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Brass, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 6L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 8L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 8L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 8L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Zinc, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 10L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tin, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 10L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 10L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 12L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 12L, 4),
            100, 30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 14L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 14L, 4),
            100, 30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 16L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 16L, 4),
            100, 30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 18L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 18L, 4),
            100, 30);

        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.AnnealedCopper, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 20L, 4),
            100, 30);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] { GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1) },
            GT_Values.NF,
            GT_ModHandler.getModItem("IC2", "itemIngot", 20L, 4),
            100, 30);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 22L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 24L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 26L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSG, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 28L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 30L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSE, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 32L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 34L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 36L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 38L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.EnergeticAlloy, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 40L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 42L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sunnarium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Draconium, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 44L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HSSS, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 48L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 52L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 56L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_Utility.getIntegratedCircuit(3),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 1),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.BlackPlutonium, 1)
            )
            .itemOutputs(GT_ModHandler.getModItem("IC2", "itemIngot", 64L, 4))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);
    }

    private void makeCoilRecipes() {
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Cupronickel, 8L),
                ItemList.AluminoSilicateWool.get(12L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.Tin.getMolten(288L))
            .itemOutputs(ItemList.Casing_Coil_Cupronickel.get(1L))
            .duration(5 * SECONDS)
            .eut(TierEU.RECIPE_LV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Kanthal, 8L),
                ItemList.AluminoSilicateWool.get(16L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.Cupronickel.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_Kanthal.get(1L))
            .duration(15 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Nichrome, 8L),
                ItemList.AluminoSilicateWool.get(20L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.Kanthal.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_Nichrome.get(1L))
            .duration(20 * SECONDS)
            .eut(TierEU.RECIPE_HV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.TPV, 8L),
                ItemList.AluminoSilicateWool.get(24L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.Nichrome.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_TungstenSteel.get(1L))
            .duration(25 * SECONDS)
            .eut(TierEU.RECIPE_EV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSG, 8L),
                ItemList.AluminoSilicateWool.get(28L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.TPV.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_HSSG.get(1L))
            .duration(30 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.HSSS, 8L),
                ItemList.AluminoSilicateWool.get(32L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.HSSG.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_HSSS.get(1L))
            .duration(35 * SECONDS)
            .eut(TierEU.RECIPE_IV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Naquadah, 8L),
                ItemList.AluminoSilicateWool.get(36L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.HSSS.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_Naquadah.get(1L))
            .duration(40 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.NaquadahAlloy, 8L),
                ItemList.AluminoSilicateWool.get(40L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.Naquadah.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_NaquadahAlloy.get(1L))
            .duration(45 * SECONDS)
            .eut(TierEU.RECIPE_LuV)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.Trinium, 8L),
                ItemList.AluminoSilicateWool.get(40L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.NaquadahAlloy.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_Trinium.get(1L))
            .duration(50 * SECONDS)
            .eut(TierEU.RECIPE_ZPM)
            .addTo(sAssemblerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.ElectrumFlux, 8L),
                ItemList.AluminoSilicateWool.get(44L),
                GT_Utility.getIntegratedCircuit(3)
            )
            .fluidInputs(Materials.Trinium.getMolten(144L))
            .itemOutputs(ItemList.Casing_Coil_ElectrumFlux.get(1L))
            .duration(55 * SECONDS)
            .eut(TierEU.RECIPE_UV)
            .addTo(sAssemblerRecipes);
    }

    private void registerSolderingAlloyRecipes() {
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
                    ItemList.AluminiumIronPlate.get(1)
                )
                .itemOutputs(ItemList.Cover_SolarPanel.get(1L))
                .fluidInputs(tMat.getMolten(72L * tMultiplier / 2L))
                .duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);

            // solar 8EU
            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 2L),
                    ItemList.Cover_SolarPanel.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Tin, 2L),
                    ItemList.Circuit_Silicon_Wafer.get(1),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.GalliumArsenide, 1L),
                    ItemList.ReinforcedAluminiumIronPlate.get(1)
                )
                .itemOutputs(ItemList.Cover_SolarPanel_8V.get(1L))
                .fluidInputs(tMat.getMolten(72L * tMultiplier / 2L))
                .duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV)
                .addTo(sAssemblerRecipes);
        }
    }
}
