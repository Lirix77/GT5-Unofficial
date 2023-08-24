package gregtech.loaders.postload.recipe;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class SifterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addSifterRecipe(
            GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cinnabar, 1L),
            new ItemStack[] { Materials.Mercury.getGems(1), Materials.Mercury.getGems(1),
                Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1),
                Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1),
                Materials.Cinnabar.getDust(1) },
            new int[] { 100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500 },
            7200, 30);
    }
}
