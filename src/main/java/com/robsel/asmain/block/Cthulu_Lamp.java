package com.robsel.asmain.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Cthulu_Lamp extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public Cthulu_Lamp(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));

    }

    private static final VoxelShape energy_crystal = Stream.of(
            Block.box(4, 2, 13, 12, 10, 14),
            Block.box(13, 2, 4, 14, 10, 12),
            Block.box(4, 2, 2, 12, 10, 3),
            Block.box(2, 2, 4, 3, 10, 12),
            Block.box(7, 14, 7, 9, 15, 9),
            Block.box(6, 12, 7, 7, 14, 9),
            Block.box(9, 12, 7, 10, 14, 9),
            Block.box(4, 11, 4, 12, 12, 12),
            Block.box(3, 1, 3, 13, 11, 13),
            Block.box(4, 0, 4, 12, 1, 12)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlock(pPos, pState.setValue(CLICKED, !currentState), 3);

        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }

}
