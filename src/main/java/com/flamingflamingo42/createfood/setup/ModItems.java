package com.flamingflamingo42.createfood.setup;

import com.flamingflamingo42.createfood.CreateFood;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {

    //public static  DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateFood.MOD_ID);

    public static final RegistryObject<Item> CAKE_DOUGH = Registration.ITEMS.register("cake_dough", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CAKE_BASE = Registration.ITEMS.register("cake_base", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CAKE_BASE_BAKED = Registration.ITEMS.register("cake_base_baked", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));

    public static final RegistryObject<Item> CAKE_PLAIN = Registration.ITEMS.register("cake_plain", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(12).saturation(10f).build())));

    public static final RegistryObject<Item> CAKE_CHOCOLATE = Registration.ITEMS.register("cake_chocolate", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(12).saturation(10f).build())));

    public static final RegistryObject<Item> CAKE_CHOCOLATE_BERRY = Registration.ITEMS.register("cake_chocolate_berry", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(15).saturation(10f).build())));

    public static final RegistryObject<Item> CAKE_SHADOWSTEEL = Registration.ITEMS.register("cake_shadowsteel", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().effect(() -> new EffectInstance(Effects.SLOWNESS, 200, 3), 1.0f).effect(() ->
                new EffectInstance(Effects.RESISTANCE,200,5),1.0f).hunger(20).saturation(20f).build())));

    public static final RegistryObject<Item> CAKE_RADIANCE = Registration.ITEMS.register("cake_radiance", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().effect(() -> new EffectInstance(Effects.LEVITATION, 600, 1), 1.0f).effect(() ->
                    new EffectInstance(Effects.SLOW_FALLING,1200,1),1.0f).hunger(20).saturation(20f).build())));
    public static final RegistryObject<ModBuckets.ItemBucketCreateBucket> BUCKET_CREAM = registerBucket("bucket_cream", ModFluids.CREAM);



    //KA
    public static Item.Properties defaultProps() {
        return new Item.Properties().group(ItemGroup.FOOD);
    }

    public static Item.Properties bucketProps(){
      return  new Item.Properties().maxStackSize(1).containerItem(Items.BUCKET);
    }

    private static RegistryObject<ModBuckets.ItemBucketCreateBucket> registerBucket(String name, Supplier<? extends Fluid> sup) {
        return register(name, () -> new ModBuckets.ItemBucketCreateBucket(sup));
    }

    static void register() {}

    private static RegistryObject<Item> register(final String name) {
        return register(name, () -> new Item(ModItems.defaultProps()));
    }
    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> sup) {
        return Registration.ITEMS.register(name, sup);
    }


    /*
    public static final RegistryObject<Item> BURGER_BUN = Registration.ITEMS.register("burger_bun", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> BURGER_PATTY = Registration.ITEMS.register("burger_patty", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> BURGER_BEEF = Registration.ITEMS.register("burger_beef", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> MEAT_MINCED = Registration.ITEMS.register("meat_minced", () ->
            new Item(new Item.Properties().group(ItemGroup.FOOD)));
    */



}
