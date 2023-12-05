package com.bitsson2.gensokyou;

import com.bitsson2.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


/**
 * @author bitsson
 */
@Mod(modid = gensokyou.MODID, name = gensokyou.NAME, version = gensokyou.VERSION, acceptedMinecraftVersions = "1.12.2")
public class gensokyou
{
    public static final String MODID = "gensokyou";
    public static final String NAME = "Gensokyou-lotus land story";
    public static final String VERSION = "1.0.0";

    @Instance(gensokyou.MODID)
    public static gensokyou instance;

    @SidedProxy(clientSide = "com.bitsson2.client.ClientProxy",
            serverSide = "com.bitsson2.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        // TODO
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // TODO
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // TODO
    }
}