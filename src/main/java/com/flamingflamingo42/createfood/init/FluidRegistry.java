package com.flamingflamingo42.createfood.init;

import com.flamingflamingo42.createfood.CreateFood;
import com.flamingflamingo42.createfood.fluids.FluidCream;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;


@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class FluidRegistry {

    public static FluidCream.Source cream;
    public static FluidCream.Flowing cream_flow;


    //register
    @SubscribeEvent
    public static void registerAll(RegistryEvent.Register<Fluid> event) {
        if (!event.getName().equals(ForgeRegistries.FLUIDS.getRegistryName()))
            return;

        cream_flow = register("cream_flow", new FluidCream.Flowing());
        cream = register("cream", new FluidCream.Source());

    }


    private static <T extends Fluid> T register(String name, T fluid) {
        ResourceLocation id = CreateFood.RL(name);
        fluid.setRegistryName(id);
        ForgeRegistries.FLUIDS.register(fluid);
        return fluid;
    }



}
