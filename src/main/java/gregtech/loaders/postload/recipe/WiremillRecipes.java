package gregtech.loaders.postload.recipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_Utility;

import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

public class WiremillRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder()
            .itemInputs(Materials.BorosilicateGlass.getIngots(1), GT_Utility.getIntegratedCircuit(3))
            .itemOutputs(ItemList.Circuit_Parts_GlassFiber.get(8L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
            .addTo(wiremillRecipes);
    }
}
