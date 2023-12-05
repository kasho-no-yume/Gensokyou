package com.bitsson2.entity.boss.ai;

import com.bitsson2.entity.ThrowableYinYangOrb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EightAngleDanmaku extends EntityAIBase
{
    private EntityLiving entityLiving;
    private int damage;
    private int time=1;
    public EightAngleDanmaku(EntityLiving entityLiving,int damage)
    {
        this.entityLiving=entityLiving;
        this.damage=damage;
    }

    @Override
    public boolean shouldExecute()
    {
        time++;
        if(time%10==0)
        {
            return true;
        }
        return false;
    }

    @Override
    public void startExecuting()
    {
        System.out.println("shoot");
        for(int i=0;i<8;i++)
        {
            ThrowableYinYangOrb tyyo=new ThrowableYinYangOrb(entityLiving.world,entityLiving);
            tyyo.shoot(Math.cos(Math.PI/4*i),0,Math.sin(Math.PI/4*i),0.5f,1);
            tyyo.setDamage(damage);
            entityLiving.world.spawnEntity(tyyo);
        }
    }
}
