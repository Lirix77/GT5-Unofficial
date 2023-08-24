package gregtech.loaders.postload.recipe;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ImplosionCompressorRecipes implements Runnable {

    @Override
    public void run() {
        if (Loader.isModLoaded("GalacticraftMars")) {
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 2L, 6),
                2,
                ItemList.TitaniumDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftMars", "item.null", 2L, 5),
                2,
                ItemList.DeshDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        }

        if (Loader.isModLoaded("GalacticraftCore")) {
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 9),
                2,
                ItemList.SteelDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 7),
                2,
                ItemList.TinDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 6),
                2,
                ItemList.CopperDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.basicItem", 2L, 11),
                2,
                ItemList.IronDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("GalacticraftCore", "item.meteoricIronIngot", 2L, 1),
                2,
                ItemList.MeteoricIronDualCompressedPlates.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ash, 2L));
        }

        if (Loader.isModLoaded("Avaritia")) {
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 2),
                1,
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 3),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 3),
                4,
                GT_ModHandler.getModItem("Avaritia", "Resource", 1L, 4),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 4),
                16,
                GT_ModHandler.getModItem("Avaritia", "Resource_Block", 1L, 0),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("Avaritia", "Resource", 9L, 6),
                64,
                GT_ModHandler.getModItem("Avaritia", "Resource_Block", 1L, 1),
                GT_Values.NI);
        }

        if (Loader.isModLoaded("ExtraUtilities")) {
            // CC
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 0),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 1),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 1),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 2),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 2),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 3),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 3),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 4),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 4),
                8,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 5),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 5),
                10,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 6),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 6),
                16,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 7),
                GT_Values.NI);
            // CD
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 8),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 9),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 9),
                2,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 10),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 10),
                4,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 11),
                GT_Values.NI);
            // CG
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 12),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 13),
                GT_Values.NI);
            // CS
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 9L, 14),
                1,
                GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1L, 15),
                GT_Values.NI);

            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("ExtraUtilities", "bedrockiumIngot", 9),
                8,
                GT_ModHandler.getModItem("ExtraUtilities", "block_bedrockium", 1L),
                GT_Values.NI);
        }

        if (Loader.isModLoaded("DraconicEvolution")) {
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 9L, 2),
                8,
                GT_ModHandler.getModItem("DraconicEvolution", "chaosShard", 1L, 0),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 9L, 1),
                4,
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 2),
                GT_Values.NI);
            GT_Values.RA.addImplosionRecipe(
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 9L, 0),
                2,
                GT_ModHandler.getModItem("DraconicEvolution", "chaosFragment", 1L, 1),
                GT_Values.NI);
        }
    }
}
