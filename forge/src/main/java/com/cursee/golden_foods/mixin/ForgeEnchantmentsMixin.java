package com.cursee.golden_foods.mixin;

import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Enchantments.class)
public abstract class ForgeEnchantmentsMixin {

//    @Unique
//    private static final ResourceKey<Enchantment> GOLDEN_FOODS_ENCHANTMENT = key("golden_foods_enchantment");
//
//    @Unique
//    private static void register(BootstrapContext<Enchantment> $$0, ResourceKey<Enchantment> $$1, Enchantment.Builder $$2) {
//        $$0.register($$1, $$2.build($$1.location()));
//    }
//
//    @Unique
//    private static ResourceKey<Enchantment> key(String $$0) {
//        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.withDefaultNamespace($$0));
//    }

//    @Inject(at = @At("TAIL"), method = "bootstrap")
//    private static void injected(BootstrapContext<Enchantment> $$0, CallbackInfo ci) {
//        HolderGetter<DamageType> $$1 = $$0.lookup(Registries.DAMAGE_TYPE);
//        HolderGetter<Enchantment> $$2 = $$0.lookup(Registries.ENCHANTMENT);
//        HolderGetter<Item> $$3 = $$0.lookup(Registries.ITEM);
//        HolderGetter<Block> $$4 = $$0.lookup(Registries.BLOCK);
//
//        register($$0, GOLDEN_FOODS_ENCHANTMENT, Enchantment.enchantment(Enchantment.definition($$3.getOrThrow(ItemTags.FISHING_ENCHANTABLE), 2, 3, Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4, new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND})).withEffect(EnchantmentEffectComponents.FISHING_LUCK_BONUS, new AddValue(LevelBasedValue.perLevel(1.0F))));
//    }

//    private static void bootstrap(BootstrapContext<Enchantment> $$0, ResourceKey<Enchantment> $$1, Enchantment.Builder $$2) {
//        $$0.register($$1, $$2.build($$1.location()));
//    }

//    @Shadow
//    private static void register(BootstrapContext<Enchantment> p_345097_, ResourceKey<Enchantment> p_342560_, Enchantment.Builder p_344763_) {
//        p_345097_.register(p_342560_, p_344763_.build(p_342560_.location()));
//    }
//
//    @Inject(at = @At("TAIL"), method = "bootstrap")
//    private static void injected(BootstrapContext<Enchantment> bootstrapContext, CallbackInfo ci) {
//        HolderGetter<Enchantment> $$2 = bootstrapContext.lookup(Registries.ENCHANTMENT);
//        HolderGetter<Item> $$3 = bootstrapContext.lookup(Registries.ITEM);
//        register(bootstrapContext, GoldenFoodsForge.GOLDEN_FOOD_ENCHANTMENT, Enchantment.enchantment(Enchantment.definition($$3.getOrThrow(ItemTags.FISHING_ENCHANTABLE), 2, 3, Enchantment.dynamicCost(15, 9), Enchantment.dynamicCost(65, 9), 4, new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND})).withEffect(GoldenFoodsForge.GOLDEN_FOOD_EFFECT, new AddValue(LevelBasedValue.perLevel(1.0F))));
//    }
}
