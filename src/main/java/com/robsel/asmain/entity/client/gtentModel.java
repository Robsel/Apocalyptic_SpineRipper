package com.robsel.asmain.entity.client;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.entity.custom.gtent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class gtentModel extends AnimatedGeoModel<gtent> {
    @Override
    public ResourceLocation getModelLocation(gtent object) {
        return new ResourceLocation(ASMain.MOD_ID, "geo/gtent.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(gtent object) {
        return new ResourceLocation(ASMain.MOD_ID, "textures/entity/gtent.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(gtent animatable) {
        return new ResourceLocation(ASMain.MOD_ID, "animations/gtent.animation.json");
    }
}
