package com.robsel.asmain.altar;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import com.robsel.asmain.altar.AltarStoneEntity;
import com.robsel.asmain.init.BlockEntitiesInit;

import org.jetbrains.annotations.Nullable;

public class AltarStoneInsBlock extends Block {

    public AltarStoneInsBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}
