package com.cursee.golden_foods.core.registry;

import com.cursee.golden_foods.Constants;
import com.cursee.golden_foods.core.block.EnchantedGoldenCakeBlock;
import com.cursee.golden_foods.core.block.GoldenCakeBlock;
import com.cursee.golden_foods.core.item.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.function.UnaryOperator;

public class GoldenFoodsFabricRegistry {
    
    public static void register() {}


    
    public static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), item);
    }

    public static Item registerGoldenFoodItem(String name) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), new Item(GOLDEN_FOOD_PROPERTIES));
    }
    public static Item registerEnchantedGoldenFoodItem(String name) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), new Item(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
    }

    private static Block registerBlockAndBlockItem(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
                new BlockItem(block, new Item.Properties().rarity(Rarity.RARE)));
    }

    private static Block registerEnchantedBlockAndBlockItem(String name, Block block) {
        registerEnchantedBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name), block);
    }

    private static Item registerEnchantedBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
                new BlockItem(block, new Item.Properties().rarity(Rarity.EPIC).component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    }





    public static final Item.Properties GOLDEN_FOOD_PROPERTIES = new Item.Properties()
            .rarity(Rarity.RARE)
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(1.2f)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION,100,1),1.0F)
                    .effect(new MobEffectInstance(MobEffects.ABSORPTION,2400,0),1.0F)
                    .alwaysEdible().build());
    
    public static final Item.Properties ENCHANTED_GOLDEN_FOOD_PROPERTIES = new Item.Properties()
            .rarity(Rarity.EPIC)
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
            .food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(8.0f)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F).alwaysEdible().build());

    public static final Item.Properties GOLDEN_BOWL_FOOD_PROPERTIES = new Item.Properties()
            .rarity(Rarity.RARE)
            .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(1.2f)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION,100,1),1.0F)
                    .effect(new MobEffectInstance(MobEffects.ABSORPTION,2400,0),1.0F)
                    .alwaysEdible().usingConvertsTo(Items.BOWL).build());
    
    public static final Item.Properties ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES = new Item.Properties()
            .rarity(Rarity.EPIC)
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
            .food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(8.0f)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1.0F)
                    .effect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1.0F).alwaysEdible().usingConvertsTo(Items.BOWL).build());

    public static final Item ENCHANTED_GOLDEN_CARROT = registerEnchantedGoldenFoodItem("enchanted_golden_carrot");

    public static final Item GOLDEN_MELON_SLICE = registerGoldenFoodItem("golden_melon_slice");
    public static final Item ENCHANTED_GOLDEN_MELON_SLICE = registerEnchantedGoldenFoodItem("enchanted_golden_melon_slice");

    public static final Item GOLDEN_SWEET_BERRIES = registerGoldenFoodItem("golden_sweet_berries");
    public static final Item ENCHANTED_GOLDEN_SWEET_BERRIES = registerEnchantedGoldenFoodItem("enchanted_golden_sweet_berries");
    public static final Item GOLDEN_GLOW_BERRIES = registerGoldenFoodItem("golden_glow_berries");
    public static final Item ENCHANTED_GOLDEN_GLOW_BERRIES = registerEnchantedGoldenFoodItem("enchanted_golden_glow_berries");


    public static final Item GOLDEN_BAKED_POTATO = registerGoldenFoodItem("golden_baked_potato");
    public static final Item ENCHANTED_GOLDEN_BAKED_POTATO = registerEnchantedGoldenFoodItem("enchanted_golden_baked_potato");
    public static final Item GOLDEN_BEETROOT = registerGoldenFoodItem("golden_beetroot");
    public static final Item ENCHANTED_GOLDEN_BEETROOT = registerEnchantedGoldenFoodItem("enchanted_golden_beetroot");
    public static final Item GOLDEN_DRIED_KELP = registerGoldenFoodItem("golden_dried_kelp");
    public static final Item ENCHANTED_GOLDEN_DRIED_KELP = registerEnchantedGoldenFoodItem("enchanted_golden_dried_kelp");
    public static final Item GOLDEN_COOKED_BEEF = registerGoldenFoodItem("golden_cooked_beef");
    public static final Item ENCHANTED_GOLDEN_COOKED_BEEF = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_beef");
    public static final Item GOLDEN_COOKED_PORKCHOP = registerGoldenFoodItem("golden_cooked_porkchop");
    public static final Item ENCHANTED_GOLDEN_COOKED_PORKCHOP = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_porkchop");
    public static final Item GOLDEN_COOKED_MUTTON = registerGoldenFoodItem("golden_cooked_mutton");
    public static final Item ENCHANTED_GOLDEN_COOKED_MUTTON = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_mutton");
    public static final Item GOLDEN_COOKED_CHICKEN = registerGoldenFoodItem("golden_cooked_chicken");
    public static final Item ENCHANTED_GOLDEN_COOKED_CHICKEN = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_chicken");
    public static final Item GOLDEN_COOKED_RABBIT = registerGoldenFoodItem("golden_cooked_rabbit");
    public static final Item ENCHANTED_GOLDEN_COOKED_RABBIT = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_rabbit");
    public static final Item GOLDEN_COOKED_COD = registerGoldenFoodItem("golden_cooked_cod");
    public static final Item ENCHANTED_GOLDEN_COOKED_COD = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_cod");

    public static final Item GOLDEN_COOKED_SALMON = registerGoldenFoodItem("golden_cooked_salmon");
    public static final Item ENCHANTED_GOLDEN_COOKED_SALMON = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_salmon");
    public static final Item GOLDEN_BREAD = registerGoldenFoodItem("golden_bread");
    public static final Item ENCHANTED_GOLDEN_BREAD = registerEnchantedGoldenFoodItem("enchanted_golden_bread");
    public static final Item GOLDEN_COOKIE = registerGoldenFoodItem("golden_cookie");
    public static final Item ENCHANTED_GOLDEN_COOKIE = registerEnchantedGoldenFoodItem("enchanted_golden_cookie");
    public static final Item GOLDEN_PUMPKIN_PIE = registerGoldenFoodItem("golden_pumpkin_pie");
    public static final Item ENCHANTED_GOLDEN_PUMPKIN_PIE = registerEnchantedGoldenFoodItem("enchanted_golden_pumpkin_pie");

    public static final Block GOLDEN_CAKE = registerBlockAndBlockItem("golden_cake", new GoldenCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
    public static final Block ENCHANTED_GOLDEN_CAKE = registerEnchantedBlockAndBlockItem("enchanted_golden_cake", new EnchantedGoldenCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final Item GOLDEN_CHORUS_FRUIT = registerItem("golden_chorus_fruit", new GoldenChorusFruitItem(GOLDEN_FOOD_PROPERTIES));
    public static final Item ENCHANTED_GOLDEN_CHORUS_FRUIT = registerItem("enchanted_golden_chorus_fruit", new EnchantedGoldenChorusFruitItem(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
    public static final Item GOLDEN_MUSHROOM_STEW = registerItem("golden_mushroom_stew", new Item(GOLDEN_BOWL_FOOD_PROPERTIES));
    public static final Item ENCHANTED_GOLDEN_MUSHROOM_STEW = registerItem("enchanted_golden_mushroom_stew", new EnchantedBowlFoodItem(ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES));
    public static final Item GOLDEN_BEETROOT_SOUP = registerItem("golden_beetroot_soup", new Item(GOLDEN_BOWL_FOOD_PROPERTIES));
    public static final Item ENCHANTED_GOLDEN_BEETROOT_SOUP = registerItem("enchanted_golden_beetroot_soup", new EnchantedBowlFoodItem(ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES));
    public static final Item GOLDEN_RABBIT_STEW = registerItem("golden_rabbit_stew", new Item(GOLDEN_BOWL_FOOD_PROPERTIES));
    public static final Item ENCHANTED_GOLDEN_RABBIT_STEW = registerItem("enchanted_golden_rabbit_stew", new EnchantedBowlFoodItem(ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES));
    public static final Item GOLDEN_MILK_BUCKET = registerItem("golden_milk_bucket", new MilkBucketItem(GOLDEN_FOOD_PROPERTIES));
    public static final Item ENCHANTED_GOLDEN_MILK_BUCKET = registerItem("enchanted_golden_milk_bucket", new EnchantedMilkBucketItem(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
    public static final Item GOLDEN_HONEY_BOTTLE = registerItem("golden_honey_bottle", new HoneyBottleItem(GOLDEN_FOOD_PROPERTIES));
    public static final Item ENCHANTED_GOLDEN_HONEY_BOTTLE = registerItem("enchanted_golden_honey_bottle", new EnchantedHoneyBottleItem(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
    
    public static final CreativeModeTab GOLDEN_FOODS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "golden_foods_tab"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.goldenFoods"))
                    .icon(() -> new ItemStack(GOLDEN_SWEET_BERRIES))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(Items.GOLDEN_APPLE);
                        output.accept(Items.ENCHANTED_GOLDEN_APPLE);

                        output.accept(GOLDEN_MELON_SLICE);
                        output.accept(ENCHANTED_GOLDEN_MELON_SLICE);
                        output.accept(GOLDEN_SWEET_BERRIES);
                        output.accept(ENCHANTED_GOLDEN_SWEET_BERRIES);
                        output.accept(GOLDEN_GLOW_BERRIES);
                        output.accept(ENCHANTED_GOLDEN_GLOW_BERRIES);
                        output.accept(GOLDEN_CHORUS_FRUIT);
                        output.accept(ENCHANTED_GOLDEN_CHORUS_FRUIT);

                        output.accept(Items.GOLDEN_CARROT);
                        output.accept(ENCHANTED_GOLDEN_CARROT);

                        output.accept(GOLDEN_BAKED_POTATO);
                        output.accept(ENCHANTED_GOLDEN_BAKED_POTATO);
                        output.accept(GOLDEN_BEETROOT);
                        output.accept(ENCHANTED_GOLDEN_BEETROOT);
                        output.accept(GOLDEN_DRIED_KELP);
                        output.accept(ENCHANTED_GOLDEN_DRIED_KELP);
                        output.accept(GOLDEN_COOKED_BEEF);
                        output.accept(ENCHANTED_GOLDEN_COOKED_BEEF);
                        output.accept(GOLDEN_COOKED_PORKCHOP);
                        output.accept(ENCHANTED_GOLDEN_COOKED_PORKCHOP);
                        output.accept(GOLDEN_COOKED_MUTTON);
                        output.accept(ENCHANTED_GOLDEN_COOKED_MUTTON);
                        output.accept(GOLDEN_COOKED_CHICKEN);
                        output.accept(ENCHANTED_GOLDEN_COOKED_CHICKEN);
                        output.accept(GOLDEN_COOKED_RABBIT);
                        output.accept(ENCHANTED_GOLDEN_COOKED_RABBIT);
                        output.accept(GOLDEN_COOKED_COD);
                        output.accept(ENCHANTED_GOLDEN_COOKED_COD);
                        output.accept(GOLDEN_COOKED_SALMON);
                        output.accept(ENCHANTED_GOLDEN_COOKED_SALMON);
                        output.accept(GOLDEN_BREAD);
                        output.accept(ENCHANTED_GOLDEN_BREAD);
                        output.accept(GOLDEN_COOKIE);
                        output.accept(ENCHANTED_GOLDEN_COOKIE);
                        output.accept(GOLDEN_PUMPKIN_PIE);
                        output.accept(ENCHANTED_GOLDEN_PUMPKIN_PIE);

                        output.accept(GOLDEN_CAKE);
                        output.accept(ENCHANTED_GOLDEN_CAKE);
                        output.accept(GOLDEN_MUSHROOM_STEW);
                        output.accept(ENCHANTED_GOLDEN_MUSHROOM_STEW);
                        output.accept(GOLDEN_BEETROOT_SOUP);
                        output.accept(ENCHANTED_GOLDEN_BEETROOT_SOUP);
                        output.accept(GOLDEN_RABBIT_STEW);
                        output.accept(ENCHANTED_GOLDEN_RABBIT_STEW);
                        output.accept(GOLDEN_MILK_BUCKET);
                        output.accept(ENCHANTED_GOLDEN_MILK_BUCKET);
                        output.accept(GOLDEN_HONEY_BOTTLE);
                        output.accept(ENCHANTED_GOLDEN_HONEY_BOTTLE);
                    }))
                    .build());
}
