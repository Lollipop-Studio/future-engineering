package moe.konara.fe.blocks;

import moe.konara.fe.FE;
import moe.konara.fe.Fluids.AllFluids;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FE.ID);

    public static final RegistryObject<Block>
            COPPER_ORE = BLOCKS.register("copper_ore", () -> new OreBlock(
            AbstractBlock.Properties
                    .create(Material.ROCK)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
    )),
            ALUMINUM_ORE = BLOCKS.register("aluminum_ore", () -> new OreBlock(
                    AbstractBlock.Properties
                            .create(Material.ROCK)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .hardnessAndResistance(3.0F, 3.0F)
            )),
            CERSEI_CRYSTAL_BLOCK = BLOCKS.register("cersei_crystal_block", () -> new CerseiCrystalBlock(
                    AbstractBlock.Properties
                            .create(Material.ICE)
                            .tickRandomly()
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .sound(SoundType.GLASS)
                            .notSolid()
                            .hardnessAndResistance(3.0F, 3.0F)
            )),
            CHARGED_CERSEI_CRYSTAL_BLOCK = BLOCKS.register("charged_cersei_crystal_block", () -> new CerseiCrystalBlock(
                    AbstractBlock.Properties
                            .create(Material.ICE)
                            .tickRandomly()
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .sound(SoundType.GLASS)
                            .notSolid()
                            .hardnessAndResistance(3.0F, 3.0F)
            )),
            GORAN_ORE = BLOCKS.register("goran_ore", () -> new OreBlock(
                    AbstractBlock.Properties
                            .create(Material.ROCK)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .hardnessAndResistance(50.0F, 5.0F)
            ));
    //Fluid Block
    public static final RegistryObject<FlowingFluidBlock>
            WEIRD_SPRING_WATER_BLOCK = BLOCKS.register("weird_spring_water", () -> new FlowingFluidBlock(
            AllFluids.WEIRD_SPRING_WATER, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));

}
