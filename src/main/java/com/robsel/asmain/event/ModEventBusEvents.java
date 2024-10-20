package com.robsel.asmain.event;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.entity.custom.GTentEntity;
import com.robsel.asmain.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ASMain.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.GTENT.get(), GTentEntity.createMobAttributes().build());
    }
}
