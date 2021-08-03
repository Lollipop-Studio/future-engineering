package moe.konara.fe.data.common.tags;

import moe.konara.fe.FE;
import moe.konara.fe.fluids.AllFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class AllFluidTags extends FluidTagsProvider {
    public AllFluidTags(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        for (RegistryObject<Fluid> obj : AllFluids.FLUIDS.getEntries()) {
            getOrCreateBuilder(FluidTags.WATER).add(obj.get());
        }
    }
}
