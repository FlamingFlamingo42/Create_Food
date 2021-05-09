package com.flamingflamingo42.createfood.setup;

import com.flamingflamingo42.createfood.CreateFood;
import com.flamingflamingo42.createfood.setup.modfluids.FluidCream;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModFluids{

   public static final RegistryObject<Fluid> CREAM = Registration.FLUIDS.register("cream", FluidCream.Source::new);
    public static final RegistryObject<Fluid> CREAM_FLOWING = Registration.FLUIDS.register("cream_flowing", FluidCream.Flowing::new);



   /* public static <T extends Fluid> RegistryObject<T> register(String name, final Supplier<T> sup) {
        return Registration.FLUIDS.register(name, sup);
    }

    */

    public static void register(){};

}
