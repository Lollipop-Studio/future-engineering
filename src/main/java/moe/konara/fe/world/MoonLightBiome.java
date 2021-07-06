package moe.konara.fe.world;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class MoonLightBiome {

    private static Biome moonlight;
    public MoonLightBiome(){


    }

    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }

    public static Biome make(){
        //TODO 未完成
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.withSpawnsWithHorseAndDonkey(mobspawninfo$builder);

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.GRASS);

        DefaultBiomeFeatures.withStrongholdAndMineshaft(biomegenerationsettings$builder);
        biomegenerationsettings$builder.withStructure(StructureFeatures.RUINED_PORTAL);
        DefaultBiomeFeatures.withCavesAndCanyons(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withLavaAndWaterLakes(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withMonsterRoom(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withNoiseTallGrass(biomegenerationsettings$builder);

        DefaultBiomeFeatures.withCommonOverworldBlocks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withOverworldOres(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withDisks(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withPlainGrassVegetation(biomegenerationsettings$builder);

        DefaultBiomeFeatures.withNormalMushroomGeneration(biomegenerationsettings$builder);

        DefaultBiomeFeatures.withLavaAndWaterSprings(biomegenerationsettings$builder);
        DefaultBiomeFeatures.withFrozenTopLayer(biomegenerationsettings$builder);
        moonlight = (new Biome.Builder())
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .setEffects(
                        (new BiomeAmbience.Builder())
                                .setWaterColor(0xFEFEFF)
                                .setWaterFogColor(329011)
                                .setFogColor(0xEAD8F8)
                                .withSkyColor(getSkyColorWithTemperatureModifier(0.8F))
                                .setMoodSound(MoodSoundAmbience.DEFAULT_CAVE)
                                .build()
                )
                .withMobSpawnSettings(mobspawninfo$builder.build())
                .withGenerationSettings(biomegenerationsettings$builder.build())
                .build();
        return moonlight;
    }
}
