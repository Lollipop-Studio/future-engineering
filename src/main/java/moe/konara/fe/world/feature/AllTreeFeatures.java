package moe.konara.fe.world.feature;

import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class AllTreeFeatures {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> SKELETON = Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(AllBlocks.SKELETON_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(AllBlocks.SKELETON_LEAVE.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1)
            ).setIgnoreVines().build()
    );
}
