package com.sana.carvings.items;

import com.sana.carvings.blocks.BlockCarving;
import com.sana.carvings.blocks.ModBlocks;
import com.sana.carvings.Carvings;
import com.sana.carvings.ModSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class ItemTracingPaper extends Item{

    protected String name;
    protected BlockCarving[] galacticBlocks = {
            ModBlocks.carvingGalacticA,
            ModBlocks.carvingGalacticB,
            ModBlocks.carvingGalacticC,
            ModBlocks.carvingGalacticD,
            ModBlocks.carvingGalacticE,
            ModBlocks.carvingGalacticF,
            ModBlocks.carvingGalacticG,
            ModBlocks.carvingGalacticH,
            ModBlocks.carvingGalacticI,
            ModBlocks.carvingGalacticJ,
            ModBlocks.carvingGalacticK,
            ModBlocks.carvingGalacticL,
            ModBlocks.carvingGalacticM,
            ModBlocks.carvingGalacticN,
            ModBlocks.carvingGalacticO,
            ModBlocks.carvingGalacticP,
            ModBlocks.carvingGalacticQ,
            ModBlocks.carvingGalacticR,
            ModBlocks.carvingGalacticS,
            ModBlocks.carvingGalacticT,
            ModBlocks.carvingGalacticU,
            ModBlocks.carvingGalacticV,
            ModBlocks.carvingGalacticW,
            ModBlocks.carvingGalacticX,
            ModBlocks.carvingGalacticY,
            ModBlocks.carvingGalacticZ
    };

    public ItemTracingPaper(String name)
    {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Carvings.creativeTab);
        this.setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        //Raytraces to check what block is being clicked
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, false);
        //If the raytrace hits a block
        if (raytraceresult.typeOfHit != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
        {
            //Get the block's position in order to get the block itself
            BlockPos blockpos = raytraceresult.getBlockPos();
            IBlockState iblockstate = worldIn.getBlockState(blockpos);
            //If the block is part of the galacticBlocks array and if the player has a pencil in their inventory
            int wantedSlot = 0;
            boolean hasItem = false;
            for (int i = 0; i <= playerIn.inventory.getSizeInventory(); i++)
            {
                if (playerIn.inventory.getStackInSlot(i).getItem() == ModItems.tracingPencil)
                {
                    wantedSlot = i;
                    hasItem = true;
                    break;
                }
                else
                 {
                    wantedSlot = 0;
                    hasItem = false;
                 }
            }
            if (Arrays.asList(galacticBlocks).contains(iblockstate.getBlock()) && hasItem)
            {
                ItemStack newItems = new ItemStack(ModItems.tracingPaperUsed);
                if (!newItems.hasTagCompound() || !newItems.getTagCompound().hasKey("symbol"))
                {
                    newItems.setTagInfo("symbol", new NBTTagString(iblockstate.getBlock().getUnlocalizedName()));
                }
                //Damages the pencil ItemStack
                ItemStack pencilStack = playerIn.inventory.getStackInSlot(wantedSlot);
                pencilStack.setItemDamage(pencilStack.getItemDamage() + 1);
                //Plays a sound effect
                playerIn.playSound(ModSounds.PENCIL_TRACE, 3.0F, 1F);
                //returns the default animation and replaces the item with newItems (ModItems.tracingPaperUsed)
                playerIn.inventory.setInventorySlotContents(playerIn.inventory.getSlotFor(itemstack), newItems);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
            }
            else
            {
                return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("It has nothing on it.");
    }

    public void registerItemModel()
    {
        Carvings.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemTracingPaper setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        return this;

    }
}
