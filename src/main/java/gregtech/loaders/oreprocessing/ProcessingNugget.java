package gregtech.loaders.oreprocessing;

import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_Utility.calculateRecipeEU;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_RecipeRegistrator;
import gregtech.api.util.GT_Utility;

public class ProcessingNugget implements gregtech.api.interfaces.IOreRecipeRegistrator {

    public ProcessingNugget() {
        OrePrefixes.nugget.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName,
        ItemStack aStack) {

        if (aMaterial.mStandardMoltenFluid != null) {
            if (!(aMaterial == Materials.AnnealedCopper || aMaterial == Materials.WroughtIron)) {
                GT_Values.RA.stdBuilder()
                    .itemInputs(ItemList.Shape_Mold_Nugget.get(0L))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial, 1L))
                    .fluidInputs(aMaterial.getMolten(16L))
                    .noFluidOutputs()
                    .duration(16 * TICKS)
                    .eut(calculateRecipeEU(aMaterial, 4))
                    .addTo(sFluidSolidficationRecipes);
            }
        }

        GT_RecipeRegistrator.registerReverseFluidSmelting(aStack, aMaterial, aPrefix.mMaterialAmount, null);
        GT_RecipeRegistrator
            .registerReverseMacerating(aStack, aMaterial, aPrefix.mMaterialAmount, null, null, null, false);
        if (!aMaterial.contains(SubTag.NO_SMELTING)
            && GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L) != null) {
                GT_ModHandler.addShapelessCraftingRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.nugget, aMaterial, 9L),
                    GT_ModHandler.RecipeBits.BUFFERED,
                    new Object[] { OrePrefixes.ingot.get(aMaterial) });
        }
    }
}
