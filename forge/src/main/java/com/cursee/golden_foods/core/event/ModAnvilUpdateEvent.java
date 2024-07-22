package com.cursee.golden_foods.core.event;

import com.cursee.golden_foods.Constants;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.cursee.golden_foods.core.item.ForgeItems.*;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class ModAnvilUpdateEvent {
    @SubscribeEvent
    public static void anvilEvent(AnvilUpdateEvent anvil)
    {

        // add the fucking cake
        
        
        // Basic Explanation
        // Check both sides for an enchanted book, then check if that enchanted book has our enchantment
        // Then, check the opposite slot for a food item, and set the output

        // Does the right slot have an enchanted book?
        if (anvil.getRight().getDescriptionId().contains("enchanted_book"))
        {

            ItemEnchantments enchantmentsFound =  EnchantmentHelper.getEnchantmentsForCrafting(anvil.getRight());
            boolean goldenFoodsEnchantmentFound = false;

            for (Holder<Enchantment> holder : enchantmentsFound.keySet()) {

                if (holder.getRegisteredName().toLowerCase().contains("golden_food") || holder.getRegisteredName().toLowerCase().contains("golden food")) {
                    goldenFoodsEnchantmentFound = true;
                }
            }

            // Does the enchanted book hold our enchantment?
            if (goldenFoodsEnchantmentFound)
            {
                // VANILLA APPLE & CARROT
                if (anvil.getLeft().getDescriptionId().contains("minecraft.golden_apple"))
                {
                    anvil.setCost(Math.min(40, anvil.getLeft().getCount()));
                    ItemStack toReturn = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
                    toReturn.setCount(anvil.getLeft().getCount());
                    // anvil.setMaterialCost(1);
                    anvil.setOutput(toReturn);
                }
                if (anvil.getLeft().getDescriptionId().contains("minecraft.golden_carrot"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_CARROT.get().getDefaultInstance());
                }
                // ADDED GOLDEN FOOD
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cake"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_CAKE.get().asItem().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_melon_slice"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_MELON_SLICE.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_sweet_berries"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_SWEET_BERRIES.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_glow_berries"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_GLOW_BERRIES.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_chorus_fruit"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_CHORUS_FRUIT.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_baked_potato"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_BAKED_POTATO.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_beetroot"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_BEETROOT.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_dried_kelp"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_DRIED_KELP.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_beef"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_BEEF.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_porkchop"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_PORKCHOP.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_mutton"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_MUTTON.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_chicken"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_CHICKEN.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_rabbit"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_RABBIT.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_cod"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_COD.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cooked_salmon"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKED_SALMON.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_bread"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_BREAD.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_cookie"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_COOKIE.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_pumpkin_pie"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_PUMPKIN_PIE.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_mushroom_stew"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_MUSHROOM_STEW.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_beetroot_soup"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_BEETROOT_SOUP.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_rabbit_stew"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_RABBIT_STEW.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_milk_bucket"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_MILK_BUCKET.get().getDefaultInstance());
                }
                if (anvil.getLeft().getDescriptionId().contains("golden_foods.golden_honey_bottle"))
                {
                    anvil.setCost(1);
                    anvil.setMaterialCost(1);
                    anvil.setOutput(ENCHANTED_GOLDEN_HONEY_BOTTLE.get().getDefaultInstance());
                }
            }
        }





    } // anvilEvent
} // ModAnvilUpdateEvent
