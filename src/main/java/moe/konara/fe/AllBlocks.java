package moe.konara.fe;

import moe.konara.fe.blocks.ores.CopperOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FE.ID);

//    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);

    public static final RegistryObject<Block>
        COPPER_ORE = BLOCKS.register("copper_ore", () -> new OreBlock(
                AbstractBlock.Properties
                        .create(Material.ROCK)
                        .setRequiresTool()
                        .hardnessAndResistance(3.0F, 3.0F)
            )
        )


            ;

}
