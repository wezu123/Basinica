package com.wezulaweciarz.basinica.items;

import com.wezulaweciarz.basinica.Basinica;
import net.minecraft.item.Item;

public class EmeraldSword extends Item {

    public EmeraldSword() {
        super(new Properties()
                .maxStackSize(1)
                .group(Basinica.setup.itemGroup));
        setRegistryName("emerald_sword");
    }
}
