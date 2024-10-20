package com.robsel.asmain.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.robsel.asmain.ASMain;
import com.robsel.asmain.entity.custom.GTentEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GTentRenderer extends MobRenderer<GTentEntity, GTentModel<GTentEntity>> {
    public GTentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new GTentModel<>(pContext.bakeLayer(ModModelLayers.GTENT_LAYER)),1f);
    }

    @Override
    public ResourceLocation getTextureLocation(GTentEntity pEntity) {
        return new ResourceLocation(ASMain.MOD_ID, "textures/entity/gtent.png");
    }

    @Override
    public void render(GTentEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
