package moe.konara.mods.fe.Blocks.Ores;

import moe.konara.mods.fe.FE;
import moe.konara.mods.fe.Utils.CreativeInventory;
import net.minecraft.block.*;
import net.minecraft.block.material.*;

public class copper_ore extends Block {
    public copper_ore()
    {
        super(Material.ROCK);
        this.setTranslationKey(FE.MOD_ID + ".copper_ore");
        this.setRegistryName("copper_ore");
        this.setCreativeTab(CreativeInventory.TAB_MAIN);
        this.setHardness(1.5F); this.setHarvestLevel("pickaxe",2);
    }
}
