package moe.konara.fe.world.biome;

import moe.konara.fe.FE;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FE.ID);

    public static RegistryObject<Biome>
            MOONLIGHT = BIOMES.register("moonlight_biome", MoonLightBiome::make);

    public static void registerBiomes(final FMLCommonSetupEvent event) {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, AllBiomes.MOONLIGHT.getId()), 1000));
    }
}
