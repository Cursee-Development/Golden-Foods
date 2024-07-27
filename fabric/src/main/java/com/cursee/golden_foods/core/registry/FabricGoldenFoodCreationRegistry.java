package com.cursee.golden_foods.core.registry;

import com.cursee.golden_foods.GoldenFoodsFabric;
import com.cursee.monolib.core.MonoLibConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import oshi.util.tuples.Triplet;

public class FabricGoldenFoodCreationRegistry {

	public static void debugPrint(Object object) {

		if (MonoLibConfiguration.debugging) {
			System.out.println(object);
		}
	}

//	public static Triplet<Integer, Integer, ItemStack> onRepairEvent(AnvilMenu pAnvilMenu, ItemStack slotLeft, ItemStack slotRight, ItemStack slotOutput, String itemName, int baseCost, Player player) {
//
//		debugPrint("\n\n\n anvil updated separator \n\n\n");
//
//		return new Triplet<>(baseCost, baseCost, slotOutput);
//	}

	public static Triplet<Integer, Integer, ItemStack> onRepairEvent(AnvilMenu pAnvilMenu, ItemStack slotLeft, ItemStack slotRight, ItemStack slotOutput, String itemName, int baseCost, Player player) {

		debugPrint("\n\n\n separator \n\n\n");

		debugPrint("enchantments found on slotRight");
		for (Holder<Enchantment> holder : slotRight.getEnchantments().keySet()) {
			debugPrint(holder.getRegisteredName());
		}

		ItemEnchantments enchantmentsFound =  EnchantmentHelper.getEnchantmentsForCrafting(slotRight);
		boolean goldenFoodsEnchantmentFound = EnchantmentHelper.getItemEnchantmentLevel(GoldenFoodsFabric.GOLDEN_FOOD_ENCHANTMENT_HOLDER, slotRight) > 0;

		debugPrint("crafting enchantments found on slotRight");
		for (Holder<Enchantment> holder : enchantmentsFound.keySet()) {
			debugPrint(holder.getRegisteredName());

			if (holder == GoldenFoodsFabric.GOLDEN_FOOD_ENCHANTMENT_HOLDER) {
				goldenFoodsEnchantmentFound = true;
			}
		}



		debugPrint("has stored enchantments? " + EnchantmentHelper.has(slotRight, DataComponents.STORED_ENCHANTMENTS));
		debugPrint("has enchantments? " + EnchantmentHelper.has(slotRight, DataComponents.ENCHANTMENTS));

//		EnchantmentHelper.getItemEnchantmentLevel(GoldenFoodsFabric.GOLDEN_FOOD_ENCHANTMENT_HOLDER, slotRight);

		debugPrint("found enchant, slotLeft ID, slotRight ID");
		debugPrint(goldenFoodsEnchantmentFound);
		debugPrint(slotLeft.getItem().getDescriptionId());
		debugPrint(slotRight.getItem().getDescriptionId());

		if (slotLeft.is(Items.GOLDEN_APPLE) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());

			debugPrint("Golden Apple Enhancement, cost and slotOutput ID");
			debugPrint("base " + baseCost);
			debugPrint(slotOutput.getItem().getDescriptionId());

			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(Items.GOLDEN_CARROT) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_CARROT);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_MELON_SLICE) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_MELON_SLICE);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_SWEET_BERRIES) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_SWEET_BERRIES);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_GLOW_BERRIES) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_GLOW_BERRIES);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_BAKED_POTATO) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_BAKED_POTATO);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_BEETROOT) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_BEETROOT);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_DRIED_KELP) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_DRIED_KELP);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_BEEF) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_BEEF);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_PORKCHOP) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_PORKCHOP);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_MUTTON) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_MUTTON);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_CHICKEN) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_CHICKEN);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_RABBIT) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_RABBIT);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_COD) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_COD);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKED_SALMON) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_SALMON);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_BREAD) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_BREAD);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_COOKIE) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKIE);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_PUMPKIN_PIE) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_PUMPKIN_PIE);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_CAKE.asItem()) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_CAKE);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_CHORUS_FRUIT) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_CHORUS_FRUIT);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_MUSHROOM_STEW) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_MUSHROOM_STEW);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_BEETROOT_SOUP) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_BEETROOT_SOUP);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_RABBIT_STEW) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_RABBIT_STEW);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_MILK_BUCKET) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_MILK_BUCKET);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}
		else if (slotLeft.is(GoldenFoodsFabricRegistry.GOLDEN_HONEY_BOTTLE) && goldenFoodsEnchantmentFound) {
			slotOutput = new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_HONEY_BOTTLE);
			slotOutput.setCount(slotLeft.getCount());
			baseCost = Math.min(40, slotLeft.getCount());
			return new Triplet<>(baseCost, baseCost, slotOutput);
		}

		return null;
	}
}
