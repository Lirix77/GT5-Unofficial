package com.sinthoras.visualprospecting.hooks;

import com.sinthoras.visualprospecting.VP;
import com.sinthoras.visualprospecting.database.ClientCache;
import com.sinthoras.visualprospecting.database.WorldIdHandler;
import com.sinthoras.visualprospecting.network.WorldIdNotification;
import com.sinthoras.visualprospecting.task.TaskManager;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import forestry.farming.triggers.TriggerLowGermlings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import static gregtech.GTMod.GT_FML_LOGGER;

public class HooksFML {

    @SubscribeEvent
    public void onEvent(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        ClientCache.instance.reset();
    }

    @SubscribeEvent
    public void onEvent(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        GT_FML_LOGGER.info("ClientCache.instance.saveVeinCache();");
        ClientCache.instance.saveVeinCache();
    }

    @SubscribeEvent
    public void onEvent(TickEvent event) {
        TaskManager.instance.onTick();
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void onEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP playerMP) {
            GT_FML_LOGGER.info("VP.network.sendTo(new WorldIdNotification(WorldIdHandler.getWorldId()), playerMP);");
            VP.network.sendTo(new WorldIdNotification(WorldIdHandler.getWorldId()), playerMP);
        } else if (event.player instanceof EntityPlayer) {
            GT_FML_LOGGER.info("ClientCache.instance.loadVeinCache(WorldIdHandler.getWorldId());");
            ClientCache.instance.loadVeinCache(WorldIdHandler.getWorldId());
        }
    }
}
