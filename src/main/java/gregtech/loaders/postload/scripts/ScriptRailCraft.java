package gregtech.loaders.postload.scripts;

import mods.railcraft.api.crafting.RailcraftCraftingManager;

import java.util.Collections;
import java.util.List;

public class ScriptRailCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Railcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("Railcraft");
    }

    @Override
    public void loadRecipes() {
        RailcraftCraftingManager.rockCrusher.getRecipes().clear();
        RailcraftCraftingManager.rollingMachine.getRecipeList().clear();
    }
}
