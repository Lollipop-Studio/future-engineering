package moe.konara.fe.data.client;

import moe.konara.fe.FE;
import moe.konara.fe.items.AllItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class AllItemModels extends ItemModelProvider {
    public AllItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FE.ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerator = getExistingFile(mcLoc("item/generated"));
        for (RegistryObject<Item> item : AllItems.ITEMS.getEntries()) {
            if (item.get() instanceof BlockItem) {
                withExistingParent(item.getId().getPath(), modLoc("block/" + item.getId().getPath()));
            } else {
                builder(itemGenerator, item.getId().getPath());
            }
        }
        // Blocks
//        withExistingParent("copper_ore", modLoc("block/copper_ore"));
//        withExistingParent("aluminum_ore", modLoc("block/aluminum_ore"));
//        withExistingParent("goran_ore", modLoc("block/goran_ore"));
//        withExistingParent("cersei_crystal_block", modLoc("block/cersei_crystal_block"));
        // Items
//        builder(itemGenerator, "copper_ingot");
//        builder(itemGenerator, "aluminum_ingot");
//        builder(itemGenerator, "goran_gem");
//        builder(itemGenerator, "cersei_crystal");
//        builder(itemGenerator, "weird_spring_water_bucket");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
