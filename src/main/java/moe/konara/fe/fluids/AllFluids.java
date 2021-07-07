package moe.konara.fe.fluids;

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
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,FE.ID);

    public static RegistryObject<FlowingFluid> WEIRD_SPRING_WATER = FLUIDS.register("weird_spring_water", () -> new ForgeFlowingFluid.Source(
            AllFluids.PROPERTIES));
    public static RegistryObject<FlowingFluid> WEIRD_SPRING_WATER_FLOWING = FLUIDS.register("weird_spring_water_flowing", () -> new ForgeFlowingFluid.Flowing(
            AllFluids.PROPERTIES));
    public static ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(WEIRD_SPRING_WATER, WEIRD_SPRING_WATER_FLOWING, FluidAttributes
            .builder(new ResourceLocation("block/water_still"), new ResourceLocation("block/water_flow"))
                .color(0xFF87CEEB).density(4000).viscosity(4000))
                .bucket(AllItems.WEIRD_SPRING_WATER_BUCKET)
                .block(AllBlocks.WEIRD_SPRING_WATER_BLOCK)
                .slopeFindDistance(3).explosionResistance(100F);
}
