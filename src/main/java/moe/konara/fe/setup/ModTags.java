package moe.konara.fe.setup;

import moe.konara.fe.FE;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block>
            ORES_COPPER = forge("ores/copper"),
            ORES_ALUMINUM = forge("ores/aluminum")
        ;

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
//        public static final ITag.INamedTag<Fluid>
//            WEIRD_SPRING_WATER = forge("fluids/water")
//                ;

        private static ITag.INamedTag<Fluid> forge(String path) {
            return FluidTags.makeWrapperTag(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Fluid> mod(String path) {
            return FluidTags.makeWrapperTag(new ResourceLocation(FE.ID, path).toString());
        }
    }
}
