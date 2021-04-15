package moe.konara.fe;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FE.ID);

    public static final RegistryObject<Item> ORE_COPPER = ITEMS.register("copper_ore", () -> new BlockItem(AllBlocks.ORE_COPPER.get(), new Item.Properties().group(FE.FEGroup)));
    public static final RegistryObject<Item> INGOT_COPPER = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup)));

}
