package gregtech.loaders.postload.recipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addFermentingRecipe(
            Materials.Concrete.getMolten(144L),
            Materials.ConstructionFoam.getFluid(800),
            20, 16, false);
    }
}
