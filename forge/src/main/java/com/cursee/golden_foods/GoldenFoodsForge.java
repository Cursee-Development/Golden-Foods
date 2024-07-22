package com.cursee.golden_foods;

import com.cursee.golden_foods.core.item.ForgeCreativeModeTabs;
import com.cursee.golden_foods.core.item.ForgeItems;
import com.cursee.monolib.core.sailing.Sailing;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;
import java.util.function.UnaryOperator;

@Mod(Constants.MOD_ID)
public class GoldenFoodsForge {

//    public static final DataComponentType<List<ConditionalEffect<EnchantmentValueEffect>>> GOLDEN_FOOD_EFFECT = registerEnchantment("golden_food", ($$0) -> {
//        return $$0.persistent(ConditionalEffect.codec(EnchantmentValueEffect.CODEC, LootContextParamSets.ENCHANTED_ENTITY).listOf());
//    });
//
//    private static <T> DataComponentType<T> registerEnchantment(String $$0, UnaryOperator<DataComponentType.Builder<T>> $$1) {
//        return Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, $$0, ($$1.apply(DataComponentType.builder())).build());
//    }
//
//    public static Holder<Enchantment> GOLDEN_FOOD_ENCHANTMENT_HOLDER;
//
//    public static void init(RegistryAccess registryAccess) {
//        Registry<Enchantment> enchantmentRegistry = registryAccess.registryOrThrow(Registries.ENCHANTMENT);
//        GOLDEN_FOOD_ENCHANTMENT_HOLDER = enchantmentRegistry.getHolderOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "golden_food")));
//    }
//
//    public static final ResourceKey<Enchantment> GOLDEN_FOOD_ENCHANTMENT = ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.withDefaultNamespace("golden_food"));



    public GoldenFoodsForge() {
    
        GoldenFoods.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ForgeItems.register(bus);
        ForgeCreativeModeTabs.register(bus);
    }

//    @Mod.EventBusSubscriber(modid = Constants.MOD_ID)
//    public static class Events {
//
//        @SubscribeEvent
//        public static void onServerStarting(ServerStartingEvent event) {
//            RegistryAccess.Frozen accessor = event.getServer().registryAccess();
//            init(accessor);
//        }
//    }
}
