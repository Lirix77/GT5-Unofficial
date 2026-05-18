package com.sinthoras.visualprospecting.integration.voxelmap;

import com.sinthoras.visualprospecting.Utils;
import com.sinthoras.visualprospecting.database.OreVeinPosition;
import com.sinthoras.visualprospecting.database.UndergroundFluidPosition;
import com.sinthoras.visualprospecting.hooks.ProspectingNotificationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import gregtech.api.GregTechAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;

import java.util.TreeSet;

public class VoxelMapEventHandler {

    @SubscribeEvent
    public void onVeinProspected(ProspectingNotificationEvent.OreVein event) {
        if (event.isCanceled()) {
            return;
        }

        OreVeinPosition pos = event.getPosition();
        short[] color = GregTechAPI.sGeneratedMaterials[pos.veinType.primaryOreMeta].getRGBA();
        TreeSet<Integer> dim = new TreeSet<>();
        dim.add(pos.dimensionId);
    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public void onFluidProspected(ProspectingNotificationEvent.UndergroundFluid event) {
        if (event.isCanceled()) {
            return;
        }

        UndergroundFluidPosition pos = event.getPosition();
        int x = Utils.coordChunkToBlock(pos.chunkX);
        int z = Utils.coordChunkToBlock(pos.chunkZ);
        int color = pos.fluid.getColor();
        TreeSet<Integer> dim = new TreeSet<>();
        dim.add(pos.dimensionId);

    }

    private static int getY() {
        EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
        ItemStack heldItem = player.getHeldItem();
        if (heldItem == null || !heldItem.getUnlocalizedName().contains("gt.detrav.metatool.01")) {
            return (int) player.posY;
        }
        return 65;
    }
}
