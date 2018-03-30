package com.sana.carvings.items;

import com.sana.carvings.Carvings;
import com.sana.carvings.gui.GuiJournal;
import com.sana.carvings.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.List;

public class ItemJournal extends Item
{
    protected String name;

    public List<String> discoveredSymbols;

    public ItemJournal(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Carvings.creativeTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if(worldIn.isRemote){
            playerIn.playSound(ModSounds.BOOK_PAGE, 1F, (float)(Math.random() * (1.2 - 0.8) + 0.8));
            Minecraft.getMinecraft().displayGuiScreen(new GuiJournal(Minecraft.getMinecraft()));
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
    }

    public void registerItemModel() {
        Carvings.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemJournal setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        return this;
    }
}