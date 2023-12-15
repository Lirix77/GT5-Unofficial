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

    public static Materials RawRadox = new MaterialBuilder(-1, TextureSet.SET_DULL, "Raw Radox").setRGB(80, 30, 80)
        .addFluid().constructMaterial();
    public static Materials RadoxSuperLight = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Light Radox")
        .setRGB(155, 0, 155).addGas().constructMaterial();
    public static Materials RadoxLight = new MaterialBuilder(-1, TextureSet.SET_DULL, "Light Radox").setRGB(140, 0, 140)
        .addGas().constructMaterial();
    public static Materials RadoxHeavy = new MaterialBuilder(-1, TextureSet.SET_DULL, "Heavy Radox").setRGB(115, 0, 115)
        .addFluid().constructMaterial();
    public static Materials RadoxSuperHeavy = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Heavy Radox")
        .setRGB(100, 0, 100).addFluid().constructMaterial();
    public static Materials Xenoxene = new MaterialBuilder(-1, TextureSet.SET_DULL, "Xenoxene").setRGB(133, 130, 128)
        .addFluid().constructMaterial();
    public static Materials DelutedXenoxene = new MaterialBuilder(-1, TextureSet.SET_DULL, "Diluted Xenoxene")
        .setRGB(206, 200, 196).addFluid().constructMaterial();
    public static Materials RadoxCracked = new MaterialBuilder(-1, TextureSet.SET_DULL, "Cracked Radox")
        .setRGB(180, 130, 180).addGas().constructMaterial();
    public static Materials RadoxGas = new MaterialBuilder(-1, TextureSet.SET_DULL, "Radox Gas").setRGB(255, 130, 255)
        .addGas().constructMaterial();
    public static Materials RadoxPolymer = new Materials(
        979, // Material ID was choosen randomly
        TextureSet.SET_DULL,
        8.0F,
        346,
        3,
        1 | 2 | 16,
        133,
        0,
        128,
        0,
        "RadoxPoly",
        "Radox Polymer",
        0,
        0,
        6203,
        0,
        true,
        false,
        1,
        1,
        1,
        Dyes.dyePurple,
        0,
        Arrays.asList(
            new MaterialStack(Materials.Carbon, 14),
            new MaterialStack(Materials.Osmium, 11),
            new MaterialStack(Materials.Oxygen, 7),
            new MaterialStack(Materials.Silver, 3),
            new MaterialStack(Materials.CallistoIce, 1)),
        Arrays.asList(new TC_Aspects.TC_AspectStack(TC_Aspects.HUMANUS, 2))).setHasCorrespondingGas(true)
        .setGasTemperature(12406);

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
