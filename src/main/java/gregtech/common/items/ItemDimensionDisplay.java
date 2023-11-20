package gregtech.common.items;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import gregtech.common.blocks.BlockDimensionDisplay;
import gregtech.common.blocks.DimBlocks;
import gregtech.common.render.items.ItemDimensionDisplayRenderer;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;

import static gregtech.api.GregTech_API.TAB_GREGTECH;

public class ItemDimensionDisplay extends ItemBlock {
    public ItemDimensionDisplay(Block block) {
        super(block);
        setCreativeTab(TAB_GREGTECH);

        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            MinecraftForgeClient.registerItemRenderer(this, new ItemDimensionDisplayRenderer());
        }
    }

    public static ItemStack getItem(String dimension) {
        Block block = DimBlocks.getBlock(dimension);
        if (block != null) {
            return new ItemStack(block);
        }
        return null;
    }

    public static String getDimension(ItemStack stack) {
        if (stack.getItem() instanceof ItemDimensionDisplay) {
            return ((BlockDimensionDisplay) Block.getBlockFromItem(stack.getItem())).getDimension();
        }
        return null;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        String dimension = getDimension(stack);
        if (dimension != null) {
            return DimBlocks.convertCondensedStringToToolTip(dimension).get(0);
        }
        return super.getItemStackDisplayName(stack);
    }
}
