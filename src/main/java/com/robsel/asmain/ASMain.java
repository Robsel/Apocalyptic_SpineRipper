package com.robsel.asmain;

import com.robsel.asmain.blockentity.AltarStoneRenderer;
import com.robsel.asmain.init.BlockEntitiesInit;
import com.robsel.asmain.init.BlockInit;
import com.robsel.asmain.init.ItemInit;
import com.robsel.asmain.init.ModCreativeModeTabs;
import com.robsel.asmain.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
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
        //ModVillagers.register(bus);
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
            //ModVillagers.registerPOIs();
        });

    }

}
