package com.bitsson2.common;

import com.bitsson2.dimension.dimensionLoader;
import com.bitsson2.effect.PotionLoader;
import com.bitsson2.entity.EntityLoader;
import com.bitsson2.event.eventLoader;
import com.bitsson2.items.itemLoader;
import com.bitsson2.spellcards.spellCardLoader;
import com.bitsson2.tab.creativeTabLoader;
import com.bitsson2.point.pointloader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


/**
 * @author bitsson
 */
public class CommonProxy {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        new creativeTabLoader(event);
        pointloader.regPointItem();
        spellCardLoader.regSpellCardItem();
        dimensionLoader.regDimension();
        new eventLoader();
        EntityLoader.regEntity();
        itemLoader.regItems();
        PotionLoader.PotionRegistr();
        // TODO
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // TODO
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // TODO
    }
}