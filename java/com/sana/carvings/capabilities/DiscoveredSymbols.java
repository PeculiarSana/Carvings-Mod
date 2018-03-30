package com.sana.carvings.capabilities;

import com.sana.carvings.blocks.BlockCarving;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiscoveredSymbols implements ModCapabilities.IDiscoveredSymbols
{
    public Set<ResourceLocation> symbols = new HashSet<>();

    public void add(ResourceLocation rl)
    {
        if(!symbols.contains(rl))
        {
            System.out.print("Attempting to add " + rl);
            symbols.add(rl);
        }
    }

    public void remove(ResourceLocation rl)
    {
        if(symbols.contains(rl))
        {
            symbols.remove(rl);
        }
    }

    public void set (Set<ResourceLocation> set)
    {
        symbols = set;
    }

    public Set<ResourceLocation> getSymbols()
    {
        return symbols;
    }
}
