package moe.konara.fe.Blocks.Ores;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CopperOre extends Block {
    public CopperOre() {
        super(
                Properties.create(Material.IRON)
                .sound(SoundType.STONE)
                .setRequiresTool()
                .hardnessAndResistance(1.5F)
        );
    }
}