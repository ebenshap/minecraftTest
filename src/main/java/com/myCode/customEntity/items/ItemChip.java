package com.myCode.customEntity.items;

import com.myCode.customEntity.handlers.EnumHandler;
import com.myCode.customEntity.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class ItemChip extends Item {

    public ItemChip(String unlocalizedName) {
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
        this.setHasSubtypes(true);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        for(int i =0; i < EnumHandler.ChipTypes.values().length; i++) {
            items.add(new ItemStack(this,1, i ));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        for(int i = 0; i < EnumHandler.ChipTypes.values().length; i++) {
            System.out.println("does this iterator happen? stack");
            System.out.println(stack);
            if(stack.getItemDamage() == i) {
                System.out.println("Does the damagething happen?");
                return this.getUnlocalizedName() + "." + EnumHandler.ChipTypes.values()[i].getName();
            }
            else {
                continue;
            }
        }

        return this.getUnlocalizedName() + "." + EnumHandler.ChipTypes.BASIC.getName();
    }
}
