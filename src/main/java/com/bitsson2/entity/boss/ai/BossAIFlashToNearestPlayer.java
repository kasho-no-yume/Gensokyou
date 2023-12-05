package com.bitsson2.entity.boss.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BossAIFlashToNearestPlayer extends EntityAIBase
{
    private EntityLiving entityIn;

    public BossAIFlashToNearestPlayer(EntityLiving entityIn)
    {
        this.entityIn=entityIn;
    }

    @Override
    public boolean shouldExecute()
    {
        Random r=new Random();
        return  r.nextInt(1000)<=70;
        //return true;
    }

    @Override
    public void updateTask()
    {
        double bx=entityIn.posX;
        double by=entityIn.posY;
        double bz=entityIn.posZ;
        World bossWorld=entityIn.getEntityWorld();
        AxisAlignedBB bossRange=new AxisAlignedBB(bx-30,by-5,bz-30,bx+30,by+5,bz+30);
        List<EntityPlayer> nearPlayerList=bossWorld.getEntitiesWithinAABB(EntityPlayer.class,bossRange);
        if(!nearPlayerList.isEmpty())
        {
            int ran=new Random().nextInt(nearPlayerList.size());
            entityIn.setPosition(nearPlayerList.get(ran).posX+2,nearPlayerList.get(ran).posY+1,nearPlayerList.get(ran).posZ+2);
        }
        super.updateTask();
    }
}
