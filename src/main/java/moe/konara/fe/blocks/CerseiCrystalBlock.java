package moe.konara.fe.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CerseiCrystalBlock extends IceBlock {
    public CerseiCrystalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isVariableOpacity() {
        return false;
    }

    @Override
    protected void turnIntoWater(BlockState blockState, World world, BlockPos pos) {

    }
}
