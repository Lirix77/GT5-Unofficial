package gregtech.loaders.postload.recipe;

public class GT_RecipeLoader implements Runnable {

    @Override
    public void run() {
        new AlloySmelterRecipes().run();
        new ArcFurnaceRecipes().run();
        new AssemblerRecipes().run();
        new AssemblingLineRecipes().run();
        new AutoclaveRecipes().run();
        new BendingMachineRecipes().run();
        new BlastFurnaceRecipes().run();
        new BrewingMachineRecipes().run();
        new CentrifugeRecipes().run();
        new ChemicalBathRecipes().run();
        new ChemicalReactorRecipes().run();
        new CircuitAssemblerRecipes().run();
        new CraftingRecipes().run();
        new CompressorRecipes().run();
        new CuttingMachineRecipes().run();
        new DistillationRecipes().run();
        new ElectrolyzerRecipes().run();
        new ExtractorRecipes().run();
        new ExtruderRecipes().run();
        new FermenterRecipes().run();
        new FluidExtractorRecipes().run();
        new FluidSolidifierRecipes().run();
        new ForgeHammerRecipes().run();
        new FormingPressRecipes().run();
        new ImplosionCompressorRecipes().run();
        new LaserEngraverRecipes().run();
        new LatheRecipes().run();
        new MaceratorRecipes().run();
        new MixerRecipes().run();
        new SifterRecipes().run();
        new VacuumFreezerRecipes().run();
        new WiremillRecipes().run();
    }
}
