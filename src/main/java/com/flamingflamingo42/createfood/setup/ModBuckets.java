package com.flamingflamingo42.createfood.setup;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ModBuckets {
    public static class ItemBucketCreateBucket extends BucketItem{
        public ItemBucketCreateBucket(Supplier<? extends Fluid> supplier){
            super(supplier, ModItems.bucketProps());
        }

        @Override
        public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt){
            return new FluidBucketWrapper(stack);
        }



    }
}
