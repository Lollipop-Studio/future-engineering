package moe.konara.fe.data.common;

import moe.konara.fe.items.AllItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class AllBrewingRecipes {
    static {
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.MUNDANE)), Ingredient.fromItems(AllItems.TWISTED_FLOWER.get()), new ItemStack(AllItems.COAGULANT.get()));
    }
    private AllBrewingRecipes(){}
    @SuppressWarnings("EmptyMethod")
    public static void init(){}
}
