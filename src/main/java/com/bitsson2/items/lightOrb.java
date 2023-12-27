package com.bitsson2.items;

import com.bitsson2.entity.ThrowableYinYangOrb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class lightOrb extends Item
{
    public lightOrb()
    {
        this.setRegistryName("gensokyou:lightorb");
        this.setUnlocalizedName("lightOrb");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (!worldIn.isRemote)
        {
            EntityThrowable tyyo=new ThrowableYinYangOrb(worldIn, playerIn);
            tyyo.shoot(playerIn,playerIn.rotationPitch,playerIn.rotationYaw,0.5f,0.5f,1);

            worldIn.spawnEntity(tyyo);
            System.out.println("throw!");
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
