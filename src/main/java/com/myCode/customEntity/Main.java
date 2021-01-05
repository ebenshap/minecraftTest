package com.myCode.customEntity;

import com.myCode.customEntity.init.ModItems;
import com.myCode.customEntity.proxy.CommonProxy;
import com.myCode.customEntity.util.Reference;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    public static KeyBinding[] keyBindings;

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModItems.register();
        proxy.registerRenders();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        System.out.println("Main FML initialization!!!");
        proxy.registerModelBakeryStuff();
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

}
