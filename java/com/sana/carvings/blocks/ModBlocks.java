package com.sana.carvings.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModBlocks {

    public static BlockOre sulfurRock = new BlockOre("sulfur_rock");

    public static BlockCarving carvingGalacticA = new BlockCarving("carving_galactic_a");
    public static BlockCarving carvingGalacticB = new BlockCarving("carving_galactic_b");
    public static BlockCarving carvingGalacticC = new BlockCarving("carving_galactic_c");
    public static BlockCarving carvingGalacticD = new BlockCarving("carving_galactic_d");
    public static BlockCarving carvingGalacticE = new BlockCarving("carving_galactic_e");
    public static BlockCarving carvingGalacticF = new BlockCarving("carving_galactic_f");
    public static BlockCarving carvingGalacticG = new BlockCarving("carving_galactic_g");
    public static BlockCarving carvingGalacticH = new BlockCarving("carving_galactic_h");
    public static BlockCarving carvingGalacticI = new BlockCarving("carving_galactic_i");
    public static BlockCarving carvingGalacticJ = new BlockCarving("carving_galactic_j");
    public static BlockCarving carvingGalacticK = new BlockCarving("carving_galactic_k");
    public static BlockCarving carvingGalacticL = new BlockCarving("carving_galactic_l");
    public static BlockCarving carvingGalacticM = new BlockCarving("carving_galactic_m");
    public static BlockCarving carvingGalacticN = new BlockCarving("carving_galactic_n");
    public static BlockCarving carvingGalacticO = new BlockCarving("carving_galactic_o");
    public static BlockCarving carvingGalacticP = new BlockCarving("carving_galactic_p");
    public static BlockCarving carvingGalacticQ = new BlockCarving("carving_galactic_q");
    public static BlockCarving carvingGalacticR = new BlockCarving("carving_galactic_r");
    public static BlockCarving carvingGalacticS = new BlockCarving("carving_galactic_s");
    public static BlockCarving carvingGalacticT = new BlockCarving("carving_galactic_t");
    public static BlockCarving carvingGalacticU = new BlockCarving("carving_galactic_u");
    public static BlockCarving carvingGalacticV = new BlockCarving("carving_galactic_v");
    public static BlockCarving carvingGalacticW = new BlockCarving("carving_galactic_w");
    public static BlockCarving carvingGalacticX = new BlockCarving("carving_galactic_x");
    public static BlockCarving carvingGalacticY = new BlockCarving("carving_galactic_y");
    public static BlockCarving carvingGalacticZ = new BlockCarving("carving_galactic_z");

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                sulfurRock,

                carvingGalacticA,
                carvingGalacticB,
                carvingGalacticC,
                carvingGalacticD,
                carvingGalacticE,
                carvingGalacticF,
                carvingGalacticG,
                carvingGalacticH,
                carvingGalacticI,
                carvingGalacticJ,
                carvingGalacticK,
                carvingGalacticL,
                carvingGalacticM,
                carvingGalacticN,
                carvingGalacticO,
                carvingGalacticP,
                carvingGalacticQ,
                carvingGalacticR,
                carvingGalacticS,
                carvingGalacticT,
                carvingGalacticU,
                carvingGalacticV,
                carvingGalacticW,
                carvingGalacticX,
                carvingGalacticY,
                carvingGalacticZ
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                sulfurRock.createItemBlock(),

                carvingGalacticA.createItemBlock(),
                carvingGalacticB.createItemBlock(),
                carvingGalacticC.createItemBlock(),
                carvingGalacticD.createItemBlock(),
                carvingGalacticE.createItemBlock(),
                carvingGalacticF.createItemBlock(),
                carvingGalacticG.createItemBlock(),
                carvingGalacticH.createItemBlock(),
                carvingGalacticI.createItemBlock(),
                carvingGalacticJ.createItemBlock(),
                carvingGalacticK.createItemBlock(),
                carvingGalacticL.createItemBlock(),
                carvingGalacticM.createItemBlock(),
                carvingGalacticN.createItemBlock(),
                carvingGalacticO.createItemBlock(),
                carvingGalacticP.createItemBlock(),
                carvingGalacticQ.createItemBlock(),
                carvingGalacticR.createItemBlock(),
                carvingGalacticS.createItemBlock(),
                carvingGalacticT.createItemBlock(),
                carvingGalacticU.createItemBlock(),
                carvingGalacticV.createItemBlock(),
                carvingGalacticW.createItemBlock(),
                carvingGalacticX.createItemBlock(),
                carvingGalacticY.createItemBlock(),
                carvingGalacticZ.createItemBlock()
        );
    }

    public static void registerModels() {
        sulfurRock.registerItemModel(Item.getItemFromBlock(sulfurRock));

        carvingGalacticA.registerItemModel(Item.getItemFromBlock(carvingGalacticA));
        carvingGalacticB.registerItemModel(Item.getItemFromBlock(carvingGalacticB));
        carvingGalacticC.registerItemModel(Item.getItemFromBlock(carvingGalacticC));
        carvingGalacticD.registerItemModel(Item.getItemFromBlock(carvingGalacticD));
        carvingGalacticE.registerItemModel(Item.getItemFromBlock(carvingGalacticE));
        carvingGalacticF.registerItemModel(Item.getItemFromBlock(carvingGalacticF));
        carvingGalacticG.registerItemModel(Item.getItemFromBlock(carvingGalacticG));
        carvingGalacticH.registerItemModel(Item.getItemFromBlock(carvingGalacticH));
        carvingGalacticI.registerItemModel(Item.getItemFromBlock(carvingGalacticI));
        carvingGalacticJ.registerItemModel(Item.getItemFromBlock(carvingGalacticJ));
        carvingGalacticK.registerItemModel(Item.getItemFromBlock(carvingGalacticK));
        carvingGalacticL.registerItemModel(Item.getItemFromBlock(carvingGalacticL));
        carvingGalacticM.registerItemModel(Item.getItemFromBlock(carvingGalacticM));
        carvingGalacticN.registerItemModel(Item.getItemFromBlock(carvingGalacticN));
        carvingGalacticO.registerItemModel(Item.getItemFromBlock(carvingGalacticO));
        carvingGalacticP.registerItemModel(Item.getItemFromBlock(carvingGalacticP));
        carvingGalacticQ.registerItemModel(Item.getItemFromBlock(carvingGalacticQ));
        carvingGalacticR.registerItemModel(Item.getItemFromBlock(carvingGalacticR));
        carvingGalacticS.registerItemModel(Item.getItemFromBlock(carvingGalacticS));
        carvingGalacticT.registerItemModel(Item.getItemFromBlock(carvingGalacticT));
        carvingGalacticU.registerItemModel(Item.getItemFromBlock(carvingGalacticU));
        carvingGalacticV.registerItemModel(Item.getItemFromBlock(carvingGalacticV));
        carvingGalacticW.registerItemModel(Item.getItemFromBlock(carvingGalacticW));
        carvingGalacticX.registerItemModel(Item.getItemFromBlock(carvingGalacticX));
        carvingGalacticY.registerItemModel(Item.getItemFromBlock(carvingGalacticY));
        carvingGalacticZ.registerItemModel(Item.getItemFromBlock(carvingGalacticZ));
    }
}