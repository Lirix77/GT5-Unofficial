package gregtech.loaders.postload.scripts;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.Collections;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptEnderIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EnderIO";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("EnderIO");
    }

/*
getModItem("Botany", "pollen", 1, wildcard)
getMetaXX(meta)
"oreDict"
GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 3L)
*/

    @Override
    public void loadRecipes() {
        recipeRemove();
        loadMachineRecipes();
        addShapedRecipe(getItemEnIO("blockFarmStation"), new Object[]{
            "plateSteel", getMeta01(32651), "plateSteel",
            getItemEnIO("itemMaterial", 5), getItemEnIO("itemMachinePart"), getItemEnIO("itemMaterial", 5),
            "plateSteel", "circuitGood", "plateSteel"}, true);
        addShapedRecipe(getItemEnIO("blockCapBank", 1), new Object[]{
            "wireGt02Iron", getItemEnIO("itemBasicCapacitor"), "wireGt02Iron",
            getItemEnIO("itemBasicCapacitor"), "batteryElite", getItemEnIO("itemBasicCapacitor"),
            "wireGt02Iron", getItemEnIO("itemBasicCapacitor"), "wireGt02Iron"}, true);
        addShapedRecipe(getItemEnIO("blockPoweredSpawner"), new Object[]{
            "plateSteel", getMeta01(32684), "plateSteel",
            "plateSteel", getItemEnIO("itemMachinePart"), "plateSteel",
            "itemVibrantCrystal", "circuitElite", "itemVibrantCrystal"}, true);
        addShapedRecipe(getItemEnIO("blockPainter"), new Object[]{
            "glass", "circuitGood", "glass",
            getMeta01(32631), getItemEnIO("itemMachinePart"), getMeta01(32611),
            "cableGt01Copper", "circuitGood", "cableGt01Copper" }, true);
        addShapedRecipe(getItemEnIO("blockCrafter"), new Object[]{
            getMeta01(32650), getMeta01(32744), getMeta01(32650),
            "circuitBasic", getItemEnIO("itemMachinePart"), "circuitBasic",
            "itemCasingSteel", getMeta01(32630), "itemCasingSteel" }, true);
        addShapedRecipe(getItemEnIO("blockTank"), new Object[]{
            "itemCasingSteel", getModItem("TConstruct", "GlassPane", 1), "itemCasingSteel",
            getModItem("TConstruct", "GlassPane", 1), "frameGtStainlessSteel", getModItem("TConstruct", "GlassPane", 1),
            "itemCasingSteel", getMeta01(32610), "itemCasingSteel" }, true);
        addShapedRecipe(getItemEnIO("blockTank", 1), new Object[]{
            "plateDarkSteel", getItemEnIO("blockDarkIronBars"), "plateDarkSteel",
            getItemEnIO("blockDarkIronBars"), "frameGtStainlessSteel", getItemEnIO("blockDarkIronBars"),
            "plateDarkSteel", getMeta01(32611), "plateDarkSteel" }, true);
        addShapedRecipe(getItemEnIO("blockEnchanter"), new Object[]{
            "itemPulsatingCrystal", "craftingBook", "itemPulsatingCrystal",
            null, "plateDarkSteel", null,
            "plateDarkSteel", Blocks.enchanting_table, "plateDarkSteel" }, true);
        addShapedRecipe(getItemEnIO("blockVacuumChest"), new Object[]{
            "plateObsidian", "itemPulsatingCrystal", "plateObsidian",
            "plateObsidian", Blocks.chest, "plateObsidian",
            "plateObsidian", "itemPulsatingCrystal", "plateObsidian" }, true);
        addShapedRecipe(getItemEnIO("blockTravelAnchor"), new Object[]{
            "plateSteel", getItemEnIO("itemMaterial", 1), "plateSteel",
            getItemEnIO("itemMaterial", 1), "itemPulsatingCrystal", getItemEnIO("itemMaterial", 1),
            "plateSteel", getItemEnIO("itemMaterial", 1), "plateSteel" }, true);
        addShapedRecipe(getItemEnIO("itemYetaWrench"), new Object[]{
            "platePulsatingIron", "craftingToolHardHammer", "platePulsatingIron",
            "platePulsatingIron", "platePulsatingIron", "platePulsatingIron",
            null, "platePulsatingIron", null }, true);
        addShapedRecipe(getModItem("EnderIO", "blockDarkIronBars", 8), new Object[]{
            null, "craftingToolWrench", null,
            "stickDarkSteel", "stickDarkSteel", "stickDarkSteel",
            "stickDarkSteel", "stickDarkSteel", "stickDarkSteel" }, true);
        addShapedRecipe(getModItem("EnderIO", "itemMaterial", 5, 7), new Object[]{
            null, "plateDarkSteel", null,
            "plateDarkSteel", "plateDarkSteel", "plateDarkSteel",
            null, "plateDarkSteel", null }, true);
        addShapedRecipe(getItemEnIO("blockBuffer"), new Object[]{
            "plateIron", "plateSteel", "plateIron",
            "plateSteel", Blocks.chest, "plateSteel",
            "plateIron", "plateSteel", "plateIron" }, true);
        addShapedRecipe(getItemEnIO("blockReinforcedObsidian"), new Object[]{
            "plateDarkSteel", getItemEnIO("blockDarkIronBars"), "plateDarkSteel",
            getItemEnIO("blockDarkIronBars"), Blocks.obsidian, getItemEnIO("blockDarkIronBars"),
            "plateDarkSteel", getItemEnIO("blockDarkIronBars"), "plateDarkSteel" }, true);
        addShapedRecipe(getItemEnIO("blockDarkSteelPressurePlate"), new Object[]{
            "plateDarkSteel", "plateDarkSteel", "craftingToolHardHammer", null, null, null, null, null, null }, true);
        addShapedRecipe(getModItem("EnderIO", "blockTransceiver", 2), new Object[]{
            getItemEnIO("itemBasicCapacitor", 2), getItemEnIO("itemFrankenSkull", 3), getMeta01(32695),
            getItemIMM(41), ItemList.Hull_LuV.get(1), getItemIMM(41),
            "circuitUltimate", "itemEnderCrystal", "circuitUltimate" }, true);
        addShapedRecipe(getItemEnIO("blockAttractor"), new Object[]{
            null, "itemAttractorCrystal", null,
            "plateEnergeticAlloy", ItemList.Field_Generator_MV.get(1), "plateEnergeticAlloy",
            "plateSoularium", getItemEnIO("itemMachinePart"), "plateSoularium" }, true);
        addShapedRecipe(getItemEnIO("blockExperienceObelisk"), new Object[]{
            null, getItemEnIO("itemXpTransfer"), null,
            null, ItemList.Field_Generator_MV.get(1), null,
            "plateSoularium", getItemEnIO("itemMachinePart"), "plateSoularium" }, true);
        addShapedRecipe(getItemEnIO("itemMachinePart"), new Object[]{
            "itemCasingSteel", "plateIron", "itemCasingSteel",
            "plateIron", getItemEnIO("itemBasicCapacitor"), "plateIron",
            "itemCasingSteel", "plateIron", "itemCasingSteel" }, true);
        addShapedRecipe(getItemEnIO("blockSoulBinder"), new Object[]{
            "plateSoularium", getMeta01(32672), "plateSoularium",
            "circuitElite", getItemEnIO("itemMachinePart"), "circuitElite",
            "plateSoularium", getItemEnIO("itemFrankenSkull", 1), "plateSoularium" }, true);
        addShapedRecipe(getItemEnIO("blockSliceAndSplice"), new Object[]{
            "cableGt01Copper", ItemList.Electric_Motor_MV.get(1), "cableGt01Copper",
            "circuitGood", getItemEnIO("itemMachinePart"), "circuitGood",
            "plateSoularium", "plateSoularium", "plateSoularium" }, true);
        addShapedRecipe(getItemEnIO("itemConduitProbe"), new Object[]{
            "plateSteel", "cableGt01Copper", "plateSteel",
            getModItem("TConstruct", "GlassPane", 1), Items.comparator, getModItem("TConstruct", "GlassPane", 1),
            "plateSilicon", getItemEnIO("itemRedstoneConduit", 2), "plateSilicon" }, true);

        }

    private void recipeRemove() {
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemItemConduit", 1));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemMaterial", 1, 6));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemMaterial", 1, 5));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemMaterial", 1, 0));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemMaterial", 1, 1));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemBasicCapacitor", 1, 0));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemBasicCapacitor", 1, 1));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemBasicCapacitor", 1, 2));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemMEConduit", 1, 0));
        GT_ModHandler.removeRecipeByOutput(getModItem("EnderIO", "itemMEConduit", 1, 1));
    }

    private void loadMachineRecipes() {
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.DarkSteel, 3L),
                GT_Utility.getIntegratedCircuit(3) },
            GT_Values.NF,
            getModItem("EnderIO", "blockDarkIronBars", 4),
            300, 4);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                getItemEnIO("itemBasicCapacitor"),
                GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Steel, 4L) },
            Materials.Plastic.getMolten(72),
            getItemEnIO("itemMachinePart"),
            50, 16);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16),
                getModItem("EnderIO", "itemMaterial", 4, 1) },
            GT_Values.NF,
            getItemEnIO("itemMEConduit"),
            50, 120);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 76),
                getModItem("EnderIO", "itemMaterial", 16, 1) },
            GT_Values.NF,
            getItemEnIO("itemMEConduit", 1),
            100, 480);
        GT_Values.RA.addChemicalBathRecipe(
            GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
            new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72),
            GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 4),
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000 },
            500, 30);
        GT_Values.RA.addChemicalBathRecipe(
            GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 1),
            new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72),
            GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 5),
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000 },
            500, 30);
        GT_Values.RA.addChemicalBathRecipe(
            GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 0),
            Materials.Glowstone.getMolten(576),
            GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L, 2),
            GT_Values.NI,
            GT_Values.NI,
            new int[] { 10000 },
            100, 8);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                getMeta01(32501),
                Materials.Gold.getIngots(4) },
            Materials.Redstone.getMolten(288),
            getItemEnIO("itemBasicCapacitor"),
            500, 64);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                getModItem("EnderIO", "itemBasicCapacitor", 2, 0),
                getItemEnIO("itemMaterial", 5) },
            Materials.Glowstone.getMolten(288),
            getItemEnIO("itemBasicCapacitor", 1),
            500, 256);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                getModItem("EnderIO", "itemBasicCapacitor", 2, 1),
                getItemEnIO("itemMaterial", 6) },
            Materials.EnergeticAlloy.getMolten(288),
            getItemEnIO("itemBasicCapacitor", 2),
            500, 1024);
        GT_Values.RA.addAutoclaveRecipe(
            Materials.Emerald.getDust(1),
            Materials.VibrantAlloy.getMolten(144L),
            getItemEnIO("itemMaterial", 6),
            8500,
            1000, 120);
        GT_Values.RA.addAutoclaveRecipe(
            Materials.Diamond.getDust(1),
            Materials.PulsatingIron.getMolten(144L),
            getItemEnIO("itemMaterial", 5),
            8500,
            1000, 24);
        GT_Values.RA.addAssemblerRecipe(
            new ItemStack[] {
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Electrum, 1L),
                getModItem("EnderIO", "itemMaterial", 4, 1) },
            Materials.PulsatingIron.getMolten(16),
            getItemEnIO("itemItemConduit"),
            20, 120);
    }
    private ItemStack getItemEnIO(String name, int meta){
        return getModItem("EnderIO", name, 1, meta);
    }
    private ItemStack getItemEnIO(String name){
        return getModItem("EnderIO", name, 1);
    }
}
