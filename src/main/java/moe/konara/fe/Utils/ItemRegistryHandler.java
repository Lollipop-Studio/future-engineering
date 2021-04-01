package moe.konara.fe.Utils;


import moe.konara.fe.Items.copper_ingot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber
public class ItemRegistryHandler {
    public static final copper_ingot COPPER_INGOT = new copper_ingot();
    public static final ItemBlock ITEM_COPPER_ORE = withRegistryName(new ItemBlock(BlockRegistryHandler.copper_ore));
    public static ItemBlock withRegistryName(ItemBlock item){
        item.setRegistryName(Objects.requireNonNull(item.getBlock().getRegistryName()));
        return item;
    }
    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(COPPER_INGOT);
        registry.register(ITEM_COPPER_ORE);
    }
    @SideOnly(Side.CLIENT) private static void registerModel (Item item){
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()),"inventory");
        ModelLoader.setCustomModelResourceLocation(item,0, modelResourceLocation);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event){
        registerModel(COPPER_INGOT);
        registerModel(ITEM_COPPER_ORE);
    }
}