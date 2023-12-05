package com.bitsson2.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class dimensionLoader
{
    public static String name="gensokyou";
    public static int ID=999;
    public static DimensionType GensokyouType=DimensionType.register("Gensokyou","_gensokyou",999,gensokyouProvider.class,true);

    public static void regDimension()
    {
        DimensionManager.registerDimension(ID,GensokyouType);
    }

}
