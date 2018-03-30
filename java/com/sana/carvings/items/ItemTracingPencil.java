package com.sana.carvings.items;

import com.sana.carvings.Carvings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTracingPencil extends Item{

    protected String name;

    public ItemTracingPencil(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Carvings.creativeTab);
        setMaxStackSize(1);
        setMaxDamage(4);
    }

    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        if(stack.getItemDamage() >= stack.getMaxDamage()){
            stack.shrink(1);
        }
    }

    public void registerItemModel()
    {
        Carvings.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemTracingPencil setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        return this;
    }
}
