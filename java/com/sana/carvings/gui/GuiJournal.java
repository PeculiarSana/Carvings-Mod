package com.sana.carvings.gui;

import com.sana.carvings.blocks.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiJournal extends GuiScreen
{
    String text = "Hello world!";

    private GuiCustomButton buttonTracings;
    private GuiBackButton buttonBack;
    private GuiItemButton buttonTest;
    private Minecraft mc;

    private int centerX;
    private int centerY;
    private int titleX;
    private int titleY;

    private int guiWidth = 146;
    private int guiHeight = 180;

    private ResourceLocation resource = new ResourceLocation("carvings:textures/gui/book.png");

    private String currentPageId = "main";
    private String previousPageId;

    int offsetFromScreenLeft;

    public GuiJournal(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();
        this.mc = mc;
        centerX = (width / 2 ) - (guiWidth / 2) ;
        centerY = (height / 2) - (guiHeight / 2);

        titleX = centerX + 15;
        titleY = centerY + 15;
    }

    @Override
    public void initGui()
    {
        buttonList.clear();
        buttonTracings = new GuiCustomButton(0, centerX + 135, centerY + 20, 48,  15,
                I18n.format("gui.carvings.scripts", new Object[0]), true, false, 0x000000, 8, 4, 0.8F,
                resource, 91, 194, 55, 15,
                91, 194);
        buttonBack = new GuiBackButton(1, centerX + 15, centerY + 155, 16,  11, "");
        buttonTest = new GuiItemButton(2, centerX + 15, centerY + 40, 16, 16, "", new ItemStack(ModBlocks.carvingGalacticA));
        buttonList.add(buttonTracings);
        buttonList.add(buttonBack);
        buttonList.add(buttonTest);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();

        mc.getTextureManager().bindTexture(new ResourceLocation("carvings:textures/gui/book.png"));
        drawTexturedModalRect(centerX, centerY, 0, 0, 146, 180);

        if (currentPageId == "main")
        {
            buttonBack.visible = false;
            buttonTest.visible = false;
            buttonTracings.visible = true;

            double titleScale = 1;
            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(titleX, titleY,0);
                GlStateManager.scale(titleScale, titleScale, titleScale);
                fontRenderer.drawString("Deciphering Journal", 0, 0, 0x000000, false);
            }
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(centerX + 15, centerY + 30,0);
                double textScale = 0.8;
                GlStateManager.scale(textScale, textScale, textScale);
                fontRenderer.drawSplitString("During my explorations, I stumbled across an ancient ruin with some curious carvings on the walls. They didn't seem to match any writing systems I know of, so I've created this journal to track my findings and progress towards deciphering this writing system. Maybe it will lead me to fascinating things!", 0, 0, 150, 0x000000);
            }
            GlStateManager.popMatrix();
        }
        else if(currentPageId == "scripts")
        {
            buttonBack.visible = true;
            buttonTest.visible = true;
            buttonTracings.visible = false;

            previousPageId = "main";

            double titleScale = 1;
            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(titleX, titleY,0);
                GlStateManager.scale(titleScale, titleScale, titleScale);
                fontRenderer.drawString("Scripts", 0, 0, 0x000000, false);
            }
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(centerX + 15, centerY + 30,0);
                GlStateManager.scale(0.8, 0.8, 0.8);
                fontRenderer.drawString("Unknown Script", 0, 0, 0x000000, false);
            }
            GlStateManager.popMatrix();

            if (mouseX >= buttonTest.x && mouseX <= buttonTest.x + buttonTest.width && mouseY >= buttonTest.y && mouseY <= buttonTest.y + buttonTest.height){
                List<String> text = new ArrayList<String>();
                text.add("Unknown Symbol");
                text.add(buttonTest.item.getUnlocalizedName());
                drawHoveringText(text, mouseX, mouseY);
            }
        }
        else if(currentPageId == "carving")
        {
            buttonBack.visible = true;
            buttonTest.visible = false;
            buttonTracings.visible = false;

            previousPageId = "scripts";

            mc.getTextureManager().bindTexture(new ResourceLocation("carvings:textures/gui/galactic.png"));
            drawTexturedModalRect(centerX + 15, centerY + 15, 2, 2, 24, 24);

            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(centerX + 44, centerY + 15,0);
                GlStateManager.scale(1, 1, 1);
                fontRenderer.drawString("Unknown Symbol", 0, 0, 0x000000, false);
            }
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            {
                GlStateManager.translate(centerX + 44, centerY + 26,0);
                GlStateManager.scale(0.7, 0.7, 0.7);
                fontRenderer.drawSplitString("An unknown symbol from an unknown writing system", 0, 0, 120, 0x000000);
            }
            GlStateManager.popMatrix();

            drawHorizontalLine(centerX + 10, centerX + 100, centerY + 100, 0x000000);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton parButton)
    {
        if (parButton == buttonTracings)
        {
            if (currentPageId != "scripts")
            {
                currentPageId = "scripts";
            }
        }
        else if (parButton == buttonBack)
        {
            currentPageId = previousPageId;
        }
        else if (parButton == buttonTest && currentPageId == "scripts")
        {
            currentPageId = "carving";
        }
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return true;
    }
}
