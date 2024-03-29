package moe.konara.fe.data.common.tags;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class AllBlockTags extends BlockTagsProvider {
    public AllBlockTags(DataGenerator gen, ExistingFileHelper existingFileHelper) {
        super(gen, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        ModTags.Blocks.Ores.ORES.forEach((obj) -> {
            getOrCreateBuilder(obj.tag).add(obj.instance.get());
            getOrCreateBuilder(Tags.Blocks.ORES).addTag(obj.tag);
        });
        ModTags.Blocks.StorageBlocks.STORAGE_BLOCKS.forEach((obj) -> {
            getOrCreateBuilder(obj.tag).add(obj.instance.get());
            getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(obj.tag);
        });
        getOrCreateBuilder(BlockTags.LOGS).add(AllBlocks.SKELETON_LOG.get());
    }
}
