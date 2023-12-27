package com.bitsson2.items;

import com.bitsson2.items.weapon.SwordLaevatein;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

public class itemLoader
{
    public static lightOrb lightorb=new lightOrb();
    private  static SwordLaevatein swordLaevatein = new SwordLaevatein();

    public itemLoader()
    {

    }

    public static void regItems()
    {
        ForgeRegistries.ITEMS.register(lightorb);
        ForgeRegistries.ITEMS.register(swordLaevatein);
    }

    public static void regItemModels()
    {
        ModelLoader.setCustomModelResourceLocation(lightorb,0,new ModelResourceLocation(lightorb.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(swordLaevatein,0,new ModelResourceLocation(swordLaevatein.getRegistryName(),"inventory"));
    }
}
