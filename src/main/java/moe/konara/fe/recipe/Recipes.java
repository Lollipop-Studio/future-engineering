package moe.konara.fe.recipe;

import moe.konara.fe.Utils.IBList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
    public Recipes(){
        GameRegistry.addSmelting(IBList.copper_ore, new ItemStack(IBList.COPPER_INGOT), 0.6F);
    }
}
