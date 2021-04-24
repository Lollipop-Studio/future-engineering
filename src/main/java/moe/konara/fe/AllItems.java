package moe.konara.fe;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FE.ID);

//    public static final RegistryObject<Item> COPPER_ORE = ITEMS.register("copper_ore", () -> new BlockItem(AllBlocks.COPPER_ORE, new Item.Properties().group(FE.FEGroup)));
//    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup)));

    public static final RegistryObject<Item>
            COPPER_ORE = ITEMS.register("copper_ore", () -> new BlockItem(AllBlocks.COPPER_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup)))

            ;

}
