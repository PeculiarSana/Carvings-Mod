package com.sana.carvings.gui;

import com.sana.carvings.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiItemButton extends GuiButton
{
    public int buttonId;
    public int xPos;
    public int yPos;
    public int width;
    public int height;
    public String buttonText;
    public ItemStack item;


    public GuiItemButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, ItemStack item)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.buttonId = buttonId;
        this.xPos = x;
        this.yPos = y;
        this.width = widthIn;
        this.height = heightIn;
        this.buttonText = buttonText;
        this.item = item;
    }

    @Override
    public void playPressSound(SoundHandler soundHandlerIn)
    {
        soundHandlerIn.playSound(PositionedSoundRecord.getMasterRecord(ModSounds.BOOK_PAGE, 1.0F));
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if (this.visible)
        {
            GlStateManager.color(1F, 1F, 1F, 1F);
            mc.getRenderItem().renderItemIntoGUI(item, xPos, yPos);
        }
    }
}