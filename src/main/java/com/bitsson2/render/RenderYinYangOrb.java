package com.bitsson2.render;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;

public class RenderYinYangOrb extends RenderSnowball
{

    public RenderYinYangOrb(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn)
    {
        super(renderManagerIn, itemIn, itemRendererIn);
    }
}
