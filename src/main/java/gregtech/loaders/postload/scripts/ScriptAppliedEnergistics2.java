package gregtech.loaders.postload.scripts;

import java.util.Collections;
import java.util.List;

public class ScriptAppliedEnergistics2 implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "AppliedEnergistics2";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList("appliedenergistics2");
    }

    @Override
    public void loadRecipes() {

    }
}
