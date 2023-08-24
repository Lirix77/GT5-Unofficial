package gregtech.loaders.postload.recipe;

import gregtech.api.enums.GT_Values;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addArcFurnaceRecipe(
            new ItemStack(Blocks.sand),
            new ItemStack[] { new ItemStack(Blocks.glass, 3) },
            null,
            16,
            72);
        GT_Values.RA.addArcFurnaceRecipe(
            GT_ModHandler.getModItem("IC2", "blockMiningPipe", 1L),
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L), },
            null,
            50,
            90);
    }
}
