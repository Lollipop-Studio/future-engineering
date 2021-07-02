package moe.konara.fe.data.common;

import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.items.AllItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

public class AllCraftRecipes extends ForgeRecipeProvider {
    public AllCraftRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(AllBlocks.COPPER_ORE.get()), AllItems.COPPER_INGOT.get(), 0.35f, 200).addCriterion("copper_ingot", InventoryChangeTrigger.Instance.forItems(AllItems.COPPER_ORE.get(), AllItems.COPPER_INGOT.get())).build(consumer);
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(AllBlocks.ALUMINUM_ORE.get()), AllItems.ALUMINUM_INGOT.get(), 0.35f, 200).addCriterion("aluminum_ingot", InventoryChangeTrigger.Instance.forItems(AllItems.ALUMINUM_ORE.get(), AllItems.ALUMINUM_INGOT.get())).build(consumer);
    }
}
