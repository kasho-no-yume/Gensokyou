package com.bitsson2.spellcards;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class spellCardLoader
{
    public static lightReflect lightreflect=new lightReflect();
    public static musouFuuin musoufuuin=new musouFuuin();
    //public static theWorld theworld=new theWorld();

    public static void regSpellCardItem()
    {
        ForgeRegistries.ITEMS.register(lightreflect);
        ForgeRegistries.ITEMS.register(musoufuuin);
        //ForgeRegistries.ITEMS.register(theworld);
    }

    public static void regSellCardModel()
    {
        ModelLoader.setCustomModelResourceLocation(lightreflect,0,new ModelResourceLocation(lightreflect.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(musoufuuin,0,new ModelResourceLocation(musoufuuin.getRegistryName(),"inventory"));
        //ModelLoader.setCustomModelResourceLocation(theworld,0,new ModelResourceLocation(theworld.getRegistryName(),"inventory"));
    }

}
