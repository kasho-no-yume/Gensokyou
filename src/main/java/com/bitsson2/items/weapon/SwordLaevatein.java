package com.bitsson2.items.weapon;

import com.sun.javafx.geom.Vec3f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import com.bitsson2.tab.creativeTabLoader;
import net.minecraft.world.WorldServer;

public class SwordLaevatein extends ItemSword
{
    public SwordLaevatein()
    {
        super(ToolMaterial.DIAMOND);
        this.setRegistryName("gensokyou:swordlaevatein");
        this.setUnlocalizedName("swordLaevatein");
        this.setCreativeTab(creativeTabLoader.gCreativeTab);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if(!(attacker instanceof EntityPlayer))
        {
            return false;
        }
        target.attackEntityFrom(new EntityDamageSource("inFire",attacker),40);
        World world = target.getEntityWorld();
        AxisAlignedBB targetRange = new AxisAlignedBB(target.posX - 3, target.posY - 1, target.posZ - 3, target.posX + 3, target.posY + 1, target.posZ + 3);
        for(Entity e: world.getEntitiesWithinAABBExcludingEntity(null, targetRange))
        {
            if(e != attacker)
            {
                e.attackEntityFrom(new EntityDamageSource("inFire",attacker),20);
            }
        }
        WorldServer worldServer = (WorldServer)world;
        worldServer.spawnParticle(EnumParticleTypes.FLAME, target.posX, target.posY, target.posZ, 3000,0,0,0,0.1);
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        AxisAlignedBB targetRange = new AxisAlignedBB(playerIn.posX - 3, playerIn.posY - 1, playerIn.posZ - 3, playerIn.posX + 3, playerIn.posY + 1, playerIn.posZ + 3);
        Vec3d v3d = Vec3d.fromPitchYawVector(playerIn.getPitchYaw());
        for (Entity e : worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, targetRange))
        {
            if(e == playerIn)
            {
                continue;
            }
            Vec3d distance = e.getPositionVector().subtract(new Vec3d(playerIn.posX, playerIn.posY, playerIn.posZ));
            if(distance.lengthVector() <= 5 && distance.dotProduct(v3d) > 0)
            {
                e.attackEntityFrom(new EntityDamageSource("inFire",playerIn),20);
            }
        }
        try
        {
            WorldServer worldServer = playerIn.getServer().getWorld(playerIn.dimension);
            worldServer.spawnParticle(EnumParticleTypes.FLAME, playerIn.posX, playerIn.posY, playerIn.posZ, 3000, 0, 0, 0, 0.1);
        }
        catch (Exception e)
        {

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
