package com.cursee.golden_foods.mixin;

import com.cursee.golden_foods.GoldenFoodsFabric;
import com.cursee.golden_foods.core.registry.GoldenFoodsFabricRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingHook.class)
public abstract class FabricFishingHookMixin {

    @Shadow @Nullable public abstract Player getPlayerOwner();

//    @SuppressWarnings("all")
//    @Inject(method = "retrieve", at= @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z", ordinal = 0))
//    private void injected(ItemStack itemStack, CallbackInfoReturnable<Integer> cir) {
//
//        if (((FishingHook)(Object)this).getPlayerOwner() != null && Minecraft.getInstance().level != null) {
//
//            float localRandom = Minecraft.getInstance().level.random.nextFloat();
//
//            if (localRandom <= 0.05F) {
//
//                if (itemStack.getItem() == Items.COD) {
//                    itemStack = new ItemStack(GoldenFoodsFabricRegistry.GOLDEN_COOKED_COD);
//                }
//                else if (itemStack.getItem() == Items.SALMON) {
//                    itemStack = new ItemStack(GoldenFoodsFabricRegistry.GOLDEN_COOKED_SALMON);
//                }
//            }
//
//            // todo: remove this block
//            if (itemStack.getItem() == Items.COD) {
//                itemStack = new ItemStack(GoldenFoodsFabricRegistry.GOLDEN_COOKED_COD);
//            }
//            else if (itemStack.getItem() == Items.SALMON) {
//                itemStack = new ItemStack(GoldenFoodsFabricRegistry.GOLDEN_COOKED_SALMON);
//            }
//            // todo: remove this block
//
//        }
//    }

    @Redirect(method = "retrieve", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z", ordinal = 0))
    boolean injected(Level instance, Entity entity) {
        float localRandom = instance.random.nextFloat();
        ItemEntity original = (ItemEntity) entity;

        // switch cod or salmon for enchanted golden cooked variant
        if (getPlayerOwner() != null && localRandom <= 0.05F) {
            Player player = getPlayerOwner();
            boolean has_enchantment = EnchantmentHelper.getEnchantmentLevel(GoldenFoodsFabric.GOLDEN_FOOD_ENCHANTMENT_HOLDER, player) > 0;

            // early return
            if (!has_enchantment) {
                return instance.addFreshEntity(entity);
            }

            if (original.getItem().is(Items.COD)) {
                ItemEntity enchantedGoldenCodItemEntity = new ItemEntity(((FishingHook) (Object) this).level(), player.getX(), player.getY(), player.getZ(), new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_COD));
                return instance.addFreshEntity(enchantedGoldenCodItemEntity);
            } else if (original.getItem().is(Items.SALMON)) {
                ItemEntity enchantedGoldenSalmonItemEntity = new ItemEntity(((FishingHook)(Object)this).level(), player.getX(), player.getY(), player.getZ(), new ItemStack(GoldenFoodsFabricRegistry.ENCHANTED_GOLDEN_COOKED_SALMON));
                return instance.addFreshEntity(enchantedGoldenSalmonItemEntity);
            }
        }

        // allow the drop by default
        return instance.addFreshEntity(entity);
    }
}
