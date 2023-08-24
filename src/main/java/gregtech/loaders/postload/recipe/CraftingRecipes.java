package gregtech.loaders.postload.recipe;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static gregtech.api.util.GT_ModHandler.RecipeBits.*;

public class CraftingRecipes implements Runnable {
    @Override
    public void run() {
        GTNHRecipes();

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2),
            NOT_REMOVABLE | BUFFERED| DELETE_ALL_OTHER_RECIPES, new Object[] {
            "C", "S", 'C', OrePrefixes.dust.get(Materials.Sulfur), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), NOT_REMOVABLE | BUFFERED,
            new Object[] {
            "C", "S", 'C', ItemList.IC2_Resin.get(1L), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1),
            NOT_REMOVABLE | BUFFERED| DELETE_ALL_OTHER_RECIPES,
            new Object[] { "WWW", "GFG", "CPC",
            'W', OrePrefixes.plank.get(Materials.Wood),
            'C', OrePrefixes.stoneCobble,
            'P', OrePrefixes.plate.get(Materials.RedstoneAlloy),
            'F', new ItemStack(Blocks.fence),
            'G', OrePrefixes.gearGtSmall.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.fence, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "FWF",
                "SWS",
                "SWS",
                'F', OrePrefixes.screw.get(Materials.Wood),
                'W', OrePrefixes.plank.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.fence, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "FdF",
                "SWS",
                "SWS",
                'F', OrePrefixes.screw.get(Materials.Iron),
                'W', OrePrefixes.plank.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.fence, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "FdF",
                "SWS",
                "SWS",
                'F', OrePrefixes.screw.get(Materials.Steel),
                'W', OrePrefixes.plank.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.fence_gate, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "F F",
                "WSW",
                "WSW",
                'F', "itemFlint",
                'W', OrePrefixes.plank.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.fence_gate, 2),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "FdF",
                "WSW",
                "WSW",
                'F', OrePrefixes.screw.get(Materials.Iron),
                'W', OrePrefixes.plank.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.fence_gate, 4),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "FdF",
                "WSW",
                "WSW",
                'F', OrePrefixes.screw.get(Materials.Steel),
                'W', OrePrefixes.plank.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.comparator, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "SRS",
                "RPR",
                "XdX",
                'S', OrePrefixes.screw.get(Materials.Iron),
                'R', new ItemStack(Blocks.redstone_torch),
                'P', OrePrefixes.plate.get(Materials.NetherQuartz),
                'X', new ItemStack(Blocks.stone_pressure_plate) });
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.comparator, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "SRS",
                "RPR",
                "XdX",
                'S', OrePrefixes.screw.get(Materials.Iron),
                'R', new ItemStack(Blocks.redstone_torch),
                'P', OrePrefixes.plate.get(Materials.CertusQuartz),
                'X', new ItemStack(Blocks.stone_pressure_plate) });
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.comparator, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "SRS",
                "RPR",
                "XdX",
                'S', OrePrefixes.screw.get(Materials.Iron),
                'R', new ItemStack(Blocks.redstone_torch),
                'P', OrePrefixes.plate.get(Materials.Quartzite),
                'X', new ItemStack(Blocks.stone_pressure_plate) });
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.stone_pressure_plate, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "SrS",
                "XCX",
                "SdS",
                'X', OrePrefixes.slab.get(Materials.Stone),
                'S', OrePrefixes.screw.get(Materials.Steel),
                'C', OrePrefixes.spring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.wooden_pressure_plate, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "SrS",
                "XCX",
                "SdS",
                'X', OrePrefixes.craft.get(Materials.Wood),
                'S', OrePrefixes.screw.get(Materials.Steel),
                'C', OrePrefixes.spring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.sign, 3),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "XXX",
                "XXX",
                " S ",
                'X', OrePrefixes.craft.get(Materials.Wood),
                'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.bookshelf),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "SSS",
                "XXX",
                "SSS",
                'X', new ItemStack(Items.book),
                'S', OrePrefixes.plate.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
                new ItemStack(Items.iron_door),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                    "XBh",
                    "XRS",
                    "XXd",
                    'X', OrePrefixes.plate.get(Materials.Iron),
                    'R', OrePrefixes.ring.get(Materials.Steel),
                    'B', "barsIron",
                    'S', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.iron_door),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "XBd",
                "XRS",
                "XXh",
                'X', OrePrefixes.plate.get(Materials.Iron),
                'R', OrePrefixes.ring.get(Materials.Steel),
                'B', "barsIron",
                'S', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.wooden_door, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "WNd",
                "WRC",
                "WWs",
                'W', OrePrefixes.plate.get(Materials.Wood),
                'R', OrePrefixes.ring.get(Materials.Iron),
                'N', new ItemStack(Blocks.trapdoor),
                'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.wooden_door, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "WNs",
                "WRC",
                "WWd",
                'W', OrePrefixes.plate.get(Materials.Wood),
                'R', OrePrefixes.ring.get(Materials.Iron),
                'N', new ItemStack(Blocks.trapdoor),
                'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.wooden_door, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "WNd",
                "WRC",
                "WWs",
                'W', OrePrefixes.plate.get(Materials.Wood),
                'R', OrePrefixes.ring.get(Materials.Copper),
                'N', new ItemStack(Blocks.trapdoor),
                'C', OrePrefixes.screw.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.wooden_door, 1),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "WNs",
                "WRC",
                "WWd",
                'W', OrePrefixes.plate.get(Materials.Wood),
                'R', OrePrefixes.ring.get(Materials.Copper),
                'N', new ItemStack(Blocks.trapdoor),
                'C', OrePrefixes.screw.get(Materials.Copper)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.ladder, 1),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "SdS",
                "NCN",
                "SrS",
                'S', OrePrefixes.stick.get(Materials.Wood),
                'N', new ItemStack(Items.string),
                'C', OrePrefixes.screw.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.ladder, 2),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "SdS",
                "NCN",
                "SrS",
                'S', OrePrefixes.stick.get(Materials.Wood),
                'N', new ItemStack(Items.string),
                'C', OrePrefixes.screw.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.ladder, 3),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "SdS",
                "NCN",
                "SrS",
                'S', OrePrefixes.stick.get(Materials.Wood),
                'N', new ItemStack(Items.string),
                'C', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.trapdoor),
            NOT_REMOVABLE | BUFFERED | DELETE_ALL_OTHER_RECIPES, new Object[] {
                "SWS", "WCW", "SWS",
                'C', "itemFlint",
                'W', "stickWood",
                'S', "slabWood"});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.trapdoor, 2),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "SWS", "WCW", "SWS",
                'C', "screwIron",
                'W', "stickWood",
                'S', "slabWood"});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.trapdoor, 3),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "SWS", "WCW", "SWS",
                'C', "screwSteel",
                'W', "stickWood",
                'S', "slabWood"});
        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.crafting_table),
            NOT_REMOVABLE | BUFFERED, new Object[] {
                "FF",
                "WW",
                'F', OrePrefixes.item.get(Materials.Flint),
                'W', OrePrefixes.log.get(Materials.Wood)});
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getIC2Item("carbonrotor", 1L));
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getIC2Item("carbonrotor", 1L), NOT_REMOVABLE | BUFFERED, new Object[] {
                "dBS",
                "BTB",
                "SBw",
                'B', GT_ModHandler.getIC2Item("carbonrotorblade", 1),
                'S', OrePrefixes.screw.get(Materials.Iridium),
                'T', GT_ModHandler.getIC2Item("steelshaft", 1)});
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getIC2Item("steelrotor", 1L));
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getIC2Item("steelrotor", 1L), NOT_REMOVABLE | BUFFERED, new Object[] {
                "dBS",
                "BTB",
                "SBw",
                'B', GT_ModHandler.getIC2Item("steelrotorblade", 1),
                'S', OrePrefixes.screw.get(Materials.StainlessSteel),
                'T', GT_ModHandler.getIC2Item("ironshaft", 1)});
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getIC2Item("ironrotor", 1L));
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getIC2Item("ironrotor", 1L), NOT_REMOVABLE | BUFFERED, new Object[] {
                "dBS",
                "BTB",
                "SBw",
                'B', GT_ModHandler.getIC2Item("ironrotorblade", 1),
                'S', OrePrefixes.screw.get(Materials.WroughtIron),
                'T', GT_ModHandler.getIC2Item("ironshaft", 1)});
        GT_ModHandler.removeRecipeByOutputDelayed(GT_ModHandler.getIC2Item("woodrotor", 1L));
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getIC2Item("woodrotor", 1L), NOT_REMOVABLE | BUFFERED, new Object[] {
                "dBS",
                "BTB",
                "SBw",
                'B', GT_ModHandler.getIC2Item("woodrotorblade", 1),
                'S', OrePrefixes.screw.get(Materials.WroughtIron),
                'T', OrePrefixes.stickLong.get(Materials.WroughtIron)});
    }
    private static final long bits = GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE
        | GT_ModHandler.RecipeBits.DISMANTLEABLE
        | GT_ModHandler.RecipeBits.BUFFERED;
    private static final long tBitMask = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE
        | GT_ModHandler.RecipeBits.REVERSIBLE;
    private static final String aTextTConstruct = "TConstruct";
    private static final String aTextGalacticraftCore = "GalacticraftCore";
    private static final String aTextIC2 = "IC2";
    private static final String aTextForestry = "Forestry";
    private static final String aTextGraviSuite = "GraviSuite";
    private static final String aTextGalacticraftMars = "GalacticraftMars";
    private void GTNHRecipes() {
        // Mine and Blade Battlegear remove recipes NBT?
        Object[] o = new Object[0];

        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Naquadah_Mark_I.get(1L),
            bits,
            new Object[]{"UCU", "FMF", "WCW", 'M', ItemList.Hull_EV, 'F', ItemList.Field_Generator_EV, 'C',
                OrePrefixes.circuit.get(Materials.Elite), 'W', OrePrefixes.cableGt04.get(Materials.Aluminium),
                'U', OrePrefixes.stick.get(Materials.Uranium235)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Naquadah_Mark_II.get(1L),
            bits,
            new Object[]{"PCP", "FMF", "WCW", 'M', ItemList.Hull_IV, 'F', ItemList.Field_Generator_IV, 'C',
                OrePrefixes.circuit.get(Materials.Master), 'W', OrePrefixes.cableGt04.get(Materials.Tungsten),
                'P', OrePrefixes.stick.get(Materials.Plutonium241)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Naquadah_Mark_III.get(1L),
            bits,
            new Object[]{"NCN", "FMF", "WCW", 'M', ItemList.Hull_LuV, 'F', ItemList.Field_Generator_LuV, 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'W', OrePrefixes.cableGt04.get(Materials.HSSG),
                'N', OrePrefixes.stick.get(Materials.Europium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Naquadah_Mark_IV.get(1L),
            bits,
            new Object[]{"NCN", "FMF", "WCW", 'M', ItemList.Hull_ZPM, 'F', ItemList.Field_Generator_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.Superconductor), 'W',
                OrePrefixes.cableGt04.get(Materials.Naquadah), 'N',
                OrePrefixes.stick.get(Materials.Americium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Generator_Naquadah_Mark_V.get(1L),
            bits,
            new Object[]{"NCN", "FMF", "WCW", 'M', ItemList.Hull_UV, 'F', ItemList.Field_Generator_UV, 'C',
                OrePrefixes.circuit.get(Materials.Infinite), 'W',
                OrePrefixes.cableGt04.get(Materials.ElectrumFlux), 'N',
                OrePrefixes.stick.get(Materials.NaquadahAlloy)});

        GT_ModHandler.addCraftingRecipe(
            ItemList.LargeHPSteamTurbine.get(1L),
            bits,
            new Object[]{"CPC", "PMP", "BPB", 'M', ItemList.Hull_IV, 'B',
                OrePrefixes.pipeLarge.get(Materials.TungstenSteel), 'C',
                OrePrefixes.circuit.get(Materials.Master), 'P',
                OrePrefixes.gearGt.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.LargePlasmaTurbine.get(1L),
            bits,
            new Object[]{"CPC", "PMP", "BPB", 'M', ItemList.Hull_UV, 'B',
                OrePrefixes.pipeHuge.get(Materials.Naquadah), 'C', OrePrefixes.circuit.get(Materials.Ultimate),
                'P', OrePrefixes.gearGt.get(Materials.NaquadahAlloy)});

        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Tank_LV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_MV, 'M', ItemList.Casing_Tank_1, 'G',
                OrePrefixes.plate.get(Materials.PulsatingIron), 'D', OrePrefixes.circuit.get(Materials.Basic),
                'P', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Tank_MV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_HV, 'M', ItemList.Casing_Tank_2, 'G',
                OrePrefixes.plate.get(Materials.VibrantAlloy), 'D', OrePrefixes.circuit.get(Materials.Good),
                'P', OrePrefixes.plate.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Tank_HV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_HV, 'M', ItemList.Casing_Tank_3, 'G',
                ItemList.Field_Generator_LV, 'D', OrePrefixes.circuit.get(Materials.Advanced), 'P',
                OrePrefixes.plate.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Tank_EV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_EV, 'M', ItemList.Casing_Tank_4, 'G',
                ItemList.Field_Generator_MV, 'D', OrePrefixes.circuit.get(Materials.Data), 'P',
                OrePrefixes.plate.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Tank_IV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_EV, 'M', ItemList.Casing_Tank_5, 'G',
                ItemList.Field_Generator_HV, 'D', OrePrefixes.circuit.get(Materials.Elite), 'P',
                OrePrefixes.plate.get(Materials.Titanium)});

        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Tank_LV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_IV, 'M', ItemList.Casing_Tank_6, 'G',
                ItemList.Field_Generator_EV, 'D', OrePrefixes.circuit.get(Materials.Master), 'P',
                OrePrefixes.plate.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Tank_MV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_IV, 'M', ItemList.Casing_Tank_7, 'G',
                ItemList.Field_Generator_IV, 'D', OrePrefixes.circuit.get(Materials.Ultimate), 'P',
                OrePrefixes.plate.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Tank_HV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_LuV, 'M', ItemList.Casing_Tank_8, 'G',
                ItemList.Field_Generator_LuV, 'D', OrePrefixes.circuit.get(Materials.Superconductor), 'P',
                OrePrefixes.plate.get(Materials.HSSS)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Tank_EV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_ZPM, 'M', ItemList.Casing_Tank_9, 'G',
                ItemList.Field_Generator_ZPM, 'D', OrePrefixes.circuit.get(Materials.Infinite), 'P',
                OrePrefixes.plate.get(Materials.Europium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Tank_IV.get(1L),
            bits,
            new Object[]{"DGD", "PMP", "DUD", 'U', ItemList.Electric_Pump_UV, 'M', ItemList.Casing_Tank_10, 'G',
                ItemList.Field_Generator_UV, 'D', OrePrefixes.circuit.get(Materials.Bio), 'P',
                OrePrefixes.plate.get(Materials.Americium)});

        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Chest_LV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_LV, 'G',
                OrePrefixes.plate.get(Materials.PulsatingIron), 'D', OrePrefixes.circuit.get(Materials.Basic),
                'P', OrePrefixes.plateDense.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Chest_MV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_MV, 'G',
                OrePrefixes.plate.get(Materials.VibrantAlloy), 'D', OrePrefixes.circuit.get(Materials.Good),
                'P', OrePrefixes.plateDense.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Chest_HV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_HV, 'G',
                ItemList.Field_Generator_LV, 'D', OrePrefixes.circuit.get(Materials.Advanced), 'P',
                OrePrefixes.plateQuintuple.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Chest_EV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_EV, 'G',
                ItemList.Field_Generator_MV, 'D', OrePrefixes.circuit.get(Materials.Data), 'P',
                OrePrefixes.plateQuintuple.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Super_Chest_IV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_IV, 'G',
                ItemList.Field_Generator_HV, 'D', OrePrefixes.circuit.get(Materials.Elite), 'P',
                OrePrefixes.plateQuadruple.get(Materials.Titanium)});

        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Chest_LV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_LuV, 'G',
                ItemList.Field_Generator_EV, 'D', OrePrefixes.circuit.get(Materials.Master), 'P',
                OrePrefixes.plateQuadruple.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Chest_MV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_ZPM, 'G',
                ItemList.Field_Generator_IV, 'D', OrePrefixes.circuit.get(Materials.Ultimate), 'P',
                OrePrefixes.plateTriple.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Chest_HV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_UV, 'G',
                ItemList.Field_Generator_LuV, 'D', OrePrefixes.circuit.get(Materials.Superconductor), 'P',
                OrePrefixes.plateTriple.get(Materials.HSSS)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Chest_EV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_MAX, 'G',
                ItemList.Field_Generator_ZPM, 'D', OrePrefixes.circuit.get(Materials.Infinite), 'P',
                OrePrefixes.plateDouble.get(Materials.Europium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Quantum_Chest_IV.get(1L),
            bits,
            new Object[]{"DPD", "PMP", "DGD", 'M', ItemList.Automation_ChestBuffer_MAX, 'G',
                ItemList.Field_Generator_UV, 'D', OrePrefixes.circuit.get(Materials.Bio), 'P',
                OrePrefixes.plate.get(Materials.Americium)});

        // Hermetic casings
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_1.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Steel), 'I',
                OrePrefixes.pipeLarge.get(Materials.Plastic)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_2.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Aluminium), 'I',
                OrePrefixes.pipeLarge.get(Materials.PolyvinylChloride)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_3.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.StainlessSteel), 'I',
                OrePrefixes.pipeLarge.get(Materials.Polytetrafluoroethylene)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_4.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Titanium), 'I',
                OrePrefixes.pipeLarge.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_5.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.TungstenSteel), 'I',
                OrePrefixes.pipeLarge.get(Materials.Titanium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_6.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Chrome), 'I',
                OrePrefixes.pipeLarge.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_7.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Iridium), 'I',
                OrePrefixes.pipeLarge.get(Materials.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_8.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Osmium), 'I',
                OrePrefixes.pipeLarge.get(Materials.Enderium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_9.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Neutronium), 'I',
                OrePrefixes.pipeLarge.get(Materials.Naquadah)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Tank_10.get(1L),
            bits,
            new Object[]{"PPP", "PIP", "PPP", 'P', OrePrefixes.plate.get(Materials.Bedrockium), 'I',
                OrePrefixes.pipeLarge.get(Materials.MysteriousCrystal)});

        GT_ModHandler.addCraftingRecipe(
            ItemList.Field_Generator_LV.get(1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"WCW", "CGC", "WCW", 'G', OrePrefixes.plate.get(Materials.EnderPearl), 'C',
                OrePrefixes.circuit.get(Materials.Advanced), 'W', OrePrefixes.plate.get(Materials.RedSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Field_Generator_MV.get(1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"WCW", "CGC", "WCW", 'G', OrePrefixes.plate.get(Materials.EnderEye), 'C',
                OrePrefixes.circuit.get(Materials.Data), 'W', OrePrefixes.plate.get(Materials.TungstenSteel)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Field_Generator_HV.get(1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.QuantumEye.get(1L), 'C',
                OrePrefixes.circuit.get(Materials.Elite), 'W',
                OrePrefixes.plateDouble.get(Materials.NiobiumTitanium)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Field_Generator_EV.get(1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"WCW", "CGC", "WCW", 'G', OrePrefixes.gem.get(Materials.NetherStar), 'C',
                OrePrefixes.circuit.get(Materials.Master), 'W', OrePrefixes.plateDouble.get(Materials.HSSG)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Field_Generator_IV.get(1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"WCW", "CGC", "WCW", 'G', ItemList.QuantumStar.get(1L), 'C',
                OrePrefixes.circuit.get(Materials.Ultimate), 'W',
                OrePrefixes.plateTriple.get(Materials.HSSS)});

        // Solar Panels 1-8 EU. Higher tier ones are in script because they're DCT crafts
        GT_ModHandler.addCraftingRecipe(
            ItemList.Cover_SolarPanel.get(1L, o),
            GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
                | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"SGS", "CPC", "TRT", 'C', OrePrefixes.circuit.get(Materials.Basic), 'G',
                GT_ModHandler.getIC2Item("reinforcedGlass", 1L), 'P',
                OrePrefixes.plateAlloy.get(Materials.Carbon), 'S', ItemList.Circuit_Silicon_Wafer, 'T',
                OrePrefixes.wireGt01.get(Materials.RedAlloy), 'R', ItemList.AluminiumIronPlate});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Cover_SolarPanel_8V.get(1L, o),
            GT_ModHandler.RecipeBits.DISMANTLEABLE | GT_ModHandler.RecipeBits.NOT_REMOVABLE
                | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{"GSG", "CRC", "PAP", 'C', OrePrefixes.circuit.get(Materials.Good), 'G',
                ItemList.Cover_SolarPanel.get(1L, o), 'P', OrePrefixes.wireGt01.get(Materials.Tin), 'S',
                ItemList.Circuit_Silicon_Wafer, 'R', OrePrefixes.plate.get(Materials.GalliumArsenide), 'A',
                ItemList.ReinforcedAluminiumIronPlate});

        // LV+1st MV circuit/parts
        GT_ModHandler.addShapelessCraftingRecipe(
            ItemList.Circuit_Board_Coated.get(1, o),
            new Object[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                ItemList.IC2_Resin.get(1, o), ItemList.IC2_Resin.get(1, o)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Board_Coated.get(3, o),
            new Object[]{"RRR", "PPP", "RRR", 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                'R', ItemList.IC2_Resin.get(1, o)});
        GT_ModHandler.addShapelessCraftingRecipe(
            ItemList.Circuit_Board_Coated.get(1, o),
            new Object[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                new ItemStack(Items.slime_ball, 1), new ItemStack(Items.slime_ball, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Board_Coated.get(3, o),
            new Object[]{"RRR", "PPP", "RRR", 'P', GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                'R', new ItemStack(Items.slime_ball, 1)});
        if (Loader.isModLoaded("TConstruct")) {
            GT_ModHandler.addShapelessCraftingRecipe(
                ItemList.Circuit_Board_Coated.get(1, o),
                new Object[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                    GT_ModHandler.getModItem(aTextTConstruct, "materials", 1, 36),
                    GT_ModHandler.getModItem(aTextTConstruct, "materials", 1, 36)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Board_Coated.get(3, o),
                new Object[]{"RRR", "PPP", "RRR", 'P',
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1), 'R',
                    GT_ModHandler.getModItem(aTextTConstruct, "materials", 1, 36)});
            GT_ModHandler.addShapelessCraftingRecipe(
                ItemList.Circuit_Board_Coated.get(1, o),
                new Object[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 0),
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 0)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Board_Coated.get(3, o),
                new Object[]{"RRR", "PPP", "RRR", 'P',
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1), 'R',
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 0)});
            GT_ModHandler.addShapelessCraftingRecipe(
                ItemList.Circuit_Board_Coated.get(1, o),
                new Object[]{GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1),
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 1),
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 1)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Board_Coated.get(3, o),
                new Object[]{"RRR", "PPP", "RRR", 'P',
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1), 'R',
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 1)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Coal), 'R',
                    GT_ModHandler.getModItem(aTextTConstruct, "materials", 1, 36)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Carbon),
                    'R', GT_ModHandler.getModItem(aTextTConstruct, "materials", 1, 36)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Charcoal),
                    'R', GT_ModHandler.getModItem(aTextTConstruct, "materials", 1, 36)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Coal), 'R',
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 0)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Carbon),
                    'R', GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 0)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Charcoal),
                    'R', GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 0)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Coal), 'R',
                    GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 1)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Carbon),
                    'R', GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 1)});
            GT_ModHandler.addCraftingRecipe(
                ItemList.Circuit_Parts_Resistor.get(1, o),
                new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                    OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Charcoal),
                    'R', GT_ModHandler.getModItem(aTextTConstruct, "strangeFood", 1, 1)});
        }
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Board_Coated_Basic.get(1, o),
            new Object[]{"FFF", "FCF", "FFF", 'C', ItemList.Circuit_Board_Coated.get(1, o), 'F',
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Good.get(1, o),
            new Object[]{"PAP", "CBC", "DCD", 'D', ItemList.Circuit_Parts_Diode.get(1, o), 'C',
                GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0), 'A', ItemList.IC2_Item_Casing_Steel.get(1, o), 'P',
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 1), 'B',
                ItemList.Circuit_Board_Phenolic_Good.get(1, o)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Board_Phenolic_Good.get(1, o),
            new Object[]{"FFF", "FCF", "FFF", 'C', ItemList.Circuit_Board_Phenolic.get(1, o), 'F',
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Gold, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Coal), 'R',
                ItemList.IC2_Resin.get(1, o)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Carbon), 'R',
                ItemList.IC2_Resin.get(1, o)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Charcoal), 'R',
                ItemList.IC2_Resin.get(1, o)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Lignite), 'R',
                ItemList.IC2_Resin.get(1, o)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Coal), 'R',
                new ItemStack(Items.slime_ball, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Carbon), 'R',
                new ItemStack(Items.slime_ball, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Charcoal), 'R',
                new ItemStack(Items.slime_ball, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Resistor.get(1, o),
            new Object[]{"RPR", "FCF", " P ", 'F', OrePrefixes.wireGt01.get(Materials.Copper), 'P',
                OrePrefixes.wireFine.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.Lignite), 'R',
                new ItemStack(Items.slime_ball, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.Circuit_Parts_Vacuum_Tube.get(1, o),
            new Object[]{"WWW", "FGF", "SAS", 'G', ItemList.Circuit_Parts_Glass_Tube.get(1, o), 'F',
                OrePrefixes.wireFine.get(Materials.Copper), 'W', OrePrefixes.wireGt01.get(Materials.Copper),
                'S', OrePrefixes.stick.get(Materials.Steel), 'A', OrePrefixes.bolt.get(Materials.RedAlloy)});

        // Filter Machine Casing for cleanroom
        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Vent.get(1L),
            bits,
            new Object[]{"PPP", "SSS", "MFV", 'P', ItemList.SteelBars.get(1, o), 'F',
                OrePrefixes.frameGt.get(Materials.StainlessSteel), 'M', ItemList.Electric_Motor_MV, 'V',
                OrePrefixes.rotor.get(Materials.Aluminium), 'S', ItemList.Component_Filter});

        // Air filter multi blocks

        GT_ModHandler.addCraftingRecipe(
            ItemList.Casing_Pyrolyse.get(1L),
            bits,
            new Object[]{"PhP", "SFS", "PwP", 'P', OrePrefixes.plate.get(Materials.Steel), 'S',
                OrePrefixes.plate.get(Materials.Iron), 'F', ItemList.Casing_BronzePlatedBricks});

        // For making bee houses
        GT_ModHandler.addCraftingRecipe(
            ItemList.WoodenCasing.get(1L),
            bits,
            new Object[]{"SSS", "UCU", "SDS", 'S', OrePrefixes.slab.get(Materials.Wood), 'D',
                ToolDictNames.craftingToolScrewdriver, 'U', OrePrefixes.screw.get(Materials.Iron), 'C',
                OrePrefixes.frameGt.get(Materials.Wood)});

        // For making gendustry upgrades
        GT_ModHandler.addCraftingRecipe(
            ItemList.IndustryFrame.get(1L),
            bits,
            new Object[]{"PPP", "SBS", "SSS", 'P', OrePrefixes.plate.get(Materials.Palladium), 'S',
                OrePrefixes.stick.get(Materials.Osmium), 'B', ItemList.IridiumBars.get(1)});

        // ===================================================================================================
        // Diodes
        // ===================================================================================================

        GT_ModHandler.addCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
            new Object[]{"S", "m", 'S', new ItemStack(Blocks.sand, 1, 32767)});
        GT_ModHandler.addCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Flint, 1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
            new Object[]{"F", "m", 'F', new ItemStack(Items.flint, 1, 0)});

        GT_ModHandler.addShapelessCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
            new Object[]{OrePrefixes.dust.get(Materials.QuartzSand), OrePrefixes.dustTiny.get(Materials.Flint)});
        GT_ModHandler.addShapelessCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 8L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
            new Object[]{OrePrefixes.dust.get(Materials.QuartzSand), OrePrefixes.dust.get(Materials.QuartzSand),
                OrePrefixes.dust.get(Materials.QuartzSand), OrePrefixes.dust.get(Materials.QuartzSand),
                OrePrefixes.dust.get(Materials.QuartzSand), OrePrefixes.dust.get(Materials.QuartzSand),
                OrePrefixes.dust.get(Materials.QuartzSand), OrePrefixes.dust.get(Materials.QuartzSand),
                OrePrefixes.dust.get(Materials.Flint)});

        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Blocks.iron_bars, 3, 0),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{" h ", "SSS", "SSS", 'S',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.AnyIron, 1)});
        GT_ModHandler.addCraftingRecipe(
            ItemList.SteelBars.get(3L, o),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE,
            new Object[]{" h ", "SSS", "SSS", 'S',
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1)});
        GT_ModHandler.addCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Steel, 1L),
            tBitMask,
            new Object[]{"PIh", "f  ", 'P', OrePrefixes.plate.get(Materials.Steel), 'I',
                OrePrefixes.ingot.get(Materials.Steel)});

        GT_ModHandler.addShapelessCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
            new Object[]{ToolDictNames.craftingToolMortar,
                new ItemStack(Blocks.stained_hardened_clay, 1,  GT_Values.W)});
        GT_ModHandler.addShapelessCraftingRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
            GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED,
            new Object[]{ToolDictNames.craftingToolMortar, new ItemStack(Blocks.hardened_clay, 1)});

        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemArmorBatpack", 1, GT_Values.W),
            bits,
            new Object[]{"RCR", "RAR", "RTR", 'R',
                GT_ModHandler.getModItem(aTextIC2, "itemBatREDischarged", 1, 0), 'C',
                OrePrefixes.circuit.get(Materials.Basic), 'A', OrePrefixes.itemCasing.get(Materials.Aluminium),
                'T', OrePrefixes.wireGt02.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemArmorAdvBatpack", 1, GT_Values.W),
            bits,
            new Object[]{"RCR", "RAR", "RTR", 'R',
                GT_ModHandler.getModItem(aTextIC2, "itemAdvBat", 1, GT_Values.W), 'C',
                OrePrefixes.circuit.get(Materials.Good), 'A',
                GT_ModHandler.getModItem(aTextIC2, "itemArmorBatpack", 1, GT_Values.W), 'T',
                OrePrefixes.wireGt04.get(Materials.AnnealedCopper)});
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemArmorEnergypack", 1, GT_Values.W),
            bits,
            new Object[]{"CSC", "EXE", "STS", 'E',
                GT_ModHandler.getModItem(aTextIC2, "itemBatCrystal", 1, GT_Values.W), 'C',
                OrePrefixes.circuit.get(Materials.Advanced), 'X',
                GT_ModHandler.getModItem(aTextIC2, "itemArmorAdvBatpack", 1, GT_Values.W), 'T',
                OrePrefixes.wireGt08.get(Materials.Gold), 'S',
                OrePrefixes.itemCasing.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemAdvBat", 1, GT_Values.W),
            bits,
            new Object[]{"WdW", "HBH", "HXH", 'W', OrePrefixes.wireGt02.get(Materials.Copper), 'H',
                OrePrefixes.itemCasing.get(Materials.Copper), 'X', OrePrefixes.itemCasing.get(Materials.Lead),
                'B', ItemList.Battery_Hull_MV});
        if (Loader.isModLoaded(aTextGalacticraftCore)) GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemNightvisionGoggles", 1, GT_Values.W),
            bits,
            new Object[]{"AXA", "RBR", "SdS", 'A',
                GT_ModHandler.getModItem(aTextIC2, "reactorHeatSwitchDiamond", 1, 1), 'X',
                OrePrefixes.screw.get(Materials.StainlessSteel), 'B',
                OrePrefixes.bolt.get(Materials.StainlessSteel), 'R',
                OrePrefixes.ring.get(Materials.StainlessSteel), 'S',
                GT_ModHandler.getModItem(aTextGalacticraftCore, "item.sensorLens", 1, 0)});
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemTreetapElectric", 1, GT_Values.W),
            bits,
            new Object[]{"dRD", "RPB", "ECS", 'R', OrePrefixes.stickLong.get(Materials.Steel), 'D',
                OrePrefixes.toolHeadDrill.get(Materials.Steel), 'P', ItemList.Electric_Pump_LV, 'B',
                GT_ModHandler.getModItem(aTextIC2, "itemBatRE", 1, GT_Values.W), 'E',
                GT_ModHandler.getModItem(aTextIC2, "itemRecipePart", 1, 3), 'C',
                OrePrefixes.cableGt01.get(Materials.Tin), 'S', OrePrefixes.screw.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(
            GT_ModHandler.getModItem(aTextIC2, "itemToolHoe", 1, GT_Values.W),
            bits,
            new Object[]{"dPH", "PGB", "ECS", 'S', OrePrefixes.screw.get(Materials.Steel), 'H',
                OrePrefixes.toolHeadHoe.get(Materials.Steel), 'G', OrePrefixes.gearGtSmall.get(Materials.Steel),
                'B', GT_ModHandler.getModItem(aTextIC2, "itemBatRE", 1, GT_Values.W), 'E',
                GT_ModHandler.getModItem(aTextIC2, "itemRecipePart", 1, 3), 'P',
                OrePrefixes.plate.get(Materials.Steel)});

        GT_ModHandler.addCraftingRecipe(
            new ItemStack(Items.clay_ball, 3, 0),
            tBitMask,
            new Object[]{"CCC", "CBC", "CCC", 'C', OrePrefixes.dustSmall.get(Materials.Clay), 'B',
                new ItemStack(Items.water_bucket, 1, 0)});

        if (Loader.isModLoaded(aTextForestry)) {
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 0),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE
                    | GT_ModHandler.RecipeBits.DISMANTLEABLE
                    | GT_ModHandler.RecipeBits.BUFFERED
                    | DELETE_ALL_OTHER_RECIPES,
                new Object[]{"BLB", "SPS", "GCG", 'B', OrePrefixes.plate.get(Materials.StainlessSteel), 'L',
                    OrePrefixes.plate.get(Materials.Lapis), 'S',
                    OrePrefixes.spring.get(Materials.StainlessSteel), 'P', OreDictNames.craftingPiston, 'G',
                    OrePrefixes.circuit.get(Materials.Basic), 'C',
                    GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 1),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE
                    | GT_ModHandler.RecipeBits.DISMANTLEABLE
                    | GT_ModHandler.RecipeBits.BUFFERED
                    | DELETE_ALL_OTHER_RECIPES,
                new Object[]{"BLB", "SPS", "GCG", 'B', OrePrefixes.plate.get(Materials.Iron), 'L',
                    OrePrefixes.plate.get(Materials.Lapis), 'S', OrePrefixes.spring.get(Materials.Iron), 'P',
                    OreDictNames.craftingPiston, 'G', OrePrefixes.gearGt.get(Materials.Iron), 'C',
                    GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 2),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE
                    | GT_ModHandler.RecipeBits.DISMANTLEABLE
                    | GT_ModHandler.RecipeBits.BUFFERED
                    | DELETE_ALL_OTHER_RECIPES,
                new Object[]{"BLB", "SPS", "GCG", 'B', OrePrefixes.plate.get(Materials.Bronze), 'L',
                    OrePrefixes.plate.get(Materials.Lapis), 'S', OrePrefixes.spring.get(Materials.Bronze), 'P',
                    OreDictNames.craftingPiston, 'G', OrePrefixes.gearGt.get(Materials.Bronze), 'C',
                    GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextForestry, "engine", 1L, 4),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE
                    | GT_ModHandler.RecipeBits.DISMANTLEABLE
                    | GT_ModHandler.RecipeBits.BUFFERED
                    | DELETE_ALL_OTHER_RECIPES,
                new Object[]{"BLB", "SPS", "GCG", 'B', OrePrefixes.plate.get(Materials.Gold), 'L',
                    OrePrefixes.plate.get(Materials.Lapis), 'S', OrePrefixes.spring.get(Materials.WroughtIron),
                    'P', OreDictNames.craftingPiston, 'G', OrePrefixes.gearGt.get(Materials.WroughtIron), 'C',
                    GT_ModHandler.getModItem(aTextForestry, "sturdyMachine", 1L, 0)});
        }

        // Rocket parts
        if (Loader.isModLoaded(aTextGalacticraftCore) && Loader.isModLoaded(aTextGalacticraftMars)) {
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftCore, "item.engine", 1L, 0),
                bits,
                new Object[]{" C ", "HFH", "HAH", 'C',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.oilCanisterPartial", 1L, 1001), 'H',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.heavyPlating", 1L, 0), 'F',
                    ItemList.Casing_Firebox_Steel, 'A', ItemList.Cover_ActivityDetector});

            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftMars, "item.itemBasicAsteroids", 1L, 1),
                bits,
                new Object[]{"BPB", "PPP", "EPE", 'B',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.engine", 1L, 1), 'P',
                    GT_ModHandler.getModItem(aTextGalacticraftMars, "item.itemBasicAsteroids", 1L, 0), 'E',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.engine", 1L, 0)});

            // nose cones
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftCore, "item.noseCone", 1L, 0),
                bits,
                new Object[]{"SNH", "CPC", "PPP", 'N', GT_ModHandler
                    .getModItem("ProjRed|Illumination", "projectred.illumination.cagelamp2.inv", 1L, 14),
                    'P', GT_ModHandler.getModItem(aTextGalacticraftCore, "item.heavyPlating", 1L, 0), 'C',
                    OrePrefixes.screw.get(Materials.StainlessSteel), 'S', ToolDictNames.craftingToolScrewdriver,
                    'H', ToolDictNames.craftingToolHardHammer});

            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftMars, "item.heavyNoseCone", 1L, 0),
                bits,
                new Object[]{"SNH", "CPC", "PPP", 'N',

                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.noseCone", 1L, 0), 'P',
                    GT_ModHandler.getModItem(aTextGalacticraftMars, "item.itemBasicAsteroids", 1L, 0), 'C',
                    OrePrefixes.screw.get(Materials.Titanium), 'S', ToolDictNames.craftingToolScrewdriver, 'H',
                    ToolDictNames.craftingToolHardHammer});

            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftCore, "item.rocketFins", 1L, 0),
                bits,
                new Object[]{"HPF", "QPQ", "QSQ", 'P',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.basicItem", 1L, 9), 'Q',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.heavyPlating", 1L, 0), 'S',
                    ToolDictNames.craftingToolSaw, 'F', ToolDictNames.craftingToolFile, 'H',
                    ToolDictNames.craftingToolHardHammer});

            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftMars, "item.itemBasicAsteroids", 1L, 2),
                bits,
                new Object[]{"HPF", "QPQ", "QSQ", 'P',
                    GT_ModHandler.getModItem(aTextGalacticraftMars, "item.null", 1L, 3), 'Q',
                    GT_ModHandler.getModItem(aTextGalacticraftMars, "item.itemBasicAsteroids", 1L, 0), 'S',
                    ToolDictNames.craftingToolSaw, 'F', ToolDictNames.craftingToolFile, 'H',
                    ToolDictNames.craftingToolHardHammer});

            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGalacticraftCore, "item.engine", 1L, 1),
                bits,
                new Object[]{"LLL", "PBP", "PVP", 'L',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.meteoricIronIngot", 1L, 1), 'P',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.heavyPlating", 1L, 0), 'B',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.fuelCanisterPartial", 1L, 1), 'V',
                    GT_ModHandler.getModItem(aTextGalacticraftCore, "item.airVent", 1L, 0)});
        }

        if (Loader.isModLoaded(aTextGraviSuite)) {
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextIC2, "itemArmorJetpackElectric", 1, GT_Values.W),
                bits,
                new Object[]{"SCS", "MBM", "EWE", 'S', OrePrefixes.itemCasing.get(Materials.StainlessSteel), 'C',
                    OrePrefixes.circuit.get(Materials.Advanced), 'M', ItemList.Electric_Motor_HV, 'B',
                    GT_ModHandler.getModItem(aTextIC2, "itemArmorBatpack", 1, GT_Values.W), 'W',
                    OrePrefixes.wireGt04.get(Materials.AnnealedCopper), 'E',
                    GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 6)});

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 3));
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 3),
                new Object[]{"OCO", "XWX", "OCO", 'C', OrePrefixes.wireGt12.get(Materials.SuperconductorLuV), 'X',
                    GT_ModHandler.getModItem(aTextGraviSuite, "itemSimpleItem", 1, 2), 'O',
                    GT_ModHandler.getModItem(aTextIC2, "blockMachine2", 1, 1), 'W',
                    ItemList.Transformer_LuV_IV.get(1, o)});
        }

        if (Loader.isModLoaded("TConstruct")) {
            // Add Clay Casts
            ItemStack aBlankClayCast = GT_ModHandler.getModItem(aTextTConstruct, "blankPattern", 1, 3);

            GT_ModHandler.addCraftingRecipe(
                aBlankClayCast,
                new Object[]{"CC ", "CC ", "   ", 'C', new ItemStack(Items.clay_ball, 1)});

            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 0),
                new Object[]{"CW ", "   ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 1),
                new Object[]{"C W", "   ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 2),
                new Object[]{"C  ", "W  ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 3),
                new Object[]{"C  ", " W ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 4),
                new Object[]{"C  ", "  W", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 5),
                new Object[]{"C  ", "   ", "W  ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 6),
                new Object[]{"C  ", "   ", " W ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 7),
                new Object[]{"C  ", "   ", "  W", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 8),
                new Object[]{"WC ", "   ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 9),
                new Object[]{" CW", "   ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 10),
                new Object[]{" C ", "W  ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 11),
                new Object[]{" C ", " W ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 12),
                new Object[]{" C ", "  W", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 13),
                new Object[]{" C ", "   ", "W  ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 22),
                new Object[]{" C ", "   ", " W ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 25),
                new Object[]{" C ", "   ", "  W", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 26),
                new Object[]{"W C", "   ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "clayPattern", 1, 27),
                new Object[]{" WC", "   ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
            GT_ModHandler.addCraftingRecipe(
                GT_ModHandler.getModItem(aTextTConstruct, "Clay Cast", 1, 3),
                new Object[]{"  C", "W  ", "   ", 'W', ToolDictNames.craftingToolKnife, 'C', aBlankClayCast});
        }
    }
}
