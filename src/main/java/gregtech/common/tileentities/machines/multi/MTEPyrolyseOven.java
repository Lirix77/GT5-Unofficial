package gregtech.common.tileentities.machines.multi;

import static com.gtnewhorizon.structurelib.structure.StructureUtility.onElementPass;
import static gregtech.api.enums.HatchElement.Energy;
import static gregtech.api.enums.HatchElement.InputBus;
import static gregtech.api.enums.HatchElement.InputHatch;
import static gregtech.api.enums.HatchElement.Maintenance;
import static gregtech.api.enums.HatchElement.Muffler;
import static gregtech.api.enums.HatchElement.OutputBus;
import static gregtech.api.enums.HatchElement.OutputHatch;
import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.api.util.GTStructureUtility.buildHatchAdder;
import static gregtech.api.util.GTStructureUtility.ofCoil;
import static gregtech.api.util.GTStructureUtility.ofFrame;

import gregtech.api.GregTechAPI;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.structurelib.alignment.constructable.ISurvivalConstructable;
import com.gtnewhorizon.structurelib.structure.IStructureDefinition;
import com.gtnewhorizon.structurelib.structure.ISurvivalBuildEnvironment;
import com.gtnewhorizon.structurelib.structure.StructureDefinition;

import gregtech.GTMod;
import gregtech.api.casing.Casings;
import gregtech.api.enums.HeatingCoilLevel;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.logic.ProcessingLogic;
import gregtech.api.metatileentity.implementations.MTEExtendedPowerMultiBlockBase;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.recipe.RecipeMaps;
import gregtech.api.recipe.check.CheckRecipeResult;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.MultiblockTooltipBuilder;

public class MTEPyrolyseOven extends MTEExtendedPowerMultiBlockBase<MTEPyrolyseOven> implements ISurvivalConstructable {

    private static final String STRUCTURE_PIECE_MAIN = "main";
    private static final int OFFSET_X = 3;
    private static final int OFFSET_Y = 4;
    private static final int OFFSET_Z = 0;
    private HeatingCoilLevel coilHeat;
    private int casingAmount;

    private static final IStructureDefinition<MTEPyrolyseOven> STRUCTURE_DEFINITION = StructureDefinition
        .<MTEPyrolyseOven>builder()
        .addShape(
            STRUCTURE_PIECE_MAIN,
            new String[][] { { "       ", "       ", " F   F ", "FBF FBF", "DBD~DBD", "GGGGGGG" },
                { "       ", "       ", " C   C ", "F FFF F", "D D D D", "GCGGGCG" },
                { "       ", "       ", " C   C ", "F FFF F", "D     D", "GCGGGCG" },
                { "       ", "       ", " C   C ", "F FFF F", "D D D D", "GCGGGCG" },
                { " E   E ", " A   A ", " A   A ", "FAF FAF", "DADDDAD", "GGGGGGG" } })
        .addElement('A', Casings.SteelPipeCasing.asElement())
        .addElement('B', Casings.SteelFireboxCasing.asElement())
        .addElement(
            'C', ofCoil(MTEPyrolyseOven::setCoilLevel, MTEPyrolyseOven::getCoilLevel))
        .addElement('D', onElementPass(MTEPyrolyseOven::onCasingAdded, Casings.PyrolyseOvenCasing.asElement()))
        .addElement('E', ofFrame(Materials.Steel))
        .addElement(
            'F',
            buildHatchAdder(MTEPyrolyseOven.class).atLeast(InputBus, InputHatch, Muffler)
                .casingIndex(Casings.PyrolyseOvenCasing.textureId)
                .dot(2)
                .buildAndChain(onElementPass(MTEPyrolyseOven::onCasingAdded, Casings.PyrolyseOvenCasing.asElement())))
        .addElement(
            'G',
            buildHatchAdder(MTEPyrolyseOven.class).atLeast(OutputBus, OutputHatch, Energy, Maintenance)
                .casingIndex(Casings.PyrolyseOvenCasing.textureId)
                .dot(1)
                .buildAndChain(onElementPass(MTEPyrolyseOven::onCasingAdded, Casings.PyrolyseOvenCasing.asElement())))
        .build();

    public MTEPyrolyseOven(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
    }

    public MTEPyrolyseOven(String aName) {
        super(aName);
    }

    @Override
    protected MultiblockTooltipBuilder createTooltip() {
        final MultiblockTooltipBuilder tt = new MultiblockTooltipBuilder();
        tt.addMachineType("Coke Oven")
            .addInfo("Industrial Charcoal producer")
            .addInfo("Processing speed scales linearly with Coil tier:")
            .addInfo("CuNi: 50%, FeAlCr: 100%, Ni4Cr: 150%, TPV: 200%, etc.")
            .addInfo("EU/t is not affected by Coil tier")
            .addPollutionAmount(getPollutionPerSecond(null))
            .beginStructureBlock(7, 6, 5, false)
            .addController("Front center")
            .addCasingInfoMin("Pyrolyse Oven Casing", 60, false)
            .addCasingInfoExactly("Heating Coils", 12, true)
            .addCasingInfoExactly("Steel Frame Box", 2, false)
            .addCasingInfoExactly("Steel Pipe Casing", 8, false)
            .addCasingInfoExactly("Steel Firebox Casing", 4, false)
            .addEnergyHatch("Any bottom layer casing", 1)
            .addMaintenanceHatch("Any bottom layer casing", 1)
            .addMufflerHatch("Any top layer casing", 2)
            .addInputBus("Any top layer casing", 2)
            .addInputHatch("Any top layer casing", 2)
            .addOutputBus("Any bottom layer casing", 1)
            .addOutputHatch("Any bottom layer casing", 1)
            .toolTipFinisher();
        return tt;
    }

    @Override
    public ITexture[] getTexture(IGregTechTileEntity baseMetaTileEntity, ForgeDirection sideDirection,
        ForgeDirection facingDirection, int colorIndex, boolean active, boolean redstoneLevel) {
        if (sideDirection == facingDirection) {
            if (active) return new ITexture[] { Casings.PyrolyseOvenCasing.getCasingTexture(), TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_PYROLYSE_OVEN_ACTIVE)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_PYROLYSE_OVEN_ACTIVE_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
            return new ITexture[] { Casings.PyrolyseOvenCasing.getCasingTexture(), TextureFactory.builder()
                .addIcon(OVERLAY_FRONT_PYROLYSE_OVEN)
                .extFacing()
                .build(),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_PYROLYSE_OVEN_GLOW)
                    .extFacing()
                    .glow()
                    .build() };
        }
        return new ITexture[] { Casings.PyrolyseOvenCasing.getCasingTexture() };
    }

    @Override
    public boolean supportsSingleRecipeLocking() {
        return true;
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return RecipeMaps.pyrolyseRecipes;
    }

    @Override
    protected ProcessingLogic createProcessingLogic() {
        return new ProcessingLogic() {

            @NotNull
            @Override
            public CheckRecipeResult process() {
                setSpeedBonus(2f / (1 + coilHeat.getTier()));
                return super.process();
            }
        };
    }

    @Override
    public IStructureDefinition<MTEPyrolyseOven> getStructureDefinition() {
        return STRUCTURE_DEFINITION;
    }

    private void onCasingAdded() {
        casingAmount++;
    }

    public HeatingCoilLevel getCoilLevel() {
        return coilHeat;
    }

    private void setCoilLevel(HeatingCoilLevel aCoilLevel) {
        coilHeat = aCoilLevel;
    }

    @Override
    public boolean checkMachine(IGregTechTileEntity aBaseMetaTileEntity, ItemStack aStack) {
        coilHeat = HeatingCoilLevel.None;
        casingAmount = 0;
        replaceDeprecatedCoils(aBaseMetaTileEntity);
        return checkPiece(STRUCTURE_PIECE_MAIN, OFFSET_X, OFFSET_Y, OFFSET_Z) && casingAmount >= 60
            && !mMufflerHatches.isEmpty();
    }

    @Override
    public boolean isCorrectMachinePart(ItemStack aStack) {
        return true;
    }

    @Override
    public int getMaxEfficiency(ItemStack aStack) {
        return 10000;
    }

    @Override
    public int getPollutionPerSecond(ItemStack aStack) {
        return GTMod.gregtechproxy.mPollutionPyrolyseOvenPerSecond;
    }

    @Override
    public int getDamageToComponent(ItemStack aStack) {
        return 0;
    }

    @Override
    public boolean explodesOnComponentBreak(ItemStack aStack) {
        return false;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEPyrolyseOven(this.mName);
    }

    private void replaceDeprecatedCoils(IGregTechTileEntity aBaseMetaTileEntity) {
        final int xDir = aBaseMetaTileEntity.getBackFacing().offsetX;
        final int zDir = aBaseMetaTileEntity.getBackFacing().offsetZ;
        final int tX = aBaseMetaTileEntity.getXCoord() + xDir * 2;
        final int tY = aBaseMetaTileEntity.getYCoord();
        final int tZ = aBaseMetaTileEntity.getZCoord() + zDir * 2;
        for (int xPos = tX - 1; xPos <= tX + 1; xPos++) {
            for (int zPos = tZ - 1; zPos <= tZ + 1; zPos++) {
                if (aBaseMetaTileEntity.getBlock(xPos, tY, zPos) == GregTechAPI.sBlockCasings1
                    && aBaseMetaTileEntity.getMetaID(xPos, tY, zPos) == 13) {
                    aBaseMetaTileEntity.getWorld()
                        .setBlock(xPos, tY, zPos, GregTechAPI.sBlockCasings5, 1, 3);
                }
            }
        }
    }

    @Override
    public void construct(ItemStack stackSize, boolean hintsOnly) {
        buildPiece(STRUCTURE_PIECE_MAIN, stackSize, hintsOnly, OFFSET_X, OFFSET_Y, OFFSET_Z);
    }

    @Override
    public int survivalConstruct(ItemStack stackSize, int elementBudget, ISurvivalBuildEnvironment env) {
        if (mMachine) return -1;
        return survivialBuildPiece(
            STRUCTURE_PIECE_MAIN,
            stackSize,
            OFFSET_X,
            OFFSET_Y,
            OFFSET_Z,
            elementBudget,
            env,
            false,
            true);
    }

    @Override
    public boolean supportsVoidProtection() {
        return true;
    }
}
