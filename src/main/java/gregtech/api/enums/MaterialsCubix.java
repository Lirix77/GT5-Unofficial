package gregtech.api.enums;

import java.util.Arrays;

import static gregtech.api.enums.OrePrefixes.*;
import gregtech.api.objects.MaterialStack;

public class MaterialsCubix {

    public static Materials Energy = new MaterialBuilder(389, TextureSet.SET_METALLIC, "Energy")
        .setName("Energy")
        .setRGBA(229, 255, 0, 255)
        .addOreItems()
        .addDustItems()
        .addMetalItems()
        .addFluid()
        .addToolHeadItems()
        .addGearItems()
        .setToolSpeed(8.0F)
        .setDurability(5120)
        .setToolQuality(4)
        .constructMaterial();

    public static Materials Power = new MaterialBuilder(390, TextureSet.SET_METALLIC, "Power")
        .setName("Power")
        .setRGBA(144, 0, 244, 255)
        .addDustItems()
        .addMetalItems()
        .addFluid()
        .addToolHeadItems()
        .addGearItems()
        .setToolSpeed(32.0F)
        .setDurability(32768)
        .setToolQuality(6)
        .constructMaterial();

    public static void init() {
        Energy.mChemicalFormula = "En";
        Power.mChemicalFormula = "Pr";

        ingot.mNotGeneratedItems.add(Energy);
        nugget.mNotGeneratedItems.add(Energy);
        plate.mNotGeneratedItems.add(Energy);
        stick.mNotGeneratedItems.add(Energy);
        dust.mNotGeneratedItems.add(Energy);
        block.mNotGeneratedItems.add(Energy);

        Energy.add(SubTag.METAL);
        Power.add(SubTag.METAL);

        ingot.mNotGeneratedItems.add(Power);
        nugget.mNotGeneratedItems.add(Power);
        plate.mNotGeneratedItems.add(Power);
        stick.mNotGeneratedItems.add(Power);
        dust.mNotGeneratedItems.add(Power);
        block.mNotGeneratedItems.add(Power);

    }
}
