package com.cursee.golden_foods.core.item;

import com.cursee.golden_foods.Constants;
import com.cursee.golden_foods.core.item.block.EnchantedBlockItem;
import com.cursee.golden_foods.core.item.block.EnchantedGoldenCakeBlock;
import com.cursee.golden_foods.core.item.block.GoldenCakeBlock;
import com.cursee.golden_foods.core.item.custom.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ForgeItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Constants.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Constants.MOD_ID);
	
	public static void register(IEventBus bus) { ITEMS.register(bus); BLOCKS.register(bus); }

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
	
	public static <T extends Item> DeferredHolder<Item, Item> registerItem(String name, Supplier<T> item) {
		return ITEMS.register(name, item::get);
	}
	
	public static <T extends Item> DeferredHolder<Item, Item> registerGoldenFoodItem(String name) {
		return ITEMS.register(name, () -> new Item(GOLDEN_FOOD_PROPERTIES));
	}
	public static <T extends Item> DeferredHolder<Item, Item> registerEnchantedGoldenFoodItem(String name) {
		return ITEMS.register(name, () -> new Item(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
	}
	
	private static <T extends Block> DeferredHolder<Block, T> registerBlockAndBlockItem(String name, Supplier<T> block) {
		DeferredHolder<Block, T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> DeferredHolder<Item, Item> registerBlockItem(String name, Supplier<T> block) {
		return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().rarity(Rarity.RARE)));
	}
	
	private static <T extends Block> DeferredHolder<Block, T> registerEnchantedBlockAndBlockItem(String name, Supplier<T> block) {
		DeferredHolder<Block, T> toReturn = BLOCKS.register(name, block);
		registerEnchantedBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> DeferredHolder<Item, Item> registerEnchantedBlockItem(String name, Supplier<T> block) {
		return ITEMS.register(name, () -> new EnchantedBlockItem(block.get(), new Item.Properties().rarity(Rarity.EPIC)));
	}
	
	public static final DeferredHolder<Item, Item> GOLDEN_MELON_SLICE = registerGoldenFoodItem("golden_melon_slice");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_MELON_SLICE = registerGoldenFoodItem("enchanted_golden_melon_slice");
	
	public static final DeferredHolder<Item, Item> GOLDEN_SWEET_BERRIES = registerGoldenFoodItem("golden_sweet_berries");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_SWEET_BERRIES = registerEnchantedGoldenFoodItem("enchanted_golden_sweet_berries");
	public static final DeferredHolder<Item, Item> GOLDEN_GLOW_BERRIES = registerGoldenFoodItem("golden_glow_berries");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_GLOW_BERRIES = registerEnchantedGoldenFoodItem("enchanted_golden_glow_berries");
	
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_CARROT = registerEnchantedGoldenFoodItem("enchanted_golden_carrot");
	
	public static final DeferredHolder<Item, Item> GOLDEN_BAKED_POTATO = registerGoldenFoodItem("golden_baked_potato");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_BAKED_POTATO = registerEnchantedGoldenFoodItem("enchanted_golden_baked_potato");
	public static final DeferredHolder<Item, Item> GOLDEN_BEETROOT = registerGoldenFoodItem("golden_beetroot");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_BEETROOT = registerEnchantedGoldenFoodItem("enchanted_golden_beetroot");
	public static final DeferredHolder<Item, Item> GOLDEN_DRIED_KELP = registerGoldenFoodItem("golden_dried_kelp");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_DRIED_KELP = registerEnchantedGoldenFoodItem("enchanted_golden_dried_kelp");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_BEEF = registerGoldenFoodItem("golden_cooked_beef");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_BEEF = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_beef");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_PORKCHOP = registerGoldenFoodItem("golden_cooked_porkchop");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_PORKCHOP = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_porkchop");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_MUTTON = registerGoldenFoodItem("golden_cooked_mutton");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_MUTTON = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_mutton");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_CHICKEN = registerGoldenFoodItem("golden_cooked_chicken");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_CHICKEN = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_chicken");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_RABBIT = registerGoldenFoodItem("golden_cooked_rabbit");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_RABBIT = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_rabbit");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_COD = registerGoldenFoodItem("golden_cooked_cod");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_COD = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_cod");
	
	public static final DeferredHolder<Item, Item> GOLDEN_COOKED_SALMON = registerGoldenFoodItem("golden_cooked_salmon");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKED_SALMON = registerEnchantedGoldenFoodItem("enchanted_golden_cooked_salmon");
	public static final DeferredHolder<Item, Item> GOLDEN_BREAD = registerGoldenFoodItem("golden_bread");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_BREAD = registerEnchantedGoldenFoodItem("enchanted_golden_bread");
	public static final DeferredHolder<Item, Item> GOLDEN_COOKIE = registerGoldenFoodItem("golden_cookie");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_COOKIE = registerEnchantedGoldenFoodItem("enchanted_golden_cookie");
	public static final DeferredHolder<Item, Item> GOLDEN_PUMPKIN_PIE = registerGoldenFoodItem("golden_pumpkin_pie");
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_PUMPKIN_PIE = registerEnchantedGoldenFoodItem("enchanted_golden_pumpkin_pie");
	
	public static final DeferredHolder<Block, Block> GOLDEN_CAKE = registerBlockAndBlockItem("golden_cake", () -> new GoldenCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
	public static final DeferredHolder<Block, Block> ENCHANTED_GOLDEN_CAKE = registerEnchantedBlockAndBlockItem("enchanted_golden_cake", () -> new EnchantedGoldenCakeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
	
	public static final DeferredHolder<Item, Item> GOLDEN_CHORUS_FRUIT = registerItem("golden_chorus_fruit", () -> new GoldenChorusFruitItem(GOLDEN_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_CHORUS_FRUIT = registerItem("enchanted_golden_chorus_fruit", () -> new EnchantedGoldenChorusFruitItem(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> GOLDEN_MUSHROOM_STEW = registerItem("golden_mushroom_stew", () -> new Item(GOLDEN_BOWL_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_MUSHROOM_STEW = registerItem("enchanted_golden_mushroom_stew", () -> new Item(ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> GOLDEN_BEETROOT_SOUP = registerItem("golden_beetroot_soup", () -> new Item(GOLDEN_BOWL_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_BEETROOT_SOUP = registerItem("enchanted_golden_beetroot_soup", () -> new Item(ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> GOLDEN_RABBIT_STEW = registerItem("golden_rabbit_stew", () -> new Item(GOLDEN_BOWL_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_RABBIT_STEW = registerItem("enchanted_golden_rabbit_stew", () -> new Item(ENCHANTED_GOLDEN_BOWL_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> GOLDEN_MILK_BUCKET = registerItem("golden_milk_bucket", () -> new GoldenMilkBucketItem(GOLDEN_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_MILK_BUCKET = registerItem("enchanted_golden_milk_bucket", () -> new EnchantedMilkBucketItem(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> GOLDEN_HONEY_BOTTLE = registerItem("golden_honey_bottle", () -> new HoneyBottleItem(GOLDEN_FOOD_PROPERTIES));
	public static final DeferredHolder<Item, Item> ENCHANTED_GOLDEN_HONEY_BOTTLE = registerItem("enchanted_golden_honey_bottle", () -> new EnchantedHoneyBottleItem(ENCHANTED_GOLDEN_FOOD_PROPERTIES));
}
