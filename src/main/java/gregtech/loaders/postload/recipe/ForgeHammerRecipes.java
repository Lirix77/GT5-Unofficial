package gregtech.loaders.postload.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;

public class ForgeHammerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addForgeHammerRecipe(
            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
            ItemList.Circuit_Parts_RawCrystalParts.get(9),
            100,
            480);

        GT_Values.RA.addForgeHammerRecipe(
            ItemList.GalliumArsenideCrystal.get(1L),
            ItemList.GalliumArsenideCrystalSmallPart.get(4L),
            50,
            4);

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addForgeHammerRecipe(
                GT_ModHandler.getModItem("TConstruct", "Smeltery", 1L, 2),
                GT_ModHandler.getModItem("TConstruct", "materials", 3L, 2),
                20,
                16);
        }
    }
}
