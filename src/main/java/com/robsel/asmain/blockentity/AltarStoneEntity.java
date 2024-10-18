package com.robsel.asmain.blockentity;

import com.robsel.asmain.init.BlockEntitiesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AltarStoneEntity extends BlockEntity {
    public AltarStoneEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesInit.ALTAR_STONE_ENTITY.get(), pos, state);
    }

    // This BlockEntity can hold data or just be used for rendering
}