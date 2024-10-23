package com.robsel.asmain.item;
import com.robsel.asmain.entity.custom.Congealed_CthuluEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Congealed_Cthulu extends Item {
    public Congealed_Cthulu(Properties pProperties) {
        super(pProperties);
    }


    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ARMOR_EQUIP_TURTLE, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!pLevel.isClientSide) {
            Congealed_CthuluEntity congealedCthulu = new Congealed_CthuluEntity(pLevel, pPlayer);
            congealedCthulu.setItem(itemstack);
            congealedCthulu.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(congealedCthulu);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
}
}
