package com.robsel.asmain.init;

import com.robsel.asmain.ASMain;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ASMain.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ASMAIN_TAB = CREATIVE_MODE_TABS.register("asmain_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.CONGEALED_CTHULU.get()))
                    .title(Component.translatable("creativetab.asmain_tab"))
                    .displayItems((displayParameters, output) -> {

                        //ITEMS
                        output.accept(ItemInit.CONGEALED_CTHULU.get());
                        output.accept(ItemInit.WEIRD_BONE.get());
                        output.accept(ItemInit.TENTACLEONASTICK.get());
                        output.accept((ItemInit.GTENT_SPAWN_EGG.get()));

                        //BLOCKS

                        //FUNCTIONAL
                        output.accept(BlockInit.CTHULU_LAMP.get());
                        output.accept(BlockInit.CULTIST_WORKSTATION.get());

                        //BUILDING
                        output.accept(BlockInit.CONGEALED_CTHULU_BLOCK.get());
                        output.accept(BlockInit.DARK_GATE.get());
                        output.accept(BlockInit.DARK_WALL.get());
                        output.accept(BlockInit.ENERGY_CRYSTAL.get());

                        //ALTAR
                        output.accept(BlockInit.ALTAR_FRAME.get());
                        output.accept(BlockInit.ALTAR_BOOST.get());
                        output.accept(BlockInit.ALTAR_MAIN.get());
                        output.accept(BlockInit.ALTAR_SLAB.get());
                        output.accept(BlockInit.ALTAR_PED.get());
                        output.accept(BlockInit.ALTAR_STONE_CONTROLLER.get());
                        output.accept(BlockInit.ALTAR_TABLET.get());
                        output.accept(BlockInit.ALTAR_SACR.get());

                        //ORE+BONE
                        output.accept(BlockInit.DH_ORE.get());
                        output.accept(BlockInit.DH_ORE_PED.get());
                        output.accept(BlockInit.DH_ORE_CENTER.get());
                        output.accept(BlockInit.DH_ORE_SIDE.get());
                        output.accept(BlockInit.DH_ORE_CORNER.get());
                        output.accept(BlockInit.WEIRD_BONE_BLOCK.get());


                    })
                    .build());
    public static void register(IEventBus bus){
        CREATIVE_MODE_TABS.register(bus);
    }
}
