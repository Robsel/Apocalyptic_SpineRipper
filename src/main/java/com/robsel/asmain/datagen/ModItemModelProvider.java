package com.robsel.asmain.datagen;

import com.robsel.asmain.ASMain;
import com.robsel.asmain.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ASMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ItemInit.GTENT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
