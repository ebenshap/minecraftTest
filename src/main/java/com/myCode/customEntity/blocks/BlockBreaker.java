package com.myCode.customEntity.blocks;

import com.myCode.customEntity.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockBreaker extends Block {

    public BlockBreaker(String unlocalizedName) {
        super(Material.IRON);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
    }
}
