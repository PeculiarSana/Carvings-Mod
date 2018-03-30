package com.sana.carvings.capabilities;

import com.sana.carvings.blocks.BlockCarving;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;

import java.util.List;
import java.util.Set;

public class ModCapabilities
{
    public interface IDiscoveredSymbols
    {
        public void add(ResourceLocation rl);

        public void remove(ResourceLocation rl);

        public void set(Set<ResourceLocation> rl);

        public Set<ResourceLocation> getSymbols();
    }

    public static void registerCapabilities(){
        CapabilityManager.INSTANCE.register(IDiscoveredSymbols.class, new DiscoveredSymbolsStorage(), DiscoveredSymbols::new);
    }
}
