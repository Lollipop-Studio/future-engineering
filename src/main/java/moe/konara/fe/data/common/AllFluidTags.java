package moe.konara.fe.data.common;

import moe.konara.fe.FE;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class AllFluidTags extends FluidTagsProvider {
    public AllFluidTags(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
    }
}
