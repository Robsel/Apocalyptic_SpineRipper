package com.robsel.asmain.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
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


public class Energy_Crystal extends Block {



    public Energy_Crystal(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));

    }



    private static final VoxelShape energy_crystal = Stream.of(
            Block.box(5, 7, 5, 11, 22, 13),
            Block.box(6, 5, 6, 10, 24, 12),
            Block.box(7, 15, 7, 9, 26, 11),
            Block.box(7, 3, 7, 9, 14, 11),
            Block.box(4, 8, 6, 5, 21, 12),
            Block.box(6, 8, 11, 10, 21, 14),
            Block.box(11, 8, 6, 12, 21, 12),
            Block.box(6, 8, 4, 10, 21, 7),
            Block.box(7, 26, 8, 9, 28, 10),
            Block.box(7, 1, 8, 9, 3, 10),
            Block.box(3, 10, 7, 4, 19, 11),
            Block.box(7, 11, 14, 9, 19, 15),
            Block.box(12, 10, 7, 13, 19, 11),
            Block.box(7, 10, 3, 9, 18, 4),
            Block.box(13, 12, 8, 14, 17, 10),
            Block.box(7, 13, 15, 9, 18, 16),
            Block.box(7, 11, 2, 9, 15, 7),
            Block.box(7, 15, 16, 9, 17, 17),
            Block.box(2, 13, 8, 3, 18, 10),
            Block.box(7, 12, 1, 9, 14, 2),
            Block.box(14, 13, 8, 15, 16, 10),
            Block.box(1, 15, 8, 2, 17, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            default:
                return energy_crystal;
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
