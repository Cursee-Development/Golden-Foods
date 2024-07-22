package com.cursee.golden_foods.core.item;

import com.cursee.golden_foods.Constants;
//import com.cursee.golden_foods.ForgeExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.cursee.golden_foods.core.item.ForgeItems.*;

public class ForgeCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);
	public static void register(IEventBus eventBus) { CREATIVE_MODE_TAB.register(eventBus); }
	
	public static final RegistryObject<CreativeModeTab> GOLDENFOODS_TAB = CREATIVE_MODE_TAB.register("goldenfoods_tab", () -> CreativeModeTab.builder()
		.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
		.title(Component.translatable("itemGroup.goldenFoods"))
		.icon(() -> GOLDEN_CAKE.get().asItem().getDefaultInstance())
		.displayItems((parameters, output) -> {
			
			
//			output.accept(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ForgeExampleMod.GF_ENCHANTMENT.get(), 1  )));
			
			output.accept(Items.GOLDEN_APPLE);
			output.accept(Items.ENCHANTED_GOLDEN_APPLE);
			
			output.accept(GOLDEN_MELON_SLICE.get());
			output.accept(ENCHANTED_GOLDEN_MELON_SLICE.get());
			output.accept(GOLDEN_SWEET_BERRIES.get());
			output.accept(ENCHANTED_GOLDEN_SWEET_BERRIES.get());
			output.accept(GOLDEN_GLOW_BERRIES.get());
			output.accept(ENCHANTED_GOLDEN_GLOW_BERRIES.get());
			output.accept(GOLDEN_CHORUS_FRUIT.get());
			output.accept(ENCHANTED_GOLDEN_CHORUS_FRUIT.get());
			
			output.accept(Items.GOLDEN_CARROT);
			output.accept(ENCHANTED_GOLDEN_CARROT.get());
			
			output.accept(GOLDEN_BAKED_POTATO.get());
			output.accept(ENCHANTED_GOLDEN_BAKED_POTATO.get());
			output.accept(GOLDEN_BEETROOT.get());
			output.accept(ENCHANTED_GOLDEN_BEETROOT.get());
			output.accept(GOLDEN_DRIED_KELP.get());
			output.accept(ENCHANTED_GOLDEN_DRIED_KELP.get());
			output.accept(GOLDEN_COOKED_BEEF.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_BEEF.get());
			output.accept(GOLDEN_COOKED_PORKCHOP.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_PORKCHOP.get());
			output.accept(GOLDEN_COOKED_MUTTON.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_MUTTON.get());
			output.accept(GOLDEN_COOKED_CHICKEN.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_CHICKEN.get());
			output.accept(GOLDEN_COOKED_RABBIT.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_RABBIT.get());
			output.accept(GOLDEN_COOKED_COD.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_COD.get());
			output.accept(GOLDEN_COOKED_SALMON.get());
			output.accept(ENCHANTED_GOLDEN_COOKED_SALMON.get());
			output.accept(GOLDEN_BREAD.get());
			output.accept(ENCHANTED_GOLDEN_BREAD.get());
			output.accept(GOLDEN_COOKIE.get());
			output.accept(ENCHANTED_GOLDEN_COOKIE.get());
			output.accept(GOLDEN_PUMPKIN_PIE.get());
			output.accept(ENCHANTED_GOLDEN_PUMPKIN_PIE.get());
			
			output.accept(GOLDEN_CAKE.get());
			output.accept(ENCHANTED_GOLDEN_CAKE.get());
			
			output.accept(GOLDEN_MUSHROOM_STEW.get());
			output.accept(ENCHANTED_GOLDEN_MUSHROOM_STEW.get());
			output.accept(GOLDEN_BEETROOT_SOUP.get());
			output.accept(ENCHANTED_GOLDEN_BEETROOT_SOUP.get());
			output.accept(GOLDEN_RABBIT_STEW.get());
			output.accept(ENCHANTED_GOLDEN_RABBIT_STEW.get());
			output.accept(GOLDEN_MILK_BUCKET.get());
			output.accept(ENCHANTED_GOLDEN_MILK_BUCKET.get());
			output.accept(GOLDEN_HONEY_BOTTLE.get());
			output.accept(ENCHANTED_GOLDEN_HONEY_BOTTLE.get());
			
		}).build());
}
