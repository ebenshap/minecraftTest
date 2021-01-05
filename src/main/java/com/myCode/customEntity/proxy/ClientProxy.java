package com.myCode.customEntity.proxy;

import com.myCode.customEntity.init.ModItems;
import com.myCode.customEntity.util.Reference;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy
{


	public void registerRenders() {
		ModItems.registerRenders();
		System.out.println("When do I happen?");
		System.out.println(ModItems.chip);
	}

	public void registerModelBakeryStuff() {
		ResourceLocation thing = new ResourceLocation(Reference.MOD_ID,"chip_basic");
		ResourceLocation thing2 = new ResourceLocation(Reference.MOD_ID,"chip_advanced");
		System.out.println("registerModelBakeryStuff");
		System.out.println(thing);
		System.out.println(ModItems.chip);
		ModelBakery.registerItemVariants(ModItems.chip, thing, thing2 );

	}

}