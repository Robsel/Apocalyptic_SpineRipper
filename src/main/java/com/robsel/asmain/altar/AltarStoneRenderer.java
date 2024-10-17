package com.robsel.asmain.altar;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.robsel.asmain.init.BlockEntitiesInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.*;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;

public class AltarStoneRenderer implements BlockEntityRenderer<AltarStoneEntity> {
    public AltarStoneRenderer(BlockEntityRendererProvider.Context context) {
        // Constructor for the renderer
    }

    @Override
    public void render(AltarStoneEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
        // Path to your .obj model
        ResourceLocation objModelLocation = new ResourceLocation("asmain", "models/block/Altar_Stone_Inscribed.obj");

        BlockRenderDispatcher blockRenderDispatcher = Minecraft.getInstance().getBlockRenderer();
        BakedModel bakedModel = blockRenderDispatcher.getBlockModelShaper().getModelManager().getModel(new ResourceLocation("asmain", "block/Altar_Stone_Inscribed.obj"));

        if (bakedModel != null) {
            poseStack.pushPose();

            // Adjust position and scale
            poseStack.translate(0.5D, 0.5D, 0.5D);
            poseStack.scale(1.0F, 1.0F, 1.0F);

            // Render the model
            blockRenderDispatcher.getModelRenderer().renderModel(poseStack.last(), bufferSource.getBuffer(RenderType.solid()), null, bakedModel, 1.0F, 1.0F, 1.0F, combinedLight, OverlayTexture.RED_OVERLAY_V);

            poseStack.popPose();
        }
    }


}

