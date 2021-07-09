package moe.konara.fe.data.common.tags;

import moe.konara.fe.FE;
import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
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
                    ORES_COPPER = registerOreTag(forge("ores/copper"), AllBlocks.COPPER_ORE);

            private static TagObject<Block> registerOreTag(ITag.INamedTag<Block> tag, RegistryObject<Block> instance) {
                TagObject<Block> obj = new TagObject<>(tag, instance);
                ORES.add(obj);
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
