package com.bitsson2.entity.boss.ai;

import com.bitsson2.entity.FlandreFour;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class BossAIFourOfAKind extends EntityAIBase
{
    private int executeTime=1;
    private EntityLiving entityIn;

    public BossAIFourOfAKind(EntityLiving entityLiving)
    {
        this.entityIn=entityLiving;
    }

    @Override
    public boolean shouldExecute()
    {
        executeTime++;
        return executeTime%300==0;
    }

    @Override
    public void startExecuting()
    {
        double bx=entityIn.posX;
        double by=entityIn.posY;
        double bz=entityIn.posZ;
        World bossWorld=entityIn.getEntityWorld();
        Entity FlandreOne=new FlandreFour(bossWorld);
        Entity FlandreTwo=new FlandreFour(bossWorld);
        Entity FlandreThree=new FlandreFour(bossWorld);
        FlandreOne.setPosition(bx+1,by,bz);
        FlandreTwo.setPosition(bx-1,by,bz);
        FlandreThree.setPosition(bx,by,bz+1);
        bossWorld.spawnEntity(FlandreOne);
        bossWorld.spawnEntity(FlandreTwo);
        bossWorld.spawnEntity(FlandreThree);
    }
}
