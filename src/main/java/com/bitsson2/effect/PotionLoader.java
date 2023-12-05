package com.bitsson2.effect;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class PotionLoader
{
    public static Potion muPower=new MuPower();
    public static Potion danmakuProtect=new DanmakuProtect();

    //@SubscribeEvent
    public static void PotionRegistr()
    {
        //event.getRegistry().register(new MuPower().setRegistryName("gensokyou", "mupower"));
        ForgeRegistries.POTIONS.register(muPower);
        ForgeRegistries.POTIONS.register(danmakuProtect);
    }


}
