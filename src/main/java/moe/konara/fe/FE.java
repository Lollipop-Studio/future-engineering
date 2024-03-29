package moe.konara.fe;

import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.data.common.AllBrewingRecipes;
import moe.konara.fe.fluids.AllFluids;
import moe.konara.fe.items.AllItems;
import moe.konara.fe.world.feature.AllOreFeatures;
import moe.konara.fe.world.biome.AllBiomes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

@Mod(FE.ID)
public class FE {
    public static final String ID = "fe";
    public static final String NAME = "FE";
    public static final String VERSION = "0.0.6-alpha";
    public static final Logger LOGGER = LogManager.getLogger("FutureEngineering");
    public static final ItemGroup FEGroup = new ItemGroup("fe_group") {
        @Override
        public @NotNull ItemStack createIcon() {
            return new ItemStack(AllItems.GEAR_CLOCK.get());
        }
    };

    public FE() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.fe.json");

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modEventBus.addListener(FE::init);
        modEventBus.addListener(AllBiomes::registerBiomes);

        AllItems.ITEMS.register(modEventBus);
        AllBlocks.BLOCKS.register(modEventBus);
        AllFluids.FLUIDS.register(modEventBus);
        AllBiomes.BIOMES.register(modEventBus);

        forgeEventBus.addListener(AllOreFeatures::generateOres);
    }

    public static void init(final FMLCommonSetupEvent event) {
        AllBrewingRecipes.init();
        try {
            AllBlocks.addStripping();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.debug("Future Engineering Mod Started!");
    }

}
