package com.wezulaweciarz.basinica.blocks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {

    public static void setupOreGen() {
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
                biome.addFeature(
                        GenerationStage.Decoration.UNDERGROUND_ORES,
                        Biome.createDecoratedFeature(Feature.ORE,
                                new OreFeatureConfig(
                                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                        ModBlocks.COBALT_ORE
                                                .getDefaultState(),
                                        4),
                                Placement.COUNT_RANGE,
                                new CountRangeConfig(10, 5, 0, 30)));
            }
        }
    }
