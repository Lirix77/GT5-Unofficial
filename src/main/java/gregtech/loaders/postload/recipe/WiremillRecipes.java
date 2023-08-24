package gregtech.loaders.postload.recipe;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Utility;

public class WiremillRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addWiremillRecipe(
            GT_Utility.getIntegratedCircuit(3),
            Materials.BorosilicateGlass.getIngots(1),
            ItemList.Circuit_Parts_GlassFiber.get(8L),
            200, 120);
    }
}
