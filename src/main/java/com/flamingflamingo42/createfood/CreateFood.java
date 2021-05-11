package com.flamingflamingo42.createfood;

import com.flamingflamingo42.createfood.init.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateFood.MOD_ID)
public class CreateFood
{
    public static final String MOD_ID = "createfood";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new ItemGroup("createfood") {
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.cake_chocolate_berry);
        }
    };
    @Nonnull
    public static ResourceLocation RL (String path) {
        return new ResourceLocation(MOD_ID, path);
    }




    public CreateFood() {


        //IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //bus.addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

}
