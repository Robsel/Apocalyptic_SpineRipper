package com.robsel.asmain.villager;


import com.google.common.collect.ImmutableSet;
import com.robsel.asmain.ASMain;
import com.robsel.asmain.init.BlockInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, ASMain.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS
            = DeferredRegister.create(ForgeRegistries.PROFESSIONS, ASMain.MOD_ID);

    public static final RegistryObject<PoiType> CULTIST_POI = POI_TYPES.register("cultistpoi",
            ()-> new PoiType("cultistpoi", PoiType.getBlockStates(BlockInit.CULTIST_WORKSTATION.get()),1,1));
    public static final  RegistryObject<VillagerProfession> CULTIST = VILLAGER_PROFESSIONS.register("cultist",
            ()-> new VillagerProfession("cultist", CULTIST_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static void  registerPOIs(){
        try{
            ObfuscationReflectionHelper.findMethod((PoiType.class),
                    "registerBlockStates", PoiType.class).invoke(null, CULTIST_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }
    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
