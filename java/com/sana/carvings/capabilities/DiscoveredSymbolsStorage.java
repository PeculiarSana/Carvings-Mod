package com.sana.carvings.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import com.sana.carvings.capabilities.ModCapabilities.IDiscoveredSymbols;

public class DiscoveredSymbolsStorage implements IStorage<IDiscoveredSymbols>
{

    @Override
    public NBTBase writeNBT(Capability<IDiscoveredSymbols> capability, ModCapabilities.IDiscoveredSymbols instance, EnumFacing side)
    {
        NBTTagList NbtList = new NBTTagList();

        for (ResourceLocation rl : instance.getSymbols()) {
            NBTTagCompound compound = new NBTTagCompound();
            compound.setString("domain", rl.getResourceDomain());
            compound.setString("path", rl.getResourcePath());
            NbtList.appendTag(compound);
        }
        return NbtList;
    }

    @Override
    public void readNBT(Capability<IDiscoveredSymbols> capability, IDiscoveredSymbols instance, EnumFacing side, NBTBase nbt)
    {
        instance.getSymbols();
    }
}