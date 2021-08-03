package moe.konara.fe.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class CerseiCrystalBlock extends IceBlock {
    public CerseiCrystalBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isVariableOpacity() {
        return false;
    }

    @Override
    protected void turnIntoWater(@NotNull BlockState blockState, @NotNull World world, @NotNull BlockPos pos) {

    }
}
