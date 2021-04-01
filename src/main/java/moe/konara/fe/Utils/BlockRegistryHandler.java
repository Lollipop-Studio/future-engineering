package moe.konara.fe.Utils;

import moe.konara.fe.Blocks.Ores.copper_ore;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
@Mod.EventBusSubscriber
public class BlockRegistryHandler
{
    public static final copper_ore copper_ore = new copper_ore();
    @SubscribeEvent public static void onRegistry(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(copper_ore);
    }
}
