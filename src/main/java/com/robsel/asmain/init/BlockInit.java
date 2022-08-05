package com.robsel.asmain.init;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.block.Cthulu_Lamp;
import com.robsel.asmain.block.Rotatable_Madness;
import com.robsel.asmain.block.Weird_Bone;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.robsel.asmain.init.ItemInit.CONGEALED_CTHULU;


public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ASMain.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    //
    //FUNCTIONAL BLOCKS
    //
    public static final RegistryObject<Block> CTHULU_LAMP = register("cthulu_lamp",
            () -> new Cthulu_Lamp(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_GREEN).strength(0.9f)
                    .sound(SoundType.LANTERN)
                    .lightLevel((state) -> state.getValue(Cthulu_Lamp.CLICKED) ? 15 : 0)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));
    //
    //BLOCKS
    //
    public static final RegistryObject<Block> CONGEALED_CTHULU_BLOCK = register("congealed_cthulu_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_GREEN).strength(0.7f)
                    .sound(SoundType.SLIME_BLOCK).explosionResistance(25000f)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));
    //
    //DIRECTIONAL ORES
    //
    public static final RegistryObject<Block> DH_ORE_CENTER = register(
            "dh_ore_center",
            () -> new Rotatable_Madness(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.COLOR_GREEN).strength(3.0f).sound(SoundType.FUNGUS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> DH_ORE_CORNER = register("dh_ore_corner",
            () -> new Rotatable_Madness(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.FUNGUS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> DH_ORE_SIDE = register("dh_ore_side",
            () -> new Rotatable_Madness(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.FUNGUS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));
    //
    //ORES
    //
    public static final RegistryObject<Block> DH_ORE = register("dh_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.FUNGUS).requiresCorrectToolForDrops(), UniformInt.of(8, 11)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> DH_ORE_PED = register("dh_ore_ped",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.MOSS, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.FUNGUS).requiresCorrectToolForDrops(), UniformInt.of(12, 20)),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> WEIRD_BONE_BLOCK = register("weird_bone_block",
            () -> new Weird_Bone(BlockBehaviour.Properties.of(Material.ICE_SOLID, MaterialColor.COLOR_GREEN).noOcclusion().strength(3.0f)
                    .sound(SoundType.AMETHYST_CLUSTER).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));
    //
    //ALTAR
    //
    public static final RegistryObject<Block> ALTAR_MAIN = register("altar_main",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_FRAME = register("altar_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_TABLET = register("altar_tablet",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_PED = register("altar_ped",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_CRYSTAL = register("altar_crystal",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_SLAB = register("altar_slab",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_FENCE = register("altar_fence",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_SACR = register("altar_sacr",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    public static final RegistryObject<Block> ALTAR_BOOST = register("altar_boost",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(3.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(ASMain.ASMAIN_TAB)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }
    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>,Supplier<? extends Item>> item) {
       RegistryObject<T> obj = registerBlock(name, block);
       ITEMS.register(name, item.apply(obj));
       return obj;
    }
}
