package gregtech.loaders.load;

import gregtech.api.enums.*;
import gregtech.api.metatileentity.implementations.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Recipe;
import gregtech.common.tileentities.automation.GT_MetaTileEntity_ChestBuffer;
import gregtech.common.tileentities.generators.GT_MetaTileEntity_PlasmaGenerator;
import gregtech.common.tileentities.machines.basic.*;
import gregtech.loaders.preload.GT_Loader_MetaTileEntities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.MetaTileEntityIDs.*;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sSlicerRecipes;

public class GT_Loader_MetaTileEntities_GTNH implements Runnable {

    public enum AdvancedGTMaterials {

        LuV(OrePrefixes.circuit.get(Materials.Master), OrePrefixes.wireGt02.get(Materials.YttriumBariumCuprate),
            Materials.VanadiumGallium, OrePrefixes.wireGt02.get(Materials.HSSG),
            OrePrefixes.gemExquisite.get(Materials.Diamond), ItemList.Gravistar,
            BartWorks.isModLoaded() ? "blockGlassLuV" : "glassReinforced",
            BartWorks.isModLoaded() ? Materials.get("Rhodium-PlatedPalladium") : Materials.Chrome,
            Materials.Enderium),

        ZPM(OrePrefixes.circuit.get(Materials.Ultimate), OrePrefixes.wireGt04.get(Materials.YttriumBariumCuprate),
            Materials.Naquadah, OrePrefixes.wireGt02.get(Materials.Naquadah),
            OrePrefixes.gemExquisite.get(Materials.GarnetYellow), ItemList.Gravistar,
            BartWorks.isModLoaded() ? "blockGlassZPM" : "glassReinforced", Materials.Iridium, Materials.Naquadah),

        UV(OrePrefixes.circuit.get(Materials.SuperconductorUHV),
            OrePrefixes.wireGt08.get(Materials.YttriumBariumCuprate), Materials.ElectrumFlux,
            OrePrefixes.wireGt02.get(Materials.NaquadahAlloy), OrePrefixes.gemExquisite.get(Materials.GarnetRed),
            new ItemStack(Blocks.dragon_egg, 1), BartWorks.isModLoaded() ? "blockGlassUV" : "glassReinforced",
            Materials.Osmium, Materials.Neutronium),

        UHV(OrePrefixes.circuit.get(Materials.Infinite), OrePrefixes.wireGt16.get(Materials.YttriumBariumCuprate),
            Materials.Bedrockium, OrePrefixes.wireGt02.get(Materials.Bedrockium), null, null,
            BartWorks.isModLoaded() ? "blockGlassUHV" : "glassReinforced", Materials.Neutronium,
            Materials.Neutronium),

        UEV(OrePrefixes.circuit.get(Materials.Bio), OrePrefixes.wireGt04.get(Materials.Bedrockium), Materials.Draconium,
            OrePrefixes.wireGt02.get(Materials.Draconium), null, null,
            BartWorks.isModLoaded() ? "blockGlassUEV" : "glassReinforced", Materials.Bedrockium,
            Materials.Infinity),

        UIV(OrePrefixes.circuit.get(Materials.Optical), OrePrefixes.wireGt08.get(Materials.Bedrockium),
            Materials.NetherStar, OrePrefixes.wireGt02.get(Materials.NetherStar), null, null,
            BartWorks.isModLoaded() ? "blockGlassUIV" : "glassReinforced", Materials.CosmicNeutronium,
            MaterialsUEVplus.TranscendentMetal),

        UMV(OrePrefixes.circuit.get(Materials.Piko), OrePrefixes.wireGt16.get(Materials.Bedrockium), Materials.Quantium,
            OrePrefixes.wireGt02.get(Materials.Quantium), null, null,
            BartWorks.isModLoaded() ? "blockGlassUMV" : "glassReinforced", MaterialsUEVplus.TranscendentMetal,
            MaterialsUEVplus.SpaceTime);

        private final Object _mCircuit;
        private final Object _mHeatingCoil;
        private final Object _mCoilWire;
        private final Object _mMachineCable;
        private final Object _mMachineCable4;
        private final Object _mGem;
        private final Object _mPowerGem;
        private final Object _mPlate;
        private final Object _mReinfGlass;
        private final Object _mPipe;
        private final Object _mPipeL;

        AdvancedGTMaterials(Object pCircuit, Object pHeatingCoil, Materials pCable, Object pCoilWire, Object pGem,
                            Object pPowerGem, Object glass, Materials pPlateMaterial, Materials pPipe) {
            _mCircuit = pCircuit;
            _mHeatingCoil = pHeatingCoil;
            _mCoilWire = pCoilWire;
            _mMachineCable = OrePrefixes.cableGt01.get(pCable);
            _mMachineCable4 = OrePrefixes.cableGt04.get(pCable);
            _mGem = pGem;
            _mPowerGem = pPowerGem;
            _mPlate = OrePrefixes.plate.get(pPlateMaterial);
            _mReinfGlass = glass;
            _mPipe = OrePrefixes.pipeMedium.get(pPipe);
            _mPipeL = OrePrefixes.pipeLarge.get(pPipe);
        }

        public Object getPipe() {
            return _mPipe;
        }

        // A test
        public Object getGlass() {
            return _mReinfGlass;
        }

        public Object getPlate() {
            return _mPlate;
        }

        public Object getPowerGem() {
            return _mPowerGem;
        }

        public Object getGem() {
            return _mGem;
        }

        public Object getCircuit() {
            return _mCircuit;
        }

        public Object getHCoil() {
            return _mHeatingCoil;
        }

        public Object getCable() {
            return _mMachineCable;
        }

        public Object getCable4() {
            return _mMachineCable4;
        }

        public Object getWire() {
            return _mCoilWire;
        }

        public Object getPipeL() {
            return _mPipeL;
        }
    }

    public static long bitsd = GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
        | GT_ModHandler.RecipeBits.REVERSIBLE
        | GT_ModHandler.RecipeBits.BUFFERED;
    private Materials LuVMat2;

    public void run() {
        LuVMat2 = BartWorks.isModLoaded() ? Materials.get("Rhodium-PlatedPalladium") : Materials.Chrome;
        registerMachineHulls();
        registerPlasmaGenerators();
        registerAlloySmelter();
        registerMatterAmplifier();
        registerAssemblingMachine();
        registerAutoclave();
        registerBendingMachine();
        registerCompressor();
        registerCuttingMachine();
        registerDistillery();
        registerElectricFurnace();
        registerElectrolyzer();
        registerElectromagneticSeparator();
        registerExtractor();
        registerExtruder();
        registerFluidSolidifier();
        registerFormingPress();
        registerForgeHammer();
        registerLathe();
        registerPrecisionLaserEngraver();
        registerMacerator();
        registerMatterFabricator();
        registerMicrowave();
        registerOreWashingPlant();
        registerPolarizer();
        registerRecycler();
        registerReplicator();
        registerScanner();
        registerSiftingMachine();
        registerSlicingMachine();
        registerThermalCentrifuge();
        registerWiremill();
        registerPump();
        registerArcFurnace();
        registerCentrifuge();
        registerPlasmaArcFurnace();
        registerBrewery();
        registerCanningMachine();
        registerChemicalBath();
        registerChemicalReactor();

        registerFermenter();
        registerFluidCanner();
        registerFluidExtractor();
        registerFluidHeater();
        registerMixer();
        registerTransformer();
        registerBatteryBuffer4By4();
        registerBatteryBuffer3By3();
        registerBatteryBuffer2By2();
        registerBatteryBuffer1By1();
        registerBatteryCharger4By4();
        registerDynamoHatches();
        registerEnergyHatches();
        registerChestBuffer();
        registerRockBreaker();
        registerCircuitAssembler();
        registerInputHatch();
        registerOutputHatches();

        registerMachines2();
        //recipes();
    }

    public void recipes() {

        Materials LuVMat2 = BartWorks.isModLoaded() ? Materials.get("Rhodium-PlatedPalladium") : Materials.Chrome;

        GT_ModHandler.addCraftingRecipe(
            ItemList.Hull_UEV.get(1L),
            bitsd,
            new Object[] { "PHP", "WMW", 'M', ItemList.Casing_UEV, 'W',
                OrePrefixes.cableGt08.get(Materials.Draconium), 'H',
                OrePrefixes.plate.get(Materials.Bedrockium), 'P',
                OrePrefixes.plateDouble.get(Materials.Polybenzimidazole) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Hull_UIV.get(1L),
            bitsd,
            new Object[] { "PHP", "WMW", 'M', ItemList.Casing_UIV, 'W',
                OrePrefixes.cableGt08.get(Materials.NetherStar), 'H',
                OrePrefixes.plate.get(Materials.BlackPlutonium), 'P',
                OrePrefixes.plateDouble.get(Materials.Polybenzimidazole) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Hull_UMV.get(1L),
            GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
            new Object[] { "PHP", "WMW", 'M', ItemList.Casing_UMV, 'W',
                OrePrefixes.wireGt12.get(Materials.Quantium), 'H',
                OrePrefixes.plate.get(MaterialsUEVplus.SpaceTime), 'P',
                OrePrefixes.plateDouble.get(Materials.Polybenzimidazole) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Hull_UXV.get(1L),
            GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE,
            new Object[] { "PHP", "WMW", 'M', ItemList.Casing_UXV, 'W',
                OrePrefixes.wireGt16.get(Materials.BlackPlutonium), 'H',
                OrePrefixes.plate.get(MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter), 'P',
                OrePrefixes.plateDense.get(MaterialsKevlar.Kevlar) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Plasma_ZPM.get(1L),
            bitsd,
            new Object[] { "UCU", "FMF", "WCW", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_ZPM, 'C',
                AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                OrePrefixes.wireGt08.get(Materials.SuperconductorUHV), 'U',
                OrePrefixes.stick.get(Materials.Americium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Plasma_UV.get(1L),
            bitsd,
            new Object[] { "UCU", "FMF", "WCW", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'C',
                AdvancedGTMaterials.UV.getCircuit(), 'W',
                OrePrefixes.wireGt12.get(Materials.SuperconductorUHV), 'U',
                OrePrefixes.stick.get(Materials.Americium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorLuV.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_LuV, 'F', ItemList.Field_Generator_LuV, 'C',
                AdvancedGTMaterials.LuV.getCircuit(), 'W',
                AdvancedGTMaterials.LuV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorZPM.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_ZPM, 'F', ItemList.Field_Generator_ZPM, 'C',
                AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                AdvancedGTMaterials.ZPM.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorUV.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'C',
                AdvancedGTMaterials.UV.getCircuit(), 'W',
                AdvancedGTMaterials.UV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorUHV.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_MAX, 'F', ItemList.Field_Generator_UHV, 'C',
                AdvancedGTMaterials.UHV.getCircuit(), 'W',
                AdvancedGTMaterials.UHV.getCable4() });
        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorUEV.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_UEV, 'F', ItemList.Field_Generator_UEV,
                'C', AdvancedGTMaterials.UEV.getCircuit(), 'W',
                AdvancedGTMaterials.UEV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorUIV.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_UIV, 'F', ItemList.Field_Generator_UIV,
                'C', AdvancedGTMaterials.UIV.getCircuit(), 'W',
                AdvancedGTMaterials.UIV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MassFabricatorUMV.get(1L),
            bitsd,
            new Object[] { "CFC", "WMW", "CFC", 'M', ItemList.Hull_UMV, 'F', ItemList.Field_Generator_UMV,
                'C', AdvancedGTMaterials.UMV.getCircuit(), 'W',
                AdvancedGTMaterials.UMV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorLuV.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_LuV, 'F', ItemList.Field_Generator_LuV, 'E',
                ItemList.Emitter_LuV, 'C', AdvancedGTMaterials.LuV.getCircuit(), 'W',
                AdvancedGTMaterials.LuV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorZPM.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_ZPM, 'F', ItemList.Field_Generator_ZPM, 'E',
                ItemList.Emitter_ZPM, 'C', AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                AdvancedGTMaterials.ZPM.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorUV.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'E',
                ItemList.Emitter_UV, 'C', AdvancedGTMaterials.UV.getCircuit(), 'W',
                AdvancedGTMaterials.UV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorUHV.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_MAX, 'F', ItemList.Field_Generator_UHV, 'E',
                ItemList.Emitter_UHV, 'C', AdvancedGTMaterials.UHV.getCircuit(), 'W',
                AdvancedGTMaterials.UHV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorUEV.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_UEV, 'F', ItemList.Field_Generator_UEV,
                'E', ItemList.Emitter_UEV, 'C', AdvancedGTMaterials.UEV.getCircuit(), 'W',
                AdvancedGTMaterials.UEV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorUIV.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_UIV, 'F', ItemList.Field_Generator_UIV,
                'E', ItemList.Emitter_UIV, 'C', AdvancedGTMaterials.UIV.getCircuit(), 'W',
                AdvancedGTMaterials.UIV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ReplicatorUMV.get(1L),
            bitsd,
            new Object[] { "EFE", "CMC", "EWE", 'M', ItemList.Hull_UMV, 'F', ItemList.Field_Generator_UMV,
                'E', ItemList.Emitter_UMV, 'C', AdvancedGTMaterials.UMV.getCircuit(), 'W',
                AdvancedGTMaterials.UMV.getCable4() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerLuV.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_LuV, 'T', ItemList.Emitter_LuV, 'R',
                ItemList.Sensor_LuV, 'C', AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                AdvancedGTMaterials.LuV.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerZPM.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_ZPM, 'T', ItemList.Emitter_ZPM, 'R',
                ItemList.Sensor_ZPM, 'C', AdvancedGTMaterials.UV.getCircuit(), 'W',
                AdvancedGTMaterials.ZPM.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerUV.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_UV, 'T', ItemList.Emitter_UV, 'R',
                ItemList.Sensor_UV, 'C', OrePrefixes.circuit.get(Materials.Infinite), 'W',
                AdvancedGTMaterials.UV.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerUHV.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_MAX, 'T', ItemList.Emitter_UHV, 'R',
                ItemList.Sensor_UHV, 'C', OrePrefixes.circuit.get(Materials.Bio), 'W',
                OrePrefixes.cableGt01.get(Materials.Bedrockium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerUEV.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_UEV, 'T', ItemList.Emitter_UEV, 'R',
                ItemList.Sensor_UEV, 'C', OrePrefixes.circuit.get(Materials.Optical), 'W',
                OrePrefixes.cableGt01.get(Materials.Draconium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerUIV.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_UIV, 'T', ItemList.Emitter_UIV, 'R',
                ItemList.Sensor_UIV, 'C', OrePrefixes.circuit.get(Materials.Piko), 'W',
                OrePrefixes.cableGt01.get(Materials.Draconium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ScannerUMV.get(1L),
            bitsd,
            new Object[] { "CTC", "WMW", "CRC", 'M', ItemList.Hull_UMV, 'T', ItemList.Emitter_UMV, 'R',
                ItemList.Sensor_UMV, 'C', OrePrefixes.circuit.get(Materials.Quantum), 'W',
                OrePrefixes.cableGt01.get(Materials.Draconium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.PumpLuV.get(1L),
            bitsd,
            new Object[] { "CPC", "PMP", "BPB", 'M', ItemList.Hull_LuV, 'B',
                AdvancedGTMaterials.LuV.getPipeL(), 'C',
                AdvancedGTMaterials.LuV.getCircuit(), 'P', ItemList.Electric_Pump_LuV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.PumpZPM.get(1L),
            bitsd,
            new Object[] { "CPC", "PMP", "BPB", 'M', ItemList.Hull_ZPM, 'B',
                AdvancedGTMaterials.ZPM.getPipeL(), 'C',
                AdvancedGTMaterials.ZPM.getCircuit(), 'P', ItemList.Electric_Pump_ZPM });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorLV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_LV, 'M', ItemList.Electric_Motor_LV, 'P',
                ItemList.Electric_Pump_LV, 'B', ItemList.Hull_LV, 'C', ItemList.Conveyor_Module_LV, 'I',
                ItemList.Electric_Piston_LV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorMV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_MV, 'M', ItemList.Electric_Motor_MV, 'P',
                ItemList.Electric_Pump_MV, 'B', ItemList.Hull_MV, 'C', ItemList.Conveyor_Module_MV, 'I',
                ItemList.Electric_Piston_MV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorHV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_HV, 'M', ItemList.Electric_Motor_HV, 'P',
                ItemList.Electric_Pump_HV, 'B', ItemList.Hull_HV, 'C', ItemList.Conveyor_Module_HV, 'I',
                ItemList.Electric_Piston_HV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorEV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_EV, 'M', ItemList.Electric_Motor_EV, 'P',
                ItemList.Electric_Pump_EV, 'B', ItemList.Hull_EV, 'C', ItemList.Conveyor_Module_EV, 'I',
                ItemList.Electric_Piston_EV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorIV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_IV, 'M', ItemList.Electric_Motor_IV, 'P',
                ItemList.Electric_Pump_IV, 'B', ItemList.Hull_IV, 'C', ItemList.Conveyor_Module_IV, 'I',
                ItemList.Electric_Piston_IV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorLuV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_LuV, 'M', ItemList.Electric_Motor_LuV, 'P',
                ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C', ItemList.Conveyor_Module_LuV, 'I',
                ItemList.Electric_Piston_LuV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorZPM.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_ZPM, 'M', ItemList.Electric_Motor_ZPM, 'P',
                ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C', ItemList.Conveyor_Module_ZPM, 'I',
                ItemList.Electric_Piston_ZPM });

        GT_ModHandler.addCraftingRecipe(
            ItemList.AcceleratorUV.get(1L),
            bitsd,
            new Object[] { "RMR", "PBC", "IMI", 'R', ItemList.Robot_Arm_UV, 'M', ItemList.Electric_Motor_UV, 'P',
                ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C', ItemList.Conveyor_Module_UV, 'I',
                ItemList.Electric_Piston_UV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryLuV.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'P',
                ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'G',
                AdvancedGTMaterials.LuV.getGlass(), 'Z',
                new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryZPM.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.Naquadah), 'P',
                ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'G',
                AdvancedGTMaterials.ZPM.getGlass(), 'Z',
                new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryUV.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'P',
                ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UV.getGlass(), 'Z',
                new ItemStack(Items.brewing_stand, 1, 32767) });
        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryUHV.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', AdvancedGTMaterials.UHV.getCable(), 'P',
                ItemList.Electric_Pump_UHV, 'B', ItemList.Hull_MAX, 'C',
                OrePrefixes.circuit.get(Materials.Infinite), 'G',
                AdvancedGTMaterials.UHV.getGlass(), 'Z',
                new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryUEV.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', OrePrefixes.cableGt01.get(Materials.Draconium), 'P',
                ItemList.Electric_Pump_UEV, 'B', ItemList.Hull_UEV, 'C',
                OrePrefixes.circuit.get(Materials.Bio), 'G', AdvancedGTMaterials.UEV.getGlass(),
                'Z', new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryUIV.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', AdvancedGTMaterials.UIV.getCable(), 'P',
                ItemList.Electric_Pump_UIV, 'B', ItemList.Hull_UIV, 'C',
                AdvancedGTMaterials.UIV.getCircuit(), 'G',
                AdvancedGTMaterials.UIV.getGlass(), 'Z',
                new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.BreweryUMV.get(1L),
            bitsd,
            new Object[] { "GPG", "WBW", "CZC", 'W', AdvancedGTMaterials.UMV.getCable(), 'P',
                ItemList.Electric_Pump_UMV, 'B', ItemList.Hull_UMV, 'C',
                AdvancedGTMaterials.UMV.getCircuit(), 'G',
                AdvancedGTMaterials.UMV.getGlass(), 'Z',
                new ItemStack(Items.brewing_stand, 1, 32767) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorLuV.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_LuV, 'R', OrePrefixes.rotor.get(LuVMat2), 'P',
                OrePrefixes.pipeMedium.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'W',
                OrePrefixes.cableGt01.get(Materials.VanadiumGallium) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorZPM.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_ZPM, 'R',
                OrePrefixes.rotor.get(Materials.Iridium), 'P',
                OrePrefixes.pipeLarge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'W',
                OrePrefixes.cableGt01.get(Materials.Naquadah) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorUV.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_UV, 'R', OrePrefixes.rotor.get(Materials.Osmium),
                'P', OrePrefixes.pipeHuge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_UV,
                'C', OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'W',
                OrePrefixes.cableGt01.get(Materials.ElectrumFlux) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorUHV.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_MAX, 'R',
                OrePrefixes.rotor.get(Materials.Osmiridium), 'P',
                OrePrefixes.pipeHuge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_UHV, 'C',
                OrePrefixes.circuit.get(Materials.Infinite), 'W',
                AdvancedGTMaterials.UHV.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorUEV.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_UEV, 'R',
                OrePrefixes.rotor.get(Materials.InfinityCatalyst), 'P',
                OrePrefixes.pipeHuge.get(Materials.PolyvinylChloride), 'M', ItemList.Electric_Motor_UEV, 'C',
                OrePrefixes.circuit.get(Materials.Bio), 'W',
                AdvancedGTMaterials.UEV.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorUIV.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_UIV, 'R',
                OrePrefixes.rotor.get(Materials.Infinity), 'P',
                OrePrefixes.pipeMedium.get(Materials.Polybenzimidazole), 'M', ItemList.Electric_Motor_UIV, 'C',
                OrePrefixes.circuit.get(Materials.Optical), 'W',
                AdvancedGTMaterials.UIV.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.ChemicalReactorUMV.get(1L),
            bitsd,
            new Object[] { "PRP", "WMW", "CHC", 'H', ItemList.Hull_UMV, 'R',
                OrePrefixes.rotor.get(MaterialsUEVplus.TranscendentMetal), 'P',
                OrePrefixes.pipeLarge.get(Materials.Polybenzimidazole), 'M', ItemList.Electric_Motor_UMV, 'C',
                OrePrefixes.circuit.get(Materials.Piko), 'W',
                AdvancedGTMaterials.UMV.getCable() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterLuV.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'P',
                ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'G',
                AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterZPM.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', OrePrefixes.cableGt01.get(Materials.Naquadah), 'P',
                ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'G',
                AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterUV.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'P',
                ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterUHV.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', AdvancedGTMaterials.UHV.getCable(), 'P',
                ItemList.Electric_Pump_UHV, 'B', ItemList.Hull_MAX, 'C',
                OrePrefixes.circuit.get(Materials.Infinite), 'G',
                AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterUEV.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', AdvancedGTMaterials.UEV.getCable(), 'P',
                ItemList.Electric_Pump_UEV, 'B', ItemList.Hull_UEV, 'C',
                OrePrefixes.circuit.get(Materials.Bio), 'G',
                AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterUIV.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', AdvancedGTMaterials.UIV.getCable(), 'P',
                ItemList.Electric_Pump_UIV, 'B', ItemList.Hull_UIV, 'C',
                OrePrefixes.circuit.get(Materials.Optical), 'G',
                AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FermenterUMV.get(1L),
            bitsd,
            new Object[] { "WPW", "GBG", "WCW", 'W', AdvancedGTMaterials.UMV.getCable(), 'P',
                ItemList.Electric_Pump_UMV, 'B', ItemList.Hull_UMV, 'C',
                OrePrefixes.circuit.get(Materials.Piko), 'G',
                AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerLuV.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'P',
                ItemList.Electric_Pump_LuV, 'B', ItemList.Hull_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'G',
                AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerZPM.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', OrePrefixes.cableGt01.get(Materials.Naquadah), 'P',
                ItemList.Electric_Pump_ZPM, 'B', ItemList.Hull_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'G',
                AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerUV.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'P',
                ItemList.Electric_Pump_UV, 'B', ItemList.Hull_UV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerUHV.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', AdvancedGTMaterials.UHV.getCable(), 'P',
                ItemList.Electric_Pump_UHV, 'B', ItemList.Hull_MAX, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerUEV.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', AdvancedGTMaterials.UEV.getCable(), 'P',
                ItemList.Electric_Pump_UEV, 'B', ItemList.Hull_UEV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerUIV.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', AdvancedGTMaterials.UIV.getCable(), 'P',
                ItemList.Electric_Pump_UIV, 'B', ItemList.Hull_UIV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidCannerUMV.get(1L),
            bitsd,
            new Object[] { "GCG", "GBG", "WPW", 'W', AdvancedGTMaterials.UMV.getCable(), 'P',
                ItemList.Electric_Pump_UMV, 'B', ItemList.Hull_UMV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorLuV.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_LuV, 'E', ItemList.Electric_Piston_LuV, 'P',
                ItemList.Electric_Pump_LuV, 'C', OrePrefixes.circuit.get(Materials.Master), 'W',
                OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'G',
                AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorZPM.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_ZPM, 'E', ItemList.Electric_Piston_ZPM, 'P',
                ItemList.Electric_Pump_ZPM, 'C', OrePrefixes.circuit.get(Materials.Ultimate), 'W',
                OrePrefixes.cableGt01.get(Materials.Naquadah), 'G',
                AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorUV.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_UV, 'E', ItemList.Electric_Piston_UV, 'P',
                ItemList.Electric_Pump_UV, 'C', OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'W',
                OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'G',
                AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorUHV.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_MAX, 'E', ItemList.Electric_Piston_UHV, 'P',
                ItemList.Electric_Pump_UHV, 'C', AdvancedGTMaterials.UHV.getCircuit(), 'W',
                AdvancedGTMaterials.UHV.getCable(), 'G',
                AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorUEV.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_UEV, 'E', ItemList.Electric_Piston_UEV,
                'P', ItemList.Electric_Pump_UEV, 'C', AdvancedGTMaterials.UEV.getCircuit(), 'W',
                AdvancedGTMaterials.UEV.getCable(), 'G',
                AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorUIV.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_UIV, 'E', ItemList.Electric_Piston_UIV,
                'P', ItemList.Electric_Pump_UIV, 'C', AdvancedGTMaterials.UIV.getCircuit(), 'W',
                AdvancedGTMaterials.UIV.getCable(), 'G',
                AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidExtractorUMV.get(1L),
            bitsd,
            new Object[] { "GEG", "WPW", "CMC", 'M', ItemList.Hull_UMV, 'E', ItemList.Electric_Piston_UMV,
                'P', ItemList.Electric_Pump_UMV, 'C', AdvancedGTMaterials.UMV.getCircuit(), 'W',
                AdvancedGTMaterials.UMV.getCable(), 'G',
                AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterLuV.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "RCR", 'M', ItemList.Hull_LuV, 'P', ItemList.Electric_Pump_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'W',
                OrePrefixes.wireGt04.get(Materials.NiobiumTitanium), 'R',
                OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'G',
                AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterZPM.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_ZPM, 'P', ItemList.Electric_Pump_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'W', OrePrefixes.wireGt04.get(Materials.Naquadah),
                'R', OrePrefixes.cableGt01.get(Materials.Naquadah), 'G',
                AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterUV.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_UV, 'P', ItemList.Electric_Pump_UV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'W',
                OrePrefixes.wireGt04.get(Materials.NaquadahAlloy), 'R',
                OrePrefixes.cableGt01.get(Materials.ElectrumFlux), 'G',
                AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterUHV.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_MAX, 'P', ItemList.Electric_Pump_UHV, 'C',
                AdvancedGTMaterials.UHV.getCircuit(), 'W',
                AdvancedGTMaterials.UHV.getHCoil(), 'R',
                AdvancedGTMaterials.UHV.getCable(), 'G',
                AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterUEV.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_UEV, 'P', ItemList.Electric_Pump_UEV, 'C',
                AdvancedGTMaterials.UEV.getCircuit(), 'W',
                AdvancedGTMaterials.UEV.getHCoil(), 'R',
                AdvancedGTMaterials.UEV.getCable(), 'G',
                AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterUIV.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_UIV, 'P', ItemList.Electric_Pump_UIV, 'C',
                AdvancedGTMaterials.UIV.getCircuit(), 'W',
                AdvancedGTMaterials.UIV.getHCoil(), 'R',
                AdvancedGTMaterials.UIV.getCable(), 'G',
                AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.FluidHeaterUMV.get(1L),
            bitsd,
            new Object[] { "WGW", "PMP", "WCW", 'M', ItemList.Hull_UMV, 'P', ItemList.Electric_Pump_UMV, 'C',
                AdvancedGTMaterials.UMV.getCircuit(), 'W',
                AdvancedGTMaterials.UMV.getHCoil(), 'R',
                AdvancedGTMaterials.UMV.getCable(), 'G',
                AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerLuV.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(LuVMat2), 'M',
                ItemList.Electric_Motor_LuV, 'B', ItemList.Hull_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'G',
                AdvancedGTMaterials.LuV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerZPM.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Iridium), 'M',
                ItemList.Electric_Motor_ZPM, 'B', ItemList.Hull_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'G',
                AdvancedGTMaterials.ZPM.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerUV.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Osmium), 'M',
                ItemList.Electric_Motor_UV, 'B', ItemList.Hull_UV, 'C',
                OrePrefixes.circuit.get(Materials.SuperconductorUHV), 'G',
                AdvancedGTMaterials.UV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerUHV.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Neutronium), 'M',
                ItemList.Electric_Motor_UHV, 'B', ItemList.Hull_MAX, 'C',
                OrePrefixes.circuit.get(Materials.Infinite), 'G',
                AdvancedGTMaterials.UHV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerUEV.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.Neutronium), 'M',
                ItemList.Electric_Motor_UEV, 'B', ItemList.Hull_UEV, 'C',
                OrePrefixes.circuit.get(Materials.Bio), 'G',
                AdvancedGTMaterials.UEV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerUIV.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'M',
                ItemList.Electric_Motor_UIV, 'B', ItemList.Hull_UIV, 'C',
                OrePrefixes.circuit.get(Materials.Optical), 'G',
                AdvancedGTMaterials.UIV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.MixerUMV.get(1L),
            bitsd,
            new Object[] { "GRG", "GMG", "CBC", 'R', OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'M',
                ItemList.Electric_Motor_UMV, 'B', ItemList.Hull_UMV, 'C',
                OrePrefixes.circuit.get(Materials.Piko), 'G',
                AdvancedGTMaterials.UMV.getGlass() });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Transformer_UEV_UHV.get(1L),
            bitsd,
            new Object[] { "KBB", "CM ", "KBB", 'M', ItemList.Hull_MAX, 'C',
                OrePrefixes.wireGt01.get(Materials.Draconium), 'B',
                OrePrefixes.wireGt04.get(Materials.SuperconductorUHV), 'K', ItemList.Circuit_Chip_PPIC });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Transformer_UIV_UEV.get(1L),
            bitsd,
            new Object[] { "KBB", "CM ", "KBB", 'M', ItemList.Hull_UEV, 'C',
                OrePrefixes.wireGt01.get(Materials.NetherStar), 'B',
                OrePrefixes.wireGt04.get(Materials.Draconium), 'K', ItemList.Circuit_Chip_QPIC });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Transformer_UMV_UIV.get(1L),
            bitsd,
            new Object[] { "KBB", "CM ", "KBB", 'M', ItemList.Hull_UIV, 'C',
                OrePrefixes.wireGt01.get(Materials.Quantium), 'B',
                OrePrefixes.wireGt04.get(Materials.NetherStar), 'K', ItemList.Circuit_Chip_QPIC });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Transformer_UXV_UMV.get(1L),
            bitsd,
            new Object[] { "KBB", "CM ", "KBB", 'M', ItemList.Hull_UMV, 'C',
                OrePrefixes.wireGt01.get(Materials.BlackPlutonium), 'B',
                OrePrefixes.wireGt04.get(Materials.Quantium), 'K', ItemList.Circuit_Chip_QPIC });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Transformer_MAX_UXV.get(1L),
            bitsd,
            new Object[] { "KBB", "CM ", "KBB", 'M', ItemList.Hull_UXV, 'C',
                OrePrefixes.wireGt01.get(Materials.Infinity), 'B',
                OrePrefixes.wireGt04.get(Materials.BlackPlutonium), 'K', ItemList.Circuit_Chip_QPIC });
        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_4by4_UEV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UEV, 'W',
                OrePrefixes.wireGt16.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_3by3_UIV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UIV, 'W',
                OrePrefixes.wireGt08.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });
        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_3by3_UMV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UMV, 'W',
                OrePrefixes.wireGt08.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_3by3_UXV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UXV, 'W',
                OrePrefixes.wireGt08.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_2by2_UEV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UEV, 'W',
                OrePrefixes.wireGt04.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_2by2_UIV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UIV, 'W',
                OrePrefixes.wireGt04.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_2by2_UMV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UMV, 'W',
                OrePrefixes.wireGt04.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_2by2_UXV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UXV, 'W',
                OrePrefixes.wireGt04.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_1by1_UEV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UEV, 'W',
                OrePrefixes.wireGt01.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_1by1_UIV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UIV, 'W',
                OrePrefixes.wireGt01.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_1by1_UMV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UMV, 'W',
                OrePrefixes.wireGt01.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_1by1_UXV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UXV, 'W',
                OrePrefixes.wireGt01.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_4by4_UIV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UIV, 'W',
                OrePrefixes.wireGt16.get(Materials.NetherStar), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_4by4_UMV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UMV, 'W',
                OrePrefixes.wireGt16.get(Materials.Quantium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_4by4_UXV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UXV, 'W',
                OrePrefixes.wireGt16.get(Materials.BlackPlutonium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Battery_Buffer_3by3_UEV.get(1L),
            bitsd,
            new Object[] { "WTW", "WMW", 'M', ItemList.Hull_UEV, 'W',
                OrePrefixes.wireGt08.get(Materials.Draconium), 'T', OreDictNames.craftingChest });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Automation_ChestBuffer_UEV.get(1L),
            bitsd,
            new Object[] { "CMV", " X ", 'M', ItemList.Hull_UEV, 'V', ItemList.Conveyor_Module_UEV, 'C',
                OreDictNames.craftingChest, 'X', OrePrefixes.circuit.get(Materials.Bio) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Automation_ChestBuffer_UIV.get(1L),
            bitsd,
            new Object[] { "CMV", " X ", 'M', ItemList.Hull_UIV, 'V', ItemList.Conveyor_Module_UIV, 'C',
                OreDictNames.craftingChest, 'X', OrePrefixes.circuit.get(Materials.Optical) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.Automation_ChestBuffer_UMV.get(1L),
            bitsd,
            new Object[] { "CMV", " X ", 'M', ItemList.Hull_UMV, 'V', ItemList.Conveyor_Module_UMV, 'C',
                OreDictNames.craftingChest, 'X', OrePrefixes.circuit.get(Materials.Piko) });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerLuV.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_LuV, 'E', ItemList.Electric_Motor_LuV,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.LuV.getGlass(), 'W',
                OrePrefixes.cableGt01.get(Materials.VanadiumGallium), 'M', ItemList.Hull_LuV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerZPM.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_ZPM, 'E', ItemList.Electric_Motor_ZPM,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.ZPM.getGlass(), 'W',
                OrePrefixes.cableGt01.get(Materials.Naquadah), 'M', ItemList.Hull_ZPM });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerUV.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UV, 'E', ItemList.Electric_Motor_UV,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.UV.getGlass(), 'W',
                OrePrefixes.cableGt01.get(Materials.NaquadahAlloy), 'M', ItemList.Hull_UV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerUHV.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UHV, 'E', ItemList.Electric_Motor_UHV,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.UHV.getGlass(), 'W',
                AdvancedGTMaterials.UHV.getCable(), 'M', ItemList.Hull_MAX });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerUEV.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UEV, 'E', ItemList.Electric_Motor_UEV,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.UEV.getGlass(), 'W',
                AdvancedGTMaterials.UEV.getCable(), 'M', ItemList.Hull_UEV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerUIV.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UIV, 'E', ItemList.Electric_Motor_UIV,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.UIV.getGlass(), 'W',
                AdvancedGTMaterials.UIV.getCable(), 'M', ItemList.Hull_UIV });

        GT_ModHandler.addCraftingRecipe(
            ItemList.RockBreakerUMV.get(1L),
            bitsd,
            new Object[] { "PED", "WMW", "GGG", 'P', ItemList.Electric_Piston_UMV, 'E', ItemList.Electric_Motor_UMV,
                'D', OreDictNames.craftingGrinder, 'G', AdvancedGTMaterials.UMV.getGlass(), 'W',
                AdvancedGTMaterials.UMV.getCable(), 'M', ItemList.Hull_UMV });
    }
    private void registerMachineHulls() {
        ItemList.Hull_UEV.set(
            new GT_MetaTileEntity_BasicHull(
                HULL_UEV.ID,
                "hull.tier.10",
                "UEV Machine Hull",
                10,
                GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        ItemList.Hull_UIV.set(
            new GT_MetaTileEntity_BasicHull(
                HULL_UIV.ID,
                "hull.tier.11",
                "UIV Machine Hull",
                11,
                GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        ItemList.Hull_UMV.set(
            new GT_MetaTileEntity_BasicHull(
                HULL_UMV.ID,
                "hull.tier.12",
                "UMV Machine Hull",
                12,
                GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        ItemList.Hull_UXV.set(
            new GT_MetaTileEntity_BasicHull(
                HULL_UXV.ID,
                "hull.tier.13",
                "UXV Machine Hull",
                13,
                GT_Loader_MetaTileEntities.imagination).getStackForm(1L));

        ItemList.Hull_MAXV.set(
            new GT_MetaTileEntity_BasicHull(
                HULL_MAX.ID,
                "hull.tier.14",
                "MAX Machine Hull",
                14,
                GT_Loader_MetaTileEntities.imagination).getStackForm(1L));
    }

    private void registerPlasmaGenerators() {
        ItemList.Generator_Plasma_ZPM.set(
            new GT_MetaTileEntity_PlasmaGenerator(
                PLASMA_GENERATOR_ZPM.ID,
                "basicgenerator.plasmagenerator.tier.08",
                "Plasma Generator Mark IV",
                7).getStackForm(1L));

        ItemList.Generator_Plasma_UV.set(
            new GT_MetaTileEntity_PlasmaGenerator(
                PLASMA_GENERATOR_UV.ID,
                "basicgenerator.plasmagenerator.tier.09",
                "Ultimate Pocket Sun",
                8).getStackForm(1L));
    }

    private void registerAlloySmelter() {
        ItemList.AlloySmelterLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_LuV.ID,
                "basicmachine.alloysmelter.tier.06",
                "Elite Alloy Smelter",
                6,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'C',
                    AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        ItemList.AlloySmelterZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_ZPM.ID,
                "basicmachine.alloysmelter.tier.07",
                "Elite Alloy Smelter II",
                7,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'C',
                    AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        ItemList.AlloySmelterUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_UV.ID,
                "basicmachine.alloysmelter.tier.08",
                "Ultimate Alloy Integrator",
                8,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'C',
                    AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        ItemList.AlloySmelterUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_UHV.ID,
                "basicmachine.alloysmelter.tier.09",
                "Epic Alloy Integrator",
                9,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'C',
                    AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        ItemList.AlloySmelterUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_UEV.ID,
                "basicmachine.alloysmelter.tier.10",
                "Epic Alloy Integrator II",
                10,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', ItemList.Hull_UEV, 'E',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'C',
                    AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));
        // Nulling recipes for now
        ItemList.AlloySmelterUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_UIV.ID,
                "basicmachine.alloysmelter.tier.11",
                "Epic Alloy Integrator III",
                11,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', ItemList.Hull_UIV, 'E',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'C',
                    AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        ItemList.AlloySmelterUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ALLOY_SMELTER_UMV.ID,
                "basicmachine.alloysmelter.tier.12",
                "Epic Alloy Integrator IV",
                12,
                MachineType.ALLOY_SMELTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes,
                2,
                1,
                false,
                0,
                1,
                "AlloySmelter.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ALLOY_SMELTER",
                new Object[] { "ECE", "CMC", "WCW", 'M', ItemList.Hull_UMV, 'E',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'C',
                    AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));
    }

    private void registerMatterAmplifier() {
        ItemList.AmplifabricatorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_LuV.ID,
                "basicmachine.amplifab.tier.06",
                "Elite Amplifabricator",
                6,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable4(), }).getStackForm(1L));

        ItemList.AmplifabricatorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_ZPM.ID,
                "basicmachine.amplifab.tier.07",
                "Elite Amplifabricator II",
                7,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable4(), }).getStackForm(1L));

        ItemList.AmplifabricatorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_UV.ID,
                "basicmachine.amplifab.tier.08",
                "Ultimate Amplicreator",
                8,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable4(), }).getStackForm(1L));

        ItemList.AmplifabricatorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_UHV.ID,
                "basicmachine.amplifab.tier.09",
                "Epic Amplicreator",
                9,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable4(), }).getStackForm(1L));

        ItemList.AmplifabricatorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_UEV.ID,
                "basicmachine.amplifab.tier.10",
                "Epic Amplicreator II",
                10,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable4(), }).getStackForm(1L));

        ItemList.AmplifabricatorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_UIV.ID,
                "basicmachine.amplifab.tier.11",
                "Epic Amplicreator III",
                11,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable4(), }).getStackForm(1L));

        ItemList.AmplifabricatorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MATTER_AMPLIFIER_UMV.ID,
                "basicmachine.amplifab.tier.12",
                "Epic Amplicreator IV",
                12,
                MachineType.MATTER_AMPLIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAmplifiers,
                1,
                1,
                1000,
                0,
                1,
                "Amplifabricator.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AMPLIFAB",
                new Object[] { "WPW", "PMP", "CPC", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable4(), }).getStackForm(1L));
    }

    private void registerAssemblingMachine() {
        ItemList.AssemblingMachineLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_LuV.ID,
                "basicmachine.assembler.tier.06",
                "Elite Assembling Machine",
                6,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.AssemblingMachineZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_ZPM.ID,
                "basicmachine.assembler.tier.07",
                "Elite Assembling Machine II",
                7,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.AssemblingMachineUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_UV.ID,
                "basicmachine.assembler.tier.08",
                "Ultimate Assembly Constructor",
                8,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.AssemblingMachineUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_UHV.ID,
                "basicmachine.assembler.tier.09",
                "Epic Assembly Constructor",
                9,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));
        ItemList.AssemblingMachineUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_UEV.ID,
                "basicmachine.assembler.tier.10",
                "Epic Assembly Constructor II",
                10,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', ItemList.Hull_UEV, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.AssemblingMachineUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_UIV.ID,
                "basicmachine.assembler.tier.11",
                "Epic Assembly Constructor III",
                11,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', ItemList.Hull_UIV, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.AssemblingMachineUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ASSEMBLING_MACHINE_UMV.ID,
                "basicmachine.assembler.tier.12",
                "Epic Assembly Constructor IV",
                12,
                MachineType.ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAssemblerRecipes,
                9,
                1,
                true,
                0,
                1,
                "Assembler2.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ASSEMBLER",
                new Object[] { "ACA", "VMV", "WCW", 'M', ItemList.Hull_UMV, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'A',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.ROBOT_ARM, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));
    }

    private void registerAutoclave() {
        ItemList.AutoclaveLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_LuV.ID,
                "basicmachine.autoclave.tier.06",
                "Elite Autoclave",
                6,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'I',
                    AdvancedGTMaterials.LuV.getPlate(), 'G',
                    AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        ItemList.AutoclaveZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_ZPM.ID,
                "basicmachine.autoclave.tier.07",
                "Elite Autoclave II",
                7,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'I',
                    AdvancedGTMaterials.ZPM.getPlate(), 'G',
                    AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        ItemList.AutoclaveUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_UV.ID,
                "basicmachine.autoclave.tier.08",
                "Ultimate Pressure Cooker",
                8,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'I',
                    AdvancedGTMaterials.UV.getPlate(), 'G',
                    AdvancedGTMaterials.UV.getGlass(), }).getStackForm(1L));

        ItemList.AutoclaveUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_UHV.ID,
                "basicmachine.autoclave.tier.09",
                "Epic Pressure Cooker",
                9,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'I',
                    AdvancedGTMaterials.UHV.getPlate(), 'G',
                    AdvancedGTMaterials.UHV.getGlass(), }).getStackForm(1L));

        ItemList.AutoclaveUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_UEV.ID,
                "basicmachine.autoclave.tier.10",
                "Epic Pressure Cooker II",
                10,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'I',
                    AdvancedGTMaterials.UEV.getPlate(), 'G',
                    AdvancedGTMaterials.UEV.getGlass(), }).getStackForm(1L));

        ItemList.AutoclaveUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_UIV.ID,
                "basicmachine.autoclave.tier.11",
                "Epic Pressure Cooker III",
                11,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'I',
                    AdvancedGTMaterials.UIV.getPlate(), 'G',
                    AdvancedGTMaterials.UIV.getGlass(), }).getStackForm(1L));

        ItemList.AutoclaveUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                AUTOCLAVE_UMV.ID,
                "basicmachine.autoclave.tier.12",
                "Epic Pressure Cooker IV",
                12,
                MachineType.AUTOCLAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes,
                2,
                4,
                true,
                0,
                1,
                "Autoclave4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "AUTOCLAVE",
                new Object[] { "IGI", "IMI", "CPC", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'I',
                    AdvancedGTMaterials.UMV.getPlate(), 'G',
                    AdvancedGTMaterials.UMV.getGlass(), }).getStackForm(1L));
    }

    private void registerBendingMachine() {

        ItemList.BendingMachineLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_LuV.ID,
                "basicmachine.bender.tier.06",
                "Elite Bending Machine",
                6,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.BendingMachineZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_ZPM.ID,
                "basicmachine.bender.tier.07",
                "Elite Bending Machine II",
                7,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.BendingMachineUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_UV.ID,
                "basicmachine.bender.tier.08",
                "Ultimate Bending Unit",
                8,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.BendingMachineUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_UHV.ID,
                "basicmachine.bender.tier.09",
                "Epic Bending Unit",
                9,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.BendingMachineUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_UEV.ID,
                "basicmachine.bender.tier.10",
                "Epic Bending Unit II",
                10,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.BendingMachineUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_UIV.ID,
                "basicmachine.bender.tier.11",
                "Epic Bending Unit III",
                11,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.BendingMachineUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                BENDING_MACHINE_UMV.ID,
                "basicmachine.bender.tier.12",
                "Epic Bending Unit IV",
                12,
                MachineType.BENDING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sBenderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Bender.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "BENDER",
                new Object[] { "PWP", "CMC", "EWE", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerCompressor() {

        ItemList.CompressorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_LuV.ID,
                "basicmachine.compressor.tier.06",
                "Elite Compressor",
                6,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.CompressorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_ZPM.ID,
                "basicmachine.compressor.tier.07",
                "Elite Compressor II",
                7,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.CompressorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_UV.ID,
                "basicmachine.compressor.tier.08",
                "Ultimate Matter Constrictor",
                8,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.CompressorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_UHV.ID,
                "basicmachine.compressor.tier.09",
                "Epic Matter Constrictor",
                9,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.CompressorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_UEV.ID,
                "basicmachine.compressor.tier.10",
                "Epic Matter Constrictor II",
                10,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.CompressorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_UIV.ID,
                "basicmachine.compressor.tier.11",
                "Epic Matter Constrictor III",
                11,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.CompressorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                COMPRESSOR_UMV.ID,
                "basicmachine.compressor.tier.12",
                "Epic Matter Constrictor IV",
                12,
                MachineType.COMPRESSOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCompressorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Compressor.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "COMPRESSOR",
                new Object[] { "WCW", "PMP", "WCW", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerCuttingMachine() {

        ItemList.CuttingMachineLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_LuV.ID,
                "basicmachine.cutter.tier.06",
                "Elite Cutting Machine",
                6,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    AdvancedGTMaterials.LuV.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        ItemList.CuttingMachineZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_ZPM.ID,
                "basicmachine.cutter.tier.07",
                "Elite Cutting Machine II",
                7,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    AdvancedGTMaterials.ZPM.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        ItemList.CuttingMachineUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_UV.ID,
                "basicmachine.cutter.tier.08",
                "Ultimate Object Divider",
                8,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    AdvancedGTMaterials.UV.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        ItemList.CuttingMachineUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_UHV.ID,
                "basicmachine.cutter.tier.09",
                "Epic Object Divider",
                9,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    AdvancedGTMaterials.UHV.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        ItemList.CuttingMachineUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_UEV.ID,
                "basicmachine.cutter.tier.10",
                "Epic Object Divider II",
                10,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    AdvancedGTMaterials.UEV.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        ItemList.CuttingMachineUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_UIV.ID,
                "basicmachine.cutter.tier.11",
                "Epic Object Divider III",
                11,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    AdvancedGTMaterials.UIV.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

        ItemList.CuttingMachineUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CUTTING_MACHINE_UMV.ID,
                "basicmachine.cutter.tier.12",
                "Epic Object Divider IV",
                12,
                MachineType.CUTTING_MACHINE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCutterRecipes,
                2,
                4,
                true,
                0,
                1,
                "Cutter4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CUTTER",
                new Object[] { "WCG", "VMB", "CWE", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    AdvancedGTMaterials.UMV.getGlass(), 'B',
                    OreDictNames.craftingDiamondBlade }).getStackForm(1L));

    }

    private void registerDistillery() {

        ItemList.DistilleryLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_LuV.ID,
                "basicmachine.distillery.tier.06",
                "Elite Distillery",
                6,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeMedium.get(Materials.Enderium), 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        ItemList.DistilleryZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_ZPM.ID,
                "basicmachine.distillery.tier.07",
                "Elite Distillery II",
                7,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeMedium.get(Materials.Naquadah), 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        ItemList.DistilleryUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_UV.ID,
                "basicmachine.distillery.tier.08",
                "Ultimate Fraction Splitter",
                8,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeMedium.get(Materials.Neutronium), 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    AdvancedGTMaterials.UV.getGlass() }).getStackForm(1L));

        ItemList.DistilleryUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_UHV.ID,
                "basicmachine.distillery.tier.09",
                "Epic Fraction Splitter",
                9,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeLarge.get(Materials.Neutronium), 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    AdvancedGTMaterials.UHV.getGlass() }).getStackForm(1L));

        ItemList.DistilleryUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_UEV.ID,
                "basicmachine.distillery.tier.10",
                "Epic Fraction Splitter II",
                10,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeHuge.get(Materials.Neutronium), 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    AdvancedGTMaterials.UEV.getGlass() }).getStackForm(1L));

        ItemList.DistilleryUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_UIV.ID,
                "basicmachine.distillery.tier.11",
                "Epic Fraction Splitter III",
                11,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeMedium.get(Materials.Infinity), 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    AdvancedGTMaterials.UIV.getGlass() }).getStackForm(1L));

        ItemList.DistilleryUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                DISTILLERY_UMV.ID,
                "basicmachine.distillery.tier.12",
                "Epic Fraction Splitter IV",
                12,
                MachineType.DISTILLERY.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sDistilleryRecipes,
                1,
                1,
                true,
                0,
                1,
                "Distillery.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "DISTILLERY",
                new Object[] { "GBG", "CMC", "WPW", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'B',
                    OrePrefixes.pipeMedium.get(MaterialsUEVplus.SpaceTime), 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    AdvancedGTMaterials.UMV.getGlass() }).getStackForm(1L));

    }

    private void registerElectricFurnace() {

        ItemList.ElectricFurnaceLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_LuV.ID,
                "basicmachine.e_furnace.tier.06",
                "Elite Electric Furnace",
                6,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'C',
                    AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        ItemList.ElectricFurnaceZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_ZPM.ID,
                "basicmachine.e_furnace.tier.07",
                "Elite Electric Furnace II",
                7,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'C',
                    AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        ItemList.ElectricFurnaceUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_UV.ID,
                "basicmachine.e_furnace.tier.08",
                "Ultimate Atom Stimulator",
                8,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'C',
                    AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        ItemList.ElectricFurnaceUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_UHV.ID,
                "basicmachine.e_furnace.tier.09",
                "Epic Atom Stimulator",
                9,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'C',
                    AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        ItemList.ElectricFurnaceUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_UEV.ID,
                "basicmachine.e_furnace.tier.10",
                "Epic Atom Stimulator II",
                10,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', ItemList.Hull_UEV, 'E',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'C',
                    AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));

        ItemList.ElectricFurnaceUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_UIV.ID,
                "basicmachine.e_furnace.tier.11",
                "Epic Atom Stimulator III",
                11,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', ItemList.Hull_UIV, 'E',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'C',
                    AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        ItemList.ElectricFurnaceUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTRIC_FURNACE_UMV.ID,
                "basicmachine.e_furnace.tier.12",
                "Epic Atom Stimulator IV",
                12,
                MachineType.ELECTRIC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFurnaceRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTRIC_FURNACE",
                new Object[] { "WCW", "CMC", "ECE", 'M', ItemList.Hull_UMV, 'E',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'C',
                    AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));

    }

    private void registerElectrolyzer() {

        ItemList.ElectrolyzerLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_LuV.ID,
                "basicmachine.electrolyzer.tier.06",
                "Elite Electrolyzer",
                6,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'I',
                    OrePrefixes.wireGt02.get(Materials.Osmium), 'G',
                    AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        ItemList.ElectrolyzerZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_ZPM.ID,
                "basicmachine.electrolyzer.tier.07",
                "Elite Electrolyzer II",
                7,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'I',
                    OrePrefixes.wireGt02.get(Materials.NiobiumTitanium), 'G',
                    AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        ItemList.ElectrolyzerUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_UV.ID,
                "basicmachine.electrolyzer.tier.08",
                "Ultimate Ionizer",
                8,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'I',
                    OrePrefixes.wireGt04.get(Materials.VanadiumGallium), 'G',
                    AdvancedGTMaterials.UV.getGlass() }).getStackForm(1L));

        ItemList.ElectrolyzerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_UHV.ID,
                "basicmachine.electrolyzer.tier.09",
                "Epic Ionizer",
                9,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'I',
                    OrePrefixes.wireGt04.get(Materials.Osmiridium), 'G',
                    AdvancedGTMaterials.UHV.getGlass() }).getStackForm(1L));

        ItemList.ElectrolyzerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_UEV.ID,
                "basicmachine.electrolyzer.tier.10",
                "Epic Ionizer II",
                10,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'I',
                    OrePrefixes.wireGt04.get(Materials.Draconium), 'G',
                    AdvancedGTMaterials.UEV.getGlass() }).getStackForm(1L));

        ItemList.ElectrolyzerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_UIV.ID,
                "basicmachine.electrolyzer.tier.11",
                "Epic Ionizer III",
                11,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'I',
                    OrePrefixes.wireGt04.get(Materials.DraconiumAwakened), 'G',
                    AdvancedGTMaterials.UIV.getGlass() }).getStackForm(1L));

        ItemList.ElectrolyzerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROLYZER_UMV.ID,
                "basicmachine.electrolyzer.tier.12",
                "Epic Ionizer IV",
                12,
                MachineType.ELECTROLYZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes,
                2,
                6,
                true,
                0,
                1,
                "Electrolyzer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROLYZER",
                new Object[] { "IGI", "IMI", "CWC", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'I',
                    OrePrefixes.wireGt04.get(Materials.Infinity), 'G',
                    AdvancedGTMaterials.UMV.getGlass() }).getStackForm(1L));

    }

    private void registerElectromagneticSeparator() {

        ItemList.ElectromagneticSeparatorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_LuV.ID,
                "basicmachine.electromagneticseparator.tier.06",
                "Elite Electromagnetic Separator",
                6,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.LuV.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.ElectromagneticSeparatorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_ZPM.ID,
                "basicmachine.electromagneticseparator.tier.07",
                "Elite Electromagnetic Separator II",
                7,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.ZPM.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.ElectromagneticSeparatorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_UV.ID,
                "basicmachine.electromagneticseparator.tier.08",
                "Ultimate Magnetar Separator",
                8,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.UV.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.ElectromagneticSeparatorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_UHV.ID,
                "basicmachine.electromagneticseparator.tier.09",
                "Epic Magnetar Separator",
                9,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.UHV.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.ElectromagneticSeparatorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_UEV.ID,
                "basicmachine.electromagneticseparator.tier.10",
                "Epic Magnetar Separator II",
                10,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', ItemList.Hull_UEV, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.UEV.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.ElectromagneticSeparatorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_UIV.ID,
                "basicmachine.electromagneticseparator.tier.11",
                "Epic Magnetar Separator III",
                11,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', ItemList.Hull_UIV, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.UIV.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.ElectromagneticSeparatorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ELECTROMAGNETIC_SEPARATOR_UMV.ID,
                "basicmachine.electromagneticseparator.tier.12",
                "Epic Magnetar Separator IV",
                12,
                MachineType.ELECTROMAGNETIC_SEPARATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes,
                1,
                3,
                false,
                0,
                1,
                "ElectromagneticSeparator.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ELECTROMAGNETIC_SEPARATOR",
                new Object[] { "VWZ", "WMS", "CWZ", 'M', ItemList.Hull_UMV, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    AdvancedGTMaterials.UMV.getWire(), 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerExtractor() {

        ItemList.ExtractorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_LuV.ID,
                "basicmachine.extractor.tier.06",
                "Elite Extractor",
                6,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    AdvancedGTMaterials.LuV.getGlass() }).getStackForm(1L));

        ItemList.ExtractorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_ZPM.ID,
                "basicmachine.extractor.tier.07",
                "Elite Extractor II",
                7,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    AdvancedGTMaterials.ZPM.getGlass() }).getStackForm(1L));

        ItemList.ExtractorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_UV.ID,
                "basicmachine.extractor.tier.08",
                "Ultimate Extractinator",
                8,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    AdvancedGTMaterials.UV.getGlass() }).getStackForm(1L));

        ItemList.ExtractorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_UHV.ID,
                "basicmachine.extractor.tier.09",
                "Epic Extractinator",
                9,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    AdvancedGTMaterials.UHV.getGlass() }).getStackForm(1L));

        ItemList.ExtractorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_UEV.ID,
                "basicmachine.extractor.tier.10",
                "Epic Extractinator II",
                10,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    AdvancedGTMaterials.UEV.getGlass() }).getStackForm(1L));

        ItemList.ExtractorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_UIV.ID,
                "basicmachine.extractor.tier.11",
                "Epic Extractinator III",
                11,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    AdvancedGTMaterials.UIV.getGlass() }).getStackForm(1L));

        ItemList.ExtractorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRACTOR_UMV.ID,
                "basicmachine.extractor.tier.12",
                "Epic Extractinator IV",
                12,
                MachineType.EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtractorRecipes,
                1,
                1,
                false,
                0,
                1,
                "Extractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRACTOR",
                new Object[] { "GCG", "EMP", "WCW", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    AdvancedGTMaterials.UMV.getGlass() }).getStackForm(1L));

    }

    private void registerExtruder() {

        ItemList.ExtruderLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_LuV.ID,
                "basicmachine.extruder.tier.06",
                "Elite Extruder",
                6,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.LuV.getCircuit(), 'P',
                    AdvancedGTMaterials.LuV.getPipe(), 'C',
                    AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        ItemList.ExtruderZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_ZPM.ID,
                "basicmachine.extruder.tier.07",
                "Elite Extruder II",
                7,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'P',
                    AdvancedGTMaterials.ZPM.getPipe(), 'C',
                    AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        ItemList.ExtruderUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_UV.ID,
                "basicmachine.extruder.tier.08",
                "Ultimate Shape Driver",
                8,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.UV.getCircuit(), 'P',
                    AdvancedGTMaterials.UV.getPipe(), 'C',
                    AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        ItemList.ExtruderUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_UHV.ID,
                "basicmachine.extruder.tier.09",
                "Epic Shape Driver",
                9,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.UHV.getCircuit(), 'P',
                    AdvancedGTMaterials.UHV.getPipe(), 'C',
                    AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        ItemList.ExtruderUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_UEV.ID,
                "basicmachine.extruder.tier.10",
                "Epic Shape Driver II",
                10,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', ItemList.Hull_UEV, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.UEV.getCircuit(), 'P',
                    AdvancedGTMaterials.UEV.getPipe(), 'C',
                    AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));

        ItemList.ExtruderUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_UIV.ID,
                "basicmachine.extruder.tier.11",
                "Epic Shape Driver III",
                11,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', ItemList.Hull_UIV, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.UIV.getCircuit(), 'P',
                    AdvancedGTMaterials.UIV.getPipe(), 'C',
                    AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        ItemList.ExtruderUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                EXTRUDER_UMV.ID,
                "basicmachine.extruder.tier.12",
                "Epic Shape Driver IV",
                12,
                MachineType.EXTRUDER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sExtruderRecipes,
                2,
                1,
                false,
                0,
                1,
                "Extruder.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "EXTRUDER",
                new Object[] { "CCE", "XMP", "CCE", 'M', ItemList.Hull_UMV, 'X',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'E',
                    AdvancedGTMaterials.UMV.getCircuit(), 'P',
                    AdvancedGTMaterials.UMV.getPipe(), 'C',
                    AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));

    }

    private void registerFluidSolidifier() {

        ItemList.FluidSolidifierLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_LuV.ID,
                "basicmachine.fluidsolidifier.tier.06",
                "Elite Fluid Solidifier",
                6,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    AdvancedGTMaterials.LuV.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

        ItemList.FluidSolidifierZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_ZPM.ID,
                "basicmachine.fluidsolidifier.tier.07",
                "Elite Fluid Solidifier II",
                7,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    AdvancedGTMaterials.ZPM.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

        ItemList.FluidSolidifierUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_UV.ID,
                "basicmachine.fluidsolidifier.tier.08",
                "Ultimate Fluid Petrificator",
                8,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    AdvancedGTMaterials.UV.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

        ItemList.FluidSolidifierUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_UHV.ID,
                "basicmachine.fluidsolidifier.tier.09",
                "Epic Fluid Petrificator",
                9,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    AdvancedGTMaterials.UHV.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

        ItemList.FluidSolidifierUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_UEV.ID,
                "basicmachine.fluidsolidifier.tier.10",
                "Epic Fluid Petrificator II",
                10,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    AdvancedGTMaterials.UEV.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

        ItemList.FluidSolidifierUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_UIV.ID,
                "basicmachine.fluidsolidifier.tier.11",
                "Epic Fluid Petrificator III",
                11,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    AdvancedGTMaterials.UIV.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

        ItemList.FluidSolidifierUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_SOLIDIFIER_UMV.ID,
                "basicmachine.fluidsolidifier.tier.12",
                "Epic Fluid Petrificator IV",
                12,
                MachineType.FLUID_SOLIDIFIER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidSolidifier.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_SOLIDIFIER",
                new Object[] { "PGP", "WMW", "CBC", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    AdvancedGTMaterials.UMV.getGlass(), 'B', OreDictNames.craftingChest })
                .getStackForm(1L));

    }

    private void registerFormingPress() {

        ItemList.FormingPressLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_LuV.ID,
                "basicmachine.press.tier.06",
                "Elite Forming Press",
                6,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.FormingPressZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_ZPM.ID,
                "basicmachine.press.tier.07",
                "Elite Forming Press II",
                7,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.FormingPressUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_UV.ID,
                "basicmachine.press.tier.08",
                "Ultimate Surface Shifter",
                8,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.FormingPressUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_UHV.ID,
                "basicmachine.press.tier.09",
                "Epic Surface Shifter",
                9,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.FormingPressUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_UEV.ID,
                "basicmachine.press.tier.10",
                "Epic Surface Shifter II",
                10,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.FormingPressUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_UIV.ID,
                "basicmachine.press.tier.11",
                "Epic Surface Shifter III",
                11,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.FormingPressUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORMING_PRESS_UMV.ID,
                "basicmachine.press.tier.12",
                "Epic Surface Shifter IV",
                12,
                MachineType.FORMING_PRESS.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPressRecipes,
                6,
                1,
                false,
                0,
                1,
                "Press3.png",
                SoundResource.IC2_MACHINES_COMPRESSOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PRESS",
                new Object[] { "WPW", "CMC", "WPW", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerForgeHammer() {

        ItemList.ForgeHammerLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_LuV.ID,
                "basicmachine.hammer.tier.06",
                "Elite Forge Hammer",
                6,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'O',
                    AdvancedGTMaterials.LuV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

        ItemList.ForgeHammerZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_ZPM.ID,
                "basicmachine.hammer.tier.07",
                "Elite Forge Hammer II",
                7,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'O',
                    AdvancedGTMaterials.ZPM.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

        ItemList.ForgeHammerUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_UV.ID,
                "basicmachine.hammer.tier.08",
                "Ultimate Impact Modulator",
                8,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'O',
                    AdvancedGTMaterials.UV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

        ItemList.ForgeHammerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_UHV.ID,
                "basicmachine.hammer.tier.09",
                "Epic Impact Modulator",
                9,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'O',
                    AdvancedGTMaterials.UHV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

        ItemList.ForgeHammerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_UEV.ID,
                "basicmachine.hammer.tier.10",
                "Epic Impact Modulator II",
                10,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'O',
                    AdvancedGTMaterials.UEV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

        ItemList.ForgeHammerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_UIV.ID,
                "basicmachine.hammer.tier.11",
                "Epic Impact Modulator III",
                11,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'O',
                    AdvancedGTMaterials.UIV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

        ItemList.ForgeHammerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FORGE_HAMMER_UMV.ID,
                "basicmachine.hammer.tier.12",
                "Epic Impact Modulator IV",
                12,
                MachineType.FORGE_HAMMER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sHammerRecipes,
                1,
                1,
                true,
                6,
                3,
                "Hammer.png",
                SoundResource.RANDOM_ANVIL_USE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "HAMMER",
                new Object[] { "WPW", "CMC", "WAW", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'O',
                    AdvancedGTMaterials.UMV.getHCoil(), 'A', OreDictNames.craftingAnvil })
                .getStackForm(1L));

    }

    private void registerLathe() {

        ItemList.LatheLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_LuV.ID,
                "basicmachine.lathe.tier.06",
                "Elite Lathe",
                6,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        ItemList.LatheZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_ZPM.ID,
                "basicmachine.lathe.tier.07",
                "Elite Lathe II",
                7,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        ItemList.LatheUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_UV.ID,
                "basicmachine.lathe.tier.08",
                "Ultimate Turn-O-Matic",
                8,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        ItemList.LatheUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_UHV.ID,
                "basicmachine.lathe.tier.09",
                "Epic Turn-O-Matic",
                9,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        ItemList.LatheUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_UEV.ID,
                "basicmachine.lathe.tier.10",
                "Epic Turn-O-Matic II",
                10,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        ItemList.LatheUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_UIV.ID,
                "basicmachine.lathe.tier.11",
                "Epic Turn-O-Matic III",
                11,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));

        ItemList.LatheUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                LATHE_UMV.ID,
                "basicmachine.lathe.tier.12",
                "Epic Turn-O-Matic IV",
                12,
                MachineType.LATHE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLatheRecipes,
                1,
                2,
                false,
                0,
                1,
                "Lathe.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LATHE",
                new Object[] { "WCW", "EMD", "CWP", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'D',
                    OreDictNames.craftingIndustrialDiamond }).getStackForm(1L));
    }

    private void registerPrecisionLaserEngraver() {

        ItemList.PrecisionLaserEngraverLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_LuV.ID,
                "basicmachine.laserengraver.tier.06",
                "Elite Precision Laser Engraver",
                6,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.PrecisionLaserEngraverZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_ZPM.ID,
                "basicmachine.laserengraver.tier.07",
                "Elite Precision Laser Engraver II",
                7,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.PrecisionLaserEngraverUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_UV.ID,
                "basicmachine.laserengraver.tier.08",
                "Ultimate Exact Photon Cannon",
                8,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.PrecisionLaserEngraverUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_UHV.ID,
                "basicmachine.laserengraver.tier.09",
                "Epic Exact Photon Cannon",
                9,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.PrecisionLaserEngraverUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_UEV.ID,
                "basicmachine.laserengraver.tier.10",
                "Epic Exact Photon Cannon II",
                10,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.PrecisionLaserEngraverUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_UIV.ID,
                "basicmachine.laserengraver.tier.11",
                "Epic Exact Photon Cannon III",
                11,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.PrecisionLaserEngraverUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PRECISION_LASER_ENGRAVER_UMV.ID,
                "basicmachine.laserengraver.tier.12",
                "Epic Exact Photon Cannon IV",
                12,
                MachineType.LASER_ENGRAVER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes,
                4,
                1,
                true,
                0,
                1,
                "LaserEngraver2.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "LASER_ENGRAVER",
                new Object[] { "PEP", "CMC", "WCW", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerMacerator() {

        ItemList.MaceratorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_LuV.ID,
                "basicmachine.macerator.tier.06",
                "Elite Pulverizer",
                6,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

        ItemList.MaceratorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_ZPM.ID,
                "basicmachine.macerator.tier.07",
                "Elite Pulverizer II",
                7,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

        ItemList.MaceratorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_UV.ID,
                "basicmachine.macerator.tier.08",
                "Ultimate Shape Eliminator",
                8,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

        ItemList.MaceratorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_UHV.ID,
                "basicmachine.macerator.tier.09",
                "Epic Shape Eliminator",
                9,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

        ItemList.MaceratorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_UEV.ID,
                "basicmachine.macerator.tier.10",
                "Epic Shape Eliminator II",
                10,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

        ItemList.MaceratorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_UIV.ID,
                "basicmachine.macerator.tier.11",
                "Epic Shape Eliminator III",
                11,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

        ItemList.MaceratorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MACERATOR_UMV.ID,
                "basicmachine.macerator.tier.12",
                "Epic Shape Eliminator IV",
                12,
                MachineType.MACERATOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes,
                1,
                4,
                false,
                0,
                1,
                "Macerator4.png",
                SoundResource.IC2_MACHINES_MACERATOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.TOP_SMOKE,
                "PULVERIZER",
                new Object[] { "PEG", "WWM", "CCW", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G', OreDictNames.craftingGrinder })
                .getStackForm(1L));

    }

    private void registerMatterFabricator() {

        ItemList.MassFabricatorLuV.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_LuV.ID,
                "basicmachine.massfab.tier.06",
                "Elite Mass Fabricator",
                6).getStackForm(1L));
        ItemList.MassFabricatorZPM.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_ZPM.ID,
                "basicmachine.massfab.tier.07",
                "Elite Mass Fabricator II",
                7).getStackForm(1L));
        ItemList.MassFabricatorUV.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_UV.ID,
                "basicmachine.massfab.tier.08",
                "Ultimate Existence Initiator",
                8).getStackForm(1L));
        ItemList.MassFabricatorUHV.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_UHV.ID,
                "basicmachine.massfab.tier.09",
                "Epic Existence Initiator",
                9).getStackForm(1L));
        ItemList.MassFabricatorUEV.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_UEV.ID,
                "basicmachine.massfab.tier.10",
                "Epic Existence Initiator II",
                10).getStackForm(1L));
        ItemList.MassFabricatorUIV.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_UIV.ID,
                "basicmachine.massfab.tier.11",
                "Epic Existence Initiator III",
                11).getStackForm(1L));
        ItemList.MassFabricatorUMV.set(
            new GT_MetaTileEntity_Massfabricator(
                MATTER_FABRICATOR_UMV.ID,
                "basicmachine.massfab.tier.12",
                "Epic Existence Initiator IV",
                12).getStackForm(1L));
    }

    private void registerMicrowave() {

        ItemList.MicrowaveLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_LuV.ID,
                "basicmachine.microwave.tier.06",
                "Elite Microwave",
                6,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        ItemList.MicrowaveZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_ZPM.ID,
                "basicmachine.microwave.tier.07",
                "Elite Microwave II",
                7,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        ItemList.MicrowaveUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_UV.ID,
                "basicmachine.microwave.tier.08",
                "Ultimate UFO Engine",
                8,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CIRCUIT, 'W',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.WIRE, 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        ItemList.MicrowaveUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_UHV.ID,
                "basicmachine.microwave.tier.09",
                "Epic UFO Engine",
                9,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getWire(), 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        ItemList.MicrowaveUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_UEV.ID,
                "basicmachine.microwave.tier.10",
                "Epic UFO Engine II",
                10,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getWire(), 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        ItemList.MicrowaveUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_UIV.ID,
                "basicmachine.microwave.tier.11",
                "Epic UFO Engine III",
                11,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getWire(), 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

        ItemList.MicrowaveUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MICROWAVE_UMV.ID,
                "basicmachine.microwave.tier.12",
                "Epic UFO Engine IV",
                12,
                MachineType.MICROWAVE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes,
                1,
                1,
                false,
                0,
                1,
                "E_Furnace.png",
                SoundResource.IC2_MACHINES_ELECTROFURNACE_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MICROWAVE",
                new Object[] { "LWC", "LMR", "LEC", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'R',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.EMITTER, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getWire(), 'L',
                    OrePrefixes.plateDense.get(Materials.Lead) }).getStackForm(1L));

    }

    private void registerOreWashingPlant() {

        ItemList.OreWashingPlantLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_LuV.ID,
                "basicmachine.orewasher.tier.06",
                "Elite Ore Washing Plant",
                6,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                    OrePrefixes.rotor.get(LuVMat2), 'E', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR,
                    'C', AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        ItemList.OreWashingPlantZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_ZPM.ID,
                "basicmachine.orewasher.tier.07",
                "Elite Ore Washing Plant II",
                7,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                    OrePrefixes.rotor.get(Materials.Iridium), 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        ItemList.OreWashingPlantUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_UV.ID,
                "basicmachine.orewasher.tier.08",
                "Ultimate Ore Washing Machine",
                8,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                    OrePrefixes.rotor.get(Materials.Osmium), 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        ItemList.OreWashingPlantUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_UHV.ID,
                "basicmachine.orewasher.tier.09",
                "Epic Ore Washing Machine",
                9,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'R',
                    OrePrefixes.rotor.get(Materials.Neutronium), 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        ItemList.OreWashingPlantUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_UEV.ID,
                "basicmachine.orewasher.tier.10",
                "Epic Ore Washing Machine II",
                10,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', ItemList.Hull_UEV, 'R',
                    OrePrefixes.rotor.get(Materials.CosmicNeutronium), 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        ItemList.OreWashingPlantUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_UIV.ID,
                "basicmachine.orewasher.tier.11",
                "Epic Ore Washing Machine III",
                11,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', ItemList.Hull_UIV, 'R',
                    OrePrefixes.rotor.get(Materials.Infinity), 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

        ItemList.OreWashingPlantUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ORE_WASHING_PLANT_UMV.ID,
                "basicmachine.orewasher.tier.12",
                "Epic Ore Washing Machine IV",
                12,
                MachineType.ORE_WASHER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sOreWasherRecipes,
                1,
                3,
                true,
                0,
                1,
                "OreWasher.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ORE_WASHER",
                new Object[] { "RGR", "CEC", "WMW", 'M', ItemList.Hull_UMV, 'R',
                    OrePrefixes.rotor.get(MaterialsUEVplus.SpaceTime), 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP }).getStackForm(1L));

    }

    private void registerPolarizer() {

        ItemList.PolarizerLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_LuV.ID,
                "basicmachine.polarizer.tier.06",
                "Elite Polarizer",
                6,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt02.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.PolarizerZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_ZPM.ID,
                "basicmachine.polarizer.tier.07",
                "Elite Polarizer II",
                7,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt04.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.PolarizerUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_UV.ID,
                "basicmachine.polarizer.tier.08",
                "Ultimate Magnetism Inducer",
                8,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.PolarizerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_UHV.ID,
                "basicmachine.polarizer.tier.09",
                "Epic Magnetism Inducer",
                9,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.PolarizerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_UEV.ID,
                "basicmachine.polarizer.tier.10",
                "Epic Magnetism Inducer II",
                10,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', ItemList.Hull_UEV, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.PolarizerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_UIV.ID,
                "basicmachine.polarizer.tier.11",
                "Epic Magnetism Inducer III",
                11,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', ItemList.Hull_UIV, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.PolarizerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                POLARIZER_UMV.ID,
                "basicmachine.polarizer.tier.12",
                "Epic Magnetism Inducer IV",
                12,
                MachineType.POLARIZER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPolarizerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Polarizer.png",
                SoundResource.IC2_MACHINES_MAGNETIZER_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "POLARIZER",
                new Object[] { "ZSZ", "WMW", "ZSZ", 'M', ItemList.Hull_UMV, 'S',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.STICK_ELECTROMAGNETIC, 'Z',
                    OrePrefixes.wireGt08.get(Materials.Osmium), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerRecycler() {

        ItemList.RecyclerLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_LuV.ID,
                "basicmachine.recycler.tier.06",
                "Elite Recycler",
                6,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        ItemList.RecyclerZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_ZPM.ID,
                "basicmachine.recycler.tier.07",
                "Elite Recycler II",
                7,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        ItemList.RecyclerUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_UV.ID,
                "basicmachine.recycler.tier.08",
                "Ultimate Scrap-O-Matic",
                8,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        ItemList.RecyclerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_UHV.ID,
                "basicmachine.recycler.tier.09",
                "Epic Scrap-O-Matic",
                9,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        ItemList.RecyclerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_UEV.ID,
                "basicmachine.recycler.tier.10",
                "Epic Scrap-O-Matic II",
                10,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        ItemList.RecyclerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_UIV.ID,
                "basicmachine.recycler.tier.11",
                "Epic Scrap-O-Matic III",
                11,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

        ItemList.RecyclerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                RECYCLER_UMV.ID,
                "basicmachine.recycler.tier.12",
                "Epic Scrap-O-Matic IV",
                12,
                MachineType.RECYCLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sRecyclerRecipes,
                1,
                1,
                false,
                0,
                1,
                "Recycler.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "RECYCLER",
                new Object[] { "GCG", "PMP", "WCW", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    OrePrefixes.dust.get(Materials.NetherStar) }).getStackForm(1L));

    }

    private void registerReplicator() {

        ItemList.ReplicatorLuV.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_LuV.ID,
                "basicmachine.replicator.tier.06",
                "Elite Replicator",
                6).getStackForm(1L));
        ItemList.ReplicatorZPM.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_ZPM.ID,
                "basicmachine.replicator.tier.07",
                "Elite Replicator II",
                7).getStackForm(1L));
        ItemList.ReplicatorUV.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_UV.ID,
                "basicmachine.replicator.tier.08",
                "Ultimate Elemental Composer",
                8).getStackForm(1L));
        ItemList.ReplicatorUHV.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_UHV.ID,
                "basicmachine.replicator.tier.09",
                "Epic Elemental Composer",
                9).getStackForm(1L));
        ItemList.ReplicatorUEV.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_UEV.ID,
                "basicmachine.replicator.tier.10",
                "Epic Elemental Composer II",
                10).getStackForm(1L));
        ItemList.ReplicatorUIV.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_UIV.ID,
                "basicmachine.replicator.tier.11",
                "Epic Elemental Composer III",
                11).getStackForm(1L));
        ItemList.ReplicatorUMV.set(
            new GT_MetaTileEntity_Replicator(
                MATTER_REPLICATOR_UMV.ID,
                "basicmachine.replicator.tier.12",
                "Epic Elemental Composer IV",
                12).getStackForm(1L));
    }

    private void registerScanner() {

        ItemList.ScannerLuV.set(
            new GT_MetaTileEntity_Scanner(SCANNER_LuV.ID, "basicmachine.scanner.tier.06", "Elite Scanner", 6)
                .getStackForm(1L));
        ItemList.ScannerZPM.set(
            new GT_MetaTileEntity_Scanner(SCANNER_ZPM.ID, "basicmachine.scanner.tier.07", "Elite Scanner II", 7)
                .getStackForm(1L));
        ItemList.ScannerUV.set(
            new GT_MetaTileEntity_Scanner(
                SCANNER_UV.ID,
                "basicmachine.scanner.tier.08",
                "Ultimate Electron Microscope",
                8).getStackForm(1L));
        ItemList.ScannerUHV.set(
            new GT_MetaTileEntity_Scanner(
                SCANNER_UHV.ID,
                "basicmachine.scanner.tier.09",
                "Epic Electron Microscope",
                9).getStackForm(1L));
        ItemList.ScannerUEV.set(
            new GT_MetaTileEntity_Scanner(
                SCANNER_UEV.ID,
                "basicmachine.scanner.tier.10",
                "Epic Electron Microscope II",
                10).getStackForm(1L));
        ItemList.ScannerUIV.set(
            new GT_MetaTileEntity_Scanner(
                SCANNER_UIV.ID,
                "basicmachine.scanner.tier.11",
                "Epic Electron Microscope III",
                11).getStackForm(1L));
        ItemList.ScannerUMV.set(
            new GT_MetaTileEntity_Scanner(
                SCANNER_UMV.ID,
                "basicmachine.scanner.tier.12",
                "Epic Electron Microscope IV",
                12).getStackForm(1L));

    }

    private void registerSiftingMachine() {

        ItemList.SiftingMachineLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_LuV.ID,
                "basicmachine.sifter.tier.06",
                "Elite Sifting Machine",
                6,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.SiftingMachineZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_ZPM.ID,
                "basicmachine.sifter.tier.07",
                "Elite Sifting Machine II",
                7,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.SiftingMachineUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_UV.ID,
                "basicmachine.sifter.tier.08",
                "Ultimate Pulsation Filter",
                8,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.SiftingMachineUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_UHV.ID,
                "basicmachine.sifter.tier.09",
                "Epic Pulsation Filter",
                9,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.SiftingMachineUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_UEV.ID,
                "basicmachine.sifter.tier.10",
                "Epic Pulsation Filter II",
                10,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.SiftingMachineUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_UIV.ID,
                "basicmachine.sifter.tier.11",
                "Epic Pulsation Filter III",
                11,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.SiftingMachineUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SIFTING_MACHINE_UMV.ID,
                "basicmachine.sifter.tier.12",
                "Epic Pulsation Filter IV",
                12,
                MachineType.SIFTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sSifterRecipes,
                1,
                9,
                true,
                2,
                5,
                "Sifter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SIFTER",
                new Object[] { "WFW", "PMP", "CFC", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'F', OreDictNames.craftingFilter,
                    'C', AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerSlicingMachine() {

        ItemList.SlicingMachineLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_LuV.ID,
                "basicmachine.slicer.tier.06",
                "Elite Slicing Machine",
                6,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.SlicingMachineZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_ZPM.ID,
                "basicmachine.slicer.tier.07",
                "Elite Slicing Machine II",
                7,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.SlicingMachineUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_UV.ID,
                "basicmachine.slicer.tier.08",
                "Ultimate Quantum Slicer",
                8,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.SlicingMachineUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_UHV.ID,
                "basicmachine.slicer.tier.09",
                "Epic Quantum Slicer",
                9,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.SlicingMachineUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_UEV.ID,
                "basicmachine.slicer.tier.10",
                "Epic Quantum Slicer II",
                10,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', ItemList.Hull_UEV.get(1), 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.SlicingMachineUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_UIV.ID,
                "basicmachine.slicer.tier.11",
                "Epic Quantum Slicer III",
                11,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', ItemList.Hull_UIV.get(1), 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.SlicingMachineUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                SLICING_MACHINE_UMV.ID,
                "basicmachine.slicer.tier.12",
                "Epic Quantum Slicer IV",
                12,
                MachineType.SLICER.tooltipDescription(),
                sSlicerRecipes,
                2,
                1,
                false,
                0,
                1,
                "Slicer.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "SLICER",
                new Object[] { "WCW", "PMV", "WCW", 'M', ItemList.Hull_UMV.get(1), 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PISTON, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerThermalCentrifuge() {

        ItemList.ThermalCentrifugeLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_LuV.ID,
                "basicmachine.thermalcentrifuge.tier.06",
                "Elite Thermal Centrifuge",
                6,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'O',
                    AdvancedGTMaterials.LuV.getHCoil() }).getStackForm(1L));

        ItemList.ThermalCentrifugeZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_ZPM.ID,
                "basicmachine.thermalcentrifuge.tier.07",
                "Elite Thermal Centrifuge II",
                7,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'O',
                    AdvancedGTMaterials.ZPM.getHCoil() }).getStackForm(1L));

        ItemList.ThermalCentrifugeUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_UV.ID,
                "basicmachine.thermalcentrifuge.tier.08",
                "Ultimate Fire Cyclone",
                8,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'O',
                    AdvancedGTMaterials.UV.getHCoil() }).getStackForm(1L));

        ItemList.ThermalCentrifugeUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_UHV.ID,
                "basicmachine.thermalcentrifuge.tier.09",
                "Epic Fire Cyclone",
                9,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'O',
                    AdvancedGTMaterials.UHV.getHCoil() }).getStackForm(1L));

        ItemList.ThermalCentrifugeUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_UEV.ID,
                "basicmachine.thermalcentrifuge.tier.10",
                "Epic Fire Cyclone II",
                10,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'O',
                    AdvancedGTMaterials.UEV.getHCoil() }).getStackForm(1L));

        ItemList.ThermalCentrifugeUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_UIV.ID,
                "basicmachine.thermalcentrifuge.tier.11",
                "Epic Fire Cyclone III",
                11,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'O',
                    AdvancedGTMaterials.UIV.getHCoil() }).getStackForm(1L));

        ItemList.ThermalCentrifugeUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                THERMAL_CENTRIFUGE_UMV.ID,
                "basicmachine.thermalcentrifuge.tier.12",
                "Epic Fire Cyclone IV",
                12,
                MachineType.THERMAL_CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes,
                1,
                3,
                false,
                0,
                1,
                "ThermalCentrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "THERMAL_CENTRIFUGE",
                new Object[] { "CEC", "OMO", "WEW", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'O',
                    AdvancedGTMaterials.UMV.getHCoil() }).getStackForm(1L));

    }

    private void registerWiremill() {

        ItemList.WiremillLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_LuV.ID,
                "basicmachine.wiremill.tier.06",
                "Elite Wiremill",
                6,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.WiremillZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_ZPM.ID,
                "basicmachine.wiremill.tier.07",
                "Elite Wiremill II",
                7,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.WiremillUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_UV.ID,
                "basicmachine.wiremill.tier.08",
                "Ultimate Wire Transfigurator",
                8,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.WiremillUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_UHV.ID,
                "basicmachine.wiremill.tier.09",
                "Epic Wire Transfigurator",
                9,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.WiremillUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_UEV.ID,
                "basicmachine.wiremill.tier.10",
                "Epic Wire Transfigurator II",
                10,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.WiremillUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_UIV.ID,
                "basicmachine.wiremill.tier.11",
                "Epic Wire Transfigurator III",
                11,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.WiremillUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                WIREMILL_UMV.ID,
                "basicmachine.wiremill.tier.12",
                "Epic Wire Transfigurator IV",
                12,
                MachineType.WIREMILL.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sWiremillRecipes,
                2,
                1,
                false,
                0,
                1,
                "Wiremill.png",
                SoundResource.IC2_MACHINES_RECYCLER_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "WIREMILL",
                new Object[] { "EWE", "CMC", "EWE", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerPump() {

        ItemList.PumpLuV.set(
            new GT_MetaTileEntity_Pump(PUMP_LuV.ID, "basicmachine.pump.tier.06", "Lake Dislocator", 6)
                .getStackForm(1L));
        ItemList.PumpZPM.set(
            new GT_MetaTileEntity_Pump(PUMP_ZPM.ID, "basicmachine.pump.tier.07", "Ocean Transposer", 7)
                .getStackForm(1L));

    }

    private void registerArcFurnace() {

        ItemList.ArcFurnaceLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_LuV.ID,
                "basicmachine.arcfurnace.tier.06",
                "Elite Arc Furnace",
                6,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateDouble.get(LuVMat2), 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.ArcFurnaceZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_ZPM.ID,
                "basicmachine.arcfurnace.tier.07",
                "Elite Arc Furnace II",
                7,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateDouble.get(Materials.Iridium), 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.ArcFurnaceUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_UV.ID,
                "basicmachine.arcfurnace.tier.08",
                "Ultimate Short Circuit Heater",
                8,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateDouble.get(Materials.Osmium), 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.ArcFurnaceUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_UHV.ID,
                "basicmachine.arcfurnace.tier.09",
                "Epic Short Circuit Heater",
                9,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateTriple.get(Materials.Osmium), 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.ArcFurnaceUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_UEV.ID,
                "basicmachine.arcfurnace.tier.10",
                "Epic Short Circuit Heater II",
                10,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', ItemList.Hull_UEV, 'P',
                    OrePrefixes.plateQuadruple.get(Materials.Osmium), 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.ArcFurnaceUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_UIV.ID,
                "basicmachine.arcfurnace.tier.11",
                "Epic Short Circuit Heater III",
                11,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', ItemList.Hull_UIV, 'P',
                    OrePrefixes.plateDouble.get(Materials.Osmiridium), 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.ArcFurnaceUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                ARC_FURNACE_UMV.ID,
                "basicmachine.arcfurnace.tier.12",
                "Epic Short Circuit Heater IV",
                12,
                MachineType.ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "ArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "ARC_FURNACE",
                new Object[] { "WGW", "CMC", "PPP", 'M', ItemList.Hull_UMV, 'P',
                    OrePrefixes.plateQuadruple.get(Materials.Osmiridium), 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable4(), 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

    }

    private void registerCentrifuge() {

        ItemList.CentrifugeLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_LuV.ID,
                "basicmachine.centrifuge.tier.06",
                "Elite Centrifuge",
                6,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable() }).getStackForm(1L));

        ItemList.CentrifugeZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_ZPM.ID,
                "basicmachine.centrifuge.tier.07",
                "Elite Centrifuge II",
                7,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable() }).getStackForm(1L));

        ItemList.CentrifugeUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_UV.ID,
                "basicmachine.centrifuge.tier.08",
                "Ultimate Molecular Tornado",
                8,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable() }).getStackForm(1L));

        ItemList.CentrifugeUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_UHV.ID,
                "basicmachine.centrifuge.tier.09",
                "Epic Molecular Tornado",
                9,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', ItemList.Hull_MAX, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));

        ItemList.CentrifugeUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_UEV.ID,
                "basicmachine.centrifuge.tier.10",
                "Epic Molecular Tornado II",
                10,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', ItemList.Hull_UEV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.CentrifugeUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_UIV.ID,
                "basicmachine.centrifuge.tier.11",
                "Epic Molecular Tornado III",
                11,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', ItemList.Hull_UIV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));

        ItemList.CentrifugeUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CENTRIFUGE_UMV.ID,
                "basicmachine.centrifuge.tier.12",
                "Epic Molecular Tornado IV",
                12,
                MachineType.CENTRIFUGE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes,
                2,
                6,
                true,
                0,
                1,
                "Centrifuge.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CENTRIFUGE",
                new Object[] { "CEC", "WMW", "CEC", 'M', ItemList.Hull_UMV, 'E',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.MOTOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));

    }

    private void registerPlasmaArcFurnace() {

        ItemList.PlasmaArcFurnaceLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_LuV.ID,
                "basicmachine.plasmaarcfurnace.tier.06",
                "Elite Plasma Arc Furnace",
                6,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateDouble.get(LuVMat2), 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.PlasmaArcFurnaceZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_ZPM.ID,
                "basicmachine.plasmaarcfurnace.tier.07",
                "Elite Plasma Arc Furnace II",
                7,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateDouble.get(Materials.Iridium), 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.PlasmaArcFurnaceUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_UV.ID,
                "basicmachine.plasmaarcfurnace.tier.08",
                "Ultimate Plasma Discharge Heater",
                8,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateDouble.get(Materials.Osmium), 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.PlasmaArcFurnaceUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_UHV.ID,
                "basicmachine.plasmaarcfurnace.tier.09",
                "Epic Plasma Discharge Heater",
                9,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    OrePrefixes.plateTriple.get(Materials.Osmium), 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.PlasmaArcFurnaceUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_UEV.ID,
                "basicmachine.plasmaarcfurnace.tier.10",
                "Epic Plasma Discharge Heater II",
                10,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', ItemList.Hull_UEV, 'P',
                    OrePrefixes.plateQuadruple.get(Materials.Osmium), 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.PlasmaArcFurnaceUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_UIV.ID,
                "basicmachine.plasmaarcfurnace.tier.11",
                "Epic Plasma Discharge Heater III",
                11,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', ItemList.Hull_UIV, 'P',
                    OrePrefixes.plateDouble.get(Materials.Osmiridium), 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));

        ItemList.PlasmaArcFurnaceUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                PLASMA_ARC_FURNACE_UMV.ID,
                "basicmachine.plasmaarcfurnace.tier.12",
                "Epic Plasma Discharge Heater IV",
                12,
                MachineType.PLASMA_ARC_FURNACE.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes,
                1,
                9,
                true,
                0,
                1,
                "PlasmaArcFurnace.png",
                SoundResource.IC2_MACHINES_INDUCTION_LOOP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "PLASMA_ARC_FURNACE",
                new Object[] { "WGW", "CMC", "TPT", 'M', ItemList.Hull_UMV, 'P',
                    OrePrefixes.plateQuadruple.get(Materials.Osmiridium), 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable4(), 'T',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'G',
                    OrePrefixes.cell.get(Materials.Graphite) }).getStackForm(1L));
    }

    private void registerBrewery() {

        ItemList.BreweryLuV.set(
            new GT_MetaTileEntity_PotionBrewer(BREWERY_LuV.ID, "basicmachine.brewery.tier.06", "Elite Brewery", 6)
                .getStackForm(1L));
        ItemList.BreweryZPM.set(
            new GT_MetaTileEntity_PotionBrewer(
                BREWERY_ZPM.ID,
                "basicmachine.brewery.tier.07",
                "Elite Brewery II",
                7).getStackForm(1L));
        ItemList.BreweryUV.set(
            new GT_MetaTileEntity_PotionBrewer(
                BREWERY_UV.ID,
                "basicmachine.brewery.tier.08",
                "Ultimate Brew Rusher",
                8).getStackForm(1L));
        ItemList.BreweryUHV.set(
            new GT_MetaTileEntity_PotionBrewer(
                BREWERY_UHV.ID,
                "basicmachine.brewery.tier.09",
                "Epic Brew Rusher",
                9).getStackForm(1L));
        ItemList.BreweryUEV.set(
            new GT_MetaTileEntity_PotionBrewer(
                BREWERY_UEV.ID,
                "basicmachine.brewery.tier.10",
                "Epic Brew Rusher II",
                10).getStackForm(1L));
        ItemList.BreweryUIV.set(
            new GT_MetaTileEntity_PotionBrewer(
                BREWERY_UIV.ID,
                "basicmachine.brewery.tier.11",
                "Epic Brew Rusher III",
                11).getStackForm(1L));
        ItemList.BreweryUMV.set(
            new GT_MetaTileEntity_PotionBrewer(
                BREWERY_UMV.ID,
                "basicmachine.brewery.tier.12",
                "Epic Brew Rusher IV",
                12).getStackForm(1L));

    }

    private void registerCanningMachine() {

        ItemList.CanningMachineLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_LuV.ID,
                "basicmachine.canner.tier.06",
                "Elite Canning Machine",
                6,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.CanningMachineZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_ZPM.ID,
                "basicmachine.canner.tier.07",
                "Elite Canning Machine II",
                7,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.CanningMachineUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_UV.ID,
                "basicmachine.canner.tier.08",
                "Ultimate Can Operator",
                8,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.CanningMachineUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_UHV.ID,
                "basicmachine.canner.tier.09",
                "Epic Can Operator",
                9,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.CanningMachineUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_UEV.ID,
                "basicmachine.canner.tier.10",
                "Epic Can Operator II",
                10,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.CanningMachineUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_UIV.ID,
                "basicmachine.canner.tier.11",
                "Epic Can Operator III",
                11,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.CanningMachineUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CANNING_MACHINE_UMV.ID,
                "basicmachine.canner.tier.12",
                "Epic Can Operator IV",
                12,
                MachineType.CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCannerRecipes,
                2,
                2,
                false,
                0,
                1,
                "Canner.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CANNER",
                new Object[] { "WPW", "CMC", "GGG", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

    }

    private void registerChemicalBath() {

        ItemList.ChemicalBathLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_LuV.ID,
                "basicmachine.chemicalbath.tier.06",
                "Elite Chemical Bath",
                6,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.LuV.getCircuit(), 'W',
                    AdvancedGTMaterials.LuV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.ChemicalBathZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_ZPM.ID,
                "basicmachine.chemicalbath.tier.07",
                "Elite Chemical Bath II",
                7,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.ZPM.getCircuit(), 'W',
                    AdvancedGTMaterials.ZPM.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.ChemicalBathUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_UV.ID,
                "basicmachine.chemicalbath.tier.08",
                "Ultimate Chemical Dunktron",
                8,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UV.getCircuit(), 'W',
                    AdvancedGTMaterials.UV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.ChemicalBathUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_UHV.ID,
                "basicmachine.chemicalbath.tier.09",
                "Epic Chemical Dunktron",
                9,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', GT_MetaTileEntity_BasicMachine_GT_Recipe.X.HULL, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UHV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.ChemicalBathUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_UEV.ID,
                "basicmachine.chemicalbath.tier.10",
                "Epic Chemical Dunktron II",
                10,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', ItemList.Hull_UEV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UEV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.ChemicalBathUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_UIV.ID,
                "basicmachine.chemicalbath.tier.11",
                "Epic Chemical Dunktron III",
                11,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', ItemList.Hull_UIV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UIV.getCircuit(), 'W',
                    AdvancedGTMaterials.UIV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

        ItemList.ChemicalBathUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_BATH_UMV.ID,
                "basicmachine.chemicalbath.tier.12",
                "Epic Chemical Dunktron IV",
                12,
                MachineType.CHEMICAL_BATH.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes,
                1,
                3,
                true,
                0,
                1,
                "ChemicalBath.png",
                SoundResource.NONE,
                false,
                true,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_BATH",
                new Object[] { "VGW", "PGV", "CMC", 'M', ItemList.Hull_UMV, 'P',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.PUMP, 'V',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.CONVEYOR, 'C',
                    AdvancedGTMaterials.UMV.getCircuit(), 'W',
                    AdvancedGTMaterials.UMV.getCable(), 'G',
                    GT_MetaTileEntity_BasicMachine_GT_Recipe.X.GLASS }).getStackForm(1L));

    }

    private void registerChemicalReactor() {

        ItemList.ChemicalReactorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_LuV.ID,
                "basicmachine.chemicalreactor.tier.06",
                "Elite Chemical Reactor",
                6,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

        ItemList.ChemicalReactorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_ZPM.ID,
                "basicmachine.chemicalreactor.tier.07",
                "Elite Chemical Reactor II",
                7,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

        ItemList.ChemicalReactorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_UV.ID,
                "basicmachine.chemicalreactor.tier.08",
                "Ultimate Chemical Perforer",
                8,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

        ItemList.ChemicalReactorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_UHV.ID,
                "basicmachine.chemicalreactor.tier.09",
                "Epic Chemical Performer",
                9,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

        ItemList.ChemicalReactorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_UEV.ID,
                "basicmachine.chemicalreactor.tier.10",
                "Epic Chemical Performer II",
                10,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

        ItemList.ChemicalReactorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_UIV.ID,
                "basicmachine.chemicalreactor.tier.11",
                "Epic Chemical Performer III",
                11,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

        ItemList.ChemicalReactorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CHEMICAL_REACTOR_UMV.ID,
                "basicmachine.chemicalreactor.tier.12",
                "Epic Chemical Performer IV",
                12,
                MachineType.CHEMICAL_REACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sChemicalRecipes,
                2,
                2,
                true,
                0,
                1,
                "ChemicalReactor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CHEMICAL_REACTOR",
                null).getStackForm(1L));

    }

    private void registerFermenter() {
        ItemList.FermenterLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_LuV.ID,
                "basicmachine.fermenter.tier.06",
                "Elite Fermenter",
                6,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));

        ItemList.FermenterZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_ZPM.ID,
                "basicmachine.fermenter.tier.07",
                "Elite Fermenter II",
                7,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));

        ItemList.FermenterUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_UV.ID,
                "basicmachine.fermenter.tier.08",
                "Ultimate Fermentation Hastener",
                8,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));

        ItemList.FermenterUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_UHV.ID,
                "basicmachine.fermenter.tier.09",
                "Epic Fermentation Hastener",
                9,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));

        ItemList.FermenterUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_UEV.ID,
                "basicmachine.fermenter.tier.10",
                "Epic Fermentation Hastener II",
                10,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));

        ItemList.FermenterUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_UIV.ID,
                "basicmachine.fermenter.tier.11",
                "Epic Fermentation Hastener III",
                11,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));

        ItemList.FermenterUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FERMENTER_UMV.ID,
                "basicmachine.fermenter.tier.12",
                "Epic Fermentation Hastener IV",
                12,
                MachineType.FERMENTER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFermentingRecipes,
                1,
                1,
                true,
                0,
                1,
                "Fermenter.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FERMENTER",
                null).getStackForm(1L));
    }

    private void registerFluidCanner() {
        ItemList.FluidCannerLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_LuV.ID,
                "basicmachine.fluidcanner.tier.06",
                "Elite Fluid Canner",
                6,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));

        ItemList.FluidCannerZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_ZPM.ID,
                "basicmachine.fluidcanner.tier.07",
                "Elite Fluid Canner II",
                7,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));

        ItemList.FluidCannerUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_UV.ID,
                "basicmachine.fluidcanner.tier.08",
                "Ultimate Liquid Can Actuator",
                8,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));

        ItemList.FluidCannerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_UHV.ID,
                "basicmachine.fluidcanner.tier.09",
                "Epic Liquid Can Actuator",
                9,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));

        ItemList.FluidCannerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_UEV.ID,
                "basicmachine.fluidcanner.tier.10",
                "Epic Liquid Can Actuator II",
                10,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));

        ItemList.FluidCannerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_UIV.ID,
                "basicmachine.fluidcanner.tier.11",
                "Epic Liquid Can Actuator III",
                11,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));

        ItemList.FluidCannerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_CANNER_UMV.ID,
                "basicmachine.fluidcanner.tier.12",
                "Epic Liquid Can Actuator IV",
                12,
                MachineType.FLUID_CANNER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidCanner.png",
                SoundResource.NONE,
                true,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_CANNER",
                null).getStackForm(1L));
    }

    private void registerFluidExtractor() {
        ItemList.FluidExtractorLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_LuV.ID,
                "basicmachine.fluidextractor.tier.06",
                "Elite Fluid Extractor",
                6,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));

        ItemList.FluidExtractorZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_ZPM.ID,
                "basicmachine.fluidextractor.tier.07",
                "Elite Fluid Extractor II",
                7,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));

        ItemList.FluidExtractorUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_UV.ID,
                "basicmachine.fluidextractor.tier.08",
                "Ultimate Liquefying Sucker",
                8,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));

        ItemList.FluidExtractorUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_UHV.ID,
                "basicmachine.fluidextractor.tier.09",
                "Epic Liquefying Sucker",
                9,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));

        ItemList.FluidExtractorUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_UEV.ID,
                "basicmachine.fluidextractor.tier.10",
                "Epic Liquefying Sucker II",
                10,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));

        ItemList.FluidExtractorUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_UIV.ID,
                "basicmachine.fluidextractor.tier.11",
                "Epic Liquefying Sucker III",
                11,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));

        ItemList.FluidExtractorUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_EXTRACTOR_UMV.ID,
                "basicmachine.fluidextractor.tier.12",
                "Epic Liquefying Sucker IV",
                12,
                MachineType.FLUID_EXTRACTOR.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes,
                1,
                1,
                true,
                0,
                1,
                "FluidExtractor.png",
                SoundResource.IC2_MACHINES_EXTRACTOR_OP,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_EXTRACTOR",
                null).getStackForm(1L));
    }

    private void registerFluidHeater() {
        ItemList.FluidHeaterLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_LuV.ID,
                "basicmachine.fluidheater.tier.06",
                "Elite Fluid Heater",
                6,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));

        ItemList.FluidHeaterZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_ZPM.ID,
                "basicmachine.fluidheater.tier.07",
                "Elite Fluid Heater II",
                7,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));

        ItemList.FluidHeaterUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_UV.ID,
                "basicmachine.fluidheater.tier.08",
                "Ultimate Heat Infuser",
                8,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));

        ItemList.FluidHeaterUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_UHV.ID,
                "basicmachine.fluidheater.tier.09",
                "Epic Heat Infuser",
                9,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));

        ItemList.FluidHeaterUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_UEV.ID,
                "basicmachine.fluidheater.tier.10",
                "Epic Heat Infuser II",
                10,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));

        ItemList.FluidHeaterUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_UIV.ID,
                "basicmachine.fluidheater.tier.11",
                "Epic Heat Infuser III",
                11,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));

        ItemList.FluidHeaterUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                FLUID_HEATER_UMV.ID,
                "basicmachine.fluidheater.tier.12",
                "Epic Heat Infuser IV",
                12,
                MachineType.FLUID_HEATER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes,
                1,
                0,
                true,
                0,
                1,
                "FluidHeater.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "FLUID_HEATER",
                null).getStackForm(1L));
    }

    private void registerMixer() {
        ItemList.MixerLuV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_LuV.ID,
                "basicmachine.mixer.tier.06",
                "Elite Mixer",
                6,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer6.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));

        ItemList.MixerZPM.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_ZPM.ID,
                "basicmachine.mixer.tier.07",
                "Elite Mixer II",
                7,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer6.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));

        ItemList.MixerUV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_UV.ID,
                "basicmachine.mixer.tier.08",
                "Ultimate Matter Organizer",
                8,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer6.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));

        ItemList.MixerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_UHV.ID,
                "basicmachine.mixer.tier.09",
                "Epic Matter Organizer",
                9,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer6.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));

        ItemList.MixerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_UEV.ID,
                "basicmachine.mixer.tier.10",
                "Epic Matter Organizer II",
                10,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer6.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));

        ItemList.MixerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_UIV.ID,
                "basicmachine.mixer.tier.11",
                "Epic Matter Organizer III",
                11,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));

        ItemList.MixerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                MIXER_UMV.ID,
                "basicmachine.mixer.tier.12",
                "Epic Matter Organizer IV",
                12,
                MachineType.MIXER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sMixerRecipes,
                9,
                4,
                true,
                0,
                1,
                "Mixer4.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "MIXER",
                null).getStackForm(1L));
    }

    private void registerTransformer() {
        ItemList.Transformer_UEV_UHV.set(
            new GT_MetaTileEntity_Transformer(
                TRANSFORMER_UEV_UHV.ID,
                "transformer.tier.09",
                "Highly Ultimate Transformer",
                9,
                "UEV -> UHV (Use Soft Mallet to invert)").getStackForm(1L));

        ItemList.Transformer_UIV_UEV.set(
            new GT_MetaTileEntity_Transformer(
                TRANSFORMER_UIV_UEV.ID,
                "transformer.tier.10",
                "Extremely Ultimate Transformer",
                10,
                "UIV -> UEV (Use Soft Mallet to invert)").getStackForm(1L));

        ItemList.Transformer_UMV_UIV.set(
            new GT_MetaTileEntity_Transformer(
                TRANSFORMER_UMV_UIV.ID,
                "transformer.tier.11",
                "Insanely Ultimate Transformer",
                11,
                "UMV -> UIV (Use Soft Mallet to invert)").getStackForm(1L));

        ItemList.Transformer_UXV_UMV.set(
            new GT_MetaTileEntity_Transformer(
                TRANSFORMER_UXV_UMV.ID,
                "transformer.tier.12",
                "Mega Ultimate Transformer",
                12,
                "UXV -> UMV (Use Soft Mallet to invert)").getStackForm(1L));

        ItemList.Transformer_MAX_UXV.set(
            new GT_MetaTileEntity_Transformer(
                TRANSFORMER_MAX_UXV.ID,
                "transformer.tier.13",
                "Extended Mega Ultimate Transformer",
                13,
                "MAX -> UXV (Use Soft Mallet to invert)").getStackForm(1L));
    }

    private void registerBatteryBuffer4By4() {
        ItemList.Battery_Buffer_4by4_UEV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_4_BY_4_UEV.ID,
                "batterybuffer.16.tier.10",
                "Extremely Ultimate Battery Buffer",
                10,
                "",
                16).getStackForm(1L));

        ItemList.Battery_Buffer_4by4_UIV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_4_BY_4_UIV.ID,
                "batterybuffer.16.tier.11",
                "Insanely Ultimate Battery Buffer",
                11,
                "",
                16).getStackForm(1L));

        ItemList.Battery_Buffer_4by4_UMV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_4_BY_4_UMV.ID,
                "batterybuffer.16.tier.12",
                "Mega Ultimate Battery Buffer",
                12,
                "",
                16).getStackForm(1L));

        ItemList.Battery_Buffer_4by4_UXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_4_BY_4_UXV.ID,
                "batterybuffer.16.tier.13",
                "Extended Mega Ultimate Battery Buffer",
                13,
                "",
                16).getStackForm(1L));

        ItemList.Battery_Buffer_4by4_MAXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_4_BY_4_MAX.ID,
                "batterybuffer.16.tier.14",
                "Maximum Battery Buffer",
                14,
                "",
                16).getStackForm(1L));

    }

    private void registerBatteryBuffer3By3() {
        ItemList.Battery_Buffer_3by3_UEV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_3_BY_3_UEV.ID,
                "batterybuffer.09.tier.10",
                "Extremely Ultimate Battery Buffer",
                10,
                "",
                9).getStackForm(1L));

        ItemList.Battery_Buffer_3by3_UIV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_3_BY_3_UIV.ID,
                "batterybuffer.09.tier.11",
                "Insanely Ultimate Battery Buffer",
                11,
                "",
                9).getStackForm(1L));

        ItemList.Battery_Buffer_3by3_UMV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_3_BY_3_UMV.ID,
                "batterybuffer.09.tier.12",
                "Mega Ultimate Battery Buffer",
                12,
                "",
                9).getStackForm(1L));

        ItemList.Battery_Buffer_3by3_UXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_3_BY_3_UXV.ID,
                "batterybuffer.09.tier.13",
                "Extended Mega Ultimate Battery Buffer",
                13,
                "",
                9).getStackForm(1L));

        ItemList.Battery_Buffer_3by3_MAXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_3_BY_3_MAX.ID,
                "batterybuffer.09.tier.14",
                "Maximum Battery Buffer",
                14,
                "",
                9).getStackForm(1L));
    }

    private void registerBatteryBuffer2By2() {
        ItemList.Battery_Buffer_2by2_UEV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_2_BY_2_UEV.ID,
                "batterybuffer.04.tier.10",
                "Extremely Ultimate Battery Buffer",
                10,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Buffer_2by2_UIV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_2_BY_2_UIV.ID,
                "batterybuffer.04.tier.11",
                "Insanely Ultimate Battery Buffer",
                11,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Buffer_2by2_UMV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_2_BY_2_UMV.ID,
                "batterybuffer.04.tier.12",
                "Mega Ultimate Battery Buffer",
                12,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Buffer_2by2_UXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_2_BY_2_UXV.ID,
                "batterybuffer.04.tier.13",
                "Extended Mega Ultimate Battery Buffer",
                13,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Buffer_2by2_MAXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_2_BY_2_MAX.ID,
                "batterybuffer.04.tier.14",
                "Maximum Battery Buffer",
                14,
                "",
                4).getStackForm(1L));
    }

    private void registerBatteryBuffer1By1() {
        ItemList.Battery_Buffer_1by1_UEV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_1_BY_1_UEV.ID,
                "batterybuffer.01.tier.10",
                "Extremely Ultimate Battery Buffer",
                10,
                "",
                1).getStackForm(1L));

        ItemList.Battery_Buffer_1by1_UIV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_1_BY_1_UIV.ID,
                "batterybuffer.01.tier.11",
                "Insanely Ultimate Battery Buffer",
                11,
                "",
                1).getStackForm(1L));

        ItemList.Battery_Buffer_1by1_UMV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_1_BY_1_UMV.ID,
                "batterybuffer.01.tier.12",
                "Mega Ultimate Battery Buffer",
                12,
                "",
                1).getStackForm(1L));

        ItemList.Battery_Buffer_1by1_UXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_1_BY_1_UXV.ID,
                "batterybuffer.01.tier.13",
                "Extended Mega Ultimate Battery Buffer",
                13,
                "",
                1).getStackForm(1L));

        ItemList.Battery_Buffer_1by1_MAXV.set(
            new GT_MetaTileEntity_BasicBatteryBuffer(
                BATTERY_BUFFER_1_BY_1_MAX.ID,
                "batterybuffer.01.tier.14",
                "Maximum Battery Buffer",
                14,
                "",
                1).getStackForm(1L));
    }

    private void registerBatteryCharger4By4() {
        ItemList.Battery_Charger_4by4_UEV.set(
            new GT_MetaTileEntity_Charger(
                BATTERY_CHARGER_4_4_UEV.ID,
                "batterycharger.16.tier.10",
                "Extremely Ultimate Battery Charger",
                10,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Charger_4by4_UIV.set(
            new GT_MetaTileEntity_Charger(
                BATTERY_CHARGER_4_4_UIV.ID,
                "batterycharger.16.tier.11",
                "Insanely Ultimate Battery Charger",
                11,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Charger_4by4_UMV.set(
            new GT_MetaTileEntity_Charger(
                BATTERY_CHARGER_4_4_UMV.ID,
                "batterycharger.16.tier.12",
                "Mega Ultimate Battery Charger",
                12,
                "",
                4).getStackForm(1L));

        ItemList.Battery_Charger_4by4_UXV.set(
            new GT_MetaTileEntity_Charger(
                BATTERY_CHARGER_4_4_UXV.ID,
                "batterycharger.16.tier.13",
                "Extended Mega Ultimate Battery Charger",
                13,
                "",
                4).getStackForm(1L));
    }

    private void registerDynamoHatches() {
        ItemList.Hatch_Dynamo_UEV.set(
            new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UEV.ID, "hatch.dynamo.tier.10", "UEV Dynamo Hatch", 10)
                .getStackForm(1L));

        ItemList.Hatch_Dynamo_UIV.set(
            new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UIV.ID, "hatch.dynamo.tier.11", "UIV Dynamo Hatch", 11)
                .getStackForm(1L));

        ItemList.Hatch_Dynamo_UMV.set(
            new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UMV.ID, "hatch.dynamo.tier.12", "UMV Dynamo Hatch", 12)
                .getStackForm(1L));

        ItemList.Hatch_Dynamo_UXV.set(
            new GT_MetaTileEntity_Hatch_Dynamo(DYNAMO_HATCH_UXV.ID, "hatch.dynamo.tier.13", "UXV Dynamo Hatch", 13)
                .getStackForm(1L));
    }

    private void registerEnergyHatches() {
        ItemList.Hatch_Energy_UEV.set(
            new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UEV.ID, "hatch.energy.tier.10", "UEV Energy Hatch", 10)
                .getStackForm(1L));

        ItemList.Hatch_Energy_UIV.set(
            new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UIV.ID, "hatch.energy.tier.11", "UIV Energy Hatch", 11)
                .getStackForm(1L));

        ItemList.Hatch_Energy_UMV.set(
            new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UMV.ID, "hatch.energy.tier.12", "UMV Energy Hatch", 12)
                .getStackForm(1L));

        ItemList.Hatch_Energy_UXV.set(
            new GT_MetaTileEntity_Hatch_Energy(ENERGY_HATCH_UXV.ID, "hatch.energy.tier.13", "UXV Energy Hatch", 13)
                .getStackForm(1L));
    }

    private void registerChestBuffer() {
        ItemList.Automation_ChestBuffer_UEV.set(
            new GT_MetaTileEntity_ChestBuffer(
                CHEST_BUFFER_UEV.ID,
                "automation.chestbuffer.tier.10",
                "Ultra High Voltage Chest Buffer",
                10).getStackForm(1L));

        ItemList.Automation_ChestBuffer_UIV.set(
            new GT_MetaTileEntity_ChestBuffer(
                CHEST_BUFFER_UIV.ID,
                "automation.chestbuffer.tier.11",
                "UIV Voltage Chest Buffer",
                11).getStackForm(1L));

        ItemList.Automation_ChestBuffer_UMV.set(
            new GT_MetaTileEntity_ChestBuffer(
                CHEST_BUFFER_UMV.ID,
                "automation.chestbuffer.tier.12",
                "UMV Voltage Chest Buffer",
                12).getStackForm(1L));
    }

    private void registerRockBreaker() {
        ItemList.RockBreakerLuV.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_LuV.ID,
                "rockbreaker.tier.06",
                "Cryogenic Magma Solidifier R-9200",
                6).getStackForm(1L));

        ItemList.RockBreakerZPM.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_ZPM.ID,
                "rockbreaker.tier.07",
                "Cryogenic Magma Solidifier R-10200",
                7).getStackForm(1L));

        ItemList.RockBreakerUV.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_UV.ID,
                "rockbreaker.tier.08",
                "Cryogenic Magma Solidifier R-11200",
                8).getStackForm(1L));

        ItemList.RockBreakerUHV.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_UHV.ID,
                "rockbreaker.tier.09",
                "Cryogenic Magma Solidifier R-12200",
                9).getStackForm(1L));

        ItemList.RockBreakerUEV.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_UEV.ID,
                "rockbreaker.tier.10",
                "Cryogenic Magma Solidifier R-13200",
                10).getStackForm(1L));

        ItemList.RockBreakerUIV.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_UIV.ID,
                "rockbreaker.tier.11",
                "Cryogenic Magma Solidifier R-14200",
                11).getStackForm(1L));

        ItemList.RockBreakerUMV.set(
            new GT_MetaTileEntity_RockBreaker(
                ROCK_BREAKER_UMV.ID,
                "rockbreaker.tier.12",
                "Cryogenic Magma Solidifier R-15200",
                12).getStackForm(1L));
    }

    private void registerCircuitAssembler() {
        ItemList.CircuitAssemblerUHV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CIRCUIT_ASSEMBLER_UHV.ID,
                "basicmachine.circuitassembler.tier.09",
                "Ultimate Circuit Assembling Machine",
                9,
                MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes,
                6,
                1,
                true,
                0,
                1,
                "CircuitAssembler.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CIRCUITASSEMBLER",
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UHV, 'E', ItemList.Emitter_UHV, 'H',
                    ItemList.Hull_MAX, 'K', ItemList.Conveyor_Module_UHV, 'C',
                    AdvancedGTMaterials.UEV.getCircuit(), 'W',
                    AdvancedGTMaterials.UHV.getCable() }).getStackForm(1L));
        ItemList.CircuitAssemblerUEV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CIRCUIT_ASSEMBLER_UEV.ID,
                "basicmachine.circuitassembler.tier.10",
                "Ultimate Circuit Assembling Machine II",
                10,
                MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes,
                6,
                1,
                true,
                0,
                1,
                "CircuitAssembler.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CIRCUITASSEMBLER",
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UEV, 'E', ItemList.Emitter_UEV, 'H',
                    ItemList.Hull_UEV, 'K', ItemList.Conveyor_Module_UEV, 'C',
                    OrePrefixes.circuit.get(Materials.Optical), 'W',
                    AdvancedGTMaterials.UEV.getCable() }).getStackForm(1L));

        ItemList.CircuitAssemblerUIV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CIRCUIT_ASSEMBLER_UIV.ID,
                "basicmachine.circuitassembler.tier.11",
                "Ultimate Circuit Assembling Machine III",
                11,
                MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes,
                6,
                1,
                true,
                0,
                1,
                "CircuitAssembler.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CIRCUITASSEMBLER",
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UIV, 'E', ItemList.Emitter_UIV, 'H',
                    ItemList.Hull_UIV, 'K', ItemList.Conveyor_Module_UIV, 'C',
                    OrePrefixes.circuit.get(Materials.Piko), 'W',
                    AdvancedGTMaterials.UIV.getCable() }).getStackForm(1L));
        ItemList.CircuitAssemblerUMV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CIRCUIT_ASSEMBLER_UMV.ID,
                "basicmachine.circuitassembler.tier.12",
                "Ultimate Circuit Assembling Machine IV",
                12,
                MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes,
                6,
                1,
                true,
                0,
                1,
                "CircuitAssembler.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CIRCUITASSEMBLER",
                new Object[] { "RCE", "KHK", "WCW", 'R', ItemList.Robot_Arm_UMV, 'E', ItemList.Emitter_UMV, 'H',
                    ItemList.Hull_UMV, 'K', ItemList.Conveyor_Module_UMV, 'C',
                    OrePrefixes.circuit.get(Materials.Quantum), 'W',
                    AdvancedGTMaterials.UMV.getCable() }).getStackForm(1L));
        ItemList.CircuitAssemblerUXV.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CIRCUIT_ASSEMBLER_UXV.ID,
                "basicmachine.circuitassembler.tier.13",
                "Ultimate Circuit Assembling Machine V",
                13,
                MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes,
                6,
                1,
                true,
                0,
                1,
                "CircuitAssembler.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CIRCUITASSEMBLER",
                null).getStackForm(1L));
        ItemList.CircuitAssemblerMAX.set(
            new GT_MetaTileEntity_BasicMachine_GT_Recipe(
                CIRCUIT_ASSEMBLER_MAX.ID,
                "basicmachine.circuitassembler.tier.14",
                "MAX Circuit Assembling Machine",
                14,
                MachineType.CIRCUIT_ASSEMBLER.tooltipDescription(),
                GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes,
                6,
                1,
                true,
                0,
                1,
                "CircuitAssembler.png",
                SoundResource.NONE,
                false,
                false,
                GT_MetaTileEntity_BasicMachine_GT_Recipe.SpecialEffects.NONE,
                "CIRCUITASSEMBLER",
                null).getStackForm(1L));
    }

    private void registerInputHatch() {
        ItemList.Hatch_Input_UEV.set(
            new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UEV.ID, "hatch.input.tier.10", "Input Hatch (UEV)", 10)
                .getStackForm(1L));
        ItemList.Hatch_Input_UIV.set(
            new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UIV.ID, "hatch.input.tier.11", "Input Hatch (UIV)", 11)
                .getStackForm(1L));
        ItemList.Hatch_Input_UMV.set(
            new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UMV.ID, "hatch.input.tier.12", "Input Hatch (UMV)", 12)
                .getStackForm(1L));
        ItemList.Hatch_Input_UXV.set(
            new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_UXV.ID, "hatch.input.tier.13", "Input Hatch (UXV)", 13)
                .getStackForm(1L));
        ItemList.Hatch_Input_MAX.set(
            new GT_MetaTileEntity_Hatch_Input(INPUT_HATCH_MAX.ID, "hatch.input.tier.14", "Input Hatch (MAX)", 14)
                .getStackForm(1L));
    }

    private void registerOutputHatches() {
        ItemList.Hatch_Output_UEV.set(
            new GT_MetaTileEntity_Hatch_Output(
                OUTPUT_HATCH_UEV.ID,
                "hatch.output.tier.10",
                "Output Hatch (UEV)",
                10).getStackForm(1L));
        ItemList.Hatch_Output_UIV.set(
            new GT_MetaTileEntity_Hatch_Output(
                OUTPUT_HATCH_UIV.ID,
                "hatch.output.tier.11",
                "Output Hatch (UIV)",
                11).getStackForm(1L));
        ItemList.Hatch_Output_UMV.set(
            new GT_MetaTileEntity_Hatch_Output(
                OUTPUT_HATCH_UMV.ID,
                "hatch.output.tier.12",
                "Output Hatch (UMV)",
                12).getStackForm(1L));
        ItemList.Hatch_Output_UXV.set(
            new GT_MetaTileEntity_Hatch_Output(
                OUTPUT_HATCH_UXV.ID,
                "hatch.output.tier.13",
                "Output Hatch (UXV)",
                13).getStackForm(1L));
        ItemList.Hatch_Output_MAX.set(
            new GT_MetaTileEntity_Hatch_Output(
                OUTPUT_HATCH_MAX.ID,
                "hatch.output.tier.14",
                "Output Hatch (MAX)",
                14).getStackForm(1L));
    }

    private void registerMachines2() {

        // ===================================================================================================
        // Electric Oven - nah - daaaah
        // ===================================================================================================

        /*
         * TODO: WE USE RANGE 10750-12500 ID's occupied from 15000-15500!! (in EM branch) ID's occupied from
         * 12500-13000!! (bartimaeusnek) A List of all registered MetaTileEntities <p/> 0 - 1199 are used by GregTech.
         * 1200 - 2047 are used for GregTech Cables. 2048 - 2559 are reserved for OvermindDL. 2560 - 3071 are reserved
         * for Immibis. 3072 - 3583 are reserved for LinusPhoenix. 3584 - 4095 are reserved for BloodyAsp. 4096 - 5095
         * are used for GregTech Frames. 5096 - 6099 are used for GregTech Pipes. 6100 - 8191 are used for GregTech
         * Decoration Blocks. 8192 - 8703 are reserved for ZL123. 8704 - 9215 are reserved for Mr10Movie. 9216 - 9727
         * are used for GregTech Automation Machines. 9728 - 10239 are reserved for 28Smiles. 10240 - 10751 are reserved
         * for VirMan. 10752 - 11263 are reserved for Briareos81. 11264 - 12000 are reserved for the next one who asks
         * me. 12500 - 13000 are reserved for bartimaeusnek 9728 - 32766 are currently free. <p/> Contact me if you need
         * a free ID-Range, which doesn't conflict with other Addons. You could make an ID-Config, but we all know, what
         * "stupid" customers think about conflicting ID's 27.01.2016 Namikon updated: 30.08.2019 bartimaeusnek
         */
    }
}
