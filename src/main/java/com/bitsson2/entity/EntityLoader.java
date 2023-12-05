package com.bitsson2.entity;

import com.bitsson2.entity.boss.bossFlandre;
import com.bitsson2.gensokyou.gensokyou;
import com.bitsson2.items.itemLoader;
import com.bitsson2.render.RenderFakeFlandre;
import com.bitsson2.render.RenderFlandre;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLoader
{
    public EntityLoader()
    {

    }


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void regRender()
    {
        RenderingRegistry.registerEntityRenderingHandler(YinYangOrb.class, manager -> new RenderSnowball<YinYangOrb>
                (manager, itemLoader.lightorb, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(bossFlandre.class,manager -> new RenderFlandre(manager));
        RenderingRegistry.registerEntityRenderingHandler(FlandreFour.class,manager -> new RenderFakeFlandre(manager));
        RenderingRegistry.registerEntityRenderingHandler(ThrowableYinYangOrb.class, manager -> new RenderSnowball<ThrowableYinYangOrb>
                (manager, itemLoader.lightorb, Minecraft.getMinecraft().getRenderItem()));

    }

    public static void regEntity()
    {
        EntityRegistry.registerModEntity(new ResourceLocation("gensokyou","yinyangorb"),YinYangOrb.class, "YinYangOrb",1000,gensokyou.instance, 80,
                1, true);
        EntityRegistry.registerModEntity(new ResourceLocation("gensokyou","flandre"), bossFlandre.class,"FlandreScarlet",1001,
                gensokyou.instance,80,1,true);
        EntityRegistry.registerModEntity(new ResourceLocation("gensokyou","flandre"), FlandreFour.class,"FakeFlandreScarlet",999,
                gensokyou.instance,80,1,true);
        EntityRegistry.registerModEntity(new ResourceLocation("gensokyou","yinyangorb"), ThrowableYinYangOrb.class,"ThrowableYingYangOrb",
                1002,gensokyou.instance,80,1,true);
    }

    public static void regEntityEgg()
    {
        EntityRegistry.registerEgg(new ResourceLocation("gensokyou","flandre"),0x666666,0xFFFFFF);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityFactory<T>(render));
    }
}
