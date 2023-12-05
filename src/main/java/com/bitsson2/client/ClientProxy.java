package com.bitsson2.client;

import com.bitsson2.common.CommonProxy;
import com.bitsson2.entity.EntityLoader;
import com.bitsson2.items.itemLoader;
import com.bitsson2.spellcards.spellCardLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import com.bitsson2.point.pointloader;


/**
 * @author bitsson
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        pointloader.regPointModel();
        spellCardLoader.regSellCardModel();
        EntityLoader.regRender();
        itemLoader.regItemModels();
        EntityLoader.regEntityEgg();
    }
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}