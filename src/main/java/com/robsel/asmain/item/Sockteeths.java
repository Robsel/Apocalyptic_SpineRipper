package com.robsel.asmain.item;

import com.robsel.asmain.init.ItemInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class Sockteeths extends BowlFoodItem {
    public Sockteeths(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? itemstack : new ItemStack(ItemInit.SOCKTEETHS.get());
    }
    //Should not be used to comb your hair, but can be
    //right click for eat anim(? custom hair anim) effect: Combed Hair, bit teethy(teeth particles?)
    //buyable from cultist
}
