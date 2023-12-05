package com.bitsson2.spellcards;

import com.bitsson2.entity.YinYangOrb;
import com.bitsson2.event.eventLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class musouFuuin extends spellCard
{

    public static int time=0;
    public static int seconds=10;
    public static double dis=3;

    public musouFuuin()
    {
        super("musoufuuin");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {

        double px=playerIn.posX;
        double py=playerIn.posY;
        double pz=playerIn.posZ;
        eventLoader.start_musoufuuin(px,py,pz,seconds,playerIn,worldIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}
