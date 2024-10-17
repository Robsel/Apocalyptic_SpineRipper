package com.robsel.asmain.event;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.init.BlockInit;
import com.robsel.asmain.init.ItemInit;
import com.robsel.asmain.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ScreenOpenEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import com.robsel.asmain.block.Altar_Stone;
import com.robsel.asmain.init.ItemInit;
import com.robsel.asmain.altar.AltarStoneInscribed;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;


import java.util.List;

@Mod.EventBusSubscriber(modid = ASMain.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack heldItem = event.getItemStack();
        Level world = event.getWorld();
        BlockPos clickedPos = event.getPos();
        BlockState clickedBlockState = world.getBlockState(clickedPos);  // Get the block at the clicked position

        // Check if player is holding the Weird Bone
        if (heldItem.is(ItemInit.WEIRD_BONE.get())) {
            // Check if the clicked block is ALTAR_MAIN
            if (clickedBlockState.getBlock() == BlockInit.ALTAR_MAIN.get()) {
                // 3x5 multiblock structure
             AltarStoneInscribed.tryForm(world, clickedPos);




            }
        }
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.CULTIST.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ItemInit.TENTACLEONASTICK.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    stack,4,5,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 27),
                    stack,4,5,0.09F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 35),
                    stack,4,5,0.09F));

            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack,4,5,0.09F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    stack,4,5,0.09F));

        }
    }
}