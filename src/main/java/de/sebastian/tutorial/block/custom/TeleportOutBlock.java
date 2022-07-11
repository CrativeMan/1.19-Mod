package de.sebastian.tutorial.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.security.PublicKey;

public class TeleportOutBlock extends Block {

    public static double lX;
    public static double lY;
    public static double lZ;

    public static boolean air = false;




    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult hitResult) {

        checkAir(pos, level);

        if(!level.isClientSide && interactionHand == InteractionHand.MAIN_HAND){

            player.sendSystemMessage(Component.nullToEmpty("Teleport point set"));

            lX = pos.getX();
            lY = pos.getY();
            lZ = pos.getZ();
        }

        return super.use(state, level, pos, player, interactionHand, hitResult);
    }

    public static void checkAir(BlockPos pos, Level level){
        BlockPos posAbove = pos.above();
        BlockState aboveState = level.getBlockState(posAbove);

        if(aboveState.isAir()){
            air = true;
        }
    }

    public TeleportOutBlock(Properties properties) {
        super(properties);
    }
}
