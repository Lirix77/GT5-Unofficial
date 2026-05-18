package gregtech.common.tileentities.machines.basic;

import static gregtech.api.enums.GTValues.D1;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.api.recipe.RecipeMaps.scannerFakeRecipes;

import java.util.List;
import java.util.Objects;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.util.ForgeDirection;

import com.sinthoras.visualprospecting.Tags;
import com.sinthoras.visualprospecting.database.OreVeinPosition;
import com.sinthoras.visualprospecting.database.ServerCache;

import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IIndividual;
import gregtech.GTMod;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MachineType;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SoundResource;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.MTEBasicMachine;
import gregtech.api.objects.ItemData;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.AssemblyLineUtils;
import gregtech.api.util.GTLog;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipe;
import gregtech.api.util.GTUtility;
import gregtech.common.items.behaviors.BehaviourDataOrb;

public class MTEScanner extends MTEBasicMachine {

    public MTEScanner(int aID, String aName, String aNameRegional, int aTier) {
        super(
            aID,
            aName,
            aNameRegional,
            aTier,
            1,
            MachineType.SCANNER.tooltipDescription(),
            1,
            1,
            TextureFactory.of(
                TextureFactory.of(OVERLAY_SIDE_SCANNER_ACTIVE),
                TextureFactory.builder()
                    .addIcon(OVERLAY_SIDE_SCANNER_ACTIVE_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_SIDE_SCANNER),
                TextureFactory.builder()
                    .addIcon(OVERLAY_SIDE_SCANNER_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_FRONT_SCANNER_ACTIVE),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_SCANNER_ACTIVE_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_FRONT_SCANNER),
                TextureFactory.builder()
                    .addIcon(OVERLAY_FRONT_SCANNER_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_TOP_SCANNER_ACTIVE),
                TextureFactory.builder()
                    .addIcon(OVERLAY_TOP_SCANNER_ACTIVE_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_TOP_SCANNER),
                TextureFactory.builder()
                    .addIcon(OVERLAY_TOP_SCANNER_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_BOTTOM_SCANNER_ACTIVE),
                TextureFactory.builder()
                    .addIcon(OVERLAY_BOTTOM_SCANNER_ACTIVE_GLOW)
                    .glow()
                    .build()),
            TextureFactory.of(
                TextureFactory.of(OVERLAY_BOTTOM_SCANNER),
                TextureFactory.builder()
                    .addIcon(OVERLAY_BOTTOM_SCANNER_GLOW)
                    .glow()
                    .build()));
    }

    public MTEScanner(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, 1, aDescription, aTextures, 1, 1);
    }

    @Override
    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MTEScanner(this.mName, this.mTier, this.mDescriptionArray, this.mTextures);
    }

    @Override
    public int checkRecipe() {
        ItemStack aStack = getInputAt(0);
        if (getOutputAt(0) != null) {
            this.mOutputBlocked += 1;
        } else if ((GTUtility.isStackValid(aStack)) && (aStack.stackSize > 0)) {
            if ((getFillableStack() != null) && (getFillableStack().containsFluid(Materials.Honey.getFluid(100L)))) {
                try {
                    IIndividual tIndividual = AlleleManager.alleleRegistry.getIndividual(aStack);
                    if (tIndividual != null) {
                        if (tIndividual.analyze()) {
                            getFillableStack().amount -= 100;
                            this.mOutputItems[0] = GTUtility.copyOrNull(aStack);
                            aStack.stackSize = 0;
                            NBTTagCompound tNBT = new NBTTagCompound();
                            tIndividual.writeToNBT(tNBT);
                            this.mOutputItems[0].setTagCompound(tNBT);
                            calculateOverclockedNess(2, 500);
                            // In case recipe is too OP for that machine
                            if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                                return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                            return 2;
                        }
                        this.mOutputItems[0] = GTUtility.copyOrNull(aStack);
                        aStack.stackSize = 0;
                        this.mMaxProgresstime = 1;
                        this.mEUt = 1;
                        return 2;
                    }
                } catch (Throwable e) {
                    if (D1) {
                        e.printStackTrace(GTLog.err);
                    }
                }
            }
            if (ItemList.IC2_Crop_Seeds.isStackEqual(aStack, true, true)) {
                NBTTagCompound tNBT = aStack.getTagCompound();
                if (tNBT == null) {
                    tNBT = new NBTTagCompound();
                }
                if (tNBT.getByte("scan") < 4) {
                    tNBT.setByte("scan", (byte) 4);
                    calculateOverclockedNess(8, 160);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                } else {
                    this.mMaxProgresstime = 1;
                    this.mEUt = 1;
                }
                aStack.stackSize -= 1;
                this.mOutputItems[0] = GTUtility.copyAmount(1, aStack);
                assert this.mOutputItems[0] != null;
                this.mOutputItems[0].setTagCompound(tNBT);
                return 2;
            }
            if (ItemList.Tool_DataOrb.isStackEqual(getSpecialSlot(), false, true)) {
                if (ItemList.Tool_DataOrb.isStackEqual(aStack, false, true)) {
                    aStack.stackSize -= 1;
                    this.mOutputItems[0] = GTUtility.copyAmount(1, getSpecialSlot());
                    calculateOverclockedNess(30, 512);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }
                ItemData tData = GTOreDictUnificator.getAssociation(aStack);
                if ((tData != null) && ((tData.mPrefix == OrePrefixes.dust) || (tData.mPrefix == OrePrefixes.cell))
                    && (tData.mMaterial.mMaterial.mElement != null)
                    && (!tData.mMaterial.mMaterial.mElement.mIsIsotope)
                    && (tData.mMaterial.mMaterial != Materials.Magic)
                    && (tData.mMaterial.mMaterial.getMass() > 0L)) {
                    getSpecialSlot().stackSize -= 1;
                    aStack.stackSize -= 1;

                    this.mOutputItems[0] = ItemList.Tool_DataOrb.get(1L);
                    BehaviourDataOrb.setDataTitle(this.mOutputItems[0], "Elemental-Scan");
                    BehaviourDataOrb.setDataName(this.mOutputItems[0], tData.mMaterial.mMaterial.mElement.name());
                    calculateOverclockedNess(30, GTUtility.safeInt(tData.mMaterial.mMaterial.getMass() * 8192L));
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }
            }
            if (ItemList.Tool_DataStick.isStackEqual(getSpecialSlot(), false, true)) {
                if (ItemList.Tool_DataStick.isStackEqual(aStack, false, true)) {
                    aStack.stackSize -= 1;
                    this.mOutputItems[0] = GTUtility.copyAmount(1, getSpecialSlot());
                    calculateOverclockedNess(30, 128);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }
                if (aStack.getItem() == Items.written_book) {
                    getSpecialSlot().stackSize -= 1;
                    aStack.stackSize -= 1;

                    this.mOutputItems[0] = GTUtility.copyAmount(1, getSpecialSlot());
                    assert this.mOutputItems[0] != null;
                    this.mOutputItems[0].setTagCompound(aStack.getTagCompound());
                    calculateOverclockedNess(30, 128);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }
                if (aStack.getItem() == Items.filled_map) {
                    getSpecialSlot().stackSize -= 1;
                    aStack.stackSize -= 1;

                    this.mOutputItems[0] = GTUtility.copyAmount(1, getSpecialSlot());
                    assert this.mOutputItems[0] != null;
                    this.mOutputItems[0].setTagCompound(
                        GTUtility
                            .getNBTContainingShort(new NBTTagCompound(), "map_id", (short) aStack.getItemDamage()));
                    calculateOverclockedNess(30, 128);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }

                if ((aStack.getItem()
                    .getUnlocalizedName()
                    .contains("Schematic")
                    || aStack.getItem()
                    .getUnlocalizedName()
                    .contains("schematic"))
                    && !aStack.getItem()
                    .getUnlocalizedName()
                    .contains("Schematics")) {
                    if (mTier < 3) return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    String sTier = "";

                    int stackItemID = Item.getIdFromItem(aStack.getItem());
                    int stackItemDamage = aStack.getItemDamage();
                    if (stackItemID == Item.getIdFromItem(
                        Objects.requireNonNull(GTModHandler.getModItem(GalacticraftCore.ID, "item.schematic", 1L, 0))
                            .getItem())) {
                        if (stackItemDamage == 0 && aStack.toString()
                            .equals(
                                Objects
                                    .requireNonNull(
                                        GTModHandler.getModItem(GalacticraftCore.ID, "item.schematic", 1L, 0))
                                    .copy()
                                    .toString()))
                            sTier = "100";
                        else if (stackItemDamage == 1 && aStack.toString()
                            .equals(
                                Objects
                                    .requireNonNull(
                                        GTModHandler.getModItem(GalacticraftCore.ID, "item.schematic", 1L, 1))
                                    .copy()
                                    .toString()))
                            sTier = "2";
                    } else {
                        if (stackItemID == Item.getIdFromItem(
                            Objects
                                .requireNonNull(GTModHandler.getModItem(GalacticraftMars.ID, "item.schematic", 1L, 0))
                                .getItem())) {
                            if (stackItemDamage == 0 && aStack.toString()
                                .equals(
                                    Objects
                                        .requireNonNull(
                                            GTModHandler.getModItem(GalacticraftMars.ID, "item.schematic", 1L, 0))
                                        .copy()
                                        .toString()))
                                sTier = "3";
                            else if (stackItemDamage == 1 && aStack.toString()
                                .equals(
                                    Objects
                                        .requireNonNull(
                                            GTModHandler.getModItem(GalacticraftMars.ID, "item.schematic", 1L, 1))
                                        .copy()
                                        .toString()))
                                sTier = "101";
                            else if (stackItemDamage == 2 && aStack.toString()
                                .equals(
                                    Objects
                                        .requireNonNull(
                                            GTModHandler.getModItem(GalacticraftMars.ID, "item.schematic", 1L, 2))
                                        .copy()
                                        .toString()))
                                sTier = "102";
                        } else if (aStack.getUnlocalizedName()
                            .matches(".*\\d+.*"))
                            sTier = aStack.getUnlocalizedName()
                                .split("(?<=\\D)(?=\\d)")[1].substring(0, 1);
                        else sTier = "1";
                    }

                    getSpecialSlot().stackSize -= 1;
                    aStack.stackSize -= 1;

                    this.mOutputItems[0] = GTUtility.copyAmount(1, getSpecialSlot());
                    assert this.mOutputItems[0] != null;
                    this.mOutputItems[0].setTagCompound(
                        GTUtility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", Short.parseShort(sTier)));

                    calculateOverclockedNess(480, 36000);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }
            }
            if (getSpecialSlot() == null && ItemList.Tool_DataStick.isStackEqual(aStack, false, true)) {
                if (GTUtility.ItemNBT.getBookTitle(aStack).equals("Raw Prospection Data")) {
                    GTUtility.ItemNBT.setBookTitle(aStack, "Analyzed Prospection Data");
                    GTUtility.ItemNBT.convertProspectionData(aStack);

                    // ========== VisualProspecting integration start ==========
                    final NBTTagCompound compound = aStack.getTagCompound();
                    if (compound != null && compound.hasKey(Tags.VISUALPROSPECTING_FLAG)) {
                        final int dimensionId = compound.getInteger(Tags.PROSPECTION_DIMENSION_ID);
                        final int blockX = compound.getInteger(Tags.PROSPECTION_BLOCK_X);
                        final int blockY = compound.getInteger(Tags.PROSPECTION_BLOCK_Y);
                        final int blockZ = compound.getInteger(Tags.PROSPECTION_BLOCK_Z);
                        final int blockRadius = compound.getInteger(Tags.PROSPECTION_ORE_RADIUS);
                        final int numberOfUndergroundFluids = compound.getInteger(Tags.PROSPECTION_NUMBER_OF_UNDERGROUND_FLUID);
                        final String position = "Dim: " + dimensionId + " X: " + blockX + " Y: " + blockY + " Z: " + blockZ;

                        final NBTTagList bookPages = new NBTTagList();

                        final String frontPage = "Prospector report\n" + position
                            + "\n\n"
                            + "Fluids: "
                            + numberOfUndergroundFluids
                            + "\n\n"
                            + "Ores within "
                            + blockRadius
                            + " blocks\n\n"
                            + "Location is center of orevein\n\n"
                            + "Results are synchronized to your map";
                        bookPages.appendTag(new NBTTagString(frontPage));

                        final List<OreVeinPosition> foundOreVeins = ServerCache.instance
                            .prospectOreBlockRadius(dimensionId, blockX, blockZ, blockRadius);
                        if (!foundOreVeins.isEmpty()) {
                            final int pageSize = 7;
                            final int numberOfPages = (foundOreVeins.size() + pageSize) / pageSize;

                            for (int pageNumber = 0; pageNumber < numberOfPages; pageNumber++) {
                                final StringBuilder pageString = new StringBuilder();
                                for (int i = 0; i < pageSize; i++) {
                                    final int veinId = pageNumber * pageSize + i;
                                    if (veinId < foundOreVeins.size()) {
                                        final OreVeinPosition oreVein = foundOreVeins.get(veinId);
                                        pageString.append(oreVein.getBlockX()).append(",").append(oreVein.getBlockZ()).append(" - ")
                                            .append(oreVein.veinType.getVeinName()).append("\n");
                                    }
                                }
                                String pageCounter = numberOfPages > 1 ? String.format(" %d/%d", pageNumber + 1, numberOfPages) : "";
                                NBTTagString pageTag = new NBTTagString(
                                    String.format("Ore Veins %s\n\n", pageCounter) + pageString);
                                bookPages.appendTag(pageTag);
                            }
                        }

                        if (compound.hasKey(Tags.PROSPECTION_FLUIDS)) {
                            GTUtility.ItemNBT.fillBookWithList(
                                bookPages,
                                "Fluids%s\n\n",
                                "\n",
                                9,
                                compound.getString(Tags.PROSPECTION_FLUIDS).split("\\|"));

                            final String fluidCoverPage = "Fluid notes\n\n" + "Prospects from NW to SE 576 chunks"
                                + "(9 8x8 fields)\n around and gives min-max amount"
                                + "\n\n"
                                + "[1][2][3]"
                                + "\n"
                                + "[4][5][6]"
                                + "\n"
                                + "[7][8][9]"
                                + "\n"
                                + "\n"
                                + "[5] - Prospector in this 8x8 area";
                            bookPages.appendTag(new NBTTagString(fluidCoverPage));

                            String tFluidsPosStr = "X: " + Math.floorDiv(blockX, 16 * 8) * 16 * 8
                                + " Z: "
                                + Math.floorDiv(blockZ, 16 * 8) * 16 * 8
                                + "\n";
                            int xOff = blockX - Math.floorDiv(blockX, 16 * 8) * 16 * 8;
                            xOff = xOff / 16;
                            int xOffRemain = 7 - xOff;

                            int zOff = blockZ - Math.floorDiv(blockZ, 16 * 8) * 16 * 8;
                            zOff = zOff / 16;
                            int zOffRemain = 7 - zOff;

                            for (; zOff > 0; zOff--) {
                                tFluidsPosStr = tFluidsPosStr.concat("--------\n");
                            }
                            for (; xOff > 0; xOff--) {
                                tFluidsPosStr = tFluidsPosStr.concat("-");
                            }

                            tFluidsPosStr = tFluidsPosStr.concat("P");

                            for (; xOffRemain > 0; xOffRemain--) {
                                tFluidsPosStr = tFluidsPosStr.concat("-");
                            }
                            tFluidsPosStr = tFluidsPosStr.concat("\n");
                            for (; zOffRemain > 0; zOffRemain--) {
                                tFluidsPosStr = tFluidsPosStr.concat("--------\n");
                            }
                            tFluidsPosStr = tFluidsPosStr.concat(
                                "            X: " + (Math.floorDiv(blockX, 16 * 8) + 1) * 16 * 8
                                    + " Z: "
                                    + (Math.floorDiv(blockZ, 16 * 8) + 1) * 16 * 8);
                            final String fluidsPage = "Corners of [5] are \n" + tFluidsPosStr
                                + "\n"
                                + "P - Prospector in 8x8 field";
                            bookPages.appendTag(new NBTTagString(fluidsPage));
                        }

                        compound.setString("author", position);
                        compound.setTag("pages", bookPages);
                        GTUtility.ItemNBT.setNBT(aStack, compound);

                        // Mimic original behaviour
                        aStack.stackSize -= 1;
                        this.mOutputItems[0] = GTUtility.copyAmount(1L, aStack);
                        calculateOverclockedNess(30, 1000);
                        if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1) {
                            return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                        } else {
                            return 2;
                        }
                    }
                    // ========== VisualProspecting integration end ==========

                    aStack.stackSize -= 1;
                    this.mOutputItems[0] = GTUtility.copyAmount(1, aStack);
                    calculateOverclockedNess(30, 1000);
                    // In case recipe is too OP for that machine
                    if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                        return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                    return 2;
                }
            }
            if (ItemList.Tool_DataStick.isStackEqual(getSpecialSlot(), false, true)) {
                for (GTRecipe.RecipeAssemblyLine tRecipe : GTRecipe.RecipeAssemblyLine.sAssemblylineRecipes) {
                    if (GTUtility.areStacksEqual(tRecipe.mResearchItem, aStack, true)) {
                        GTRecipe matchingRecipe = null;

                        for (GTRecipe scannerRecipe : scannerFakeRecipes.getAllRecipes()) {
                            if (GTUtility.areStacksEqual(scannerRecipe.mInputs[0], aStack, true)) {
                                matchingRecipe = scannerRecipe;
                                break;
                            }
                        }

                        if (matchingRecipe == null || aStack.stackSize < matchingRecipe.mInputs[0].stackSize) {
                            return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                        }

                        this.mOutputItems[0] = GTUtility.copyAmount(1, getSpecialSlot());

                        // Use Assline Utils
                        if (AssemblyLineUtils.setAssemblyLineRecipeOnDataStick(this.mOutputItems[0], tRecipe)) {
                            aStack.stackSize -= matchingRecipe.mInputs[0].stackSize;
                            calculateOverclockedNess(30, tRecipe.mResearchTime);
                            // In case recipe is too OP for that machine
                            if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                                return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
                            getSpecialSlot().stackSize -= 1;
                            return 2;
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        if (mProgresstime >= (mMaxProgresstime - 1)) {
            if ((this.mOutputItems[0] != null) && (this.mOutputItems[0].getUnlocalizedName()
                .equals("gt.metaitem.01.32707"))) {
                GTMod.achievements.issueAchievement(
                    aBaseMetaTileEntity.getWorld()
                        .getPlayerEntityByName(aBaseMetaTileEntity.getOwnerName()),
                    "scanning");
            }
        }
        super.onPostTick(aBaseMetaTileEntity, aTick);
    }

    @Override
    public RecipeMap<?> getRecipeMap() {
        return scannerFakeRecipes;
    }

    @Override
    public int getCapacity() {
        return 1000;
    }

    @Override
    protected boolean allowPutStackValidated(IGregTechTileEntity aBaseMetaTileEntity, int aIndex, ForgeDirection side,
                                             ItemStack aStack) {
        return super.allowPutStackValidated(aBaseMetaTileEntity, aIndex, side, aStack)
            && getRecipeMap().containsInput(aStack);
    }

    @Override
    public void startSoundLoop(byte aIndex, double aX, double aY, double aZ) {
        super.startSoundLoop(aIndex, aX, aY, aZ);
        if (aIndex == 1) {
            GTUtility.doSoundAtClient(SoundResource.IC2_MACHINES_MAGNETIZER_LOOP, 10, 1.0F, aX, aY, aZ);
        }
    }

    @Override
    public void startProcess() {
        sendLoopStart((byte) 1);
    }
}
