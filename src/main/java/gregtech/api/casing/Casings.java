package gregtech.api.casing;

import net.minecraft.block.Block;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhlib.util.data.BlockSupplier;

import gregtech.api.GregTechAPI;
import tectech.thing.casing.BlockGTCasingsTT;

public enum Casings implements ICasing {

    // spotless:off
    // I know this indenting looks weird, but I think it makes it easier to read because everything is aligned

    // For some reason a couple of these blockCasings2Misc casings don't register their textures in the expected indices
    // Instead, block casings 5 uses these indices
    // Why? Idk, blame alk or something
//Block Casings 1
    ULVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 0, gt(0, 0, 0)),
    LVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 1, gt(0, 0, 1)),
    MVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 2, gt(0, 0, 2)),
    HVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 3, gt(0, 0, 3)),
    EVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 4, gt(0, 0, 4)),
    IVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 5, gt(0, 0, 5)),
    LuVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 6, gt(0, 0, 6)),
    ZPMMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 7, gt(0, 0, 7)),
    UVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 8, gt(0, 0, 8)),
    UHVMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 9, gt(0, 0, 9)),
    BronzePlatedBricks
        (() -> GregTechAPI.sBlockCasings1, 10, gt(0, 0, 10)),
    HeatProofMachineCasing
        (() -> GregTechAPI.sBlockCasings1, 11, gt(0, 0, 11)),
    DimensionallyTranscendentCasing
        (() -> GregTechAPI.sBlockCasings1, 12, gt(0, 0, 12)),
    DimensionalInjectionCasing
        (() -> GregTechAPI.sBlockCasings1, 13, gt(0, 0, 13)),
    DimensionalBridge
        (() -> GregTechAPI.sBlockCasings1, 14, gt(0, 0, 14)),
    SuperconductingCoilBlock
        (() -> GregTechAPI.sBlockCasings1, 15, gt(0, 0, 15)),

    // Block Casings 2
    SolidSteelMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 0, gt(0, 1, 0)),
    FrostProofMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 1, gt(0, 1, 1)),
    BronzeGearBoxCasing
        (() -> GregTechAPI.sBlockCasings2, 2, gt(0, 1, 2)),
    SteelGearBoxCasing
        (() -> GregTechAPI.sBlockCasings2, 3, gt(0, 1, 3)),
    TitaniumGearBoxCasing
        (() -> GregTechAPI.sBlockCasings2, 4, gt(0, 1, 4)),
    AssemblyLineCasing
        (() -> GregTechAPI.sBlockCasings2, 5, gt(0, 1, 5)),
    ProcessorMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 6, gt(0, 1, 6)),
    DataDriveMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 7, gt(0, 1, 7)),
    ContainmentFieldMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 8, gt(0, 1, 8)),
    AssemblerMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 9, gt(0, 1, 9)),
    PumpMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 10, gt(0, 1, 10)),
    MotorMachineCasing
        (() -> GregTechAPI.sBlockCasings2, 11, gt(0, 1, 11)),
    BronzePipeCasing
        (() -> GregTechAPI.sBlockCasings2, 12, gt(0, 1, 12)),
    SteelPipeCasing
        (() -> GregTechAPI.sBlockCasings2, 13, gt(0, 1, 13)),
    TitaniumPipeCasing
        (() -> GregTechAPI.sBlockCasings2, 14, gt(0, 1, 14)),
    TungstensteelPipeCasing
        (() -> GregTechAPI.sBlockCasings2, 15, gt(0, 1, 15)),

    // Block Casings 3
    YellowStripesBlockA
        (() -> GregTechAPI.sBlockCasings3, 0, gt(0, 2, 0)),
    YellowStripesBlockB
        (() -> GregTechAPI.sBlockCasings3, 1, gt(0, 2, 1)),
    RadioactiveHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 2, gt(0, 2, 2)),
    BioHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 3, gt(0, 2, 3)),
    ExplosionHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 4, gt(0, 2, 4)),
    FireHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 5, gt(0, 2, 5)),
    AcidHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 6, gt(0, 2, 6)),
    MagicHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 7, gt(0, 2, 7)),
    FrostHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 8, gt(0, 2, 8)),
    NoiseHazardSignBlock
        (() -> GregTechAPI.sBlockCasings3, 9, gt(0, 2, 9)),
    GrateMachineCasing
        (() -> GregTechAPI.sBlockCasings3, 10, gt(0, 2, 10)),
    FilterMachineCasing
        (() -> GregTechAPI.sBlockCasings3, 11, gt(0, 2, 11)),
    RadiationProofMachineCasing
        (() -> GregTechAPI.sBlockCasings3, 12, gt(0, 2, 12)),
    BronzeFireboxCasing
        (() -> GregTechAPI.sBlockCasings3, 13, gt(0, 2, 13)),
    SteelFireboxCasing
        (() -> GregTechAPI.sBlockCasings3, 14, gt(0, 2, 14)),
    TungstensteelFireboxCasing
        (() -> GregTechAPI.sBlockCasings3, 15, gt(0, 2, 15)),

    // Block Casings 4
    RobustTungstenSteelMachineCasing
        (() -> GregTechAPI.sBlockCasings4, 0, gt(0, 3, 0)),
    CleanStainlessSteelMachineCasing
        (() -> GregTechAPI.sBlockCasings4, 1, gt(0,3,1)),
    StableTitaniumMachineCasing
        (() -> GregTechAPI.sBlockCasings4, 2, gt(0, 3, 2)),
    TitaniumFireboxCasing
        (() -> GregTechAPI.sBlockCasings4, 3, gt(0, 3, 3)),
    FusionMachineCasing
        (() -> GregTechAPI.sBlockCasings4, 6, gt(0, 3, 6)),
    FusionCoilBlock
        (() -> GregTechAPI.sBlockCasings4, 7, gt(0, 3, 7)),
    FusionMachineCasingMKII
        (() -> GregTechAPI.sBlockCasings4, 8, gt(0, 3, 8)),
    TurbineCasing
        (() -> GregTechAPI.sBlockCasings4, 9, gt(0, 3, 9)),
    StainlessSteelTurbineCasing
        (() -> GregTechAPI.sBlockCasings4, 10, gt(0, 3, 10)),
    TitaniumTurbineCasing
        (() -> GregTechAPI.sBlockCasings4, 11, gt(0, 3, 11)),
    TungstensteelTurbineCasing
        (() -> GregTechAPI.sBlockCasings4, 12, gt(0, 3, 12)),
    EngineIntakeCasing
        (() -> GregTechAPI.sBlockCasings4, 13, gt(0, 3, 13)),
    MiningOsmiridiumCasing
        (() -> GregTechAPI.sBlockCasings4, 14, gt(0, 3, 14)),
    Firebricks
        (() -> GregTechAPI.sBlockCasings4, 15, gt(0, 3, 15)),

    // Block Casings 5
    CupronickelCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 0, gt(1, 0, 0)),
    KanthalCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 1, gt(1,0,1)),
    NichromeCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 2, gt(1, 0, 2)),
    TPVCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 3, gt(1, 0, 3)),
    HSSGCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 4, gt(1, 0, 4)),
    HSSSCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 9, gt(1, 0, 9)),
    NaquadahCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 5, gt(1, 0, 5)),
    NaquadahAlloyCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 6, gt(1, 0, 6)),
    TriniumCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 10, gt(1, 0, 10)),
    ElectrumFluxCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 8, gt(1, 0, 8)),
    AwakenedDraconiumCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 9, gt(1, 0, 9)),
    InfinityCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 11, gt(1, 0, 11)),
    HypogenCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 12, gt(1, 0, 12)),
    EternalCoilBlock
        (() -> GregTechAPI.sBlockCasings5, 13, gt(1, 0, 13)),

    // Block Casings 6
    HermeticCasing
        (() -> GregTechAPI.sBlockCasings6, 0, gt(8, 7, 0)),
    HermeticCasing1
        (() -> GregTechAPI.sBlockCasings6, 1, gt(8,7,1)),
    HermeticCasing2
        (() -> GregTechAPI.sBlockCasings6, 2, gt(8, 7, 2)),
    HermeticCasing3
        (() -> GregTechAPI.sBlockCasings6, 3, gt(8, 7, 3)),
    HermeticCasing4
        (() -> GregTechAPI.sBlockCasings6, 4, gt(8, 7, 4)),
    HermeticCasing5
        (() -> GregTechAPI.sBlockCasings6, 5, gt(8, 7, 5)),
    HermeticCasing6
        (() -> GregTechAPI.sBlockCasings6, 6, gt(8, 7, 6)),
    HermeticCasing7
        (() -> GregTechAPI.sBlockCasings6, 7, gt(8, 7, 7)),
    HermeticCasing8
        (() -> GregTechAPI.sBlockCasings6, 8, gt(8, 7, 8)),
    HermeticCasing9
        (() -> GregTechAPI.sBlockCasings6, 9, gt(8, 7, 9)),
    HermeticCasing10
        (() -> GregTechAPI.sBlockCasings6, 10, gt(8, 7, 10)),
    HermeticCasing11
        (() -> GregTechAPI.sBlockCasings6, 11, gt(8, 7, 11)),
    HermeticCasing12
        (() -> GregTechAPI.sBlockCasings6, 12, gt(8, 7, 12)),
    HermeticCasing13
        (() -> GregTechAPI.sBlockCasings6, 13, gt(8, 7, 13)),
    HermeticCasing14
        (() -> GregTechAPI.sBlockCasings6, 14, gt(8, 7, 14)),

    // Block Casings 8
    ChemicallyInertMachineCasing
        (() -> GregTechAPI.sBlockCasings8, 0, gt(1, 3, 0)),
    PTFEPipeCasing
        (() -> GregTechAPI.sBlockCasings8, 1, gt(1,3,1)),
    MiningNeutroniumCasing
        (() -> GregTechAPI.sBlockCasings8, 2, gt(1, 3, 2)),
    MiningBlackPlutoniumCasing
        (() -> GregTechAPI.sBlockCasings8, 3, gt(1, 3, 3)),
    ExtremeEngineIntakeCasing
        (() -> GregTechAPI.sBlockCasings8, 4, gt(1, 3, 4)),
    EuropiumReinforcedRadiationProofMachineCasing
        (() -> GregTechAPI.sBlockCasings8, 5, gt(1, 3, 5)),
    AdvancedRhodiumPlatedPalladiumMachineCasing
        (() -> GregTechAPI.sBlockCasings8, 6, gt(1, 3, 6)),
    AdvancedIridiumPlatedMachineCasing
        (() -> GregTechAPI.sBlockCasings8, 7, gt(1, 3, 7)),
    MagicalMachineCasing
        (() -> GregTechAPI.sBlockCasings8, 8, gt(1, 3, 8)),
    RadiantNaquadahAlloyCasing
        (() -> GregTechAPI.sBlockCasings8, 10, gt(1, 3, 10)),
    BasicPhotolithographicFrameworkCasing
        (() -> GregTechAPI.sBlockCasings8, 11, gt(1, 3, 11)),
    ReinforcedPhotolithographicFrameworkCasing
        (() -> GregTechAPI.sBlockCasings8, 12, gt(1, 3, 12)),
    RadiationProofPhotolithographicFrameworkCasing
        (() -> GregTechAPI.sBlockCasings8, 13, gt(1, 3, 13)),
    InfinityCooledCasing
        (() -> GregTechAPI.sBlockCasings8, 14, gt(1, 3, 14)),

    // Block Casings 9
    PBIPipeCasing
        (() -> GregTechAPI.sBlockCasings9, 0, gt(16, 1, 0)),
    AdvancedFilterCasing
        (() -> GregTechAPI.sBlockCasings9, 1, gt(16, 1, 1)),
    PrimitiveWoodenCasing
        (() -> GregTechAPI.sBlockCasings9, 2, gt(16, 1, 2)),
    SuperplasticizerTreatedHighStrengthConcrete
        (() -> GregTechAPI.sBlockCasings9, 3, gt(16, 1, 3)),
    SterileWaterPlantCasing
        (() -> GregTechAPI.sBlockCasings9, 4, gt(16, 1, 4)),
    ReinforcedSterileWaterPlantCasing
        (() -> GregTechAPI.sBlockCasings9, 5, gt(16, 1, 5)),
    SlickSterileFlocculationCasing
        (() -> GregTechAPI.sBlockCasings9, 6, gt(16, 1, 6)),
    StabilizedNaquadahWaterPlantCasing
        (() -> GregTechAPI.sBlockCasings9, 7, gt(16, 1, 7)),
    InertNeutralizationWaterPlantCasing
        (() -> GregTechAPI.sBlockCasings9, 8, gt(16, 1, 8)),
    ReactiveGasContainmentCasing
        (() -> GregTechAPI.sBlockCasings9, 9, gt(16, 1, 9)),
    InertFiltrationCasing
        (() -> GregTechAPI.sBlockCasings9, 10, gt(16, 1, 10)),
    HeatResistantTriniumPlatedCasing
        (() -> GregTechAPI.sBlockCasings9, 11, gt(16, 1, 11)),
    NaquadriaReinforcedWaterPlantCasing
        (() -> GregTechAPI.sBlockCasings9, 12, gt(16, 1, 12)),
    HighEnergyUltravioletEmitterCasing
        (() -> GregTechAPI.sBlockCasings9, 13, gt(16, 1, 13)),
    ParticleBeamGuidancePipeCasing
        (() -> GregTechAPI.sBlockCasings9, 14, gt(16, 1, 14)),
    FemtometerCalibratedParticleBeamCasing
        (() -> GregTechAPI.sBlockCasings9, 15, gt(16, 1, 15)),

    // Block Casings 10
    MagTechCasing
        (() -> GregTechAPI.sBlockCasings10, 0, gt(16, 3, 0)),
    LaserContainmentCasing
        (() -> GregTechAPI.sBlockCasings10, 1, gt(16, 3, 1)),
    QuarkExclusionCasing
        (() -> GregTechAPI.sBlockCasings10, 2, gt(16, 3, 2)),
    PressureContainmentCasing
        (() -> GregTechAPI.sBlockCasings10, 3, gt(16, 3, 3)),
    ElectricCompressorCasing
        (() -> GregTechAPI.sBlockCasings10, 4, gt(16, 3, 4)),
    CompressionPipeCasing
        (() -> GregTechAPI.sBlockCasings10, 5, gt(16, 3, 5)),
    NeutroniumCasing
        (() -> GregTechAPI.sBlockCasings10, 6, gt(16, 3, 6)),
    ActiveNeutroniumCasing
        (() -> GregTechAPI.sBlockCasings10, 7, gt(16, 3, 7)),
    NeutroniumStabilizationCasing
        (() -> GregTechAPI.sBlockCasings10, 8, gt(16, 3, 8)),
    CoolantDuct
        (() -> GregTechAPI.sBlockCasings10, 9, gt(16, 3, 9)),
    HeatingDuct
        (() -> GregTechAPI.sBlockCasings10, 10, gt(16, 3, 10)),
    ExtremeDensitySpaceBendingCasing
        (() -> GregTechAPI.sBlockCasings10, 11, gt(16, 3, 11)),
    BackgroundRadiationAbsorbentCasing
        (() -> GregTechAPI.sBlockCasings10, 12, gt(16, 3, 12)),
    SolidifierCasing
        (() -> GregTechAPI.sBlockCasings10, 13, gt(16, 3, 13)),
    SolidifierRadiator
        (() -> GregTechAPI.sBlockCasings10, 14, gt(16, 3, 14)),
    ReinforcedWoodenCasing
        (() -> GregTechAPI.sBlockCasings10, 15, gt(16, 3, 15)),

    // Block Casings 11
    TinItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 0, gt(16, 4, 0)),
    BrassItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 1, gt(16, 4, 1)),
    ElectrumItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 2, gt(16, 4, 2)),
    PlatinumItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 3, gt(16, 4, 3)),
    OsmiumItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 4, gt(16, 4, 4)),
    QuantiumItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 5, gt(16, 4, 5)),
    FluxedElectrumItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 6, gt(16, 4, 6)),
    BlackPlutoniumItemPipeCasing
        (() -> GregTechAPI.sBlockCasings11, 7, gt(16, 4, 7)),
    // Block Casings NH
    AirFilterTurbineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 0, gt(8, 4, 0)),
    AirFilterVentCasing
        (() -> GregTechAPI.sBlockCasingsNH, 1, gt(8, 4, 1)),
    PyrolyseOvenCasing
        (() -> GregTechAPI.sBlockCasingsNH, 2, gt(8, 4, 2)),
    AdvancedAirFilterTurbineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 3, gt(8, 4, 3)),
    AdvancedAirFilterVentCasing
        (() -> GregTechAPI.sBlockCasingsNH, 4, gt(8, 4, 4)),
    SuperAirFilterTurbineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 5, gt(8, 4, 5)),
    SuperAirFilterVentCasing
        (() -> GregTechAPI.sBlockCasingsNH, 6, gt(8, 4, 6)),
    UEVMachineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 10, gt(8, 4, 10)),
    UIVMachineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 11, gt(8, 4, 11)),
    UMVMachineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 12, gt(8, 4, 12)),
    UXVMachineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 13, gt(8, 4, 13)),
    MAXMachineCasing
        (() -> GregTechAPI.sBlockCasingsNH, 14, gt(8, 4, 14)),

    ;
    // spotless:on


    public final BlockSupplier blockGetter;
    public final int meta;
    public final int textureId;

    Casings(BlockSupplier blockGetter, int meta, int textureId) {
        this.blockGetter = blockGetter;
        this.meta = meta;
        this.textureId = textureId;
    }

    @Override
    public @NotNull Block getBlock() {
        return blockGetter.get();
    }

    @Override
    public int getBlockMeta() {
        return meta;
    }

    @Override
    public int getTextureId() {
        if (textureId == -1) {
            throw new UnsupportedOperationException(
                "Casing " + name() + " does not have a casing texture; The result of getTextureId() is undefined.");
        }

        return textureId;
    }

    private static int gt(int page, int id) {
        return page * 128 + id;
    }

    private static int gt(int page, int casing, int id) {
        return page * 128 + casing * 16 + id;
    }

    private static int gtpp(int page, int id) {
        int aRealID = id + (page * 16);
        return 64 + aRealID;
    }

    private static int tt(int id) {
        return BlockGTCasingsTT.textureOffset + id;
    }
}
