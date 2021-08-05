package moe.konara.fe.world.feature;

import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.world.biome.AllBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

public class AllOreFeatures {
    public static void generateOres(final BiomeLoadingEvent event) {
        switch (event.getCategory()) {
            case NETHER:
                //MagmaBlock
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        generateOre(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER,
                                AllBlocks.MAGMA_OBSIDIAN.get().getDefaultState(),
                                    8,1,33,15));
                break;
            case THEEND:
                break;
            default:
                // Copper
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        generateOre(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                AllBlocks.COPPER_ORE.get().getDefaultState(),
                                8, 1, 60, 15));
                // Aluminum
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                        generateOre(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                AllBlocks.ALUMINUM_ORE.get().getDefaultState(),
                                7, 3, 55, 13));
                //Goran
                if(Objects.equals(event.getName(), AllBiomes.MOONLIGHT.getId()))
                    event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                            generateOre(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                                    AllBlocks.GORAN_ORE.get().getDefaultState(),
                                    8, 10, 50, 8));
                break;
        }
    }

    private static ConfiguredFeature<?, ?> generateOre(RuleTest fillerType, BlockState state,
                                                       int veinSize, int minHeight, int maxHeight, int amount) {
        return Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
                .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                .square().count(amount);
    }
}
