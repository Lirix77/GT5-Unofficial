package gregtech.loaders.postload.scripts;

import gregtech.api.enums.ItemList;
import gregtech.api.util.GT_ModHandler;

import java.util.Collections;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptForestry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forestry";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("Forestry");
    }

    @Override
    public void loadRecipes() {
        recipeRemove();
        addShapedRecipe(getModItem("Forestry", "sturdyMachine", 1), new Object[]{
            "plateBronze", "screwSteel", "plateBronze",
            "screwSteel", ItemList.Casing_LV.get(1), "screwSteel",
            "plateBronze", "screwSteel", "plateBronze" }, true);
    }

    private void recipeRemove(){
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "alveary", 1L, 2));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "alveary", 1L, 3));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "alveary", 1L, 4));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "alveary", 1L, 5));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "alveary", 1L, 6));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "alveary", 1L, 7));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, W));

    }
}
