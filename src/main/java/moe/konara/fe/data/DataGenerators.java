package moe.konara.fe.data;

import moe.konara.fe.data.client.AllBlockStates;
import moe.konara.fe.data.client.AllItemModels;
import moe.konara.fe.data.common.tags.AllBlockTags;
import moe.konara.fe.data.common.AllCraftRecipes;
import moe.konara.fe.data.common.AllLootTables;
import moe.konara.fe.data.common.tags.AllFluidTags;
import moe.konara.fe.data.common.tags.AllItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {
    }

    @SubscribeEvent
    public static void dataGen(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            gen.addProvider(new AllBlockStates(gen, existingFileHelper));
            gen.addProvider(new AllItemModels(gen, existingFileHelper));
        }

        if (event.includeServer()) {
            AllBlockTags allBlockTags = new AllBlockTags(gen, existingFileHelper);
            gen.addProvider(allBlockTags);
            gen.addProvider(new AllItemTags(gen, allBlockTags, existingFileHelper));
            gen.addProvider(new AllFluidTags(gen, existingFileHelper));
            gen.addProvider(new AllLootTables(gen));
            gen.addProvider(new AllCraftRecipes(gen));
        }

    }
}
