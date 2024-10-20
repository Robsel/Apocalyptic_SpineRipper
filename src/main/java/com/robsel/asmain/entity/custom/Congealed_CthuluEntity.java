package com.robsel.asmain.entity.custom;

import com.robsel.asmain.init.EntityInit;
import com.robsel.asmain.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class Congealed_CthuluEntity extends ThrowableItemProjectile {
    public Congealed_CthuluEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public Congealed_CthuluEntity(Level pLevel) {
        super(EntityInit.CONG_CTHUL.get(), pLevel);
    }

    public Congealed_CthuluEntity(Level pLevel, LivingEntity livingEntity) {
        super(EntityInit.CONG_CTHUL.get(), pLevel);
    }


    @Override
    protected Item getDefaultItem() {
        return ItemInit.CONGEALED_CTHULU.get();

    }
    @Override
    protected void onHitBlock(BlockHitResult pResult){
        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte)3));
            //this.level().playSound()  .getCollisions(), , 3);
        }
        super.onHitBlock(pResult);
    }
    /*
    throwable, bouncy
     */
}
