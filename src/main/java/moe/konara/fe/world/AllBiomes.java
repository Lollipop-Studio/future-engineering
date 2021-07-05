package moe.konara.fe.world;

import moe.konara.fe.FE;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FE.ID);

    public static RegistryObject<Biome>
            MOONLIGHT = BIOMES.register("moonlightbiome", MoonLightBiome::get);
            //TODO 人类至今未曾得知为什么崩溃      人間はなぜ彼らが崩壊したのかまだ知らない
}
