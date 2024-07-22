package com.cursee.golden_foods.core.item.custom;

import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;

public class EnchantedHoneyBottleItem extends HoneyBottleItem {
    public EnchantedHoneyBottleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}