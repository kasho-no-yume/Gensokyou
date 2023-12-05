package com.bitsson2.spellcards;

import com.bitsson2.tab.creativeTabLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class spellCard extends Item
{
    public spellCard(String name)
    {
        super();
        this.setUnlocalizedName(name);
        this.setCreativeTab(creativeTabLoader.gCreativeTab);
        this.setMaxStackSize(1);
        this.setRegistryName("gensokyou:"+name);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.getHeldItem(handIn).shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
