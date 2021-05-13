package com.flamingflamingo42.createfood.blocks;

import com.flamingflamingo42.createfood.CreateFood;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class CustomCake extends CakeBlock {
    public int hunger;
    public float saturation;

    public CustomCake(Properties p_i48434_1_, int hun, float sat) {
        super(p_i48434_1_);
        this.hunger = hun;
        this.saturation = sat;
    }


    @Override
    public ActionResultType onUse(final BlockState p_225533_1_, final World p_225533_2_, final BlockPos p_225533_3_, final PlayerEntity p_225533_4_, final Hand p_225533_5_, final BlockRayTraceResult p_225533_6_) {
        CreateFood.LOGGER.info("WANT CAKE!");
        if (p_225533_2_.isRemote) {
            final ItemStack itemstack = p_225533_4_.getHeldItem(p_225533_5_);
            if (this.tryEat(p_225533_2_, p_225533_3_, p_225533_1_, p_225533_4_, this.hunger, this.saturation) == ActionResultType.SUCCESS) {
                return ActionResultType.SUCCESS;
            }
            if (itemstack.isEmpty()) {
                return ActionResultType.CONSUME;
            }
        }
        return this.tryEat(p_225533_2_, p_225533_3_, p_225533_1_, p_225533_4_,this.hunger, this.saturation);
    }

    private ActionResultType tryEat(IWorld p_226911_1_, BlockPos p_226911_2_, BlockState p_226911_3_, PlayerEntity player, int hunger, float saturation) {
        CreateFood.LOGGER.info("EAT CAKE!");
        if (!player.canEat(false)) {
            return ActionResultType.PASS;
        } else {
            player.addStat(Stats.EAT_CAKE_SLICE);
            player.getFoodStats().addStats(hunger, saturation);

            //has effect params?
            player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 10, 1));

            int i = p_226911_3_.get(BITES);
            if (i < 6) {
                p_226911_1_.setBlockState(p_226911_2_, p_226911_3_.with(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                p_226911_1_.removeBlock(p_226911_2_, false);
            }

            return ActionResultType.SUCCESS;
        }
    }
}
