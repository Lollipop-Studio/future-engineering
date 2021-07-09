package moe.konara.fe.data.common.tags;

import moe.konara.fe.FE;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
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
    }
}
