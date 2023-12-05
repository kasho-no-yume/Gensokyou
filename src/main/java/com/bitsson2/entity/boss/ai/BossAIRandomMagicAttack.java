package com.bitsson2.entity.boss.ai;

import com.bitsson2.damageType.danmakuDamage;
import com.bitsson2.effect.MuPower;
import com.bitsson2.effect.PotionLoader;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BossAIRandomMagicAttack extends EntityAIBase
{
    private static int executeTime=1;
    private EntityLiving entityIn;

    public BossAIRandomMagicAttack(EntityLiving entityIn)
    {
        this.entityIn=entityIn;
    }

    @Override
    public boolean shouldExecute()
    {
        executeTime++;
        return executeTime%100==0;
    }

    @Override
    public void startExecuting()
    {
        World bossWorld=entityIn.getEntityWorld();
        double bx=entityIn.posX;
        double by=entityIn.posY;
        double bz=entityIn.posZ;
        AxisAlignedBB bossRange=new AxisAlignedBB(bx-30,by-5,bz-30,bx+30,by+5,bz+30);
        List<EntityPlayer> nearPlayerList=bossWorld.getEntitiesWithinAABB(EntityPlayer.class,bossRange);
        for(EntityPlayer e:nearPlayerList)
        {
            e.attackEntityFrom(new danmakuDamage(),4);
            if(e.getActivePotionEffect(PotionLoader.muPower)!=null)
            {
                int level=e.getActivePotionEffect(PotionLoader.muPower).getAmplifier()+1;
                //e.removeActivePotionEffect(PotionLoader.muPower);
                e.addPotionEffect(new PotionEffect(PotionLoader.muPower,60*20,level));
            }
            else
            {
                e.addPotionEffect(new PotionEffect(PotionLoader.muPower,60*20,0));
            }
        }
    }
}
