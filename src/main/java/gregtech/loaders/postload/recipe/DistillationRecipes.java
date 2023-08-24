package gregtech.loaders.postload.recipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Utility;

public class DistillationRecipes implements Runnable {

    @Override
    public void run() {
        distilleryRecipes();
        distillationTowerRecipes();
    }

    public static void distillationTowerRecipes() {

    }

    public static void distilleryRecipes() {
        GT_Values.RA.addDistilleryRecipe(
            GT_Utility.getIntegratedCircuit(1),
            Materials.Biomass.getFluid(40L),
            Materials.Ethanol.getFluid(20L),
            16, 24, false);
    }
}
