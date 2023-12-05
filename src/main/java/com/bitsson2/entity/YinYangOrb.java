package com.bitsson2.entity;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class YinYangOrb extends Entity
{

    public YinYangOrb(World worldIn)
    {
        super(worldIn);
        this.setSize(1,1);
    }

    @Override
    protected void entityInit()
    {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }


}
