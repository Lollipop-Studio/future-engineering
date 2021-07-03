package moe.konara.fe.Fluids;

import moe.konara.fe.blocks.AllBlocks;
import moe.konara.fe.items.AllItems;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import moe.konara.fe.FE;

public class AllFluids {
    public static final ResourceLocation STILL_OIL_TEXTURE = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING_OIL_TEXTURE = new ResourceLocation("block/water_flow");


    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS,FE.ID);

    public static RegistryObject<FlowingFluid> WEIRD_SPRING_WATER = FLUID.register("weird_spring_water", () -> new ForgeFlowingFluid.Source(
            AllFluids.PROPERTIES));
    public static RegistryObject<FlowingFluid> WEIRD_SPRING_WATER_FLOWING = FLUID.register("weird_spring_water_flowing", () -> new ForgeFlowingFluid.Flowing(
            AllFluids.PROPERTIES));
    public static ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(WEIRD_SPRING_WATER, WEIRD_SPRING_WATER_FLOWING, FluidAttributes
            .builder(STILL_OIL_TEXTURE, FLOWING_OIL_TEXTURE)
                .color(0xFF87CEEB).density(4000).viscosity(4000))
                .bucket(AllItems.WEIRD_SPRING_WATER_BUCKET)
                .block(AllBlocks.WEIRD_SPRING_WATER_CUBE)
                .slopeFindDistance(3).explosionResistance(100F);
}
