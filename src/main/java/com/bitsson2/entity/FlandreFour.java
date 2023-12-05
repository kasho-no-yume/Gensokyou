package com.bitsson2.entity;

import com.bitsson2.point.pointloader;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FlandreFour extends EntitySpider
{
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntitySpider.class, DataSerializers.BYTE);


    public FlandreFour(World worldIn)
    {
        super(worldIn);
        this.setSize(0.6f,1.9f);
        //this.setCustomNameTag("fakeFlandre");
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
    }


    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new FlandreFour.AISpiderAttack(this));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new FlandreFour.AISpiderTarget(this, EntityPlayer.class));
    }

    @Override
    public void onDeath(DamageSource cause)
    {

    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier)
    {

    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6f);

    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
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

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {

    }

    static class AISpiderAttack extends EntityAIAttackMelee
    {
        public AISpiderAttack(EntitySpider spider)
        {
            super(spider, 1.0D, true);
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        @Override
        public boolean shouldContinueExecuting()
        {
            return super.shouldContinueExecuting();
        }

        @Override
        protected double getAttackReachSqr(EntityLivingBase attackTarget)
        {
            return (double)(10.0F + attackTarget.width);
        }
    }

    static class AISpiderTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
    {
        public AISpiderTarget(EntitySpider spider, Class<T> classTarget)
        {
            super(spider, classTarget, false);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        @Override
        public boolean shouldExecute()
        {
            return super.shouldExecute();
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
    }
}
