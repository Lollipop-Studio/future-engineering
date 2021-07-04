package moe.konara.fe.items;

import moe.konara.fe.FE;
import moe.konara.fe.Fluids.AllFluids;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FE.ID);

    public static final RegistryObject<Item>

            // Ores
            COPPER_ORE = ITEMS.register("copper_ore", () -> new BlockItem(AllBlocks.COPPER_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))),
            ALUMINUM_ORE = ITEMS.register("aluminum_ore", () -> new BlockItem(AllBlocks.ALUMINUM_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))),
            GORAN_ORE = ITEMS.register("goran_ore", () -> new BlockItem(AllBlocks.GORAN_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))),
            CERSEI_CRYSTAL_BLOCK = ITEMS.register("cersei_crystal_block", () -> new BlockItem(AllBlocks.CERSEI_CRYSTAL_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))),
            CHARGED_CERSEI_CRYSTAL_BLOCK = ITEMS.register("charged_cersei_crystal_block", () -> new BlockItem(AllBlocks.CHARGED_CERSEI_CRYSTAL_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))),

    // Ingots
    COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS))),
            ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS))),
            GORAN_GEM = ITEMS.register("goran_gem", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS))),
            CERSEI_CRYSTAL = ITEMS.register("cersei_crystal", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS))),
            CHARGED_CERSEI_CRYSTAL = ITEMS.register("charged_cersei_crystal", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS))),
            GEAR_CLOCK = ITEMS.register("gear_clock", () -> new Item(new Item.Properties().group(FE.FEGroup))),

    //FluidBucket
    WEIRD_SPRING_WATER_BUCKET = ITEMS.register("weird_spring_water_bucket", () -> new BucketItem(AllFluids.WEIRD_SPRING_WATER, new Item.Properties().group(ItemGroup.MISC).containerItem(BUCKET)));
}
