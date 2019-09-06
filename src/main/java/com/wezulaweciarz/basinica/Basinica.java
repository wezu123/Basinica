package com.wezulaweciarz.basinica;

import com.wezulaweciarz.basinica.blocks.*;
import com.wezulaweciarz.basinica.blocks.firstblock.FirstBlock;
import com.wezulaweciarz.basinica.blocks.firstblock.FirstBlockContainer;
import com.wezulaweciarz.basinica.blocks.firstblock.FirstBlockTile;
import com.wezulaweciarz.basinica.blocks.ores.CobaltOre;
import com.wezulaweciarz.basinica.items.CobaltIngot;
import com.wezulaweciarz.basinica.items.FirstItem;
import com.wezulaweciarz.basinica.setup.ClientProxy;
import com.wezulaweciarz.basinica.setup.IProxy;
import com.wezulaweciarz.basinica.setup.ModSetup;
import com.wezulaweciarz.basinica.setup.ServerProxy;
import com.wezulaweciarz.basinica.tiers.BasinicaTiers;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("basinica")
public class Basinica {

    public static final String MODID = "basinica";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public Basinica() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
}

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
        OreGen.setupOreGen();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new FirstBlock());
            event.getRegistry().register(new SolarPanel());
            event.getRegistry().register(new Capacitor());
            event.getRegistry().register(new CobaltOre());
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.FIRSTBLOCK, properties).setRegistryName("firstblock"));
            event.getRegistry().register(new BlockItem(ModBlocks.SOLARPANEL, properties).setRegistryName("solarpanel"));
            event.getRegistry().register(new BlockItem(ModBlocks.CAPACITOR, properties).setRegistryName("capacitor"));
            event.getRegistry().register(new BlockItem(ModBlocks.COBALT_ORE, properties).setRegistryName("cobalt_ore"));
            event.getRegistry().register(new FirstItem());
            event.getRegistry().register(new CobaltIngot());
            event.getRegistry().register(new PickaxeItem(BasinicaTiers.EMERALD, 1, -2.8f, properties).setRegistryName("emerald_pickaxe"));
            event.getRegistry().register(new SwordItem(BasinicaTiers.EMERALD, 4, -2.4f, properties).setRegistryName("emerald_sword"));
            event.getRegistry().register(new ShieldItem(properties.maxDamage(1)).setRegistryName("diamond_shield"));
        }
        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(FirstBlockTile::new, ModBlocks.FIRSTBLOCK).build(null).setRegistryName("firstblock"));
        }
        @SubscribeEvent
        public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event){
            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new FirstBlockContainer(windowId, Basinica.proxy.getClientWorld(), pos, inv, Basinica.proxy.getClientPlayer());
            }).setRegistryName("firstblock"));
        }
    }
}
