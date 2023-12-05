package com.bitsson2.spellcards;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class lightReflect extends spellCard
{

    public lightReflect()
    {
        super("lightreflect");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(14),20*180));
        return super.onItemRightClick(worldIn,playerIn,handIn);
    }
}
