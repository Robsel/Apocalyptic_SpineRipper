package com.robsel.asmain.init;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.entity.ModEntityTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ASMain.MOD_ID);

    public static final RegistryObject<Item> CONGEALED_CTHULU = register("congealed_cthulu",
            () -> new Item(new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Item> WEIRD_BONE = register("weird_bone",
            () -> new Item(new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Item> TENTACLEONASTICK = register("tentacleonastick",
            () -> new Item(new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Item> GTENT_SPAWN_EGG = register("gtent_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.GTENT, 0x42ed2a, 0xf0f614,
                    new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
