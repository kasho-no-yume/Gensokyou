package com.bitsson2.tab;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class creativeTabLoader
{
    public static creativeTab gCreativeTab;

    public creativeTabLoader(FMLPreInitializationEvent event)
    {
        gCreativeTab=new creativeTab("gensokyou");
    }
}
