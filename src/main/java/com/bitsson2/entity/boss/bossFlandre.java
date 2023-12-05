package com.bitsson2.entity.boss;

import com.bitsson2.effect.PotionLoader;
import com.bitsson2.entity.FlandreFour;
import com.bitsson2.entity.boss.ai.BossAIFlashToNearestPlayer;
import com.bitsson2.entity.boss.ai.BossAIFourOfAKind;
import com.bitsson2.entity.boss.ai.BossAIRandomMagicAttack;
import com.bitsson2.entity.boss.ai.EightAngleDanmaku;
import com.bitsson2.point.pointloader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class bossFlandre extends EntityMob
{

    private final BossInfoServer bossInfo;
    private final UUID flandreUUID=UUID.fromString("1d30285b-d016-4224-a2d4-270eb003f629");
    protected final int experienceValue=200;


    public bossFlandre(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6f,1.9f);
        this.bossInfo=new BossInfoServer(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.NOTCHED_20);
        bossInfo.setVisible(true);
        this.addPotionEffect(new PotionEffect(PotionLoader.danmakuProtect,7));
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.applyEntityAI();
    }


    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier)
    {
        this.dropItem(pointloader.brokenstar,1);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Override
    public void onDeath(DamageSource cause)
    {
        this.dropItem(pointloader.star,1);
        double x1,y1,z1,x2,y2,z2;
        x1=this.posX-30;
        x2=this.posX+30;
        y1=this.posY-30;
        y2=this.posY+30;
        z1=this.posZ-30;
        z2=this.posZ+30;
        AxisAlignedBB alignedBB=new AxisAlignedBB(x1,y1,z1,x2,y2,z2);
        List<Entity> all=this.world.getEntitiesWithinAABBExcludingEntity(null,alignedBB);
        for(Entity i:all)
        {
            if(i instanceof FlandreFour)
            {
                i.setDead();
            }
        }
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return super.getExperiencePoints(player);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return null;
    }

    protected void applyEntityAI()
    {
        this.tasks.addTask(3, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new BossAIFlashToNearestPlayer(this));
        this.tasks.addTask(3, new BossAIRandomMagicAttack(this));
        this.tasks.addTask(3, new BossAIFourOfAKind(this));
        this.tasks.addTask(3, new EightAngleDanmaku(this,10));
        //this.tasks.addTask(3, new SixAngleDanmaku(this));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(60);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(500);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(4);

    }

    @Override
    protected void updateAITasks()
    {
        super.updateAITasks();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        if (hasCustomName())
        {
            bossInfo.setName(getDisplayName());
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setString("name","flandre");
        super.writeEntityToNBT(compound);
    }

    @Override
    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
        bossInfo.setName(getDisplayName());
    }

    @Override
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        bossInfo.addPlayer(player);
    }

    @Override
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        bossInfo.removePlayer(player);
    }

}
