package moe.konara.mods.fe.Items;

import moe.konara.mods.fe.FE;
import moe.konara.mods.fe.Utils.CreativeInventory;
import net.minecraft.item.Item;

public class copper_ingot extends Item{
        public copper_ingot() {
            this.setMaxStackSize(64);
            this.setTranslationKey(FE.MOD_ID + ".copper_ingot");
            this.setRegistryName(FE.MOD_ID, "copper_ingot");

            // this.setRegistryName("copper_ingot");
            this.setCreativeTab(CreativeInventory.TAB_MAIN);
        }
}
