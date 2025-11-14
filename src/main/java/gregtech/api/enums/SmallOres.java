package gregtech.api.enums;

import static galacticgreg.api.enums.DimensionDef.Anubis;
import static galacticgreg.api.enums.DimensionDef.Asteroids;
import static galacticgreg.api.enums.DimensionDef.EndAsteroids;
import static galacticgreg.api.enums.DimensionDef.Horus;
import static galacticgreg.api.enums.DimensionDef.Mars;
import static galacticgreg.api.enums.DimensionDef.MehenBelt;
import static galacticgreg.api.enums.DimensionDef.Moon;
import static galacticgreg.api.enums.DimensionDef.Seth;
import static gregtech.common.SmallOreBuilder.NETHER;
import static gregtech.common.SmallOreBuilder.OW;

import galacticgreg.WorldgenOreSmallSpace;
import gregtech.common.SmallOreBuilder;
import gregtech.common.WorldgenGTOreSmallPieces;

public enum SmallOres {

    // spotless : off
    Copper(new SmallOreBuilder().name("ore.small.copper")
        .heightRange(60, 180)
        .amount(32)
        .ore(Materials.Copper)
        .enableInDim(Mars)
        .enableInDim(NETHER, OW)),

    Tin(new SmallOreBuilder().name("ore.small.tin")
        .heightRange(80, 220)
        .amount(32)
        .ore(Materials.Tin)
        .enableInDim(MehenBelt, Mars, EndAsteroids)
        .enableInDim(NETHER, OW)),

    Bismuth(new SmallOreBuilder().name("ore.small.bismuth")
        .heightRange(80, 120)
        .amount(8)
        .ore(Materials.Bismuth)
        .enableInDim(Mars)
        .enableInDim(NETHER)),

    Coal(new SmallOreBuilder().name("ore.small.coal")
        .heightRange(120, 250)
        .amount(24)
        .ore(Materials.Coal)
        .enableInDim(OW)),

    Iron(new SmallOreBuilder().name("ore.small.iron")
        .heightRange(40, 100)
        .amount(16)
        .ore(Materials.Iron)
        .enableInDim(
            Asteroids,
            Mars)
        .enableInDim(NETHER, OW)),

    Lead(new SmallOreBuilder().name("ore.small.lead")
        .heightRange(40, 180)
        .amount(16)
        .ore(Materials.Lead)
        .enableInDim(
            Asteroids,
            Mars,
            EndAsteroids)
        .enableInDim(NETHER)),

    Zinc(new SmallOreBuilder().name("ore.small.zinc")
        .heightRange(80, 210)
        .amount(24)
        .ore(Materials.Zinc)
        .enableInDim(Mars, EndAsteroids)
        .enableInDim(NETHER, OW)),

    Gold(new SmallOreBuilder().name("ore.small.gold")
        .heightRange(20, 60)
        .amount(8)
        .ore(Materials.Gold)
        .enableInDim(
            Asteroids,
            Mars,
            EndAsteroids)
        .enableInDim(OW)),

    Silver(new SmallOreBuilder().name("ore.small.silver")
        .heightRange(20, 60)
        .amount(20)
        .ore(Materials.Silver)
        .enableInDim(EndAsteroids)
        .enableInDim(NETHER, OW)),

    Nickel(new SmallOreBuilder().name("ore.small.nickel")
        .heightRange(80, 150)
        .amount(8)
        .ore(Materials.Nickel)
        .enableInDim(
            MehenBelt,
            Asteroids,
            Mars,
            EndAsteroids)
        .enableInDim(OW)),

    Lapis(new SmallOreBuilder().name("ore.small.lapis")
        .heightRange(10, 50)
        .amount(4)
        .ore(Materials.Lapis)
        .enableInDim(MehenBelt)
        .enableInDim(OW)),

    Diamond(new SmallOreBuilder().name("ore.small.diamond")
        .heightRange(5, 15)
        .amount(2)
        .ore(Materials.Diamond)
        .enableInDim(Asteroids)
        .enableInDim(OW)),

    Emerald(new SmallOreBuilder().name("ore.small.emerald")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Emerald)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Ruby(new SmallOreBuilder().name("ore.small.ruby")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Ruby)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Sapphire(new SmallOreBuilder().name("ore.small.sapphire")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Sapphire)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Greensapphire(new SmallOreBuilder().name("ore.small.greensapphire")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.GreenSapphire)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Olivine(new SmallOreBuilder().name("ore.small.olivine")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Olivine)
        .enableInDim(Horus, MehenBelt)
        .enableInDim(OW)),

    Topaz(new SmallOreBuilder().name("ore.small.topaz")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Topaz)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Tanzanite(new SmallOreBuilder().name("ore.small.tanzanite")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Tanzanite)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Amethyst(new SmallOreBuilder().name("ore.small.amethyst")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Amethyst)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Opal(new SmallOreBuilder().name("ore.small.opal")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Opal)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Jasper(new SmallOreBuilder().name("ore.small.jasper")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Jasper)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Bluetopaz(new SmallOreBuilder().name("ore.small.bluetopaz")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.BlueTopaz)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Amber(new SmallOreBuilder().name("ore.small.amber")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Amber)
        .enableInDim(OW)),

    Foolsruby(new SmallOreBuilder().name("ore.small.foolsruby")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.FoolsRuby)
        .enableInDim(Horus)),

    Garnetred(new SmallOreBuilder().name("ore.small.garnetred")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.GarnetRed)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Garnetyellow(new SmallOreBuilder().name("ore.small.garnetyellow")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.GarnetYellow)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Redstone(new SmallOreBuilder().name("ore.small.redstone")
        .heightRange(5, 25)
        .amount(8)
        .ore(Materials.Redstone)
        .enableInDim(Mars)
        .enableInDim(NETHER, OW)),

    Netherquartz(new SmallOreBuilder().name("ore.small.netherquartz")
        .heightRange(30, 120)
        .amount(64)
        .ore(Materials.NetherQuartz)
        .enableInDim(NETHER)),

    Saltpeter(new SmallOreBuilder().name("ore.small.saltpeter")
        .heightRange(10, 60)
        .amount(8)
        .ore(Materials.Saltpeter)
        .enableInDim(Mars)
        .enableInDim(NETHER)),

    Sulfur(new SmallOreBuilder().name("ore.small.sulfur")
        .heightRange(5, 60)
        .amount(40)
        .ore(Materials.Sulfur)
        .enableInDim(NETHER)),

    Titanium(new SmallOreBuilder().name("ore.small.titanium")
        .heightRange(10, 180)
        .amount(32)
        .ore(Materials.Titanium)
        .enableInDim(
            MehenBelt,
            Asteroids,
            Mars)

    ),

    Tungsten(new SmallOreBuilder().name("ore.small.tungsten")
        .heightRange(10, 120)
        .amount(16)
        .ore(Materials.Tungsten)
        .enableInDim(Mars)),

    Meteoriciron(new SmallOreBuilder().name("ore.small.meteoriciron")
        .heightRange(50, 70)
        .amount(8)
        .ore(Materials.MeteoricIron)
        .enableInDim(Moon, Mars)),

    Firestone(new SmallOreBuilder().name("ore.small.firestone")
        .heightRange(5, 15)
        .amount(2)
        .ore(Materials.Firestone)
        .enableInDim(NETHER)),

    Neutronium(new SmallOreBuilder().name("ore.small.neutronium")
        .heightRange(5, 15)
        .amount(8)
        .ore(Materials.Neutronium)
        .enableInDim(MehenBelt)),

    Chromite(new SmallOreBuilder().name("ore.small.chromite")
        .heightRange(20, 40)
        .amount(8)
        .ore(Materials.Chromite)
        .enableInDim(
            MehenBelt,
            Asteroids,
            Mars)),

    Tungstate(new SmallOreBuilder().name("ore.small.tungstate")
        .heightRange(20, 40)
        .amount(8)
        .ore(Materials.Tungstate)
        .enableInDim(
            Asteroids,
            Mars)),

    Naquadah(new SmallOreBuilder().name("ore.small.naquadah")
        .heightRange(5, 25)
        .amount(8)
        .ore(Materials.Naquadah)
        .enableInDim(Asteroids)),

    Quantium(new SmallOreBuilder().name("ore.small.quantium")
        .heightRange(5, 25)
        .amount(6)
        .ore(Materials.Quantium)
        .enableInDim(Seth)),

    Mythril(new SmallOreBuilder().name("ore.small.mythril")
        .heightRange(5, 25)
        .amount(6)
        .ore(Materials.Mytryl)
        .enableInDim(Horus)),

    Ledox(new SmallOreBuilder().name("ore.small.ledox")
        .heightRange(40, 60)
        .amount(4)
        .ore(Materials.Ledox)
        .enableInDim(MehenBelt)),

    Oriharukon(new SmallOreBuilder().name("ore.small.oriharukon")
        .heightRange(20, 40)
        .amount(6)
        .ore(Materials.Oriharukon)
        .enableInDim(Mars)),

    Draconium(new SmallOreBuilder().name("ore.small.draconium")
        .heightRange(5, 15)
        .amount(4)
        .ore(Materials.Draconium)
        .enableInDim(Seth)),

    Awdraconium(new SmallOreBuilder().name("ore.small.awdraconium")
        .heightRange(5, 15)
        .amount(2)
        .ore(Materials.DraconiumAwakened)
        .enableInDim(Seth)),

    Desh(new SmallOreBuilder().name("ore.small.desh")
        .heightRange(10, 30)
        .amount(6)
        .ore(Materials.Desh)
        .enableInDim(Asteroids)),

    Blackplutonium(new SmallOreBuilder().name("ore.small.blackplutonium")
        .heightRange(25, 45)
        .amount(6)
        .ore(Materials.BlackPlutonium)
        .enableInDim(Anubis)),

    Infinitycatalyst(new SmallOreBuilder().name("ore.small.infinitycatalyst")
        .heightRange(40, 80)
        .amount(6)
        .ore(Materials.InfinityCatalyst)
        .enableInDim(Anubis)),

    Infinity(new SmallOreBuilder().name("ore.small.infinity")
        .heightRange(2, 40)
        .amount(2)
        .ore(Materials.Infinity)
        .disabledByDefault()),

    Bedrockium(new SmallOreBuilder().name("ore.small.bedrockium")
        .heightRange(5, 25)
        .amount(6)
        .ore(Materials.Bedrockium)
        .enableInDim(Seth)),

    Realgar(new SmallOreBuilder().name("ore.small.realgar")
        .heightRange(15, 85)
        .amount(32)
        .ore(Materials.Realgar)
        .enableInDim(NETHER)),

    Certusquartz(new SmallOreBuilder().name("ore.small.certusquartz")
        .heightRange(5, 115)
        .amount(16)
        .ore(Materials.CertusQuartz)
        .enableInDim(Horus)
        .enableInDim(NETHER)),

    Jade(new SmallOreBuilder().name("ore.small.jade")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.Jade)
        .enableInDim(Horus)
        .enableInDim(OW)),

    Deepiron(new SmallOreBuilder().name("ore.small.deepiron")
        .heightRange(5, 40)
        .amount(8)
        .ore(Materials.DeepIron)
        .enableInDim(Moon)),

    Redgarnet(new SmallOreBuilder().name("ore.small.redgarnet")
        .heightRange(5, 35)
        .amount(2)
        .ore(Materials.GarnetRed)
        .enableInDim(Horus)),

    Chargedcertus(new SmallOreBuilder().name("ore.small.chargedcertus")
        .heightRange(5, 115)
        .amount(4)
        .ore(Materials.CertusQuartzCharged)
        .enableInDim(Horus)),;
    // spotless : on

    public final SmallOreBuilder smallOreBuilder;

    SmallOres(gregtech.common.SmallOreBuilder smallOreBuilder) {
        this.smallOreBuilder = smallOreBuilder;
    }

    public WorldgenGTOreSmallPieces addGTSmallOre() {
        return new WorldgenGTOreSmallPieces(this.smallOreBuilder);
    }

    public WorldgenOreSmallSpace addGaGregSmallOre() {
        return new WorldgenOreSmallSpace(this.smallOreBuilder);
    }
}
