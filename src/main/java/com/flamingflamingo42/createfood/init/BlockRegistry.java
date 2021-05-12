package com.flamingflamingo42.createfood.init;

import com.flamingflamingo42.createfood.CreateFood;
import com.flamingflamingo42.createfood.fluids.FluidCream;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {

    //Blocklist
    public static Block cream;

    //register
    @SubscribeEvent
    public static void registerAll(RegistryEvent.Register<Block> event) {
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName()))
            return;


            cream = register("cream", new FlowingFluidBlock(() -> FluidRegistry.cream, Block.Properties.create(Material.WATER).doesNotBlockMovement().noDrops()));

    }


    //functions register
    private static <T extends Block> T register(String name, T block) {
        BlockItem item = new BlockItem(block, new Item.Properties().group(ItemGroup.FOOD));
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable BlockItem item) {
        ResourceLocation id = CreateFood.RL(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }

}
