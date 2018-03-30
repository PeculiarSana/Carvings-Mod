package com.sana.carvings;

import com.sana.carvings.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CarvingsTab extends CreativeTabs{
    public CarvingsTab() {
        super(Carvings.modId);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.journal);
    }
}
