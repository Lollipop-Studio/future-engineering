package moe.konara.fe.blocks;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.trees.SkeletonTree;
import moe.konara.fe.fluids.AllFluids;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

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
            )),
            SKELETON_LOG = BLOCKS.register("skeleton_log", () -> createLogBlock(MaterialColor.BLUE, MaterialColor.GRAY)),
            STRIPPED_SKELETON_LOG = BLOCKS.register("stripped_skeleton_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD))),
            MAGMA_OBSIDIAN = BLOCKS.register("magma_obsidian", () -> new MagmaObsidian(
                    AbstractBlock.Properties
                            .create(Material.ROCK)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                            .sound(SoundType.STONE)
                            .hardnessAndResistance(50.0F, 1200.0F)
                            .setLightLevel((lightLevel) -> 10)
            )),

            SKELETON_SAPLING = BLOCKS.register("skeleton_sapling", () -> new SaplingBlock(new SkeletonTree(),
                    AbstractBlock.Properties
                            .create(Material.PLANTS)
                            .doesNotBlockMovement()
                            .tickRandomly()
                            .zeroHardnessAndResistance()
                            .sound(SoundType.PLANT)) {
                @Override
                @NotNull
                public VoxelShape getShape(@NotNull BlockState state, @NotNull IBlockReader worldIn, @NotNull BlockPos pos, @NotNull ISelectionContext context) {
                    return Block.makeCuboidShape(0F, 0F, 0F, 16F, 16F, 16F);
                }
            });

    //Fluid Block
    public static final RegistryObject<FlowingFluidBlock>
            WEIRD_SPRING_WATER_BLOCK = BLOCKS.register("weird_spring_water", () -> new FlowingFluidBlock(
            AllFluids.WEIRD_SPRING_WATER, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).noDrops()));


    private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
    }

    //Leaves
    public static final RegistryObject<LeavesBlock>
            SKELETON_LEAVE = BLOCKS.register("skeleton_leave", () -> new LeavesBlock(
            AbstractBlock.Properties
                    .create(Material.LEAVES)
                    .notSolid()
                    .hardnessAndResistance(0.2F, 0.2F)
                    .sound(SoundType.PLANT)
    ));

    public static void addStripping() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = Class.forName("net.minecraft.item.AxeItem");
        Field map = clazz.getDeclaredField("BLOCK_STRIPPING_MAP");

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(map, map.getModifiers() & ~Modifier.FINAL);

        map.setAccessible(true);
        Map<Block, Block> strip_map = (Map<Block, Block>) map.get(null);
        HashMap<Block, Block> new_map = new HashMap<>(strip_map);
        new_map.put(AllBlocks.SKELETON_LOG.get(), AllBlocks.STRIPPED_SKELETON_LOG.get());
        map.set(null, new_map);
    }
}
