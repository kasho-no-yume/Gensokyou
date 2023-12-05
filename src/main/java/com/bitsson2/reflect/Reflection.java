package com.bitsson2.reflect;


import java.lang.reflect.Method;
import java.util.UUID;

public class Reflection
{
    private Reflection()
    {

    }
    public static void main(String[] args) throws Exception
    {
        try
        {
            /*Class cls=Class.forName("net.minecraft.entity.projectile.EntityArrow");
            Method[] mcls=cls.getDeclaredMethods();
            for(Method m:mcls)
            {
                System.out.println(m);
            }*/
            System.out.println(UUID.randomUUID());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
