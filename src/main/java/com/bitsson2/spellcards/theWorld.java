package com.bitsson2.spellcards;

import com.bitsson2.event.eventLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class theWorld extends spellCard
{
    private static int time=10;
    public theWorld()
    {
        super("theworld");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        eventLoader.start_theworld(time,worldIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
