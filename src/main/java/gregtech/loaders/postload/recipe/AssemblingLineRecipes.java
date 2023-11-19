package gregtech.loaders.postload.recipe;

import gregtech.api.enums.*;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

import static gregtech.api.util.GT_RecipeBuilder.HOURS;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeConstants.*;

public class AssemblingLineRecipes implements Runnable {

    @Override
    public void run() {
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
            ? FluidRegistry.getFluid("molten.indalloy140")
            : FluidRegistry.getFluid("molten.solderingalloy");

        // Mainframe Circuits and Neuro CPU
        GT_Values.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_Stemcell.get(1L))
            .metadata(RESEARCH_TIME, 1 * HOURS)
            .itemInputs(
                ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                ItemList.Circuit_Chip_Stemcell.get(16L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 8L),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.NaquadahEnriched, 4L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnySyntheticRubber, 64L),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.TungstenSteel, 32L))
            .fluidInputs(
                Materials.GrowthMediumSterilized.getFluid(250L),
                Materials.UUMatter.getFluid(250L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000))
            .itemOutputs(ItemList.Circuit_Chip_NeuroCPU.get(1L))
            .eut(TierEU.RECIPE_ZPM)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        GT_Values.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_NeuroCPU.get(1L))
            .metadata(RESEARCH_TIME, 2 * HOURS)
            .itemInputs(
                ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Chip_Biocell.get(16L),
                ItemList.Circuit_Parts_Reinforced_Glass_Tube.get(16L),
                GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Polybenzimidazole, 16),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.ElectrumFlux, 16L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.AnySyntheticRubber, 64L),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.HSSS, 32L))
            .fluidInputs(
                Materials.BioMediumSterilized.getFluid(500L),
                Materials.UUMatter.getFluid(500L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000))
            .itemOutputs(ItemList.Circuit_Chip_BioCPU.get(1L))
            .eut(TierEU.RECIPE_UV)
            .duration(30 * SECONDS)
            .addTo(AssemblyLine);

        GT_Values.RA.stdBuilder()
            .metadata(RESEARCH_ITEM, ItemList.Circuit_Chip_NeuroCPU.get(1L))
            .metadata(RESEARCH_TIME, 2 * HOURS)
            .itemInputs(
                ItemList.Circuit_Board_Multifiberglass.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Master, 4),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Parts_Crystal_Chip_Master.get(36L),
                ItemList.Circuit_Chip_HPIC.get(64L),
                ItemList.Circuit_Parts_DiodeASMD.get(8L),
                ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                ItemList.Circuit_Parts_ResistorASMD.get(8L),
                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 64))
            .fluidInputs(new FluidStack(solderIndalloy, 720))
            .itemOutputs(ItemList.Energy_LapotronicOrb2.get(1L))
            .eut(TierEU.RECIPE_ZPM)
            .duration(50 * SECONDS)
            .addTo(AssemblyLine);
    }
}
