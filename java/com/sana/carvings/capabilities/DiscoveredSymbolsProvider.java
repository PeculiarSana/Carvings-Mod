package com.sana.carvings.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import com.sana.carvings.capabilities.ModCapabilities.IDiscoveredSymbols;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class DiscoveredSymbolsProvider implements ICapabilitySerializable<NBTBase>

{

    @CapabilityInject(IDiscoveredSymbols.class)
    public static final Capability<IDiscoveredSymbols> DISCOVERED_SYMBOLS = null;

    private IDiscoveredSymbols instance = DISCOVERED_SYMBOLS.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == DISCOVERED_SYMBOLS;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return capability == DISCOVERED_SYMBOLS ? DISCOVERED_SYMBOLS.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return DISCOVERED_SYMBOLS.getStorage().writeNBT(DISCOVERED_SYMBOLS, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        DISCOVERED_SYMBOLS.getStorage().readNBT(DISCOVERED_SYMBOLS, this.instance, null, nbt);
    }
}

