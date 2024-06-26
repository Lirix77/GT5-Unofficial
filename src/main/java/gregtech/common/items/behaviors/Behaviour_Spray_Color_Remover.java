package gregtech.common.items.behaviors;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import appeng.api.implementations.tiles.IColorableTile;
import appeng.api.util.AEColor;
import appeng.block.networking.BlockCableBus;
import gregtech.api.interfaces.tileentity.IColoredTileEntity;
import gregtech.api.util.GT_LanguageManager;

public class Behaviour_Spray_Color_Remover extends Behaviour_Spray_Color {

    public Behaviour_Spray_Color_Remover(ItemStack aEmpty, ItemStack aUsed, ItemStack aFull, long aUses) {
        super(aEmpty, aUsed, aFull, aUses);
        this.mTooltip = GT_LanguageManager
            .addStringLocalization("gt.behaviour.paintspray.solvent.tooltip", "Can remove paint from things");
    }

    @Override
    protected boolean colorize(World aWorld, int aX, int aY, int aZ, ForgeDirection side, EntityPlayer player) {
        final Block aBlock = aWorld.getBlock(aX, aY, aZ);
        if (aBlock != Blocks.air) {
            if (aBlock instanceof IColorableTile) {
                return ((IColorableTile) aBlock).recolourBlock(side, AEColor.Transparent, player);
            }

            TileEntity tTileEntity = aWorld.getTileEntity(aX, aY, aZ);
            if (tTileEntity instanceof IColoredTileEntity gte) {
                if (gte.getColorization() >= 0) {
                    gte.setColorization((byte) -1);
                    return true;
                }
            }
        }
        return false;
    }
}
