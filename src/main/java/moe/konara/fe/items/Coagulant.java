package moe.konara.fe.items;

import moe.konara.fe.blocks.AllBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class Coagulant extends Item {
    public Coagulant(Properties properties) {
        super(properties);
    }

    @Override
    @NotNull
    public ActionResult<ItemStack> onItemRightClick(@NotNull World worldIn, @NotNull PlayerEntity playerIn, @NotNull Hand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        BlockRayTraceResult rayTraceResult = rayTrace(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);
        if (rayTraceResult.getType() != RayTraceResult.Type.MISS) {
            if (rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos blockPos = rayTraceResult.getPos();
                if (worldIn.getFluidState(blockPos).getBlockState().equals(AllBlocks.WEIRD_SPRING_WATER_BLOCK.get().getDefaultState())) {
                    worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.chasingPosY, playerIn.chasingPosZ, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    worldIn.setBlockState(blockPos, AllBlocks.CERSEI_CRYSTAL_BLOCK.get().getDefaultState());
                    return ActionResult.func_233538_a_(Items.GLASS_BOTTLE.getDefaultInstance(), worldIn.isRemote);
                } else if (worldIn.getFluidState(blockPos).isTagged(FluidTags.WATER)) {
                    worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.chasingPosY, playerIn.chasingPosZ, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    worldIn.setBlockState(blockPos, Blocks.ICE.getDefaultState());
                    return ActionResult.func_233538_a_(Items.GLASS_BOTTLE.getDefaultInstance(), worldIn.isRemote);
                } else if (worldIn.getFluidState(blockPos).isTagged(FluidTags.LAVA)) {
                    worldIn.playSound(playerIn, playerIn.getPosX(), playerIn.chasingPosY, playerIn.chasingPosZ, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    worldIn.setBlockState(blockPos, Blocks.MAGMA_BLOCK.getDefaultState());
                    return ActionResult.func_233538_a_(Items.GLASS_BOTTLE.getDefaultInstance(), worldIn.isRemote);
                } else {
                    return ActionResult.resultPass(itemStack);
                }
            }
        }
        return ActionResult.resultPass(itemStack);
    }
}
