package gregtech.api.recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import codechicken.nei.drawable.DrawableBuilder;
import codechicken.nei.drawable.DrawableResource;
import codechicken.nei.recipe.HandlerInfo;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import gregtech.api.util.FieldsAreNonnullByDefault;
import gregtech.api.util.MethodsReturnNonnullByDefault;
import gregtech.common.config.Client;
import ru.justagod.cutter.GradleSide;
import ru.justagod.cutter.GradleSideOnly;
import ru.justagod.cutter.invoke.Invoke;

/**
 * Allows certain recipes to be displayed on different tabs on NEI.
 * <p>
 * Each entry must be declared under {@link gregtech.api.recipe.RecipeCategories}, and config entry must be added to
 * {@link gregtech.common.config.Client.NEI.RecipeCategories}.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@FieldsAreNonnullByDefault
public final class RecipeCategory {

    public static final Map<String, RecipeCategory> ALL_RECIPE_CATEGORIES = new HashMap<>();

    public final String unlocalizedName;
    public final RecipeMap<?> recipeMap;
    public final ModContainer ownerMod;
    public final Supplier<RecipeCategorySetting> settingSupplier;
    @Nullable
    @GradleSideOnly(GradleSide.CLIENT)
    public UnaryOperator<HandlerInfo.Builder> handlerInfoCreator;

    /**
     * @param unlocalizedName    Unlocalized name of this category. Must be unique.
     * @param recipeMap          RecipeMap this category belongs to.
     * @param settingSupplier    Supplier for the setting whether to enable this category.
     * @param handlerInfoCreator Supplier of handler info for the NEI handler this category belongs to.
     */
    public RecipeCategory(String unlocalizedName, RecipeMap<?> recipeMap,
        Supplier<RecipeCategorySetting> settingSupplier,
        @Nullable UnaryOperator<HandlerInfo.Builder> handlerInfoCreator) {
        this.unlocalizedName = unlocalizedName;
        this.recipeMap = recipeMap;
        this.ownerMod = Loader.instance()
            .activeModContainer();
        this.settingSupplier = settingSupplier;
        Invoke.client(() -> this.handlerInfoCreator = handlerInfoCreator);
        if (ALL_RECIPE_CATEGORIES.containsKey(unlocalizedName)) {
            throw new IllegalArgumentException(
                "Cannot register recipe category with duplicated unlocalized name: " + unlocalizedName);
        }
        ALL_RECIPE_CATEGORIES.put(unlocalizedName, this);
    }

    RecipeCategory(RecipeMap<?> recipeMap) {
        this(
            recipeMap.unlocalizedName,
            recipeMap,
            RecipeCategorySetting::getDefault,
            Invoke.clientValue(() -> recipeMap.getFrontend().neiProperties.handlerInfoCreator));
    }

    @Override
    public String toString() {
        return "RecipeCategory{" + "unlocalizedName='"
            + unlocalizedName
            + '\''
            + ", recipeMap="
            + recipeMap.unlocalizedName
            + ", ownerMod="
            + ownerMod.getModId()
            + '}';
    }

    /**
     * Util method for creating icon for recipe category. Size is 16px.
     */
    @GradleSideOnly(GradleSide.CLIENT)
    public static DrawableResource createIcon(String resourceLocation) {
        return new DrawableBuilder(resourceLocation, 0, 0, 16, 16)
            // GuiRecipeTab#drawForeground draws icon with 1px offset to make fuel icon (14px) prettier
            .addPadding(-1, 0, -1, 0)
            .setTextureSize(16, 16)
            .build();
    }
}
