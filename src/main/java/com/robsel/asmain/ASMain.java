package com.robsel.asmain;

import com.robsel.asmain.blockentity.AltarStoneRenderer;
import com.robsel.asmain.entity.client.GTentRenderer;
import com.robsel.asmain.init.*;
import com.robsel.asmain.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.GeckoLib;

@Mod("asmain")
public class ASMain {

    public static final String MOD_ID = "asmain";

    private static final Logger LOGGER = LogManager.getLogger();

    public ASMain() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(bus);

        GeckoLib.initialize();
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntitiesInit.BLOCK_ENTITIES.register(bus);
        EntityInit.ENTITY_TYPES.register(bus);
        ModVillagers.register(bus);
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }



    @OnlyIn(Dist.CLIENT)
    public void onInitializeClient(FMLClientSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() ->{
            BlockEntityRenderers.register(BlockEntitiesInit.ALTAR_STONE_ENTITY.get(), AltarStoneRenderer::new);
            ItemBlockRenderTypes.setRenderLayer(BlockInit.CONGEALED_CTHULU_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockInit.CTHULU_LAMP.get(), RenderType.translucent());
            EntityRenderers.register(EntityInit.GTENT.get(), GTentRenderer::new);
        });

    }

}
