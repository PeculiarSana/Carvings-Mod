package com.sana.carvings.gui;

import com.sana.carvings.ModSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiBackButton extends GuiButton
{
    public int buttonId;
    public int xPos;
    public int yPos;
    public int width;
    public int height;
    public String buttonText;

    public ResourceLocation resource = new ResourceLocation("carvings:textures/gui/book.png");

    public GuiBackButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.buttonId = buttonId;
        this.xPos = x;
        this.yPos = y;
        this.width = widthIn;
        this.height = heightIn;
        this.buttonText = buttonText;
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
            GlStateManager.pushMatrix();
            {
                mc.renderEngine.bindTexture(resource);
                this.drawTexturedModalRect(xPos, yPos, 49, 194, 16, 11);
            }
            GlStateManager.popMatrix();
        }
    }
}