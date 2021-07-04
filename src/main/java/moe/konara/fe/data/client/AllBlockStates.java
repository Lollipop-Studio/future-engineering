package moe.konara.fe.data.client;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class AllBlockStates extends BlockStateProvider {
    public AllBlockStates(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> object : AllBlocks.BLOCKS.getEntries()) {
            // TODO:  Remove this if the weird_spring_water texture is provided.
            if (object.get().matchesBlock(AllBlocks.WEIRD_SPRING_WATER_BLOCK.get())) {
                continue;
            }

            simpleBlock(object.get());
        }
    }
}
