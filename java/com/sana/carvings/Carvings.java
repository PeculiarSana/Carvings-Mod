package com.sana.carvings;

import com.sana.carvings.blocks.ModBlocks;
import com.sana.carvings.capabilities.DiscoveredSymbolsProvider;
import com.sana.carvings.capabilities.ModCapabilities;
import com.sana.carvings.capabilities.ModCapabilities.IDiscoveredSymbols;
import com.sana.carvings.items.ModItems;
import com.sana.carvings.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(modid = Carvings.modId, name = Carvings.name, version = Carvings.version)
public class Carvings{

    public static final String modId = "carvings";
    public static final String name = "Carvings Mod";
    public static final String version = "1.0.0";

    public static final CarvingsTab creativeTab = new CarvingsTab();

    public static final Logger LOGGER = LogManager.getLogger(modId);

    public static IForgeRegistry blockRegistry;

    @Mod.Instance(modId)
    public static Carvings instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModCapabilities.registerCapabilities();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        proxy.serverStarting(event);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void register(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void register(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
            ModSounds.register(event.getRegistry());
        }

        public static void onPlayerDeath(PlayerEvent.Clone event)
        {
            EntityPlayer player = event.getEntityPlayer();
            IDiscoveredSymbols symbols = player.getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);
            IDiscoveredSymbols oldSymbols = event.getOriginal().getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);
        }

        public static final ResourceLocation DISCOVERED_SYMBOLS = new ResourceLocation(Carvings.modId, "discovered_symbols");
        @SubscribeEvent
        public static void attachCapability(AttachCapabilitiesEvent event)
        {
            if (!(event.getObject() instanceof EntityPlayer)) return;

            event.addCapability(DISCOVERED_SYMBOLS, new DiscoveredSymbolsProvider());
        }

        @SubscribeEvent
        public static void onPlayerLogsIn(PlayerLoggedInEvent event)
        {
            EntityPlayer player = event.player;
            IDiscoveredSymbols symbols = player.getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);

            String message = String.format("Hello there, you have discovered §7%d§r symbols.", symbols.getSymbols().size());

            player.sendMessage(new TextComponentString(message));
        }
    }

    @SidedProxy(serverSide = "com.sana.carvings.proxy.CommonProxy", clientSide = "com.sana.carvings.proxy.ClientProxy")
    public static CommonProxy proxy;
}