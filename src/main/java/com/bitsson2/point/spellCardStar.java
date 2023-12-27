package com.bitsson2.point;

import com.bitsson2.tab.creativeTabLoader;
import net.minecraft.item.Item;

public class spellCardStar extends Item
{
    public spellCardStar()
    {
        super();
        this.setUnlocalizedName("spellcardstar");
        this.setRegistryName("gensokyou:spellcardstar");
        this.setCreativeTab(creativeTabLoader.gCreativeTab);
    }
}
