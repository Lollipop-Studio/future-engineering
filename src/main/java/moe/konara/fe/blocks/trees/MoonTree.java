package moe.konara.fe.blocks.trees;

import moe.konara.fe.world.feature.AllTreeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Random;

public class MoonTree extends Tree {
    @Nullable
    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(@NotNull Random randomIn, boolean largeHive) {
        return AllTreeFeatures.MOON;
    }
}
