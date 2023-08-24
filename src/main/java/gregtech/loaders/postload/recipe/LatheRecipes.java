package gregtech.loaders.postload.recipe;

import gregtech.api.enums.ItemList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class LatheRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.addLatheRecipe(
            ItemList.ReinforcedGlassPLate.get(1L),
            ItemList.ReinforcedGlassLense.get(1L),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L),
            400,
            16);

        GT_Values.RA.addLatheRecipe(
            new ItemStack(Blocks.wooden_slab, 1, 0),
            new ItemStack(Items.bowl, 1),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
            50,
            8);
        GT_Values.RA.addLatheRecipe(
            new ItemStack(Blocks.wooden_slab, 1, 1),
            new ItemStack(Items.bowl, 1),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
            50,
            8);
        GT_Values.RA.addLatheRecipe(
            new ItemStack(Blocks.wooden_slab, 1, 2),
            new ItemStack(Items.bowl, 1),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
            50,
            8);
        GT_Values.RA.addLatheRecipe(
            new ItemStack(Blocks.wooden_slab, 1, 3),
            new ItemStack(Items.bowl, 1),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
            50,
            8);
        GT_Values.RA.addLatheRecipe(
            new ItemStack(Blocks.wooden_slab, 1, 4),
            new ItemStack(Items.bowl, 1),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
            50,
            8);
        GT_Values.RA.addLatheRecipe(
            new ItemStack(Blocks.wooden_slab, 1, 5),
            new ItemStack(Items.bowl, 1),
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
            50,
            8);

        if (Loader.isModLoaded("Forestry")) {
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 0),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 1),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 2),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 3),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 4),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 5),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 6),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs1", 1L, 7),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 0),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 1),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 2),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 3),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 4),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 5),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 6),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs2", 1L, 7),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 0),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 1),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 2),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 3),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 4),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 5),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 6),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
            GT_Values.RA.addLatheRecipe(
                GT_ModHandler.getModItem("Forestry", "slabs3", 1L, 7),
                new ItemStack(Items.bowl, 1),
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Wood, 1),
                50,
                8);
        }
    }
}
