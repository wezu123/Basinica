package com.wezulaweciarz.basinica.items;

import com.wezulaweciarz.basinica.Basinica;
import net.minecraft.item.Item;

public class EmeraldPickaxe extends Item {

    public EmeraldPickaxe() {
        super(new Properties()
                .maxStackSize(1)
                .group(Basinica.setup.itemGroup));
        setRegistryName("emerald_pickaxe");
    }
}
