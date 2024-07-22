package com.cursee.golden_foods.core.item.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class GoldenCakeBlock extends CakeBlock {
    public GoldenCakeBlock(Properties properties) { super(properties); }

    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        Item item = itemStack.getItem();
        if (itemStack.is(ItemTags.CANDLES) && (Integer)blockState.getValue(BITES) == 0) {
            Block var10 = Block.byItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock)var10;
                itemStack.consume(1, player);
                level.playSound((Player)null, blockPos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(blockPos, CandleCakeBlock.byCandle(candleBlock));
                level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
                player.awardStat(Stats.ITEM_USED.get(item));
                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            if (eat(level, blockPos, blockState, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, blockPos, blockState, player);
    }

    protected static InteractionResult eat(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1));
            int i = (Integer)blockState.getValue(BITES);
            levelAccessor.gameEvent(player, GameEvent.EAT, blockPos);
            if (i < 6) {
                levelAccessor.setBlock(blockPos, (BlockState)blockState.setValue(BITES, i + 1), 3);
            } else {
                levelAccessor.removeBlock(blockPos, false);
                levelAccessor.gameEvent(player, GameEvent.BLOCK_DESTROY, blockPos);
            }

            return InteractionResult.SUCCESS;
        }
    }

//    @Override
//    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
//        ItemStack itemstack = player.getItemInHand(hand);
//        Item item = itemstack.getItem();
//        if (itemstack.is(ItemTags.CANDLES) && state.getValue(BITES) == 0) {
//            Block block = Block.byItem(item);
//            if (block instanceof CandleBlock) {
//                if (!player.isCreative()) {
//                    itemstack.shrink(1);
//                }
//
//                level.playSound((Player)null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
//                level.setBlockAndUpdate(pos, CandleCakeBlock.byCandle(block));
//                level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
//                player.awardStat(Stats.ITEM_USED.get(item));
//                return InteractionResult.SUCCESS;
//            }
//        }
//
//        if (level.isClientSide) {
//            if (eat(level, pos, state, player).consumesAction()) {
//                return InteractionResult.SUCCESS;
//            }
//
//            if (itemstack.isEmpty()) {
//                return InteractionResult.CONSUME;
//            }
//        }
//
//        return eat(level, pos, state, player);
//    }
//    protected static InteractionResult eat(LevelAccessor accessor, BlockPos pos, BlockState state, Player player) {
//        player.awardStat(Stats.EAT_CAKE_SLICE);
//        player.getFoodData().eat(4, 1.2F);
//        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
//        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 1));
//        int i = state.getValue(BITES);
//        accessor.gameEvent(player, GameEvent.EAT, pos);
//        if (i < 6) {
//            accessor.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
//        } else {
//            accessor.removeBlock(pos, false);
//            accessor.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
//        }
//
//        return InteractionResult.SUCCESS;
//    }
}
