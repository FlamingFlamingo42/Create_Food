package com.flamingflamingo42.createfood.init;

import com.flamingflamingo42.createfood.CreateFood;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {
    //ItemList
    public static Item cake_base;
    public static Item cake_base_baked;
    public static Item cake_chocolate;
    public static Item cake_chocolate_berry;
    public static Item cake_dough;
    public static Item cake_plain;
    public static Item cake_radiance;
    public static Item cake_shadowsteel;

    public static Item coffee;
    public static Item coffee_roasted;

    public static Item bucket_cream;

    //register
   @SubscribeEvent
    public static void registerAll(RegistryEvent.Register<Item> event) {
        if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName()))
            return;

        cake_dough = register("cake_dough", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));
        cake_base = register("cake_base", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));
        cake_base_baked = register("cake_base_baked", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));

        cake_chocolate = register("cake_chocolate", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));
        cake_chocolate_berry = register("cake_chocolate_berry", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));
        cake_plain = register("cake_plain", new BlockItem(BlockRegistry.cake_plain, new Item.Properties().group(CreateFood.ITEM_GROUP)));
        cake_radiance = register("cake_radiance", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));
        cake_shadowsteel = register("cake_shadowsteel", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));

       bucket_cream = register("bucket_cream", new BucketItem(()->FluidRegistry.cream, new Item.Properties().group(CreateFood.ITEM_GROUP)
                        .maxStackSize(1)));

       coffee = register("coffee",new BlockNamedItem(BlockRegistry.coffee, new Item.Properties().group(CreateFood.ITEM_GROUP)));
       coffee_roasted = register("coffee_roasted", new Item(new Item.Properties().group(CreateFood.ITEM_GROUP)));
    }

    //register functions
    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = CreateFood.RL(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

}
