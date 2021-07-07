package moe.konara.fe.world.biome;

import moe.konara.fe.FE;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FE.ID);

    public static RegistryObject<Biome>
            MOONLIGHT = BIOMES.register("moonlight_biome", MoonLightBiome::make);
}
