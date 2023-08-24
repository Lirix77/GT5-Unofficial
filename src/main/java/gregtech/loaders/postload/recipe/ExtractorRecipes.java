package gregtech.loaders.postload.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ExtractorRecipes implements Runnable {

    @Override
    public void run() {
        GT_ModHandler.addExtractionRecipe(
            new ItemStack(Blocks.stone_slab, 1, 4),
            new ItemStack(Items.brick, 2, 0));
        if (Loader.isModLoaded("TConstruct")) {
            GT_ModHandler.addExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "materials", 4L, 2));
            GT_ModHandler.addExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.sapling", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0));
            GT_ModHandler.addExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 0),
                GT_ModHandler.getModItem("TConstruct", "strangeFood", 4L, 0));
            GT_ModHandler.addExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 1),
                new ItemStack(Items.slime_ball, 4, 0));
            GT_ModHandler.addExtractionRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.leaves", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 1L));
        }
    }
}
