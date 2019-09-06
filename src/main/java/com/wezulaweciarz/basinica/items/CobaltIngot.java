package com.wezulaweciarz.basinica.items;

import com.wezulaweciarz.basinica.Basinica;
import net.minecraft.item.Item;

public class CobaltIngot extends Item {

    public CobaltIngot() {
        super(new Properties()
                .maxStackSize(64)
                .group(Basinica.setup.itemGroup));
        setRegistryName("cobalt_ingot");
    }
}
