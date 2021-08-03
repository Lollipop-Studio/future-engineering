package moe.konara.fe.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class MagmaObsidian extends Block {
    public MagmaObsidian(AbstractBlock.Properties properties) {
        super(properties);
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState stateIn, @NotNull World worldIn, @NotNull BlockPos pos, Random rand) {
        if (rand.nextInt(5) == 0) {
            Direction direction = Direction.getRandomDirection(rand);
            if (direction != Direction.UP) {
                BlockPos blockpos = pos.offset(direction);
                BlockState blockstate = worldIn.getBlockState(blockpos);
                if (!stateIn.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, direction.getOpposite())) {
                    double d0 = direction.getXOffset() == 0 ? rand.nextDouble() : 0.5D + (double)direction.getXOffset() * 0.6D;
                    double d1 = direction.getYOffset() == 0 ? rand.nextDouble() : 0.5D + (double)direction.getYOffset() * 0.6D;
                    double d2 = direction.getZOffset() == 0 ? rand.nextDouble() : 0.5D + (double)direction.getZOffset() * 0.6D;
                    worldIn.addParticle(ParticleTypes.LAVA, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }
}