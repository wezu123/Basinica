package com.wezulaweciarz.basinica.tiers;

import com.wezulaweciarz.basinica.items.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum BasinicaTiers implements IItemTier {
        EMERALD(3, 2500, 6.0F, 2.0F, 20, ()->{
            return Ingredient.fromItems(Items.EMERALD);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyLoadBase<Ingredient> repairMaterial;

   private BasinicaTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn,
        Supplier<Ingredient> repairMaterialIn)
        {
            this.harvestLevel = harvestLevelIn;
            this.maxUses = maxUsesIn;
            this.efficiency = efficiencyIn;
            this.attackDamage = attackDamageIn;
            this.enchantability = enchantabilityIn;
            this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
        }

        @Override
        public int getMaxUses() {
        return this.maxUses;
    }

        @Override
        public float getEfficiency() {
        return this.efficiency;
    }

        @Override
        public float getAttackDamage() {
        return this.attackDamage;
    }

        @Override
        public int getHarvestLevel() {
        return this.harvestLevel;
    }

        @Override
        public int getEnchantability() {
        return this.enchantability;
    }

    @Override
        public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
    }