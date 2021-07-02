package moe.konara.fe.items;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FE.ID);

    public static final RegistryObject<Item>

            // Ores
            COPPER_ORE = ITEMS.register("copper_ore", () -> new BlockItem(AllBlocks.COPPER_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            ALUMINUM_ORE = ITEMS.register("aluminum_ore", () -> new BlockItem(AllBlocks.ALUMINUM_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            GORAN_ORE = ITEMS.register("goran_ore", () -> new BlockItem(AllBlocks.GORAN_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            CERSEI_CRYSTAL_BLOCK = ITEMS.register("cersei_crystal_block", () -> new BlockItem(AllBlocks.CERSEI_CRYSTAL_BLOCK.get(), new Item.Properties().group(FE.FEGroup))),

            // Ingots
            COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            GORAN_GEM = ITEMS.register("goran_gem", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            CERSEI_CRYSTAL = ITEMS.register("cersei_crystal", () -> new Item(new Item.Properties().group(FE.FEGroup)))
    ;
}
