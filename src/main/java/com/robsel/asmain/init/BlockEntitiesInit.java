package com.robsel.asmain.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.robsel.asmain.ASMain;
import com.robsel.asmain.blockentity.AltarStoneEntity;

public class BlockEntitiesInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ASMain.MOD_ID);

    // Register the BlockEntity for the Multiblock Controller
    public static final RegistryObject<BlockEntityType<AltarStoneEntity>> ALTAR_STONE_ENTITY = BLOCK_ENTITIES.register(
            "altar_stone_entity",
            () -> BlockEntityType.Builder.of(AltarStoneEntity::new, BlockInit.ALTAR_STONE_CONTROLLER.get()).build(null)
    );
}
