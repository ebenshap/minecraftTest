package com.myCode.customEntity.init;

import com.myCode.customEntity.handlers.EnumHandler;
import com.myCode.customEntity.items.ItemChip;
import com.myCode.customEntity.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModItems {

    public static Item chip;

    public static void init() {
        chip = new ItemChip("chip");
    }

    public static void register() {
        registerItem(chip);
    }

    public static void registerRenders(){
        for( int i =0; i < EnumHandler.ChipTypes.values().length; i++ ) {
            registerRender(chip, i, "chip_" + EnumHandler
                    .ChipTypes.values()[i].getName());
        }

    }

    public static void registerItem(Item item) {
        item.setCreativeTab( CreativeTabs.MATERIALS);
        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerRender(Item item) {

    }

    public static void registerRender(Item item, int meta, String fileName){
        ModelLoader.setCustomModelResourceLocation( item, meta,
                new ModelResourceLocation( new ResourceLocation (Reference.MOD_ID, fileName), "inventory"));
    }
}
