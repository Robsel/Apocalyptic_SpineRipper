package com.robsel.asmain.entity;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.entity.custom.gtent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ASMain.MOD_ID);

    public static final RegistryObject<EntityType<gtent>> GTENT = ENTITY_TYPES.register("gtent",
            () -> EntityType.Builder.of(gtent::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.1f)
                    .build(new ResourceLocation(ASMain.MOD_ID, "gtent").toString()));

 /*   public static final RegistryObject<EntityType<cultist>> CULTIST = ENTITY_TYPES.register("cultist",
            () -> EntityType.Builder.of(gtent::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.1f)
                    .build(new ResourceLocation(ASMain.MOD_ID, "cultist").toString()));
*/

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
