package com.wezulaweciarz.basinica.blocks;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.List;

public class SolarPanel extends Block {
    public SolarPanel() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
        );
        setRegistryName("solarpanel");
    }
    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT; //or TRANSPARENT or CUTOUT as you require
    }

    public static final VoxelShape SOLARSLAB = Block.makeCuboidShape(0, 0, 0, 16, 7, 16);

    public static final List<VoxelShape> SOLARLIST = ImmutableList.of(
            Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
            Block.makeCuboidShape(7, 1, 7, 9, 6, 9),
            Block.makeCuboidShape(0, 6, 0, 16, 7, 16),
            Block.makeCuboidShape(6, 1, 6, 10, 2, 10),
            Block.makeCuboidShape(6, 5, 6, 10, 6, 10)
    );

    public static final VoxelShape SOLARMODEL = merge(SOLARLIST);

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SOLARMODEL;
    }

   /* @Override
    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return SOLARSLAB;
    }
 */
   @Override
   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
       return SOLARSLAB;
   }

    @Override
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 3;
    }


    private static VoxelShape merge(List<VoxelShape> shapes) {
        VoxelShape shape = shapes.get(0);
        for (VoxelShape s : shapes) {
            shape = VoxelShapes.combine(shape, s, IBooleanFunction.OR);
        }
        return shape;
    }
}

