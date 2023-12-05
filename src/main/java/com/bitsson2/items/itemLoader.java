package com.bitsson2.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class itemLoader
{
    public static lightOrb lightorb=new lightOrb();

    public itemLoader()
    {

    }

    public static void regItems()
    {
        ForgeRegistries.ITEMS.register(lightorb);
    }

    public static void regItemModels()
    {
        ModelLoader.setCustomModelResourceLocation(lightorb,0,new ModelResourceLocation(lightorb.getRegistryName(),"inventory"));
    }
}
