package gregtech.loaders.postload.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class MixerRecipes implements Runnable {

    @Override
    public void run() {
         GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                new ItemStack(Items.blaze_powder, 1, 0),
                new ItemStack(Items.gunpowder, 1, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{new ItemStack(Items.fire_charge, 1, 0)},
            new FluidStack[]{GT_Values.NF},
            400, 24);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Electrum, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Invar, 3L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            300, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Invar, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.StainlessSteel, 9L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            900, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Kanthal, 3L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            300, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Brass, 4L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            400, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Bronze, 4L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            400, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_Utility.getIntegratedCircuit(3)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Cupronickel, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 24);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 4L),
                GT_Utility.getIntegratedCircuit(4)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.SterlingSilver, 5L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            500, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 2L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.BlackBronze, 5L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            500, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bismuth, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.BismuthBronze, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            500, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackBronze, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 3L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.BlackSteel, 5L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            500, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BismuthBronze, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.RedSteel, 8L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            800, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.BlueSteel, 8L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            800, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 15L),
                GT_Utility.getIntegratedCircuit(14)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.BlackSteel, 25L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            800, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bismuth, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 20L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 10L),
                GT_Utility.getIntegratedCircuit(15)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.RedSteel, 40L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            1200, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 31L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 64L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 16L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 40L),
                GT_Utility.getIntegratedCircuit(16)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{
                GT_OreDictUnificator.getDust(Materials.BlueSteel, 64L * OrePrefixes.dust.mMaterialAmount),
                GT_OreDictUnificator.getDust(Materials.BlueSteel, 64L * OrePrefixes.dust.mMaterialAmount),
                GT_OreDictUnificator.getDust(Materials.BlueSteel, 32L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            3600, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1L),
                GT_Utility.getIntegratedCircuit(2)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Ultimet, 9L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            900, 480);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 7L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.CobaltBrass, 9L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            900, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 3L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Gunpowder, 6L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            600, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 3L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Gunpowder, 6L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            600, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 3L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Gunpowder, 6L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            600, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Phosphorus, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.IndiumGalliumPhosphide, 3L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Fireclay, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Nichrome, 5L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            500, 480);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 3L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.Osmiridium, 4L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            400, 1920);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.NiobiumTitanium, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            400, 1920);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.VanadiumGallium, 4L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            400, 1920);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.TungstenCarbide, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 480);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.TungstenSteel, 2L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            50, 1920);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.TPV, 7L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            175, 1920);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.HSSG, 9L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            600, 1920);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.HSSE, 9L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            700, 4096);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Utility.getIntegratedCircuit(2)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.HSSS, 9L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            800, 7680);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.FerriteMixture, 6L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Boron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 7L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.getDust(Materials.BorosilicateGlass, 8L * OrePrefixes.dust.mMaterialAmount)},
            new FluidStack[]{GT_Values.NF},
            200, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Redstone, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ruby, 4L)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{ItemList.IC2_Energium_Dust.get(1L)},
            new FluidStack[]{GT_Values.NF},
            300, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 4L)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{ItemList.IC2_Energium_Dust.get(9L)},
            new FluidStack[]{GT_Values.NF},
            600, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1L),
                new ItemStack(Blocks.brown_mushroom, 1),
                new ItemStack(Items.spider_eye, 1)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{new ItemStack(Items.fermented_spider_eye, 1)},
            new FluidStack[]{GT_Values.NF},
            100, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.LightFuel, 5L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.HeavyFuel, 1L)
            },
            new FluidStack[]{GT_Values.NF},
            new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 6L)},
            new FluidStack[]{GT_Values.NF},
            16, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.LightFuel, 5L),
                Materials.Empty.getCells(1),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.HeavyFuel.getFluid(1000L)},
            new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 6L)},
            new FluidStack[]{GT_Values.NF},
            16, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.HeavyFuel, 1L),
                Materials.Empty.getCells(5),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.LightFuel.getFluid(5000L)},
            new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 6L)},
            new FluidStack[]{GT_Values.NF},
            16, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.LightFuel, 5L),
                GT_Utility.getIntegratedCircuit(5)
            },
            new FluidStack[]{Materials.HeavyFuel.getFluid(1000L)},
            new ItemStack[]{Materials.Empty.getCells(5)},
            new FluidStack[]{Materials.Fuel.getFluid(6000L)},
            16, 120);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.HeavyFuel, 1L),
                GT_Utility.getIntegratedCircuit(6)
            },
            new FluidStack[]{Materials.LightFuel.getFluid(5000L)},
            new ItemStack[]{Materials.Empty.getCells(1)},
            new FluidStack[]{Materials.Fuel.getFluid(6000L)},
            400, 8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Water, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L)
            },
            new FluidStack[]{Materials.Lubricant.getFluid(20)},
            new ItemStack[]{Materials.Empty.getCells(5)},
            new FluidStack[]{new FluidStack(ItemList.sDrillingFluid, 5000)},
            64, 16);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L),
                GT_Utility.getIntegratedCircuit(4)
            },
            new FluidStack[]{Materials.Water.getFluid(125)},
            new ItemStack[]{GT_Values.NI},
            new FluidStack[]{FluidRegistry.getFluidStack("ic2coolant", 125)},
            256, 48);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1L),
                GT_Utility.getIntegratedCircuit(4)
            },
            new FluidStack[]{GT_ModHandler.getDistilledWater(1000)},
            new ItemStack[]{GT_Values.NI},
            new FluidStack[]{FluidRegistry.getFluidStack("ic2coolant", 1000)},
            256, 48);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 4L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.AdvancedGlue.getFluid(200)},
            new ItemStack[]{ItemList.SFMixture.get(4)},
            new FluidStack[]{GT_Values.NF},
            800, 16);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 4L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.AdvancedGlue.getFluid(200)},
            new ItemStack[]{ItemList.SFMixture.get(8)},
            new FluidStack[]{GT_Values.NF},
            800, 16);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 4L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.AdvancedGlue.getFluid(200)},
            new ItemStack[]{ItemList.SFMixture.get(12)},
            new FluidStack[]{GT_Values.NF},
            800, 16);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                ItemList.SFMixture.get(2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L)
            },
            new FluidStack[]{Materials.Mercury.getFluid(1000)},
            new ItemStack[]{ItemList.MSFMixture.get(4)},
            new FluidStack[]{GT_Values.NF},
            300, 64);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                ItemList.SFMixture.get(1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Blaze, 1L)
            },
            new FluidStack[]{Materials.Mercury.getFluid(500)},
            new ItemStack[]{ItemList.MSFMixture.get(1)},
            new FluidStack[]{GT_Values.NF},
            300, 64);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Lignite, 4),
                ItemList.MSFMixture.get(24),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.NitroFuel.getFluid(4000)},
            new ItemStack[]{ItemList.Block_MSSFUEL.get(4)},
            new FluidStack[]{GT_Values.NF},
            400, 600);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 4),
                ItemList.MSFMixture.get(16),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.NitroFuel.getFluid(3000)},
            new ItemStack[]{ItemList.Block_MSSFUEL.get(4)},
            new FluidStack[]{GT_Values.NF},
            300, 600);

        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 4),
                ItemList.MSFMixture.get(8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.NitroFuel.getFluid(2000)},
            new ItemStack[]{ItemList.Block_MSSFUEL.get(4)},
            new FluidStack[]{GT_Values.NF},
            200, 600);

        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Lignite, 4),
                ItemList.MSFMixture.get(24),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.GasolinePremium.getFluid(1600)},
            new ItemStack[]{ItemList.Block_MSSFUEL.get(4)},
            new FluidStack[]{GT_Values.NF},
            400, 600);

        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 4),
                ItemList.MSFMixture.get(16),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.GasolinePremium.getFluid(1200)},
            new ItemStack[]{ItemList.Block_MSSFUEL.get(4)},
            new FluidStack[]{GT_Values.NF},
            300, 600);

        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 4),
                ItemList.MSFMixture.get(8),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.GasolinePremium.getFluid(800)},
            new ItemStack[]{ItemList.Block_MSSFUEL.get(4)},
            new FluidStack[]{GT_Values.NF},
            200, 600);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Lignite, 1),
                ItemList.SFMixture.get(6),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.NitroFuel.getFluid(1000)},
            new ItemStack[]{ItemList.Block_SSFUEL.get(1)},
            new FluidStack[]{GT_Values.NF},
            140, 250);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1),
                ItemList.SFMixture.get(4),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.NitroFuel.getFluid(750)},
            new ItemStack[]{ItemList.Block_SSFUEL.get(1)},
            new FluidStack[]{GT_Values.NF},
            120, 250);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1),
                ItemList.SFMixture.get(2),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.NitroFuel.getFluid(500)},
            new ItemStack[]{ItemList.Block_SSFUEL.get(1)},
            new FluidStack[]{GT_Values.NF},
            100, 250);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Lignite, 1),
                ItemList.SFMixture.get(6),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.GasolinePremium.getFluid(400)},
            new ItemStack[]{ItemList.Block_SSFUEL.get(1)},
            new FluidStack[]{GT_Values.NF},
            140, 250);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1),
                ItemList.SFMixture.get(4),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.GasolinePremium.getFluid(300)},
            new ItemStack[]{ItemList.Block_SSFUEL.get(1)},
            new FluidStack[]{GT_Values.NF},
            120, 250);
        GT_Values.RA.addMixerRecipe(
            new ItemStack[]{
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1),
                ItemList.SFMixture.get(2),
                GT_Utility.getIntegratedCircuit(1)
            },
            new FluidStack[]{Materials.GasolinePremium.getFluid(200)},
            new ItemStack[]{ItemList.Block_SSFUEL.get(1)},
            new FluidStack[]{GT_Values.NF},
            100, 250);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1L),
            GT_Values.NI,
            GT_Values.NI,
            new FluidStack(FluidRegistry.getFluid("ic2coolant"), 2000),
            Materials.SuperCoolant.getFluid(2000),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 2L),
            200,
            480);

        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 16L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Bauxite, 16L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Bauxite, 16L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 12L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 64L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Aluminium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Aluminium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 4L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Sodalite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Sodalite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Alunite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Alunite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lepidolite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Lepidolite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Mica, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Mica, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Tanzanite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Tanzanite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Biotite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Biotite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Lazurite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Lazurite, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 12L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Glauconite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Glauconite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.GlauconiteSand, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.GlauconiteSand, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Vermiculite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Vermiculite, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 3L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 16L),
            200,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L),
            100,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustImpure, Materials.Zeolite, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L),
            300,
            48);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustPure, Materials.Zeolite, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumHydroxide, 6L),
            GT_Utility.getIntegratedCircuit(5),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 36L),
            200,
            48);

        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrudeSteel, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(3),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 3L),
            100,
            8);

        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            new ItemStack(Blocks.soul_sand, 1, 0),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 3L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 4L),
            400,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thaumium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 4L),
            200,
            8);

        // Superconductor dust recipes in mixer.

        // MV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cadmium, 5L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            Materials.Oxygen.getGas(6000),
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 12L),
            10 * 20,
            120);

        // HV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 10L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            Materials.Oxygen.getGas(20000),
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 40L),
            10 * 20,
            480);

        // EV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Platinum, 3L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 4L),
            10 * 20,
            1920);

        // IV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 3L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 4L),
            10 * 20,
            7680);

        // LuV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 7L),
            GT_Utility.getIntegratedCircuit(3),
            Materials.Oxygen.getGas(14000),
            GT_Values.NF,
            GT_OreDictUnificator.get(
                OrePrefixes.dust,
                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                30L),
            10 * 20,
            30720);

        // ZPM Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Indium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Palladium, 6L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 13L),
            10 * 20,
            122880);

        // UV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Samarium, 1L),
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 9L),
            10 * 20,
            491520);

        // UHV Superconductor Recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 6L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 7L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 5L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Americium, 6L),
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 24L),
            10 * 20,
            1966080);

        // UEV Superconductor dust recipe.
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 5L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 5L),
            GT_ModHandler.getModItem("miscutils", "itemDustCelestialTungsten", 1L),
            GT_ModHandler.getModItem("miscutils", "itemDustAdvancedNitinol", 1L),
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NI,
            Materials.Iron.getPlasma(144L),
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SuperconductorUEVBase, 12L),
            10 * 20,
            7864320);

        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 2L),
            400,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
            ItemList.IC2_Resin.get(1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            ItemList.MicaBasedPulp.get(4L),
            400,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            ItemList.MicaBasedPulp.get(4L),
            400,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.getDust(Materials.NaquadahAlloy, 4L * OrePrefixes.dust.mMaterialAmount),
            (int) (400L * OrePrefixes.dust.mMaterialAmount / 3628800L),
            8000);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Barium, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 3L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            Materials.Oxygen.getGas(7000),
            GT_Values.NF,
            GT_OreDictUnificator.getDust(Materials.YttriumBariumCuprate, 13L * OrePrefixes.dust.mMaterialAmount),
            (int) (600L * OrePrefixes.dust.mMaterialAmount / 3628800L),
            2000);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 6L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AnyCopper, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(3),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.getDust(Materials.Duralumin, 9L * OrePrefixes.dust.mMaterialAmount),
            (int) (900L * OrePrefixes.dust.mMaterialAmount / 3628800L),
            2000);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 5L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alumite, 9L),
            200,
            8);

        GT_Values.RA.addMixerRecipe(
            ItemList.IC2_Energium_Dust.get(9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 6L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            ItemList.LapotronDust.get(15L),
            600,
            480);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 4L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 4L),
            200,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 16L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(4),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 16L),
            800,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 4L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 5L),
            160,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 16L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(4),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 20L),
            640,
            8);

        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 7L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 9L),
            100,
            30);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 4L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 5L),
            200,
            120);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 6L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 9L),
            900,
            120);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RoseGold, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.AstralSilver, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SterlingSilver, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
            GT_Utility.getIntegratedCircuit(4),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 4L),
            50,
            900);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 6L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Molybdenum, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(18),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L),
            225,
            900);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadium, 1L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(9),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 18L),
            225,
            900);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NI,
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 1L),
            200,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 2L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            Materials.Water.getFluid(2000L),
            Materials.Concrete.getMolten(2304L),
            GT_Values.NI,
            100,
            16);

        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 8L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_ModHandler.getWater(1000L),
            GT_Values.NF,
            new ItemStack(Items.clay_ball, 4, 0),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 4L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(2),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedAlloy, 1L),
            100,
            16);

        GT_Values.RA.addMixerRecipe(
            new ItemStack(Blocks.dirt, 1, 0),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L),
            new ItemStack(Blocks.sand, 4, 0),
            GT_Values.NI,
            Materials.Water.getFluid(1000L),
            GT_Values.NF,
            ItemList.IC2_Fertilizer.get(4),
            100,
            30);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BatteryAlloy, 5L),
            100,
            4);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Antimony, 1L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SolderingAlloy, 10L),
            100,
            8);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnalium, 3L),
            100,
            4);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 16L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(1),
            GT_Values.NI,
            Materials.Helium.getPlasma(2304L),
            GT_Values.NF,
            ItemList.RawNeutronium.get(16L),
            3600,
            122880);
        // One Step Alloy Dust Mixer
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
            GT_Utility.getIntegratedCircuit(15),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 9L),
            120,
            120);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(17),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 27L),
            240,
            480);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(16),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 27L),
            240,
            480);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 12L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
            GT_Utility.getIntegratedCircuit(18),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 64L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 17L),
            GT_Values.NI,
            GT_Values.NI,
            480,
            480);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 27L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 9L),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 64L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 17L),
            GT_Values.NI,
            GT_Values.NI,
            480,
            480);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(14),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 9L),
            120,
            120);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
            GT_Values.NI,
            GT_Values.NI,
            GT_Utility.getIntegratedCircuit(16),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 27L),
            240,
            480);
        GT_Values.RA.addMixerRecipe(
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 4L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 1L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 3L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Endstone, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 9L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 27L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 27L),
            GT_Utility.getIntegratedCircuit(18),
            GT_Values.NF,
            GT_Values.NF,
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 64L),
            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 17L),
            GT_Values.NI,
            GT_Values.NI,
            480,
            480);

        GT_Values.RA.addMixerRecipe(
            new ItemStack[] { GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 16L, 0),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 2L),
                GT_Utility.getIntegratedCircuit(1) },
            new FluidStack[] { GT_Values.NF },
            new ItemStack[] { ItemList.BioBall.get(1L) },
            new FluidStack[] { GT_Values.NF },
            200,
            16);

        GT_Values.RA.addMixerRecipe(
            Materials.Silver.getDust(2),
            Materials.Thaumium.getDust(1),
            GT_Utility.getIntegratedCircuit(1),
            null,
            null,
            null,
            Materials.AstralSilver.getDust(3),
            60,
            480);
        GT_Values.RA.addMixerRecipe(
            Materials.Tin.getDust(9),
            Materials.Antimony.getDust(1),
            GT_Utility.getIntegratedCircuit(1),
            null,
            null,
            null,
            Materials.SolderingAlloy.getDust(10),
            60,
            30);

        if (Loader.isModLoaded("EnderIO")) {
            GT_Values.RA.addMixerRecipe(
                GT_ModHandler.getModItem("EnderIO", "itemMaterial", 1L, 14),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 3L),
                100,
                8);
        }

        if (Loader.isModLoaded("ExtraTrees")) {
            GT_Values.RA.addMixerRecipe(
                GT_ModHandler.getModItem("ExtraTrees", "misc", 4L, 2),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.Water.getFluid(500L),
                GT_Values.NF,
                ItemList.FR_Mulch.get(1L),
                600,
                2);
        }

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addMixerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "materials", 4L, 42),
                200,
                8);

            GT_Values.RA.addMixerRecipe(
                GT_ModHandler.getModItem("TConstruct", "slime.gel", 1L, 2),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 3L),
                100,
                8);

            GT_Values.RA.addMixerRecipe(
                new ItemStack(Blocks.sand, 3, 0),
                new ItemStack(Blocks.gravel, 3, 0),
                new ItemStack(Blocks.clay, 2, 0),
                GT_Values.NI,
                Materials.Water.getFluid(2000L),
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 8L, 1),
                200,
                16);
            GT_Values.RA.addMixerRecipe(
                new ItemStack(Blocks.sand, 3, 1),
                new ItemStack(Blocks.gravel, 3, 0),
                new ItemStack(Blocks.clay, 2, 0),
                GT_Values.NI,
                Materials.Water.getFluid(2000L),
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 8L, 1),
                200,
                16);
            GT_Values.RA.addMixerRecipe(
                new ItemStack(Items.nether_wart, 1, 0),
                new ItemStack(Blocks.soul_sand, 1, 0),
                new ItemStack(Blocks.gravel, 1, 0),
                GT_ModHandler.getModItem("Natura", "soil.tainted", 1L, 0),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                Materials.Water.getFluid(2000L),
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 2L, 6),
                200,
                16);
            GT_Values.RA.addMixerRecipe(
                new ItemStack(Items.nether_wart, 1, 0),
                new ItemStack(Blocks.soul_sand, 1, 0),
                new ItemStack(Blocks.gravel, 1, 0),
                new ItemStack(Blocks.sand, 1, 32767),
                GT_Utility.getIntegratedCircuit(2),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                Materials.Water.getFluid(2000L),
                GT_Values.NF,
                GT_ModHandler.getModItem("TConstruct", "CraftedSoil", 2L, 6),
                200,
                16);
        }

        if (Loader.isModLoaded("appliedenergistics2")) {
            GT_Values.RA.addMixerRecipe(
                new ItemStack[]{
                    GT_ModHandler.getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1L, 1),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Redstone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.gem, Materials.NetherQuartz, 1L)
                },
                new FluidStack[]{Materials.Water.getFluid(500L)},
                new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Fluix, 2L)},
                new FluidStack[]{GT_Values.NF},
                20, 16);
        }
        if(Loader.isModLoaded("Forestry")){
            GT_Values.RA.addMixerRecipe(
                new ItemStack[]{
                    ItemList.IC2_Fertilizer.get(1L),
                    new ItemStack(Blocks.dirt, 8, 32767),
                    GT_Utility.getIntegratedCircuit(1)
                },
                new FluidStack[]{Materials.Water.getFluid(1000L)},
                new ItemStack[]{GT_ModHandler.getModItem("Forestry", "soil", 8L, 0)},
                new FluidStack[]{GT_Values.NF},
                64, 16);
            GT_Values.RA.addMixerRecipe(
                new ItemStack[]{
                    ItemList.FR_Mulch.get(8L),
                    new ItemStack(Blocks.dirt, 8, 32767),
                    GT_Utility.getIntegratedCircuit(1)
                },
                new FluidStack[]{Materials.Water.getFluid(1000L)},
                new ItemStack[]{GT_ModHandler.getModItem("Forestry", "soil", 8L, 0)},
                new FluidStack[]{GT_Values.NF},
                64, 16);
            GT_Values.RA.addMixerRecipe(
                new ItemStack[]{
                    ItemList.FR_Compost.get(1L),
                    new ItemStack(Blocks.dirt, 8, 32767),
                    GT_Utility.getIntegratedCircuit(1)
                },
                new FluidStack[]{Materials.Water.getFluid(1000L)},
                new ItemStack[]{GT_ModHandler.getModItem("Forestry", "soil", 8L, 0)},
                new FluidStack[]{GT_Values.NF},
                64, 16);
            GT_Values.RA.addMixerRecipe(
                new ItemStack[]{
                    new ItemStack(Blocks.sand, 1, 32767),
                    new ItemStack(Blocks.dirt, 1, 32767),
                    GT_Utility.getIntegratedCircuit(1)
                },
                new FluidStack[]{Materials.Water.getFluid(250L)},
                new ItemStack[]{GT_ModHandler.getModItem("Forestry", "soil", 2L, 1)},
                new FluidStack[]{GT_Values.NF},
                16, 16);
        }
        if (Loader.isModLoaded("Thaumcraft")) {
            GT_Values.RA.addMixerRecipe(
                ItemList.SFMixture.get(20),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedAir, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.FierySteel.getFluid(50),
                null,
                ItemList.MSFMixture.get(20),
                200,
                64);
            GT_Values.RA.addMixerRecipe(
                ItemList.SFMixture.get(20),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.FierySteel.getFluid(50),
                null,
                ItemList.MSFMixture.get(20),
                200,
                64);
            GT_Values.RA.addMixerRecipe(
                ItemList.SFMixture.get(20),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEntropy, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.FierySteel.getFluid(50),
                null,
                ItemList.MSFMixture.get(20),
                200,
                64);
            GT_Values.RA.addMixerRecipe(
                ItemList.SFMixture.get(20),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.FierySteel.getFluid(50),
                null,
                ItemList.MSFMixture.get(20),
                200,
                64);
            GT_Values.RA.addMixerRecipe(
                ItemList.SFMixture.get(20),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedOrder, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.FierySteel.getFluid(50),
                null,
                ItemList.MSFMixture.get(20),
                200,
                64);
            GT_Values.RA.addMixerRecipe(
                ItemList.SFMixture.get(20),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Utility.getIntegratedCircuit(1),
                Materials.FierySteel.getFluid(50),
                null,
                ItemList.MSFMixture.get(20),
                200,
                64);

            FluidStack tFD = FluidRegistry.getFluidStack("fluiddeath", 30);
            if (tFD != null && tFD.getFluid() != null && tFD.amount > 0) {
                GT_Values.RA.addMixerRecipe(
                    ItemList.SFMixture.get(30),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedAir, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    tFD,
                    null,
                    ItemList.MSFMixture.get(30),
                    200,
                    64);
                GT_Values.RA.addMixerRecipe(
                    ItemList.SFMixture.get(30),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    tFD,
                    null,
                    ItemList.MSFMixture.get(30),
                    200,
                    64);
                GT_Values.RA.addMixerRecipe(
                    ItemList.SFMixture.get(30),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEntropy, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    tFD,
                    null,
                    ItemList.MSFMixture.get(30),
                    200,
                    64);
                GT_Values.RA.addMixerRecipe(
                    ItemList.SFMixture.get(30),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    tFD,
                    null,
                    ItemList.MSFMixture.get(30),
                    200,
                    64);
                GT_Values.RA.addMixerRecipe(
                    ItemList.SFMixture.get(30),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedOrder, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    tFD,
                    null,
                    ItemList.MSFMixture.get(30),
                    200,
                    64);
                GT_Values.RA.addMixerRecipe(
                    ItemList.SFMixture.get(30),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    tFD,
                    null,
                    ItemList.MSFMixture.get(30),
                    200,
                    64);

                GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, Materials.Lignite, 1),
                    ItemList.MSFMixture.get(6),
                    GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.NitroFuel.getFluid(1000),
                    null,
                    ItemList.Block_MSSFUEL.get(1),
                    140,
                    600);
                GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1),
                    ItemList.MSFMixture.get(4),
                    GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.NitroFuel.getFluid(750),
                    null,
                    ItemList.Block_MSSFUEL.get(1),
                    120,
                    600);
                GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1),
                    ItemList.MSFMixture.get(2),
                    GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.NitroFuel.getFluid(500),
                    null,
                    ItemList.Block_MSSFUEL.get(1),
                    100,
                    600);
                GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, Materials.Lignite, 1),
                    ItemList.MSFMixture.get(6),
                    GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.GasolinePremium.getFluid(400),
                    null,
                    ItemList.Block_MSSFUEL.get(1),
                    140,
                    600);
                GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1),
                    ItemList.MSFMixture.get(4),
                    GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.GasolinePremium.getFluid(300),
                    null,
                    ItemList.Block_MSSFUEL.get(1),
                    120,
                    600);
                GT_Values.RA.addMixerRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 1),
                    ItemList.MSFMixture.get(2),
                    GT_ModHandler.getModItem("Thaumcraft", "ItemResource", 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Utility.getIntegratedCircuit(1),
                    Materials.GasolinePremium.getFluid(200),
                    null,
                    ItemList.Block_MSSFUEL.get(1),
                    100,
                    600);
            }
        }
    }
}
