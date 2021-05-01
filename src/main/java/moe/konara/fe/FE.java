package moe.konara.fe;

import moe.konara.fe.world.OreGen;
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

@Mod(FE.ID)
public class FE {
    public static final String ID = "fe";
    public static final String NAME = "FE";
    public static final String VERSION = "0.0.2-alpha";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup FEGroup = new ItemGroup("fe_group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AllItems.COPPER_INGOT.get());
        }
    };

    public FE() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(FE::init);
        AllItems.ITEMS.register(modEventBus);
        AllBlocks.BLOCKS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::generateOres);
    }

    public static void init(final FMLCommonSetupEvent event) {


        LOGGER.info("Future Engineering Mod Started!");
    }

}
