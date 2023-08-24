package gregtech.loaders.postload.scripts;

import micdoodle8.mods.galacticraft.api.recipe.*;

import java.util.Collections;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptGalaxy implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Galaxy";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("GalacticraftCore");
    }

    @Override
    public void loadRecipes() {
        CompressorRecipes.getRecipeList().clear();
        CircuitFabricatorRecipes.removeRecipe(getModItem("GalacticraftCore", "item.basicItem", 3, 13));
        CircuitFabricatorRecipes.removeRecipe(getModItem("GalacticraftCore", "item.basicItem", 1, 14));
    }
}
