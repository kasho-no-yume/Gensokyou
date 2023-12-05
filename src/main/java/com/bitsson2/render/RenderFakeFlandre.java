package com.bitsson2.render;

import com.bitsson2.entity.FlandreFour;
import com.bitsson2.entity.boss.bossFlandre;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderFakeFlandre extends RenderLiving<FlandreFour>
{

    private static final ResourceLocation Texture = new ResourceLocation("gensokyou:textures/bossskin/flandre.png");
    public RenderFakeFlandre(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn,new ModelPlayer(1,true), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(FlandreFour entity)
    {
        return Texture;
    }
}
