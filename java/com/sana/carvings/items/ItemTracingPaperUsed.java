package com.sana.carvings.items;

import com.sana.carvings.Carvings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTracingPaperUsed extends Item
{
    protected String name;

    public ItemTracingPaperUsed(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Carvings.creativeTab);
    }

    /*@Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        if (!playerIn.getEntityData().tag || !itemStack.getTagCompound().hasKey("symbol"))
        {
            newItems.setTagInfo("symbol", new NBTTagString(iblockstate.getBlock().getUnlocalizedName()));
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }*/

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if(stack.hasTagCompound() && stack.getTagCompound().getString("symbol") != "empty")
        {
            tooltip.add("Unknown Symbol (" + stack.getTagCompound().getString("symbol") + ")");
        }
    }

    public void registerItemModel()
    {
        Carvings.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemTracingPaperUsed setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        return this;
    }
}
