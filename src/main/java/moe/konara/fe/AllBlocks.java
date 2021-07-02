package moe.konara.fe;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;
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
            CERSEI_CRYSTAL_BLOCK = BLOCKS.register("cersei_crystal_block", () -> new OreBlock(
                    AbstractBlock.Properties
                            .create(Material.ROCK)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .hardnessAndResistance(3.0F, 3.0F)
                            .notSolid()
                            .sound(SoundType.GLASS)
            )),
            GORAN_ORE = BLOCKS.register("goran_ore", () -> new OreBlock(
                    AbstractBlock.Properties
                            .create(Material.ROCK)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .hardnessAndResistance(50.0F, 5.0F)
            ))
                    ;

}
