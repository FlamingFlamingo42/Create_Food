package com.flamingflamingo42.createfood.setup;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<? extends T> sup) {
        return Registration.BLOCKS.register(name, sup);
    }

    private static Block.Properties fluidProps() {
        return Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100f).noDrops();
    }
    public static final RegistryObject<FlowingFluidBlock> CREAM = registerNoItem("cream",
            () -> new FlowingFluidBlock(() -> (FlowingFluid) ModFluids.CREAM.get(),  fluidProps()));


    public static void register(){};
}
