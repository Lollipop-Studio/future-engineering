package moe.konara.fe.world.biome;

import com.google.common.collect.ImmutableList;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class MoonLightBiome {
    public static Biome make(){
        //TODO 未完成
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        //基本动物
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.SHEEP, 12, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.PIG, 10, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.CHICKEN, 10, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.COW, 8, 4, 4));
        //基本怪物
        mobspawninfo$builder.withSpawner(EntityClassification.AMBIENT, new MobSpawnInfo.Spawners(EntityType.BAT, 10, 8, 8));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 90, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 10, 1, 1));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 90, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4));
        mobspawninfo$builder.withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4));

        //表面制造
        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        //结构生成
        biomegenerationsettings$builder.withStructure(StructureFeatures.MINESHAFT);
        biomegenerationsettings$builder.withStructure(StructureFeatures.STRONGHOLD);
        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL);
        biomegenerationsettings$builder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
        biomegenerationsettings$builder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);

        //生成表面湖
        ConfiguredFeature<?, ?> WEIRD_LAKE = register("weird_lake", Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(AllBlocks.WEIRD_SPRING_WATER_BLOCK.get().getDefaultState())).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(10))));
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, WEIRD_LAKE);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);

        //普遍の方块
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIRT);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GRAVEL);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GRANITE);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIORITE);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_ANDESITE);
        //原版矿石
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_COAL);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_IRON);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_GOLD);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_REDSTONE);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_DIAMOND);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_LAPIS);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.ORE_EMERALD);
        //withDisks
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_SAND);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_CLAY);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Features.DISK_GRAVEL);
        //withPlainGrassVegetation
        ConfiguredFeature<BaseTreeFeatureConfig, ?> OAK = register("oak", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AllBlocks.MOON_LOG.get().getDefaultState()), new SimpleBlockStateProvider(AllBlocks.MOON_TREE_LEAVE.get().getDefaultState()), new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));
        ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_MOON_TREE = register("fancy_moon_tree", Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(AllBlocks.MOON_LOG.get().getDefaultState()), new SimpleBlockStateProvider(AllBlocks.MOON_TREE_LEAVE.get().getDefaultState()), new FancyFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build()));
        ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_MOON_TREE_BEES = register("fancy_moon_tree_bees", Feature.TREE.withConfiguration(FANCY_MOON_TREE.getConfig().copy(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT))));
        ConfiguredFeature<BaseTreeFeatureConfig, ?> MOON_TREE_BEES = register("moon_tree_bees", Feature.TREE.withConfiguration(OAK.getConfig().copy(ImmutableList.of(Features.Placements.BEES_005_PLACEMENT))));
        ConfiguredFeature<?, ?> PLAIN_VEGETATION = register("moonlight_vegetation", Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(FANCY_MOON_TREE_BEES.withChance(0.33333334F)), MOON_TREE_BEES)).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1))));
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, PLAIN_VEGETATION);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.FLOWER_PLAIN_DECORATED);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.PATCH_GRASS_PLAIN);
        //withLavaAndWaterSprings
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_WATER);
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.SPRING_LAVA);
        //withFrozenTopLayer
        biomegenerationsettings$builder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Features.FREEZE_TOP_LAYER);

        return (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .setEffects(
                        (new BiomeAmbience.Builder())
                                .withGrassColor(0x46747A)
                                .setWaterColor(0x28323B)
                                .setWaterFogColor(0x1C2836)
                                .setFogColor(0xEAD8F8)
                                .withFoliageColor(0x70718E)
                                .withSkyColor(0x1E2035)
                                .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                                .build()
                )
                .withMobSpawnSettings(mobspawninfo$builder.build())
                .withGenerationSettings(biomegenerationsettings$builder.build())
                .build();
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
