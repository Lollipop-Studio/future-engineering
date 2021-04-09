package moe.konara.fe.Generators;


import moe.konara.fe.Utils.IBList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class OreGenerator implements IWorldGenerator {
    private final WorldGenMinable Copper_OreGenerator = new WorldGenMinable(IBList.copper_ore.getDefaultState(), 50);

    public OreGenerator() {
    }


    private void generateHellWorld(Random random, int posX, int posZ, World world) {

    }

    private void generateMainWorld(Random random, int posX, int posZ, World world) {
        //每个区块仅生成1条含有铁母的巨型矿脉
        for(int i=0;i<=4;i++) {
            BlockPos genPos = new BlockPos(
                    posX + random.nextInt(16),
                    random.nextInt(64),
                    posZ + random.nextInt(16));
            Copper_OreGenerator.generate(world, random, genPos);
            //ironOreGenerator.generate(world, random, genPos);
        }
    }

    private void generateEndWorld(Random random, int posX, int posZ, World world) {

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int posX = 16 * chunkX, posZ = 16 * chunkZ;
        switch (world.provider.getDimension()) {
            case -1:
                //地狱
                generateHellWorld(random, posX, posZ, world);
                break;
            case 0:
                //主世界
                generateMainWorld(random, posX, posZ, world);
                break;
            case 1:
                //末地
                generateEndWorld(random, posX, posZ, world);
                break;
        }
    }
}