package moe.konara.fe.datagen;

import moe.konara.fe.datagen.client.ModBlockStateProvider;
import moe.konara.fe.datagen.client.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}
    
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void dataGen(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            gen.addProvider(new ModItemModelProvider(gen, existingFileHelper));
            gen.addProvider(new ModBlockStateProvider(gen, existingFileHelper));
        }

        if (event.includeServer()) {

        }

    }
}
