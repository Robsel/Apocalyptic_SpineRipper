package com.robsel.asmain.entity.custom;

import com.robsel.asmain.init.EntityInit;
import com.robsel.asmain.init.ItemInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Congealed_CthuluEntity extends ThrowableItemProjectile {
    public Congealed_CthuluEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public Congealed_CthuluEntity(Level pLevel) {
        super(EntityInit.CONG_CTHUL.get(), pLevel);
    }
    public Congealed_CthuluEntity(Level pLevel, double pX, double pY, double pZ) {
        super(EntityInit.CONG_CTHUL.get(), pX, pY, pZ, pLevel);
    }

    public Congealed_CthuluEntity(Level pLevel, LivingEntity livingEntity) {
        super(EntityInit.CONG_CTHUL.get(), pLevel);
    }


    @Override
    protected Item getDefaultItem() {
        return ItemInit.CONGEALED_CTHULU.get();

    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);
    }
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        int i = entity instanceof Blaze ? 3 : 0;
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float)i);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult){
        if(!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, ((byte)3));
            this.level().setThunderLevel(20); // .getCollisions(), , 3);
        }
        super.onHitBlock(pResult);
    }
    /*
    throwable, bouncy
     */
}
