package com.sana.carvings.items;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemJournal journal = new ItemJournal("journal");
    public static ItemTracingPaper tracingPaper = new ItemTracingPaper("tracing_paper");
    public static ItemTracingPaperUsed tracingPaperUsed = new ItemTracingPaperUsed("tracing_paper_used");
    public static ItemTracingPencil tracingPencil = new ItemTracingPencil("tracing_pencil");
    public static ItemBase sulfur = new ItemBase("sulfur");
    public static ItemBase bucketAcid = new ItemBase("bucket_acid");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                journal,
                tracingPaper,
                tracingPaperUsed,
                tracingPencil,
                sulfur,
                bucketAcid
        );
    }

    public static void registerModels()
    {
        journal.registerItemModel();
        tracingPaper.registerItemModel();
        tracingPaperUsed.registerItemModel();
        tracingPencil.registerItemModel();
        sulfur.registerItemModel();
        bucketAcid.registerItemModel();
    }
}