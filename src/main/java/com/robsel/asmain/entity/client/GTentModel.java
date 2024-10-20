package com.robsel.asmain.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.robsel.asmain.entity.animations.ModAnimationDefinitions;
import com.robsel.asmain.entity.custom.GTentEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class GTentModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "gtentmodel"), "main");
	private final ModelPart gtent;
	private final ModelPart foot;
	private final ModelPart lowerbody;
	private final ModelPart body;
	private final ModelPart head;

	public GTentModel(ModelPart root) {
		this.gtent = root.getChild("gtent");
		this.foot = this.gtent.getChild("foot");
		this.lowerbody = this.gtent.getChild("lowerbody");
		this.body = this.gtent.getChild("body");
		this.head = this.gtent.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gtent = partdefinition.addOrReplaceChild("gtent", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition foot = gtent.addOrReplaceChild("foot", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition lowerbody = gtent.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(0, 14).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(40, 24).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 48).addBox(-2.0F, 1.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 0).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 11).addBox(-2.0F, -1.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 48).addBox(1.0F, -1.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition body = gtent.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(40, 19).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 47).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(42, 47).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 8).addBox(-2.0F, -2.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(10, 48).addBox(1.0F, -2.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = gtent.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 30).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(40, 14).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(32, 45).addBox(-2.0F, 1.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(42, 45).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 2).addBox(-2.0F, -1.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(48, 5).addBox(1.0F, -1.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach((ModelPart::resetPose));
		this.applyHeadRotation((GTentEntity) entity,netHeadYaw,headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.GTENT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((GTentEntity) entity).idleAnimationState, ModAnimationDefinitions.GTENT_IDLE, ageInTicks, 1f);
	}



	private void applyHeadRotation(GTentEntity pEntity, float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -30.0F, 30.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI/180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI/180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		gtent.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return gtent;
	}
}