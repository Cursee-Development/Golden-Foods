package com.cursee.golden_foods.core.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MilkBucketItem;

public class EnchantedMilkBucketItem extends MilkBucketItem {
    public EnchantedMilkBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
