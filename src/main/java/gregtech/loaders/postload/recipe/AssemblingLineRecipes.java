package gregtech.loaders.postload.recipe;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class AssemblingLineRecipes implements Runnable {

    @Override
    public void run() {
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
            ? FluidRegistry.getFluid("molten.indalloy140")
            : FluidRegistry.getFluid("molten.solderingalloy");

        // Mainframe Circuits and Neuro CPU
        GT_Values.RA.addAssemblylineRecipe(
            ItemList.Circuit_Chip_Stemcell.get(1L),
            72000,
            new Object[] { ItemList.Circuit_Board_Wetware_Extreme.get(1L), ItemList.Circuit_Chip_Stemcell.get(16L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 8L),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahEnriched, 4L),
                new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32L), },
            new FluidStack[] { Materials.GrowthMediumSterilized.getFluid(250L), Materials.UUMatter.getFluid(250L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000) },
            ItemList.Circuit_Chip_NeuroCPU.get(1L),
            600,
            80000);

        GT_Values.RA.addAssemblylineRecipe(
            ItemList.Circuit_Chip_NeuroCPU.get(1L),
            144000,
            new Object[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Chip_Biocell.get(16L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.ElectrumFlux, 16L),
                new Object[] { OrePrefixes.foil.get(Materials.AnySyntheticRubber), 64L },
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32L), },
            new FluidStack[] { Materials.BioMediumSterilized.getFluid(500L), Materials.UUMatter.getFluid(500L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000) },
            ItemList.Circuit_Chip_BioCPU.get(1L),
            600,
            600000);

        GT_Values.RA.addAssemblylineRecipe(
            ItemList.Energy_LapotronicOrb.get(1L),
            288000,
            new Object[] { ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                new Object[] { OrePrefixes.circuit.get(Materials.Master), 4L },
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L), ItemList.Circuit_Chip_HPIC.get(64L),
                ItemList.Circuit_Parts_DiodeASMD.get(8L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                ItemList.Circuit_Parts_ResistorASMD.get(8L), ItemList.Circuit_Parts_TransistorASMD.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64), },
            new FluidStack[] { new FluidStack(solderIndalloy, 720) },
            ItemList.Energy_LapotronicOrb2.get(1L),
            1000,
            80000);

        if (Loader.isModLoaded("GraviSuite")) {
            GT_Values.RA.addAssemblylineRecipe(
                ItemList.Casing_Coil_Superconductor.get(1L),
                288000,
                new Object[] { ItemList.Casing_Fusion_Coil.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt16, Materials.SuperconductorUV, 16L),
                    new Object[] { OrePrefixes.circuit.get(Materials.Superconductor), 16L },
                    ItemList.Sensor_UV.get(16L), ItemList.Emitter_UV.get(16L),
                    ItemList.Field_Generator_UV.get(8L), ItemList.Circuit_Wafer_QPIC.get(64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Americium, 64L) },
                new FluidStack[] { Materials.Longasssuperconductornameforuvwire.getMolten(2880L),
                    Materials.Americium.getPlasma(2880L), Materials.Enderium.getMolten(5760L) },
                GT_ModHandler.getModItem("GraviSuite", "relocator", 1, 26),
                60000,
                500000);
        }
    }
}
