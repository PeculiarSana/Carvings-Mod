package com.sana.carvings.gui;

import com.sana.carvings.ModSounds;
import com.sun.org.apache.xpath.internal.operations.Bool;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.Sys;

import java.util.ArrayList;
import java.util.List;

public class GuiCustomButton extends GuiButton
{
    public int buttonId;
    public int xPos;
    public int yPos;
    public int width;
    public int height;
    public String buttonText;
    public Boolean hasText;
    public Boolean textShadow;
    public int textX;
    public int textY;
    public int textColor;
    public float textScale;
    public static ResourceLocation texture;
    public static int texU;
    public static int texV;
    public static int texWidth;
    public static int texHeight;
    public static int texMouseU;
    public static int texMouseV;


    public GuiCustomButton(int buttonId, int x, int y, int widthIn, int heightIn,
                           String buttonText, Boolean hasText, Boolean textShadow, int textColor, int textX, int textY, float textScale,
                           ResourceLocation texture, int textureU, int textureV, int textureWidth, int textureHeight,
                           int textureHoverU, int textureHoverV)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.buttonId = buttonId;
        this.xPos = x;
        this.yPos = y;
        this.width = widthIn;
        this.height = heightIn;
        this.buttonText = buttonText;
        this.hasText = hasText;
        this.textShadow = textShadow;
        this.textColor = textColor;
        this.textX = textX;
        this.textY = textY;
        this.textScale = textScale;

        //Normal texture
        this.texture = texture;
        this.texU = textureU;
        this.texV = textureV;
        this.texWidth = textureWidth;
        this.texHeight = textureHeight;

        //Mouse-over texture
        this.texMouseU = textureHoverU;
        this.texMouseV = textureHoverV;
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
                mc.renderEngine.bindTexture(texture);
                this.drawTexturedModalRect(xPos, yPos, texU, texV, texWidth, texHeight);
            }
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(this.xPos + textX, this.yPos + textY, 1);
                GlStateManager.scale(textScale, textScale, textScale);
                mc.fontRenderer.drawString(buttonText, 0, 0, textColor, textShadow);
            }
            GlStateManager.popMatrix();
        }
    }
}