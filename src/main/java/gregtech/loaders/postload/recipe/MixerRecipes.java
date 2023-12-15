package gregtech.loaders.postload.recipe;

import gregtech.api.enums.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.*;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

public class MixerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Bauxite, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Bauxite, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Sodalite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Sodalite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Alunite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Alunite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lepidolite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Lepidolite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Mica, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Tanzanite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Tanzanite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lazurite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Lazurite, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Glauconite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Glauconite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.GlauconiteSand, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.GlauconiteSand, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Vermiculite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Vermiculite, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L))
            .duration(5 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Zeolite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L))
            .duration(15 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Zeolite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
                GT_Utility.getIntegratedCircuit(5))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L))
            .duration(10 * SECONDS).eut(48).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrudeSteel, 3L)).duration(5 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 3L)).duration(5 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 3L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(Blocks.soul_sand, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 3L)).duration(5 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 3L)).duration(5 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 3L)).duration(5 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L))
            .duration(20 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 2L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 4L)).duration(10 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        // Superconductor dust recipes in mixer.

        // MV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 12L))
            .fluidInputs(Materials.Oxygen.getGas(6000)).duration(10 * 20).eut(TierEU.RECIPE_MV)
            .addTo(sMixerRecipes);
        // HV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 10L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(
                GT_OreDictUnificator
                    .get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 40L))
            .fluidInputs(Materials.Oxygen.getGas(20000)).duration(10 * 20).eut(TierEU.RECIPE_HV)
            .addTo(sMixerRecipes);
        // EV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 3L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 4L))
            .duration(10 * 20).eut(TierEU.RECIPE_EV).addTo(sMixerRecipes);
        // IV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 3L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 4L))
            .duration(10 * 20).eut(TierEU.RECIPE_IV).addTo(sMixerRecipes);
        // LuV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 7L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(
                GT_OreDictUnificator.get(
                    OrePrefixes.dust,
                    Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                    30L))
            .fluidInputs(Materials.Oxygen.getGas(14000)).duration(10 * 20).eut(TierEU.RECIPE_LuV)
            .addTo(sMixerRecipes);
        // ZPM Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(
                GT_OreDictUnificator
                    .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 13L))
            .duration(10 * 20).eut(TierEU.RECIPE_ZPM).addTo(sMixerRecipes);
        // UV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 9L))
            .duration(10 * 20).eut(TierEU.RECIPE_UV).addTo(sMixerRecipes);
        // UHV Superconductor Recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 7L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 6L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 24L))
            .duration(10 * 20).eut(TierEU.RECIPE_UHV).addTo(sMixerRecipes);
        // UEV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 5L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemDustCelestialTungsten", 1L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemDustAdvancedNitinol", 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUEVBase, 12L))
            .fluidInputs(Materials.Iron.getPlasma(144L)).duration(10 * 20).eut(TierEU.RECIPE_UEV)
            .addTo(sMixerRecipes);
        // UIV Superconductor dust recipe.

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsCubix.RadoxPolymer, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, MaterialsUEVplus.TranscendentMetal, 10L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemDustRhugnor", 6L),
                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemDustChromaticGlass", 5L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUIVBase, 25L))
            .fluidInputs(Materials.Bismuth.getPlasma(144L)).duration(10 * 20).eut(TierEU.RECIPE_UIV)
            .addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 2L)).duration(20 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(
                GT_OreDictUnificator.getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.mMaterialAmount))
            .duration((int) (400L * OrePrefixes.dust.mMaterialAmount / 3628800L)).eut(8000).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 3L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(
                GT_OreDictUnificator
                    .getDust(Materials.YttriumBariumCuprate, 13L * OrePrefixes.dust.mMaterialAmount))
            .fluidInputs(Materials.Oxygen.getGas(7000))
            .duration((int) (600L * OrePrefixes.dust.mMaterialAmount / 3628800L)).eut(2000).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(GT_OreDictUnificator.getDust(Materials.Duralumin, 9L * OrePrefixes.dust.mMaterialAmount))
            .duration((int) (900L * OrePrefixes.dust.mMaterialAmount / 3628800L)).eut(2000).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.AlumiteDust.get(9L)).duration(10 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                ItemList.IC2_Energium_Dust.get(9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 6L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(ItemList.LapotronDust.get(15L)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 4L)).duration(10 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 16L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 16L)).duration(40 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 5L)).duration(8 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 16L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 20L)).duration(32 * SECONDS)
            .eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 7L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 9L))
            .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 5L)).duration(10 * SECONDS)
            .eut(TierEU.RECIPE_MV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 9L))
            .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AstralSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Utility.getIntegratedCircuit(4))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 4L))
            .duration(2 * SECONDS + 10 * TICKS).eut(900).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1L),
                GT_Utility.getIntegratedCircuit(18))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L))
            .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_Utility.getIntegratedCircuit(9))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L))
            .duration(11 * SECONDS + 5 * TICKS).eut(900).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 1L))
            .duration(10 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                GT_Utility.getIntegratedCircuit(2))
            .fluidInputs(Materials.Water.getFluid(2000L)).fluidOutputs(Materials.Concrete.getMolten(2304L))
            .duration(5 * SECONDS).eut(16).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 8L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(new ItemStack(Items.clay_ball, 4, 0)).fluidInputs(GT_ModHandler.getWater(1000L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
                GT_Utility.getIntegratedCircuit(2))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L)).duration(5 * SECONDS)
            .eut(16).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                new ItemStack(Blocks.dirt, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L),
                new ItemStack(Blocks.sand, 4, 0))
            .itemOutputs(ItemList.IC2_Fertilizer.get(4)).fluidInputs(Materials.Water.getFluid(1000L))
            .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BatteryAlloy, 5L))
            .duration(5 * SECONDS).eut(4).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 10L))
            .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnalium, 3L)).duration(5 * SECONDS)
            .eut(4).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 16L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.RawNeutronium.get(16L)).fluidInputs(Materials.Helium.getPlasma(2304L))
            .duration(3 * MINUTES).eut(TierEU.RECIPE_ZPM).addTo(sMixerRecipes);

        // One Step Alloy Dust Mixer

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                GT_Utility.getIntegratedCircuit(15))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 9L))
            .duration(6 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_Utility.getIntegratedCircuit(17))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 27L))
            .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_Utility.getIntegratedCircuit(16))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 27L))
            .duration(12 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
                GT_Utility.getIntegratedCircuit(18))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 17L))
            .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 17L))
            .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                GT_Utility.getIntegratedCircuit(14))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 9L)).duration(6 * SECONDS)
            .eut(TierEU.RECIPE_MV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                GT_Utility.getIntegratedCircuit(16))
            .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 27L)).duration(12 * SECONDS)
            .eut(TierEU.RECIPE_HV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 27L),
                GT_Utility.getIntegratedCircuit(18))
            .itemOutputs(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 17L))
            .duration(24 * SECONDS).eut(TierEU.RECIPE_HV).addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 2L),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(ItemList.BioBall.get(1L)).duration(10 * SECONDS).eut(16).addTo(sMixerRecipes);

        // Astral Silver & Soldering Alloy + reverse

        GT_Values.RA.stdBuilder()
            .itemInputs(
                Materials.Silver.getDust(2),
                Materials.Iron.getDust(1),
                GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(Materials.AstralSilver.getDust(3)).duration(3 * SECONDS).eut(TierEU.RECIPE_HV)
            .addTo(sMixerRecipes);

        GT_Values.RA.stdBuilder()
            .itemInputs(Materials.Tin.getDust(9), Materials.Antimony.getDust(1), GT_Utility.getIntegratedCircuit(1))
            .itemOutputs(Materials.SolderingAlloy.getDust(10)).duration(3 * SECONDS).eut(TierEU.RECIPE_LV)
            .addTo(sMixerRecipes);

        if (EnderIO.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(EnderIO.ID, "itemMaterial", 1L, 14),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 3L))
                .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

        }

        if (ExtraTrees.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(ExtraTrees.ID, "misc", 4L, 2),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(ItemList.FR_Mulch.get(1L)).fluidInputs(Materials.Water.getFluid(500L))
                .duration(30 * SECONDS).eut(2).addTo(sMixerRecipes);

        }

        if (TinkerConstruct.isModLoaded() && Natura.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 4L, 42))
                .duration(10 * SECONDS).eut(8).addTo(sMixerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "slime.gel", 1L, 2),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 3L))
                .duration(5 * SECONDS).eut(8).addTo(sMixerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Items.nether_wart, 1, 0),
                    new ItemStack(Blocks.soul_sand, 1, 0),
                    new ItemStack(Blocks.gravel, 1, 0),
                    GT_ModHandler.getModItem(Natura.ID, "soil.tainted", 1L, 0),
                    GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 2L, 6))
                .fluidInputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS).eut(16).addTo(sMixerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    new ItemStack(Items.nether_wart, 1, 0),
                    new ItemStack(Blocks.soul_sand, 1, 0),
                    new ItemStack(Blocks.gravel, 1, 0),
                    new ItemStack(Blocks.sand, 1, 32767),
                    GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 2L, 6))
                .fluidInputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS).eut(16).addTo(sMixerRecipes);

        }

        if (AppliedEnergistics2.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                    GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2L, 8))
                .fluidInputs(Materials.Water.getFluid(500L)).duration(20 * TICKS).eut(16).addTo(sMixerRecipes);

            GT_Values.RA.stdBuilder()
                .itemInputs(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartzCharged, 1),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                    GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(GT_ModHandler.getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2L, 8))
                .fluidInputs(GT_ModHandler.getDistilledWater(500L)).duration(20 * TICKS).eut(16)
                .addTo(sMixerRecipes);
        }
    }
}
