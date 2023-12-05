package com.bitsson2.point;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class pointloader
{
    public static ppoint p_point=new ppoint();
    public static bpoint b_point=new bpoint();
    public static brokenSpellCardStar brokenstar=new brokenSpellCardStar();
    public static spellCardStar star=new spellCardStar();

    public static void regPointItem()
    {
        p_point.setRegistryName("gensokyou:ppoint");
        b_point.setRegistryName("gensokyou:bpoint");
        brokenstar.setRegistryName("gensokyou:brokenspellcardstar");
        star.setRegistryName("gensokyou:spellcardstar");
        ForgeRegistries.ITEMS.register(p_point);
        ForgeRegistries.ITEMS.register(b_point);
        ForgeRegistries.ITEMS.register(brokenstar);
        ForgeRegistries.ITEMS.register(star);
    }

    public static void regPointModel()
    {
        ModelLoader.setCustomModelResourceLocation(p_point,0,new ModelResourceLocation(p_point.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(b_point,0,new ModelResourceLocation(b_point.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(brokenstar,0,new ModelResourceLocation(brokenstar.getRegistryName(),"inventory"));
        ModelLoader.setCustomModelResourceLocation(star,0,new ModelResourceLocation(star.getRegistryName(),"inventory"));
    }

}
