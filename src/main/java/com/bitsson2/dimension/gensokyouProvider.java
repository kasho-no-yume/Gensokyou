package com.bitsson2.dimension;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkGeneratorDebug;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;

import java.util.Random;

public class gensokyouProvider extends WorldProvider
{

    @Override
    public DimensionType getDimensionType()
    {
        return dimensionLoader.GensokyouType;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight) {
        return false;
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        //return new gensokyouGenerator(world);
        Random random=new Random();
        return new ChunkGeneratorOverworld(world,random.nextLong(),true,"");
    }
}
