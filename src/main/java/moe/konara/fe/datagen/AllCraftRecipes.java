package moe.konara.fe.datagen;

import moe.konara.fe.AllItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AllCraftRecipes extends ForgeRecipeProvider {
    public static final Map<String, ShapedRecipeBuilder> entries = new HashMap<>();

    public AllCraftRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    public static final ShapedRecipeBuilder
            CERSEI = register("sercei_crystal_block", () ->
            ShapedRecipeBuilder.shapedRecipe(AllItems.CERSEI_CRYSTAL_BLOCK.get(), 1)
                    .patternLine("II")
                    .patternLine("II")
                    .key('I', AllItems.CERSEI_CRYSTAL::get)
                    .addCriterion("cersei_crystal_block", InventoryChangeTrigger.Instance.forItems(AllItems.CERSEI_CRYSTAL.get()))
    );

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        entries.values().forEach(
                entry -> {
                    entry.build(consumer);
                }
        );
    }

    private static ShapedRecipeBuilder register(String name, Supplier<ShapedRecipeBuilder> supplier) {
        entries.putIfAbsent(name, supplier.get());
        return supplier.get();
    }

}
