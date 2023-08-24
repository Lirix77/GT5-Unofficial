package gregtech.loaders.postload.scripts;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class ScriptIC2 implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "IC2";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("IC2");
    }

    @Override
    public void loadRecipes() {
        recipeRemove();
        loadMachineRecipes();
        addShapedRecipe(GT_ModHandler.getIC2Item("blockCrop",1),
            new Object[]{"stickLongWood", null, "stickLongWood", null, null, null, null, null, null });
    }

    private void loadMachineRecipes() {
    }
    private void recipeRemove(){

    }
}
