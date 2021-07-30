package moe.konara.fe.data.common.tags;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.items.AllItems;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.LinkedList;
import java.util.List;

public class ModTags {
    public static final class Blocks {
        public static final class Ores {
            // Ore Blocks
            public static final List<TagObject<Block>> ORES = new LinkedList<>();
            public static final TagObject<Block>
                    ORES_ALUMINUM = registerOreTag(forge("ores/aluminum"), AllBlocks.ALUMINUM_ORE),
                    ORES_COPPER = registerOreTag(forge("ores/copper"), AllBlocks.COPPER_ORE),
                    ORES_GORAN = registerOreTag(forge("ores/goran"), AllBlocks.GORAN_ORE);

            private static TagObject<Block> registerOreTag(ITag.INamedTag<Block> tag, RegistryObject<Block> instance) {
                TagObject<Block> obj = new TagObject<>(tag, instance);
                ORES.add(obj);
                return obj;
            }
        }

        public static final class StorageBlocks {
            // Storage Blocks
            public static final List<TagObject<Block>> STORAGE_BLOCKS = new LinkedList<>();
            public static final TagObject<Block>
                    CERSEI_CRYSTAL_BLOCK = registerOtherBlockTag(forge("storage_blocks/cersei_crystal_block"), AllBlocks.CERSEI_CRYSTAL_BLOCK),
                    CHARGED_CERSEI_CRYSTAL_BLOCK = registerOtherBlockTag(forge("storage_blocks/charged_cersei_crystal_block"), AllBlocks.CHARGED_CERSEI_CRYSTAL_BLOCK);

            private static TagObject<Block> registerOtherBlockTag(ITag.INamedTag<Block> tag, RegistryObject<Block> instance) {
                TagObject<Block> obj = new TagObject<>(tag, instance);
                STORAGE_BLOCKS.add(obj);
                return obj;
            }
        }
        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.makeWrapperTag(new ResourceLocation(FE.ID, path).toString());
        }

    }

    public static final class Items {
        public static final class Ores {
            // Ores
            public static final List<TagObject<Item>> ORES = new LinkedList<>();
            public static final TagObject<Item>
                    COPPER_ORE = registerOre(forge("ores/copper_ore"), AllItems.COPPER_ORE),
                    ALUMINUM_ORE = registerOre(forge("ores/aluminum_ore"), AllItems.ALUMINUM_ORE),
                    GORAN_ORE = registerOre(forge("ores/goran_ore"), AllItems.GORAN_ORE),
                    CERSEI_CRYSTAL_BLOCK = registerOre(forge("ores/cersei_crystal_block"), AllItems.CERSEI_CRYSTAL_BLOCK),
                    CHARGED_CERSEI_CRYSTAL_BLOCK = registerOre(forge("ores/charged_cersei_crystal_block"), AllItems.CHARGED_CERSEI_CRYSTAL_BLOCK);

            private static TagObject<Item> registerOre(ITag.INamedTag<Item> tag, RegistryObject<Item> instance) {
                TagObject<Item> obj = new TagObject<>(tag, instance);
                ORES.add(obj);
                return obj;
            }
        }

        public static final class Ingots {
            // Ingots
            public static final List<TagObject<Item>> INGOTS = new LinkedList<>();
            public static final TagObject<Item>
                    COPPER_INGOT = registerIngot(forge("ingots/copper_ingot"), AllItems.COPPER_INGOT),
                    ALUMINUM_INGOT = registerIngot(forge("ingots/aluminum_ingot"), AllItems.ALUMINUM_INGOT);

            private static TagObject<Item> registerIngot(ITag.INamedTag<Item> tag, RegistryObject<Item> instance) {
                TagObject<Item> obj = new TagObject<>(tag, instance);
                INGOTS.add(obj);
                return obj;
            }
        }

        public static final class Gems {
            // Gems
            public static final List<TagObject<Item>> GEMS = new LinkedList<>();
            public static final TagObject<Item>
                    GORAN_GEM = registerGems(forge("gems/goran_gem"), AllItems.GORAN_GEM),
                    CERSEI_CRYSTAL = registerGems(forge("gems/cersei_crystal"), AllItems.CERSEI_CRYSTAL),
                    CHARGED_CERSEI_CRYSTAL = registerGems(forge("gems/charged_cersei_crystal"), AllItems.CHARGED_CERSEI_CRYSTAL);

            private static TagObject<Item> registerGems(ITag.INamedTag<Item> tag, RegistryObject<Item> instance) {
                TagObject<Item> obj = new TagObject<>(tag, instance);
                GEMS.add(obj);
                return obj;
            }
        }

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.makeWrapperTag(new ResourceLocation(FE.ID, path).toString());
        }
    }

    public static final class Fluids {
        public static final ITag.INamedTag<Fluid> WIRED_SPRING_WATER = forge("fluids/wired_spring_water");

        private static ITag.INamedTag<Fluid> forge(String path) {
            return FluidTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Fluid> mod(String path) {
            return FluidTags.makeWrapperTag(new ResourceLocation(FE.ID, path).toString());
        }
    }

    public static class TagObject<T extends IForgeRegistryEntry<? super T>> {
        public ITag.INamedTag<T> tag;
        public RegistryObject<T> instance;

        public TagObject(ITag.INamedTag<T> tag, RegistryObject<T> instance) {
            this.tag = tag;
            this.instance = instance;
        }
    }

}
