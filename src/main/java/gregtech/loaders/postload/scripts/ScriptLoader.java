package gregtech.loaders.postload.scripts;


import gregtech.api.util.GT_Log;

public class ScriptLoader {

    public static void run() {
        IScriptLoader[] scripts = new IScriptLoader[] {
            new ScriptIC2(),
            new ScriptForestry(),
            new ScriptRailCraft(),
            new ScriptGalaxy(),
            new ScriptEnderIO(),
            new ScriptAppliedEnergistics2()
        };

        for (IScriptLoader script : scripts) {
            if (script.isScriptLoadable()) {
                final long timeStart = System.currentTimeMillis();
                script.loadRecipes();
                final long timeToLoad = System.currentTimeMillis() - timeStart;
                GT_Log.out.println("Loaded " + script.getScriptName() + " script in " + timeToLoad + " ms.");
            } else {
                GT_Log.out.println(
                    "Missing dependencies to load " + script.getScriptName() + " script. It won't be loaded.");
            }
        }
    }
}
