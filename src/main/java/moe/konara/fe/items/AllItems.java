package moe.konara.fe.items;

import moe.konara.fe.FE;
import moe.konara.fe.fluids.AllFluids;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;

public class AllItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FE.ID);

    public static final RegistryObject<Item>

            // Ores
            COPPER_ORE = ITEMS.register("copper_ore", () -> new BlockItem(AllBlocks.COPPER_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            ALUMINUM_ORE = ITEMS.register("aluminum_ore", () -> new BlockItem(AllBlocks.ALUMINUM_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            GORAN_ORE = ITEMS.register("goran_ore", () -> new BlockItem(AllBlocks.GORAN_ORE.get(), new Item.Properties().group(FE.FEGroup))),
            CERSEI_CRYSTAL_BLOCK = ITEMS.register("cersei_crystal_block", () -> new BlockItem(AllBlocks.CERSEI_CRYSTAL_BLOCK.get(), new Item.Properties().group(FE.FEGroup))),
            CHARGED_CERSEI_CRYSTAL_BLOCK = ITEMS.register("charged_cersei_crystal_block", () -> new BlockItem(AllBlocks.CHARGED_CERSEI_CRYSTAL_BLOCK.get(), new Item.Properties().group(FE.FEGroup))),
            MAGMA_OBSIDIAN = ITEMS.register("magma_obsidian", () -> new BlockItem(AllBlocks.MAGMA_OBSIDIAN.get(), new Item.Properties().group(FE.FEGroup))),

            // Ingots
            COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().group(FE.FEGroup))),

            //Gems
            GORAN_GEM = ITEMS.register("goran_gem", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            CERSEI_CRYSTAL = ITEMS.register("cersei_crystal", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            CHARGED_CERSEI_CRYSTAL = ITEMS.register("charged_cersei_crystal", () -> new Item(new Item.Properties().group(FE.FEGroup))),

            // Logs
            SKELETON_LOG = ITEMS.register("skeleton_log", () -> new BlockItem(AllBlocks.SKELETON_LOG.get(), new Item.Properties().group(FE.FEGroup))),
            STRIPPED_SKELETON_LOG = ITEMS.register("stripped_skeleton_log", () -> new BlockItem(AllBlocks.STRIPPED_SKELETON_LOG.get(), new Item.Properties().group(FE.FEGroup))),

            //FluidBucket
            WEIRD_SPRING_WATER_BUCKET = ITEMS.register("weird_spring_water_bucket", () -> new BucketItem(AllFluids.WEIRD_SPRING_WATER, new Item.Properties().group(FE.FEGroup).containerItem(BUCKET))),

            // Others
            GEAR_CLOCK = ITEMS.register("gear_clock", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            TWISTED_FLOWER = ITEMS.register("twisted_flower", () -> new Item(new Item.Properties().group(FE.FEGroup))),
            COAGULANT = ITEMS.register("coagulant", () -> new Item(new Item.Properties().group(FE.FEGroup))),

            //Leaves
            SKELETON_LEAVE = ITEMS.register("skeleton_leave", () -> new BlockItem(AllBlocks.SKELETON_LEAVE.get(), new Item.Properties().group(FE.FEGroup))),

            // Saplings
            SKELETON_SAPLING = ITEMS.register("skeleton_sapling", () -> new BlockItem(AllBlocks.SKELETON_SAPLING.get(), new Item.Properties().group(FE.FEGroup)))
        ;
}
