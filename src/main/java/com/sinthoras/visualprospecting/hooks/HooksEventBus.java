package com.sinthoras.visualprospecting.hooks;

import com.sinthoras.visualprospecting.Utils;
import com.sinthoras.visualprospecting.database.ClientCache;
import com.sinthoras.visualprospecting.database.ServerCache;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

import static gregtech.GTMod.GT_FML_LOGGER;

public class HooksEventBus {

    @SubscribeEvent
    public void onEvent(WorldEvent.Unload event) {
        if (Utils.isLogicalClient()) {
            GT_FML_LOGGER.info(" ClientCache.instance.saveVeinCache();");
            ClientCache.instance.saveVeinCache();
        }
    }

    @SubscribeEvent
    public void onEvent(WorldEvent.Save event) {
        ServerCache.instance.saveVeinCache();
    }
}
