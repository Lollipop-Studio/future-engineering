package moe.konara.fe.Utils;

import moe.konara.fe.FE;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeInventory {
    public static final CreativeTabs TAB_MAIN = new net.minecraft.creativetab.CreativeTabs(FE.MOD_ID+".main") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistryHandler.copper_ingot);
        }
    };
}
