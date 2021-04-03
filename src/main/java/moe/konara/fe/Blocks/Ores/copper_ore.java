package moe.konara.fe.Blocks.Ores;

import moe.konara.fe.FE;
import moe.konara.fe.Utils.CreativeInventory;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;
import java.util.Random;

public class copper_ore extends Block {
    public copper_ore()
    {
        super(Material.IRON);
        this.setTranslationKey(FE.MOD_ID + ".copper_ore");
        this.setSoundType(SoundType.STONE);
        this.setRegistryName("copper_ore");
        this.setCreativeTab(CreativeInventory.TAB_MAIN);
        this.setResistance(20);
        this.setHardness(1.5F); this.setHarvestLevel("pickaxe",1);
    }
}
