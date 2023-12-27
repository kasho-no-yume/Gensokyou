package com.bitsson2.event;

import com.bitsson2.damageType.danmakuDamage;
import com.bitsson2.effect.PotionLoader;
import com.bitsson2.entity.YinYangOrb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.*;

public class eventLoader
{
    private static class timeData
    {
        public int time;
        public EntityPlayer player;
        public World currentWorld;
        public timeData(int t,EntityPlayer p,World w)
        {
            time=t;
            player=p;
            currentWorld=w;
        }
        public Entity[] queue_yinYangOrb=new Entity[6];
    }
    private static List<timeData> data_musoufuuin=new ArrayList<timeData>();
    private static int time_theworld=0;
    private static float damageAmount=10;
    private static double range=4;
    private static boolean isWorldStop=false;

    //the function start musou fuuin

    public static void start_musoufuuin(double x,double y,double z,int time,EntityPlayer playerIn,World worldIn)
    {
        if(!worldIn.isRemote)
        {
            System.out.println("spawn yinyangorb");
            timeData tData = new timeData(20 * time, playerIn, worldIn);
            for (int i = 0; i < 6; i++)
            {
                tData.queue_yinYangOrb[i] = new YinYangOrb(worldIn);
                tData.queue_yinYangOrb[i].setNoGravity(true);
                worldIn.spawnEntity(tData.queue_yinYangOrb[i]);
            }
            data_musoufuuin.add(tData);
        }
    }

    public static void start_theworld(int time,World world)
    {
        time_theworld+=20*time;
        world.tickUpdates(false);
        isWorldStop=true;
        System.out.println("幻世-世界!");
    }

    public eventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void musouFuuinEvent(TickEvent.PlayerTickEvent pevent)
    {
        //musou fuuin function implement
        if(!data_musoufuuin.isEmpty()&&pevent.player.isServerWorld())
        {
            Iterator<timeData> iterator=data_musoufuuin.iterator();
            while(iterator.hasNext())
            {
                timeData userData = iterator.next();
                if (userData.player == pevent.player)
                {
                    double px = userData.player.posX;
                    double py = userData.player.posY;
                    double pz = userData.player.posZ;
                    World world = userData.player.getEntityWorld();
                    AxisAlignedBB playerRange = new AxisAlignedBB(px - range, py - range, pz - range, px + range, py + range, pz + range);
                    List<Entity> allEntity = world.getEntitiesWithinAABBExcludingEntity(null, playerRange);
                    for (Entity e : allEntity)
                    {
                        if (e instanceof EntityMob || e instanceof EntityGhast)
                        {
                            e.attackEntityFrom(new EntityDamageSource("danmaku", userData.player), EntityLivingBase.class.cast(e).getMaxHealth() / 2>20?20:EntityLivingBase.class.cast(e).getMaxHealth() / 2);
                        }
                        else if (!(e instanceof EntityLivingBase) && !(e instanceof Entity))
                        {
                            e.setDead();
                        }
                    }
                    for (int i = 0; i < 6; i++)
                    {
                        if (!world.isRemote)
                        {
                            System.out.println("change position");
                            double vec = userData.time * Math.PI / 30;
                            userData.queue_yinYangOrb[i].posX = px + (2 * Math.sin(Math.PI / 3 * i + vec));
                            userData.queue_yinYangOrb[i].posY = py + 1;
                            userData.queue_yinYangOrb[i].posZ = pz + (2 * Math.cos(Math.PI / 3 * i + vec));
                        }

                    }
                    userData.time--;
                    if (userData.time <= 0)
                    {
                        iterator.remove();
                        for (int i = 0; i < 6; i++)
                        {
                            double[] dx = new double[6];
                            double[] dy = new double[6];
                            double[] dz = new double[6];
                            if (!world.isRemote)
                            {
                                dx[i] = userData.queue_yinYangOrb[i].posX;
                                dy[i] = userData.queue_yinYangOrb[i].posY;
                                dz[i] = userData.queue_yinYangOrb[i].posZ;

                                userData.queue_yinYangOrb[i].setDead();
                            }
                        }
                    }
                }

            }
        }
    }

    @SubscribeEvent
    public void EntityIsAttacked(LivingHurtEvent event)
    {
        EntityLivingBase e=event.getEntityLiving();
        //System.out.println(e.serializeNBT().toString());
        //目力伤害
        if (event.getSource().damageType.equals("danmaku"))
        {
            //System.out.println("being attacked by danmaku");
            PotionEffect effect = e.getActivePotionEffect(PotionLoader.muPower);
            if (effect != null)
            {
                //System.out.println("being attacked by danmaku with potion effect");
                event.setAmount(event.getAmount()*(3+effect.getAmplifier())/2);
            }
            effect=e.getActivePotionEffect(PotionLoader.danmakuProtect);
            if(effect !=null)
            {
                if(effect.getAmplifier()<10)
                {
                    event.setAmount(event.getAmount()*(9-effect.getAmplifier())/10);
                }
                else
                {
                    event.setAmount(0);
                }
            }

        }
    }

    /*failed the world

    @SubscribeEvent
    public void debugFunc(LivingAttackEvent event)
    {
        if(event.getSource().getDamageType().equals("mob")&&time_theworld>=0)
        {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void theWorldEvent(TickEvent.WorldTickEvent event)
    {
        if(time_theworld>=0)
        {
            if (!event.world.isRemote)
            {
                    time_theworld--;
                    List<Entity> allEntity = event.world.loadedEntityList;
                    for (Entity e : allEntity)
                    {
                        if (!(e instanceof EntityLivingBase))
                        {
                            e.setNoGravity(true);
                            e.motionX=0;
                            e.motionZ=0;
                            e.motionY=0;
                            if(e instanceof EntityArrow)
                            {
                                if(!(EntityArrow.class.cast(e).shootingEntity instanceof EntityPlayer))
                                {
                                    e.setDead();
                                }
                            }
                        }
                        else
                        {
                            if (!(e instanceof EntityPlayer))
                            {
                                e.setNoGravity(true);
                                e.motionX=0;
                                e.motionZ=0;
                                e.motionY=0;
                                EntityLivingBase.class.cast(e).addPotionEffect(new PotionEffect(Potion.getPotionById(2), 2, 10));
                            }
                        }
                    }
            }
            isWorldStop=true;
        }
        else if(time_theworld<0&&isWorldStop)
        {
            event.world.tickUpdates(true);
            isWorldStop=false;
            if(!event.world.isRemote)
            {
                List<Entity> allEntity = event.world.loadedEntityList;
                for (Entity e : allEntity)
                {
                    e.setNoGravity(false);
                }
            }

        }
    }*/

}
