package com.myCode.customEntity;

import com.mojang.authlib.GameProfile;
import com.sun.org.apache.xpath.internal.objects.XObject;
import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

// Next, figure out how to print message to the minecraft game screen. And to other people's
// screens too.

@Mod.EventBusSubscriber (value = Side.CLIENT)
public class KeyboardTest {

    private static FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public static void breakBlock(BlockPos newPos) {
        World world = FMLClientHandler.instance().getServer().getWorld(0);
        //Minecraft.getMinecraft().player.getEntityWorld();
        //Minecraft.getMinecraft().

        IBlockState state = world.getBlockState(newPos); // Gets the block state
        Block block = state.getBlock(); // Gets the block

        // If the block is not air, is not unbreakable or a liquid it will try and break it
        if (!block.isAir(state, world, newPos) && block.getBlockHardness(state, world, newPos) >= 0
                && !(block instanceof BlockDynamicLiquid) && !(block instanceof BlockStaticLiquid)) {
            world.destroyBlock(newPos, true );

        }
    }

    @SubscribeEvent
    public static void onEvent(InputEvent.KeyInputEvent event)
    {
        BlockPos blockPos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();

        char thing = Keyboard.getEventCharacter();
        String s=Character.toString(thing);
        if(s.equals("z")) {
            breakBlock(blockPos);
            Minecraft.getMinecraft().ingameGUI.addChatMessage( ChatType.GAME_INFO, new TextComponentString("Block destroyed!"));
        }
    }

}
