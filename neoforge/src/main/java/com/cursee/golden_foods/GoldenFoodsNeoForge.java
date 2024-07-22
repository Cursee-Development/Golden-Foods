package com.cursee.golden_foods;

import com.cursee.monolib.core.sailing.Sailing;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.ConditionalEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.function.UnaryOperator;

@Mod(Constants.MOD_ID)
public class GoldenFoodsNeoForge {

    public static final ResourceKey<Enchantment> GOLDEN_FOOD_ENCHANTMENT = key("golden_food");

    public static Holder<Enchantment> GOLDEN_FOOD_ENCHANTMENT_HOLDER;

    public static final DataComponentType<List<ConditionalEffect<EnchantmentValueEffect>>> GOLDEN_FOOD = registerEnchantment("golden_food", ($$0) -> {
        return $$0.persistent(ConditionalEffect.codec(EnchantmentValueEffect.CODEC, LootContextParamSets.ENCHANTED_ENTITY).listOf());
    });

    private static ResourceKey<Enchantment> key(String $$0) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.withDefaultNamespace($$0));
    }

    public static void init(RegistryAccess registryAccess) {
        Registry<Enchantment> enchantmentRegistry = registryAccess.registryOrThrow(Registries.ENCHANTMENT);
        GOLDEN_FOOD_ENCHANTMENT_HOLDER = enchantmentRegistry.getHolderOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "golden_food")));
    }

    private static void bootstrap(BootstrapContext<Enchantment> $$0, ResourceKey<Enchantment> $$1, Enchantment.Builder $$2) {
        $$0.register($$1, $$2.build($$1.location()));
    }

    private static <T> DataComponentType<T> registerEnchantment(String $$0, UnaryOperator<DataComponentType.Builder<T>> $$1) {
        return Registry.register(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, $$0, ($$1.apply(DataComponentType.builder())).build());
    }

    public GoldenFoodsNeoForge(IEventBus eventBus) {

        GoldenFoods.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);
    }

    @EventBusSubscriber
    public static class Events {

        @SubscribeEvent
        public static void onServerStarting(ServerStartingEvent event) {
            RegistryAccess registryAccess = event.getServer().registryAccess();
            init(registryAccess);
        }
    }
}
