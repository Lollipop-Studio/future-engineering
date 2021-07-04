package moe.konara.fe.data.common;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.setup.ModTags;
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
        getOrCreateBuilder(ModTags.Blocks.Ores.ORES_COPPER).add(AllBlocks.COPPER_ORE.get());
        getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.Ores.ORES_COPPER);


    }
}
