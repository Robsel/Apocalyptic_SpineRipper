package com.robsel.asmain;

import com.robsel.asmain.blockentity.AltarStoneRenderer;
import com.robsel.asmain.init.EntityTypesInit;
import com.robsel.asmain.entity.client.gtentRenderer;
import com.robsel.asmain.init.BlockEntitiesInit;
import com.robsel.asmain.init.BlockInit;
import com.robsel.asmain.init.ItemInit;
import com.robsel.asmain.villager.ModVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod("asmain")
public class ASMain {

    public static final String MOD_ID = "asmain";

    public static final CreativeModeTab ASMAIN_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.CONGEALED_CTHULU.get());
        }
    };

    public ASMain() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLib.initialize();
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockEntitiesInit.BLOCK_ENTITIES.register(bus);
        EntityTypesInit.register(bus);
        ModVillagers.register(bus);
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() ->{
            BlockEntityRenderers.register(BlockEntitiesInit.ALTAR_STONE_ENTITY.get(), AltarStoneRenderer::new);
            ItemBlockRenderTypes.setRenderLayer(BlockInit.CONGEALED_CTHULU_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockInit.CTHULU_LAMP.get(), RenderType.translucent());
            ModVillagers.registerPOIs();
            EntityRenderers.register(EntityTypesInit.GTENT.get(), gtentRenderer::new);
        });

    }

}
