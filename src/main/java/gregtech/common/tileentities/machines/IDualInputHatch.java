package gregtech.common.tileentities.machines;

import java.util.Iterator;

import net.minecraft.item.ItemStack;

public interface IDualInputHatch {

    boolean justUpdated();

    Iterator<? extends IDualInputInventory> inventories();

    void updateTexture(int id);
}
