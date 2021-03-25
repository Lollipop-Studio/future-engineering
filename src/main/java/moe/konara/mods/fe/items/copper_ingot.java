package moe.konara.mods.fe.items;

import moe.konara.mods.fe.FE;
import net.minecraft.item.Item;

public class copper_ingot extends Item{
        public copper_ingot() {
            this.setMaxStackSize(64);
            this.setTranslationKey(FE.MOD_ID + ".copper_ingot");
            this.setRegistryName("copper_ingot");
            this.setCreativeTab(FE.TAB_FE);
        }
}
