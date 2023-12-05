package com.bitsson2.damageType;

import net.minecraft.util.DamageSource;

public class danmakuDamage extends DamageSource
{

    public danmakuDamage()
    {
        super("player");
        this.damageType="danmaku";
        this.setDamageBypassesArmor();

    }


}
