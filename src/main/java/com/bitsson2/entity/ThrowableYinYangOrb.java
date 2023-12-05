package com.bitsson2.entity;

import com.bitsson2.damageType.danmakuDamage;
import com.bitsson2.entity.boss.bossFlandre;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ThrowableYinYangOrb extends EntityThrowable
{
    private int damage=4;
    private EntityLivingBase thrower;
    public ThrowableYinYangOrb(World worldIn)
    {
        super(worldIn);
    }

    public ThrowableYinYangOrb(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
        thrower=throwerIn;
    }
    public void setDamage(int d)
    {
        damage=d;
    }
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if(!world.isRemote)
        {
            if(result.typeOfHit== RayTraceResult.Type.ENTITY)
            {
                if(result.entityHit!=thrower)
                {
                    result.entityHit.attackEntityFrom(new EntityDamageSource("danmaku",thrower),damage);
                    this.setDead();
                }
            }
            else if (result.typeOfHit==RayTraceResult.Type.BLOCK)
            {
                this.setDead();
            }
            this.setDead();
        }
        else
        {
            if(result.typeOfHit==RayTraceResult.Type.MISS)
            {
                this.setDead();
            }
        }
    }

    @Override
    public boolean isInWater()
    {
        return false;
    }
    @Override
    public boolean isInLava()
    {
        return false;
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0f;
    }
}
