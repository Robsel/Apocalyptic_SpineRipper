package com.robsel.asmain.block;

import net.minecraft.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;


public class Energy_Crystal extends Block {


    public Energy_Crystal(Properties p_49795_) {
        super(p_49795_);
    }
    public VoxelShape energy_crystal = Stream.of(
        Block.box(0.4375, 0, 0.4375, 0.5625, 2, 0.5625),
        Block.box(0.3125, 0.25, 0.3125, 0.6875, 1.75, 0.6875),
        Block.box(0.25, 0.75, 0.25, 0.75, 1.25, 0.75)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

}
