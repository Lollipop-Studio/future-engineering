package moe.konara.fe.data.common.tags;

import moe.konara.fe.FE;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class AllItemTags extends ItemTagsProvider {
    public AllItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
    }
}
