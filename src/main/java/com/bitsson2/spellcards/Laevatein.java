package com.bitsson2.spellcards;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Laevatein extends spellCard
{

    public Laevatein()
    {
        super("laevatein");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.addItemStackToInventory(null);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
