package moe.konara.fe;

import moe.konara.fe.fluids.AllFluids;
import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.items.AllItems;
import moe.konara.fe.world.biome.AllBiomes;
import moe.konara.fe.world.AllOreFeatures;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

@Mod(FE.ID)
public class FE {
    public static final String ID = "fe";
    public static final String NAME = "FE";
    public static final String VERSION = "0.0.5-alpha";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup FEGroup = new ItemGroup("fe_group") {
        @Override
        public @NotNull ItemStack createIcon() {
            return new ItemStack(AllItems.GEAR_CLOCK.get());
        }
    };

    public FE() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        modEventBus.addListener(FE::init);

        AllItems.ITEMS.register(modEventBus);
        AllBlocks.BLOCKS.register(modEventBus);
        AllFluids.FLUIDS.register(modEventBus);
        AllBiomes.BIOMES.register(modEventBus);

        forgeEventBus.addListener(AllOreFeatures::generateOres);
        forgeEventBus.addListener(AllBiomes::registerBiomes);
    }

    public static void init(final FMLCommonSetupEvent event) {
        LOGGER.info("Future Engineering Mod Started!");
    }

}
