package com.robsel.asmain.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Weird_Bone  extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public Weird_Bone(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(7, 13, 8, 9, 15, 9),
            Block.box(9, 14, 8, 10, 16, 9),
            Block.box(6, 10, 7, 7, 15, 8),
            Block.box(4, 2, 7, 5, 7, 9),
            Block.box(7, 7, 6, 10, 11, 7),
            Block.box(5, 4, 6, 6, 6, 7),
            Block.box(11, 7, 7, 12, 10, 8),
            Block.box(12, 2, 7, 13, 7, 9),
            Block.box(8, 11, 6, 9, 12, 7),
            Block.box(11, 3, 6, 12, 6, 7),
            Block.box(6, 2, 6, 11, 7, 7),
            Block.box(5, 1, 7, 13, 2, 10),
            Block.box(5, 7, 7, 7, 10, 8),
            Block.box(10, 7, 7, 11, 10, 8),
            Block.box(9, 14, 7, 10, 15, 8),
            Block.box(7, 7, 7, 10, 14, 8),
            Block.box(5, 2, 7, 12, 7, 8),
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(10, 14, 8, 11, 16, 9),
            Block.box(6, 12, 8, 7, 14, 9),
            Block.box(10, 10, 7, 11, 15, 8)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(7, 13, 7, 8, 15, 9),
            Block.box(7, 14, 9, 8, 16, 10),
            Block.box(8, 10, 6, 9, 15, 7),
            Block.box(7, 2, 4, 9, 7, 5),
            Block.box(9, 7, 7, 10, 11, 10),
            Block.box(9, 4, 5, 10, 6, 6),
            Block.box(8, 7, 11, 9, 10, 12),
            Block.box(7, 2, 12, 9, 7, 13),
            Block.box(9, 11, 8, 10, 12, 9),
            Block.box(9, 3, 11, 10, 6, 12),
            Block.box(9, 2, 6, 10, 7, 11),
            Block.box(6, 1, 5, 9, 2, 13),
            Block.box(8, 7, 5, 9, 10, 7),
            Block.box(8, 7, 10, 9, 10, 11),
            Block.box(8, 14, 9, 9, 15, 10),
            Block.box(8, 7, 7, 9, 14, 10),
            Block.box(8, 2, 5, 9, 7, 12),
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(7, 14, 10, 8, 16, 11),
            Block.box(7, 12, 6, 8, 14, 7),
            Block.box(8, 10, 10, 9, 15, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(7, 13, 7, 9, 15, 8),
            Block.box(6, 14, 7, 7, 16, 8),
            Block.box(9, 10, 8, 10, 15, 9),
            Block.box(11, 2, 7, 12, 7, 9),
            Block.box(6, 7, 9, 9, 11, 10),
            Block.box(10, 4, 9, 11, 6, 10),
            Block.box(4, 7, 8, 5, 10, 9),
            Block.box(3, 2, 7, 4, 7, 9),
            Block.box(7, 11, 9, 8, 12, 10),
            Block.box(4, 3, 9, 5, 6, 10),
            Block.box(5, 2, 9, 10, 7, 10),
            Block.box(3, 1, 6, 11, 2, 9),
            Block.box(9, 7, 8, 11, 10, 9),
            Block.box(5, 7, 8, 6, 10, 9),
            Block.box(6, 14, 8, 7, 15, 9),
            Block.box(6, 7, 8, 9, 14, 9),
            Block.box(4, 2, 8, 11, 7, 9),
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(5, 14, 7, 6, 16, 8),
            Block.box(9, 12, 7, 10, 14, 8),
            Block.box(5, 10, 8, 6, 15, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(8, 13, 7, 9, 15, 9),
            Block.box(8, 14, 6, 9, 16, 7),
            Block.box(7, 10, 9, 8, 15, 10),
            Block.box(7, 2, 11, 9, 7, 12),
            Block.box(6, 7, 6, 7, 11, 9),
            Block.box(6, 4, 10, 7, 6, 11),
            Block.box(7, 7, 4, 8, 10, 5),
            Block.box(7, 2, 3, 9, 7, 4),
            Block.box(6, 11, 7, 7, 12, 8),
            Block.box(6, 3, 4, 7, 6, 5),
            Block.box(6, 2, 5, 7, 7, 10),
            Block.box(7, 1, 3, 10, 2, 11),
            Block.box(7, 7, 9, 8, 10, 11),
            Block.box(7, 7, 5, 8, 10, 6),
            Block.box(7, 14, 6, 8, 15, 7),
            Block.box(7, 7, 6, 8, 14, 9),
            Block.box(7, 2, 4, 8, 7, 11),
            Block.box(0, 0, 0, 16, 1, 16),
            Block.box(8, 14, 5, 9, 16, 6),
            Block.box(8, 12, 9, 9, 14, 10),
            Block.box(7, 10, 5, 8, 15, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public  BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}


