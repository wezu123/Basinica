package com.wezulaweciarz.basinica.blocks;

import com.wezulaweciarz.basinica.blocks.firstblock.FirstBlock;
import com.wezulaweciarz.basinica.blocks.firstblock.FirstBlockContainer;
import com.wezulaweciarz.basinica.blocks.firstblock.FirstBlockTile;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("basinica:firstblock")
    public static FirstBlock FIRSTBLOCK;

    @ObjectHolder("basinica:solarpanel")
    public static SolarPanel SOLARPANEL;

    @ObjectHolder("basinica:capacitor")
    public static Capacitor CAPACITOR;

    @ObjectHolder("basinica:firstblock")
    public static TileEntityType<FirstBlockTile> FIRSTBLOCK_TILE;

    @ObjectHolder("basinica:firstblock")
    public static ContainerType<FirstBlockContainer> FIRSTBLOCK_CONTAINER;
}