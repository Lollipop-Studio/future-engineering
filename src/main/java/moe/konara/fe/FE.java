package moe.konara.fe;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FE.ID)
public class FE {
    public static final String ID = "fe";
    public static final String NAME = "FE";
    public static final String VERSION = "0.0.1-alpha";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup FEGroup = new FEGroup();

    public FE() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(FE::init);
        AllItems.ITEMS.register(modEventBus);
        AllBlocks.BLOCKS.register(modEventBus);
    }

    public static void init(final FMLCommonSetupEvent event) {
        LOGGER.info("Future Engineering Mod Started!");
    }

    private static class FEGroup extends ItemGroup {
        public FEGroup() {
            super("fe_group");
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(AllItems.INGOT_COPPER.get());
        }
    }
}
