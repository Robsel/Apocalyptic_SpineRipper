package com.robsel.asmain.init;

import com.robsel.asmain.ASMain;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ASMain.MOD_ID);

    public static final RegistryObject<Item> CONGEALED_CTHULU = register("congealed_cthulu",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WEIRD_BONE = register("weird_bone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TENTACLEONASTICK = register("tentacleonastick",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GTENT_SPAWN_EGG = register("gtent_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.GTENT, 0x05ab36,0xd8a900,
                    new Item.Properties()));


    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
