package moe.konara.fe.items;

import moe.konara.fe.FE;
import moe.konara.fe.Fluids.AllFluids;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.math.IEEE754rUtils;

import static net.minecraft.item.Items.BUCKET;

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
            CERSEI_CRYSTAL = ITEMS.register("cersei_crystal", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            CHARGED_CERSEI_CRYSTAL = ITEMS.register("charged_cersei_crystal", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            GEAR_CLOCK = ITEMS.register("gear_clock", () -> new Item(new Item.Properties().group(FE.FEGroup))),

            //FluidBucket
            WEIRD_SPRING_WATER_BUCKET = ITEMS.register("weird_spring_water_bucket", () -> new BucketItem(AllFluids.WEIRD_SPRING_WATER, new Item.Properties().group(FE.FEGroup).containerItem(BUCKET)))
    ;
}
