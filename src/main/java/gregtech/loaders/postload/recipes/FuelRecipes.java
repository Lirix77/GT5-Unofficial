package gregtech.loaders.postload.recipes;

import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeConstants.FUEL_TYPE;
import static gregtech.api.util.GT_RecipeConstants.FUEL_VALUE;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_RecipeConstants;

public class FuelRecipes implements Runnable {

    // todo: add an enum for the fuel type, int values are mysterious
    @Override
    public void run() {
        GT_Values.RA.stdBuilder()
            .itemInputs(GT_ModHandler.getIC2Item("biogasCell", 1L))
            .metadata(FUEL_VALUE, 40)
            .metadata(FUEL_TYPE, 1)
            .addTo(GT_RecipeConstants.Fuel);

        GT_Values.RA.stdBuilder()
            .itemInputs(new ItemStack(Items.golden_apple, 1, 1))
            .itemOutputs(new ItemStack(Items.apple, 1))
            .metadata(FUEL_VALUE, 6400)
            .metadata(FUEL_TYPE, 5)
            .addTo(GT_RecipeConstants.Fuel);
    }
}
