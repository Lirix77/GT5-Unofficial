package detrav.items.processing;

import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerEV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerHV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerIV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerLV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerLuV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerMV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerUHV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerUV;
import static detrav.enums.IDDetraveMetaGeneratedTool01.ProspectorScannerZPM;

import gregtech.api.enums.GTValues;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import detrav.DetravScannerMod;
import detrav.items.DetravMetaGeneratedTool01;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;

/**
 * Created by wital_000 on 18.03.2016.
 */
public class ProcessingDetravToolProspector implements gregtech.api.interfaces.IOreRecipeRegistrator {

    public ProcessingDetravToolProspector() {
        OrePrefixes.toolHeadDrill.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials material, String aOreDictName, String aModName,
        ItemStack aStack) {
        if (!aPrefix.doGenerateItem(material)) return;
        if (DetravScannerMod.DEBUG_ENABLED) return;

        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerLV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellSulfuricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellHydroxide")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.LV), 'X', ItemList.Sensor_LV });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerMV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellSulfuricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellHydroxide")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.MV), 'X', ItemList.Sensor_MV });

        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerHV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellNitricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellSodiumPersulfate")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.HV), 'X', ItemList.Sensor_HV });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerEV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellNitricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellSodiumPersulfate")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.EV), 'X', ItemList.Sensor_EV });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerIV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellNitricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellSodiumPersulfate")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.IV), 'X', ItemList.Sensor_IV });

        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerLuV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellHydrofluoricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellLithiumPeroxide")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.LuV), 'X', ItemList.Sensor_LuV });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerZPM.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellHydrofluoricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellLithiumPeroxide")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.ZPM), 'X', ItemList.Sensor_ZPM });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerUV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellHydrofluoricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellLithiumPeroxide")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.UV), 'X', ItemList.Sensor_UV });

        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE
                .getToolWithStats(ProspectorScannerUHV.ID, 1, material, Materials.Steel, null),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "SHE", "CPC", "PXP", 'E', OreDictionary.getOres("cellHydrofluoricAcid")
                .get(0), 'S',
                OreDictionary.getOres("cellHydrogenPeroxide")
                    .get(0),
                'H', OrePrefixes.toolHeadDrill.get(material), 'P', OrePrefixes.plate.get(material), 'C',
                OrePrefixes.circuit.get(Materials.UHV), 'X', ItemList.Sensor_UHV });

        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                100,
                1,
                material,
                Materials.Iridium,
                new long[] { 102400000L, GTValues.V[6], 6L, -1L }),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_LuV, 'H',
                OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_LuV, 'C',
                OrePrefixes.circuit.get(Materials.LuV), 'P', OrePrefixes.plate.get(Materials.Iridium), 'B',
                ItemList.BatteryHull_LuV_Full.get(1L) });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                102,
                1,
                material,
                Materials.Osmium,
                new long[] { 409600000L, GTValues.V[7], 7L, -1L }),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_ZPM, 'H',
                OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_ZPM, 'C',
                OrePrefixes.circuit.get(Materials.ZPM), 'P', OrePrefixes.plate.get(Materials.Osmium), 'B',
                ItemList.BatteryHull_ZPM_Full.get(1L) });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                104,
                1,
                material,
                Materials.Neutronium,
                new long[] { 1638400000L, GTValues.V[8], 8L, -1L }),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_UV, 'H',
                OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_UV, 'C',
                OrePrefixes.circuit.get(Materials.UV), 'P', OrePrefixes.plate.get(Materials.Neutronium), 'B',
                ItemList.BatteryHull_UV_Full.get(1L) });
        GTModHandler.addCraftingRecipe(
            DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                106,
                1,
                material,
                Materials.Infinity,
                new long[] { 6553600000L, GTValues.V[9], 9L, -1L }),
            GTModHandler.RecipeBits.DISMANTLEABLE | GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS
                | GTModHandler.RecipeBits.BUFFERED,
            new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_UHV, 'H',
                OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_UHV, 'C',
                OrePrefixes.circuit.get(Materials.UHV), 'P', OrePrefixes.plate.get(Materials.Infinity), 'B',
                ItemList.BatteryHull_UHV_Full.get(1L) });

    }
}
