package goodgenerator.crossmod.nei;

import cpw.mods.fml.common.Optional;
import gregtech.api.enums.Mods;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import goodgenerator.main.GoodGenerator;
import ru.justagod.cutter.invoke.Invoke;

@Optional.Interface(iface = "codechicken.nei.api.IConfigureNEI", modid = Mods.Names.NOT_ENOUGH_ITEMS)
public class NEIConfig implements IConfigureNEI {

    public static boolean isAdded = true;

    @Override
    public void loadConfig() {
        NEIConfig.isAdded = true;
    }

    public static void hide(Block aBlock) {
        Invoke.client(()-> API.hideItem(new ItemStack(aBlock, 1)));
    }

    public static void hide(Item aItem) {
        Invoke.client(()-> API.hideItem(new ItemStack(aItem, 1)));
    }

    @Override
    public String getName() {
        return "Good Generator NEI Plugin";
    }

    @Override
    public String getVersion() {
        return GoodGenerator.VERSION;
    }
}
