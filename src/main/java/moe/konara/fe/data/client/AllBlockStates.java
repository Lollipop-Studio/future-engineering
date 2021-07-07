package moe.konara.fe.data.client;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class AllBlockStates extends BlockStateProvider {
    public AllBlockStates(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> object : AllBlocks.BLOCKS.getEntries()) {
            if (object.get().matchesBlock(AllBlocks.WEIRD_SPRING_WATER_BLOCK.get())) {
                ModelFile.ExistingModelFile ret = new ModelFile.ExistingModelFile(mcLoc("block/water"), this.models().existingFileHelper);
                ret.assertExistence();
                simpleBlock(object.get(), ret);
                continue;
            }
            simpleBlock(object.get());
        }
    }
}
