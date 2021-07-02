package moe.konara.fe.world;

import moe.konara.fe.FE;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, FE.ID);

    public static final RegistryObject<Biome> example = BIOMES.register("example", () -> {
        return (new Biome.Builder()).build();
    });

}
