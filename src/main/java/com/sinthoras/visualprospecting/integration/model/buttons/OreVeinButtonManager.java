package com.sinthoras.visualprospecting.integration.model.buttons;

import com.gtnewhorizons.navigator.api.model.buttons.ButtonManager;
import com.sinthoras.visualprospecting.Tags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class OreVeinButtonManager extends ButtonManager {

    public static final OreVeinButtonManager instance = new OreVeinButtonManager();

    @Override
    public ResourceLocation getIcon(String theme) {
        return new ResourceLocation(Tags.MODID, "textures/icons/oreveins.png");
    }

    @Override
    public String getButtonText() {
        return StatCollector.translateToLocal("visualprospecting.button.orevein");
    }
}
