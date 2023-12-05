package com.bitsson2.tab;

import net.minecraft.creativetab.CreativeTabs;
import com.bitsson2.point.pointloader;
import net.minecraft.item.ItemStack;

public class creativeTab extends CreativeTabs
{

    public creativeTab(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(pointloader.p_point);
    }
}
