package com.flamingflamingo42.createfood.setup.modfluids;

import com.flamingflamingo42.createfood.setup.ModBlocks;
import com.flamingflamingo42.createfood.setup.ModFluids;
import com.flamingflamingo42.createfood.setup.ModItems;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static com.flamingflamingo42.createfood.CreateFood.RL;

public class FluidCream {
    private static final FluidAttributes.Builder ATTRS = FluidAttributes.builder(
            RL("block/fluid/cream_still"),RL("block/fluid/cream_flow")
    ).density(800).viscosity(10000).temperature(300);

    private static final ForgeFlowingFluid.Properties PROPS =
            new ForgeFlowingFluid.Properties(ModFluids.CREAM, ModFluids.CREAM_FLOWING, ATTRS)
                .block(ModBlocks.CREAM).bucket(ModItems.BUCKET_CREAM);

    public static class Source extends ForgeFlowingFluid.Source {
        public Source() {
            super(PROPS);
        }

        @Override
        public int getTickRate(IWorldReader world){
            return 20;
        }
    }

    public static class Flowing extends ForgeFlowingFluid.Flowing {
        public Flowing(){
            super(PROPS);
        }
    }
}
