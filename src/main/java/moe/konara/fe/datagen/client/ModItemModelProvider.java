package moe.konara.fe.datagen.client;

import moe.konara.fe.FE;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Blocks
        withExistingParent("copper_ore", modLoc("block/copper_ore"));
        withExistingParent("aluminum_ore", modLoc("block/aluminum_ore"));
        withExistingParent("goran_ore", modLoc("block/goran_ore"));
        withExistingParent("cersei_crystal_block", modLoc("block/cersei_crystal_block"));

        // Items
        ModelFile itemGenerator = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerator, "copper_ingot");
        builder(itemGenerator, "aluminum_ingot");
        builder(itemGenerator, "goran_gem");
        builder(itemGenerator, "cersei_crystal");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
