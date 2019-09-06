package com.wezulaweciarz.basinica.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CobaltOre extends Block{
    public CobaltOre() {
        super(Block.Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(4.0f)
                .harvestLevel(3)
        );
        setRegistryName("cobalt_ore");
    }
}
