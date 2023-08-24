package gregtech.loaders.postload.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class CircuitAssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    public final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy,
        Materials.Tin };

    public final ItemStack[] RocketMaterial = new ItemStack[] {
        GT_ModHandler.getModItem("GalacticraftCore", "item.heavyPlating", 1L),
        GT_ModHandler.getModItem("GalacticraftMars", "item.null", 1L, 3),
        GT_ModHandler.getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1L)};

    public final ItemStack[] RocketChip = new ItemStack[] {
        ItemList.SchematicsTier1.get(1L),
        ItemList.SchematicsTier2.get(1L),
        ItemList.SchematicsTier3.get(1L)};

    // Rocket Circuits
    public final int[] EUperRecipe = new int[] {
        480, // t2 = HV
        1920, // t3 = EV
        7680, // t4 = IV
        30720, // t5 = LuV
        30720, // t6 = LuV
        130870, // t7 = ZPM
        520400, // t8 = UV
    };

    public final ItemStack[] ExtraChips = new ItemStack[] {
        ItemList.SchematicsMoonBuggy.get(1L),
        ItemList.SchematicsCargoRocket.get(1L),
        ItemList.SchematicsAstroMiner.get(1L)};

    @Override
    public void run() {
        this.solderingMaterials();
        // Recipes with High Tier Soldering
        Fluid solderIndalloy = FluidRegistry.getFluid("molten.indalloy140") != null
            ? FluidRegistry.getFluid("molten.indalloy140")
            : FluidRegistry.getFluid("molten.solderingalloy");

        // Crystal Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                ItemList.Circuit_Chip_CrystalCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(2L),
                ItemList.Circuit_Parts_CapacitorASMD.get(6), ItemList.Circuit_Parts_TransistorASMD.get(6),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Crystalprocessor.get(1L),
            100, 9600, true);

        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                ItemList.Circuit_Crystalprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(6L),
                ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(24),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Crystalcomputer.get(1L),
            200, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                ItemList.Circuit_Crystalcomputer.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 32) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Ultimatecrystalcomputer.get(1L),
            400, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                ItemList.Circuit_Ultimatecrystalcomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(8L),
                ItemList.Circuit_Parts_CapacitorASMD.get(16L), ItemList.Circuit_Chip_Ram.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorLuV, 16) },
            new FluidStack(solderIndalloy, 288),
            ItemList.Circuit_Crystalmainframe.get(1L),
            800, 30720, true);
        // Wetware Circuits
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorASMD.get(8L),
                ItemList.Circuit_Parts_TransistorASMD.get(8L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Neuroprocessor.get(1L),
            200, 38400, true);

        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Chip_NeuroCPU.get(1L), ItemList.Circuit_Chip_CrystalCPU.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_CapacitorXSMD.get(2L),
                ItemList.Circuit_Parts_TransistorXSMD.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 8) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Neuroprocessor.get(1L),
            25, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(8L),
                ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Wetwarecomputer.get(1L),
            300, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(1L),
                ItemList.Circuit_Neuroprocessor.get(2L), ItemList.Circuit_Parts_InductorXSMD.get(2L),
                ItemList.Circuit_Parts_CapacitorXSMD.get(3L), ItemList.Circuit_Chip_Ram.get(24L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 16) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Wetwarecomputer.get(1L),
            37, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(8L),
                ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Wetwaresupercomputer.get(1L),
            600, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Wetware_Extreme.get(2L),
                ItemList.Circuit_Wetwarecomputer.get(2L), ItemList.Circuit_Parts_DiodeXSMD.get(2L),
                ItemList.Circuit_Chip_NOR.get(16L), ItemList.Circuit_Chip_Ram.get(64L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.YttriumBariumCuprate, 24) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Wetwaresupercomputer.get(1L),
            75, 153600, true);

        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorASMD.get(12L),
                ItemList.Circuit_Parts_TransistorASMD.get(12L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Bioprocessor.get(1L),
            300, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Chip_BioCPU.get(1L), ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                ItemList.Circuit_Chip_NanoCPU.get(2L), ItemList.Circuit_Parts_CapacitorXSMD.get(3L),
                ItemList.Circuit_Parts_TransistorXSMD.get(3L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Bioprocessor.get(1L),
            37, 614400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L),
                ItemList.Circuit_Parts_InductorASMD.get(12L), ItemList.Circuit_Parts_CapacitorASMD.get(16L),
                ItemList.Circuit_Chip_Ram.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Biowarecomputer.get(1L),
            400, 153600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Bio_Ultra.get(1L), ItemList.Circuit_Bioprocessor.get(2L),
                ItemList.Circuit_Parts_InductorXSMD.get(3L), ItemList.Circuit_Parts_CapacitorXSMD.get(4L),
                ItemList.Circuit_Chip_Ram.get(32L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 24) },
            new FluidStack(solderIndalloy, 144),
            ItemList.Circuit_Biowarecomputer.get(1L),
            50, 614400, true);

        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 2),
                ItemList.Circuit_Chip_UHPIC.get(4L), ItemList.Circuit_Chip_QuantumCPU.get(2L),
                ItemList.Circuit_Chip_NanoCPU.get(2L),
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorZPM, 64) },
            new FluidStack(solderIndalloy, 288),
            ItemList.HighEnergyFlowCircuit.get(1L),
            2400, 7680, true);

        // SoC for nano, quantum, crystal
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Epoxy_Advanced.get(1L), ItemList.Circuit_Chip_SoC2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 8) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Nanoprocessor.get(1L),
            50, 9600, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                ItemList.Circuit_Chip_SoC2.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.NiobiumTitanium, 8) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Quantumprocessor.get(1L),
            50, 38400, true);
        GT_Values.RA.addCircuitAssemblerRecipe(
            new ItemStack[] { ItemList.Circuit_Board_Multifiberglass_Elite.get(1L),
                ItemList.Circuit_Chip_CrystalSoC.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 8),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.YttriumBariumCuprate, 8) },
            new FluidStack(solderIndalloy, 72),
            ItemList.Circuit_Crystalprocessor.get(1L),
            50, 153600, true);
    }

    public void solderingMaterials() {
        for (Materials tMat : solderingMaterials) {
            int tMultiplier = tMat.contains(SubTag.SOLDERING_MATERIAL_GOOD) ? 1
                : tMat.contains(SubTag.SOLDERING_MATERIAL_BAD) ? 4 : 2;

            if (Loader.isModLoaded("appliedenergistics2")) {
                // 1k ME Storage Component
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 2),
                        GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 4L, 8),
                        GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 22),
                        ItemList.Circuit_Board_Basic.get(1),
                        GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(72L * tMultiplier),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 35),
                    200, 30, false);
                // 4k ME Storage Component
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Primitive, 16),
                        GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 22),
                        ItemList.Circuit_Board_Coated_Basic.get(1), GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(72L * tMultiplier),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 36),
                    200, 30, true);
                // 16k ME Storage Component
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 16),
                        GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 24),
                        ItemList.Circuit_Board_Phenolic_Good.get(1), GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(72L * tMultiplier),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 37),
                    200, 120, true);
                // 64k ME Storage Component
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 16),
                        GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 24),
                        ItemList.Circuit_Board_Epoxy_Advanced.get(1), GT_Utility.getIntegratedCircuit(1) },
                    tMat.getMolten(72L * tMultiplier),
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 38),
                    200, 480, true);
            }
            // Rocket Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Quantumprocessor.get(1L), RocketMaterial[0],
                    GT_Utility.getIntegratedCircuit(1)},
                tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Data.get(1L), RocketMaterial[0],
                    GT_Utility.getIntegratedCircuit(1)},
                tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Nanocomputer.get(1L), RocketMaterial[0],
                    GT_Utility.getIntegratedCircuit(1)},
                tMat.getMolten(576L * tMultiplier / 2L), RocketChip[0], 9000, 480, true);

            for (int i = 2; i < 4; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                    GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) i));
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Elite.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[(i - 1)],
                    9000, EUperRecipe[(i - 2)], true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Elitenanocomputer.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[(i - 1)],
                    9000, EUperRecipe[(i - 2)], true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Quantumcomputer.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[(i - 1)],
                    9000, EUperRecipe[(i - 2)], true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[(i - 1)], ItemList.Circuit_Crystalprocessor.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    RocketChip[(i - 1)],
                    9000, EUperRecipe[(i - 2)], true);
            }

            for (byte i = 0; i < 3; ++i) {
                ItemStack DataStickWScheme = ItemList.Tool_DataStick.get(1L);
                DataStickWScheme.setTagCompound(
                    GT_Utility.getNBTContainingShort(new NBTTagCompound(), "rocket_tier", (short) (i + 100)));
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[i], ItemList.Circuit_Quantumprocessor.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    ExtraChips[i],
                    9000, EUperRecipe[i], true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[i], ItemList.Circuit_Data.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    ExtraChips[i],
                    9000, EUperRecipe[i], true);
                GT_Values.RA.addCircuitAssemblerRecipe(
                    new ItemStack[]{RocketMaterial[i], ItemList.Circuit_Nanocomputer.get(1L),
                        DataStickWScheme.splitStack(0)},
                    tMat.getMolten(576L * tMultiplier / 2L),
                    ExtraChips[i],
                    9000, EUperRecipe[i], true);
            }
            // Primitive Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                    ItemList.Circuit_Chip_Simple_SoC.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1)},
                tMat.getMolten(36L * tMultiplier / 2L),
                ItemList.NandChipBoard.get(1),
                300, 120);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                    ItemList.Circuit_Chip_Simple_SoC.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1)},
                tMat.getMolten(36L * tMultiplier / 2L),
                ItemList.NandChipBoard.get(1),
                150, 120);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_Simple_SoC.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1)},
                tMat.getMolten(36L * tMultiplier / 2L),
                ItemList.NandChipBoard.get(2),
                300, 480);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_Simple_SoC.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1)},
                tMat.getMolten(36L * tMultiplier / 2L),
                ItemList.NandChipBoard.get(2),
                150, 480);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Chip_Simple_SoC.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 1)},
                tMat.getMolten(36L * tMultiplier / 2L),
                ItemList.NandChipBoard.get(4),
                300, 1920);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Chip_Simple_SoC.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.RedAlloy, 1),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.AnnealedCopper, 1)},
                tMat.getMolten(36L * tMultiplier / 2L),
                ItemList.NandChipBoard.get(4),
                150, 1920);

            // Basic Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                    ItemList.Circuit_Parts_Resistor.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                    ItemList.Circuit_Parts_Vacuum_Tube.get(2L)},
                tMat.getMolten(144L * tMultiplier / 2L),
                GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
                200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L),
                    ItemList.Circuit_Parts_ResistorSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 2),
                    ItemList.Circuit_Parts_Vacuum_Tube.get(2L)},
                tMat.getMolten(144L * tMultiplier / 2L),
                GT_ModHandler.getModItem("IC2", "itemPartCircuit", 1L, 0),
                200, 16);
            // Good Circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                    GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                    ItemList.Circuit_Parts_Diode.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Good.get(1L),
                300, 30);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L),
                    GT_ModHandler.getModItem("IC2", "itemPartCircuit", 2L, 0),
                    ItemList.Circuit_Parts_DiodeSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Good.get(1L),
                300, 30);

            // Integraded Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                    ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_Diode.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Basic.get(1L),
                200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                    ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_Diode.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Basic.get(1L),
                200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                    ItemList.Circuit_Parts_ResistorSMD.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Basic.get(1L),
                200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Coated_Basic.get(1L), ItemList.Circuit_Chip_ILC.get(1L),
                    ItemList.Circuit_Parts_Resistor.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Tin, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Basic.get(1L),
                200, 16);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                    ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_Diode.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Integrated_Good.get(1L),
                400, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                    ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_Diode.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Integrated_Good.get(1L),
                400, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                    ItemList.Circuit_Parts_ResistorSMD.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Integrated_Good.get(1L),
                400, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                    ItemList.Circuit_Parts_ResistorASMD.get(1L), ItemList.Circuit_Parts_DiodeASMD.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Integrated_Good.get(1L),
                200, 24);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Phenolic_Good.get(1L), ItemList.Circuit_Basic.get(2L),
                    ItemList.Circuit_Parts_Resistor.get(4L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Gold, 4),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Silver, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Integrated_Good.get(1L),
                400, 24);

            // Advanced circuit
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                    ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_Transistor.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)},
                tMat.getMolten(144L * tMultiplier / 2L),
                GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                800, 30, false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                    ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)},
                tMat.getMolten(144L * tMultiplier / 2L),
                GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                800, 30, false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Integrated_Good.get(1L), ItemList.Circuit_Chip_ILC.get(2L),
                    ItemList.Circuit_Chip_Ram.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 8)},
                tMat.getMolten(144L * tMultiplier / 2L),
                GT_ModHandler.getIC2Item("advancedCircuit", 1L),
                400, 30, false);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                    ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                    ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                    ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_Transistor.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                    ItemList.Circuit_Parts_Capacitor.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(2L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                    ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                    ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(1L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                100, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                    ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_Transistor.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                    ItemList.Circuit_Parts_Capacitor.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_Resistor.get(4L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L),
                    ItemList.Circuit_Parts_Capacitor.get(8L), ItemList.Circuit_Chip_Ram.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Computer.get(1L),
                400, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(2L), ItemList.Circuit_Chip_NAND.get(32L),
                    ItemList.Circuit_Chip_Ram.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 16),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plastic, 4)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Tool_DataStick.get(1L),
                400, 90, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_Diode.get(4L),
                    ItemList.Circuit_Chip_Ram.get(8L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Data.get(1L),
                400, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                    ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_Capacitor.get(24),
                    ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 24)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Elite.get(1L),
                1600, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(2L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(2L), ItemList.Circuit_Parts_TransistorSMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(4L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(4L), ItemList.Circuit_Parts_TransistorSMD.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                200, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_Coil.get(4L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Computer.get(1L),
                400, 96, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_CPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(4L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(1L), ItemList.Circuit_Parts_TransistorASMD.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                100, 60, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Processor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(1L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 8)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Computer.get(1L),
                200, 96, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(4L),
                    ItemList.Circuit_Chip_Ram.get(8L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Data.get(1L),
                400, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Advanced.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(1L),
                    ItemList.Circuit_Chip_Ram.get(8L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Platinum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Data.get(1L),
                200, 120, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                    ItemList.Circuit_Parts_Coil.get(12L), ItemList.Circuit_Parts_CapacitorSMD.get(16L),
                    ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Elite.get(1L),
                1600, 480, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 2),
                    ItemList.Circuit_Parts_InductorASMD.get(3L), ItemList.Circuit_Parts_CapacitorASMD.get(4L),
                    ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 16)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Elite.get(1L),
                800, 480, true);
            // Nanotech Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorSMD.get(8L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Parts_TransistorSMD.get(8L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Nanoprocessor.get(1L),
                200, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Chip_NanoCPU.get(1L), ItemList.Circuit_Parts_ResistorASMD.get(2L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Parts_TransistorASMD.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 8)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Nanoprocessor.get(1L),
                100, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_InductorSMD.get(8L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(8L), ItemList.Circuit_Chip_Ram.get(8L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Nanocomputer.get(1L),
                400, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(2L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(2L), ItemList.Circuit_Chip_Ram.get(8L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Nanocomputer.get(1L),
                200, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Nanoprocessor.get(2L), ItemList.Circuit_Chip_Ram.get(4L),
                    ItemList.Circuit_Chip_NOR.get(32L), ItemList.Circuit_Chip_NAND.get(64L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 32)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Tool_DataOrb.get(1L),
                400, 1200, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L),
                    ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Elitenanocomputer.get(1L),
                400, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Epoxy_Advanced.get(1L),
                    ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                    ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Electrum, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Elitenanocomputer.get(1L),
                200, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_InductorSMD.get(16L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(32L), ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Master.get(1L),
                1600, 1920, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    ItemList.Circuit_Elitenanocomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(4L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(8L), ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 32)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Master.get(1L),
                800, 1920, true);
            // Quantum Circuits
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(12L), ItemList.Circuit_Parts_TransistorSMD.get(12L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Quantumprocessor.get(1L),
                200, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Chip_QuantumCPU.get(1L), ItemList.Circuit_Chip_NanoCPU.get(1L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(3L), ItemList.Circuit_Parts_TransistorASMD.get(3L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Quantumprocessor.get(1L),
                100, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_InductorSMD.get(12L),
                    ItemList.Circuit_Parts_CapacitorSMD.get(16L), ItemList.Circuit_Chip_Ram.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Quantumcomputer.get(1L),
                400, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Parts_InductorASMD.get(3L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(4L), ItemList.Circuit_Chip_Ram.get(4L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 24)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Quantumcomputer.get(1L),
                200, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeSMD.get(8L),
                    ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Masterquantumcomputer.get(1L),
                400, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Quantumcomputer.get(2L), ItemList.Circuit_Parts_DiodeASMD.get(2L),
                    ItemList.Circuit_Chip_NOR.get(4L), ItemList.Circuit_Chip_Ram.get(16L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 48)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Circuit_Masterquantumcomputer.get(1L),
                200, 2400, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_InductorSMD.get(24),
                    ItemList.Circuit_Parts_CapacitorSMD.get(48L), ItemList.Circuit_Chip_Ram.get(24),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Quantummainframe.get(1L),
                1600, 7680, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 2),
                    ItemList.Circuit_Masterquantumcomputer.get(2L), ItemList.Circuit_Parts_InductorASMD.get(6L),
                    ItemList.Circuit_Parts_CapacitorASMD.get(12L), ItemList.Circuit_Chip_Ram.get(24),
                    GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.AnnealedCopper, 48)},
                tMat.getMolten(144L * tMultiplier * 2),
                ItemList.Circuit_Quantummainframe.get(1L),
                800, 7680, true);

            // SoC
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_SoC.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Copper, 2),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Copper, 2)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Microprocessor.get(2L),
                50, 600, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                    ItemList.Circuit_Chip_SoC.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.RedAlloy, 4),
                    GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.AnnealedCopper, 4)},
                tMat.getMolten(144L * tMultiplier / 2L),
                ItemList.Circuit_Processor.get(1L),
                50, 2400, true);

            // Lapo orbs
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Chip_PIC.get(4L), ItemList.Circuit_Parts_Crystal_Chip_Master.get(24L),
                    ItemList.Circuit_Chip_NanoCPU.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Platinum, 16),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Platinum, 8)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Energy_LapotronicOrb.get(1L),
                512, 1024, true);
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Fiberglass_Advanced.get(1L),
                    ItemList.Circuit_Chip_HPIC.get(4L), ItemList.Energy_LapotronicOrb.get(8L),
                    ItemList.Circuit_Chip_QuantumCPU.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.NiobiumTitanium, 16),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NaquadahAlloy, 16)},
                tMat.getMolten(144L * tMultiplier),
                ItemList.Energy_LapotronicOrb2.get(1L),
                1024, 4096, true);

            // Wetware Board
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Multifiberglass.get(16L),
                    ItemList.Circuit_Parts_PetriDish.get(1L), ItemList.Electric_Pump_LuV.get(1L),
                    ItemList.Sensor_IV.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NiobiumTitanium, 16L)},
                Materials.GrowthMediumSterilized.getFluid(4000L),
                ItemList.Circuit_Board_Wetware.get(16L),
                1200, 30720, true);

            // Bio Board
            GT_Values.RA.addCircuitAssemblerRecipe(
                new ItemStack[]{ItemList.Circuit_Board_Wetware.get(32L), ItemList.Circuit_Parts_PetriDish.get(8L),
                    ItemList.Electric_Pump_UV.get(1L), ItemList.Sensor_LuV.get(2L),
                    GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.SuperconductorUHV, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.foil, Materials.Neutronium, 32L)},
                Materials.BioMediumSterilized.getFluid(16000L),
                ItemList.Circuit_Board_Bio.get(32L),
                1200, 500000, true);
        }
    }
}
