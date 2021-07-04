package moe.konara.fe.data.common;

import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.items.AllItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipe;
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
        ShapedRecipeBuilder.shapedRecipe(AllItems.CERSEI_CRYSTAL_BLOCK.get())
                .patternLine("II")
                .patternLine("II")
                .key('I', AllItems.CERSEI_CRYSTAL.get())
                .addCriterion("cersei_crystal_block", InventoryChangeTrigger.Instance.forItems(AllItems.CERSEI_CRYSTAL.get()))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(AllItems.CHARGED_CERSEI_CRYSTAL_BLOCK.get())
                .patternLine("II")
                .patternLine("II")
                .key('I', AllItems.CHARGED_CERSEI_CRYSTAL.get())
                .addCriterion("charged_cersei_crystal_block", InventoryChangeTrigger.Instance.forItems(AllItems.CHARGED_CERSEI_CRYSTAL.get()))
                .build(consumer);
    }
}
