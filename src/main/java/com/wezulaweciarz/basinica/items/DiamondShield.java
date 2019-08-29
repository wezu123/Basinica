package com.wezulaweciarz.basinica.items;

import com.wezulaweciarz.basinica.Basinica;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DiamondShield extends Item {

    public DiamondShield() {
        super(new Properties()
                .maxStackSize(1)
                .group(Basinica.setup.itemGroup));
        setRegistryName("diamond_shield");
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}
