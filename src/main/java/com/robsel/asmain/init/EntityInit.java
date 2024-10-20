package com.robsel.asmain.init;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.entity.custom.Congealed_CthuluEntity;
import com.robsel.asmain.entity.custom.GTentEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ASMain.MOD_ID);

    public static final RegistryObject<EntityType<GTentEntity>> GTENT =
            ENTITY_TYPES.register("gtent", () -> EntityType.Builder.of(GTentEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 1.5f).build("gtent"));

    public static final RegistryObject<EntityType<Congealed_CthuluEntity>> CONG_CTHUL =
            ENTITY_TYPES.register("cong_cthul", () -> EntityType.Builder.<Congealed_CthuluEntity>of(Congealed_CthuluEntity::new, MobCategory.MISC)
                    .sized(0.75f, 1.5f).build("cong_cthul"));
    public static void register(IEventBus bus){
        ENTITY_TYPES.register(bus);
    }
}
