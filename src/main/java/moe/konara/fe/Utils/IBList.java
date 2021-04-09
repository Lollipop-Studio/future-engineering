package moe.konara.fe.Utils;

import moe.konara.fe.Blocks.Ores.copper_ore;
import moe.konara.fe.Items.copper_ingot;
import net.minecraft.item.ItemBlock;

public class IBList {
    public static final copper_ore copper_ore = new copper_ore();
    public static final ItemBlock ITEM_COPPER_ORE = ItemRegistryHandler.withRegistryName(new ItemBlock(copper_ore));
    public static final copper_ingot COPPER_INGOT = new copper_ingot();
}
