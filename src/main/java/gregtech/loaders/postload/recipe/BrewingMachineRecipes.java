package gregtech.loaders.postload.recipe;

import java.lang.reflect.Field;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.Loader;
import forestry.api.recipes.IFermenterRecipe;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Recipe;

public class BrewingMachineRecipes implements Runnable {

    @Override
    public void run() {
        // Add fermenter recipes from forestry into gregtech
        if (Loader.isModLoaded("Forestry")) {
            try {
                Class forestryFermenterRecipeManager = Class.forName("forestry.factory.recipes.FermenterRecipeManager");
                Field fieldFermenterRecipes = forestryFermenterRecipeManager.getDeclaredField("recipes");
                fieldFermenterRecipes.setAccessible(true);

                Iterable<IFermenterRecipe> recipes = (Iterable<IFermenterRecipe>) fieldFermenterRecipes.get(null);

                for (IFermenterRecipe recipe : recipes) {
                    ItemStack resource = recipe.getResource();

                    boolean alreadyHasRecipe = GT_Recipe.GT_Recipe_Map.sBrewingRecipes.containsInput(resource);
                    boolean resultsInBiomass = recipe.getOutput().equals(FluidRegistry.getFluid("biomass"));

                    if (!alreadyHasRecipe && resultsInBiomass) {
                        int amountIn = recipe.getFermentationValue() * 2;
                        int amountOut = amountIn;
                        GT_Values.RA.addBrewingRecipeCustom(
                            resource,
                            FluidRegistry.getFluidStack("water", amountIn),
                            FluidRegistry.getFluidStack("biomass", amountOut),
                            8 * amountOut,
                            3,
                            false);

                        amountOut = (int) (amountOut * 1.5);
                        GT_Values.RA.addBrewingRecipeCustom(
                            resource,
                            FluidRegistry.getFluidStack("juice", amountIn),
                            FluidRegistry.getFluidStack("biomass", amountOut),
                            8 * amountOut,
                            3,
                            false);
                        GT_Values.RA.addBrewingRecipeCustom(
                            resource,
                            Materials.Honey.getFluid(amountIn),
                            FluidRegistry.getFluidStack("biomass", amountOut),
                            8 * amountOut,
                            3,
                            false);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
