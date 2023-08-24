package gregtech.common.blocks;
import gregtech.api.enums.Dyes;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Textures;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * Created by danie_000 on 03.10.2016.
 */
public class GT_Block_CasingsNH extends GT_Block_Casings_Abstract {

    public GT_Block_CasingsNH() {
        super(GT_Item_CasingsNH.class, "gt.blockcasingsNH", GT_Material_Casings.INSTANCE, 6);
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".0.name", "UEV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".1.name", "UIV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".2.name", "UMV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".3.name", "UXV Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".4.name", "MAX Machine Casing"); // adding
        GT_LanguageManager.addStringLocalization(getUnlocalizedName() + ".5.name", "Pyrolyse Oven Casing"); // adding

        ItemList.Casing_UEV.set(new ItemStack(this, 1, 0));
        ItemList.Casing_UIV.set(new ItemStack(this, 1, 1));
        ItemList.Casing_UMV.set(new ItemStack(this, 1, 2));
        ItemList.Casing_UXV.set(new ItemStack(this, 1, 3));
        ItemList.Casing_MAXV.set(new ItemStack(this, 1, 4));
        ItemList.Casing_Pyrolyse.set(new ItemStack(this, 1, 5));
    }

    @Override
    public int getTextureIndex(int aMeta) {
        return 1088 + aMeta;
    }

    @Override
    public IIcon getIcon(int aSide, int aMeta) {
        switch (aMeta) {
            case 5:
                return Textures.BlockIcons.MACHINE_CASING_PYROLYSE.getIcon();
            default:
                if (aSide == 0) {
                    return Textures.BlockIcons.MACHINECASINGS_BOTTOM[aMeta+10].getIcon();
                }
                if (aSide == 1) {
                    return Textures.BlockIcons.MACHINECASINGS_TOP[aMeta+10].getIcon();
                }
                return Textures.BlockIcons.MACHINECASINGS_SIDE[aMeta+10].getIcon();
        }
    }

    @Override
    public int colorMultiplier(IBlockAccess aWorld, int aX, int aY, int aZ) {
        return aWorld.getBlockMetadata(aX, aY, aZ) <= 9
            ? super.colorMultiplier(aWorld, aX, aY, aZ)
            : Dyes.MACHINE_METAL.mRGBa[0] << 16 | Dyes.MACHINE_METAL.mRGBa[1] << 8 | Dyes.MACHINE_METAL.mRGBa[2];
    }
}
