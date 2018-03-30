package com.sana.carvings;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModSounds{

    public static final SoundEvent PENCIL_TRACE = newSoundEvent("pencil_trace");
    public static final SoundEvent BOOK_PAGE = newSoundEvent("book_page");

    public static SoundEvent newSoundEvent(String pathIn){
        ResourceLocation soundID = new ResourceLocation("carvings", pathIn);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    public static void register(IForgeRegistry<SoundEvent> registry) {
        registry.registerAll(
                PENCIL_TRACE,
                BOOK_PAGE
        );
    }
}
