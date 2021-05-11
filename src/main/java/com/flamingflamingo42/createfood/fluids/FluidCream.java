package com.flamingflamingo42.createfood.fluids;

import com.flamingflamingo42.createfood.CreateFood;
import com.flamingflamingo42.createfood.init.BlockRegistry;
import com.flamingflamingo42.createfood.init.FluidRegistry;
import com.flamingflamingo42.createfood.init.ItemRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.extensions.IForgeFluidState;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class FluidCream extends FlowingFluid {

    @Override
    public Fluid getFlowingFluid() {
        return FluidRegistry.cream_flow;
    }

    @Override
    public Fluid getStillFluid() {
        return FluidRegistry.cream;
    }

    @Override
    protected boolean canSourcesMultiply() {
        return false;
    }

    @Override
    protected void beforeReplacingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {

    }

    @Override
    protected int getSlopeFindDistance(IWorldReader p_185698_1_) {
        return 8;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader p_204528_1_) {
        return 1;
    }

    @Override
    public Item getFilledBucket() {
        return ItemRegistry.bucket_cream;
    }

    @Override
    protected boolean canDisplace(FluidState state, IBlockReader iblock, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
        return false;
    }

    @Override
    public int getTickRate(IWorldReader p_205569_1_) {
        return 20;
    }



    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    protected BlockState getBlockState(FluidState state) {
        return BlockRegistry.cream.getDefaultState().with(FlowingFluidBlock.LEVEL, Integer.valueOf(getLevelFromState(state)));
    }


    @Override
    protected FluidAttributes createAttributes(){
        return FluidAttributes.builder(CreateFood.RL("block/fluid/cream_still"),CreateFood.RL("block/fluid/cream_flow"))
                .viscosity(10000)
                .density(800)
                .translationKey("block.createfood.cream")
                .build(this);
    }

    public static class Flowing extends  FluidCream{

        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder){
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            CreateFood.LOGGER.debug(state.get(FluidCream.LEVEL_1_8));
            return state.get(FluidCream.LEVEL_1_8);
        }
    }

    public static class Source extends FluidCream {

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }
}
