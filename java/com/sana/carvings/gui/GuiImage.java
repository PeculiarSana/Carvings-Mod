package com.sana.carvings.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiImage extends GuiScreen
{
    public int posX;
    public int posY;

    public GuiImage (Minecraft mc, int posX, int posY)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();
        this.mc = mc;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("carvings:textures/gui/galactic_a.png"));
        drawTexturedModalRect(posX, posY, 0, 0, 36, 36);
    }
}
