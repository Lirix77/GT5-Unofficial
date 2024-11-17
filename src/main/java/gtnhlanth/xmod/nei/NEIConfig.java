package gtnhlanth.xmod.nei;

import codechicken.nei.api.IConfigureNEI;
import cpw.mods.fml.common.Optional;
import gregtech.api.enums.Mods;
import gtnhlanth.Tags;

@Optional.Interface(iface = "codechicken.nei.api.IConfigureNEI", modid = Mods.Names.NOT_ENOUGH_ITEMS)
public class NEIConfig implements IConfigureNEI {

    public static boolean isAdded = true;

    @Override
    public String getName() {
        return "GTNH: Lanthanides NEI";
    }

    @Override
    public String getVersion() {
        return Tags.VERSION;
    }

    @Override
    public void loadConfig() {
        isAdded = true;
    }
}
