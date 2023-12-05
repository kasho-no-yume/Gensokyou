package com.bitsson2.render;

import com.bitsson2.entity.boss.bossFlandre;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;


public class RenderFlandre extends RenderLiving<bossFlandre>
{

    private static final ResourceLocation Texture = new ResourceLocation("gensokyou:textures/bossskin/flandre.png");
    public RenderFlandre(RenderManager rendermanagerIn)
    {
        super(rendermanagerIn,new ModelPlayer(1,true), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(bossFlandre entity)
    {
        return Texture;
    }
}
