package com.wezulaweciarz.basinica.items;

import com.wezulaweciarz.basinica.Basinica;
import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(Basinica.setup.itemGroup));
        setRegistryName("firstitem");
    }
}
