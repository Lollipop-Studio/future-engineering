package moe.konara.fe.world.feature;

import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class AllTreeFeatures {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SKELETON_TREE = Feature.TREE.withConfiguration((
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(AllBlocks.SKELETON_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(AllBlocks.SKELETON_LEAVE.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()
    );
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_SKELETON_TREE = Feature.TREE.withConfiguration((
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(AllBlocks.SKELETON_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(AllBlocks.SKELETON_LEAVE.get().getDefaultState()),
                    new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build());
}
