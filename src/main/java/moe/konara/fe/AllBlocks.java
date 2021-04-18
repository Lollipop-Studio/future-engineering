package moe.konara.fe;

import moe.konara.fe.Blocks.Ores.*;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FE.ID);

    public static final RegistryObject<Block> ORE_COPPER = BLOCKS.register("copper_ore", CopperOre::new);

}
