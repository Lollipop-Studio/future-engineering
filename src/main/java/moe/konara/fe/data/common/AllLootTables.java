package moe.konara.fe.data.common;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.items.AllItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.LimitCount;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AllLootTables extends ForgeLootTableProvider {
    public AllLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(AllBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    public static class AllBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            registerDropSelfLootTable(AllBlocks.COPPER_ORE.get());
            registerDropSelfLootTable(AllBlocks.ALUMINUM_ORE.get());
            registerDropSelfLootTable(AllBlocks.GORAN_ORE.get());
            registerDropSelfLootTable(AllBlocks.SKELETON_LOG.get());
            registerDropSelfLootTable(AllBlocks.STRIPPED_SKELETON_LOG.get());
            registerDropSelfLootTable(AllBlocks.MAGMA_OBSIDIAN.get());
            registerDropSelfLootTable(AllBlocks.SKELETON_SAPLING.get());
            registerLootTable(AllBlocks.CERSEI_CRYSTAL_BLOCK.get(),
                    (cersei_crystal_block) ->
                            droppingWithSilkTouch(cersei_crystal_block,
                                    withExplosionDecay(cersei_crystal_block, ItemLootEntry.builder(AllItems.CERSEI_CRYSTAL.get())
                                            .acceptFunction(SetCount.builder(RandomValueRange.of(2.0F, 4.0F)))
                                            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                                            .acceptFunction(LimitCount.func_215911_a(IntClamper.func_215843_a(1, 4))))));
            registerLootTable(AllBlocks.CHARGED_CERSEI_CRYSTAL_BLOCK.get(),
                    (charged_cersei_crystal_block) ->
                            droppingWithSilkTouch(charged_cersei_crystal_block,
                                    withExplosionDecay(charged_cersei_crystal_block, ItemLootEntry.builder(AllItems.CHARGED_CERSEI_CRYSTAL.get())
                                            .acceptFunction(SetCount.builder(RandomValueRange.of(2.0F, 4.0F)))
                                            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                                            .acceptFunction(LimitCount.func_215911_a(IntClamper.func_215843_a(1, 4)))))
            );
            registerLootTable(AllBlocks.GORAN_ORE.get(),
                    (goran_ore) ->
                            droppingWithSilkTouch(goran_ore,
                                    withExplosionDecay(goran_ore, ItemLootEntry.builder(AllItems.GORAN_GEM.get()))
                                            .acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 3.0F)))
                                            .acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE))
                                            .acceptFunction(LimitCount.func_215911_a(IntClamper.func_215843_a(1, 4)))));
            registerLootTable(AllBlocks.SKELETON_LEAVE.get(),
                    (skeleton_leave) ->
                            droppingWithSilkTouchOrShears(skeleton_leave, withSurvivesExplosion(skeleton_leave, withExplosionDecay(skeleton_leave, ItemLootEntry.builder(AllItems.TWISTED_FLOWER.get()).acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F)))).acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.033333333F, 0.036666663F, 0.03888883F, 0.04F, 0.1F))))
                    );
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return AllBlocks.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }

}
