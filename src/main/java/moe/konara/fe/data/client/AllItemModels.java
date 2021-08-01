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
            if (item.get() instanceof BlockItem && !item.get().equals(AllItems.MOON_SAPLING.get())) {
                withExistingParent(item.getId().getPath(), modLoc("block/" + item.getId().getPath()));
            } else {
                builder(itemGenerator, item.getId().getPath());
            }
        }
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
