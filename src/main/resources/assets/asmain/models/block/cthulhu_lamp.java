Stream.of(
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
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();