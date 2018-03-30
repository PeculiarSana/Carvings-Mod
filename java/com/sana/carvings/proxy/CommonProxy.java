package com.sana.carvings.proxy;

import com.sana.carvings.commands.CommandAddSymbol;
import net.minecraft.item.Item;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy{
    public void registerItemRenderer(Item item, int meta, String id)
    {
    }

    public void serverStarting(FMLServerStartingEvent event)
    {
        System.out.print("Registering CommandAddSymbol()");
        event.registerServerCommand(new CommandAddSymbol());
    }
}
