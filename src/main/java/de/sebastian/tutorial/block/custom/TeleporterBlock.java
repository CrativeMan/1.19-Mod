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
import static java.lang.Math.toIntExact;

import static de.sebastian.tutorial.block.custom.TeleportOutBlock.*;

public class TeleporterBlock extends Block {


    public double posXl = lX;
    public double posYl = lY;
    public double posZl = lZ;

    String failed = "To low on levels";

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if(!level.isClientSide && interactionHand == InteractionHand.MAIN_HAND){
            if(player.experienceLevel > 1) {

            player.giveExperienceLevels(-1);
            player.teleportTo(lX + 0.5, lY + 1, lZ +0.5);

            } else {
                player.sendSystemMessage(Component.nullToEmpty(failed));
            }

        }

        return super.use(state, level, blockPos, player, interactionHand, blockHitResult);
    }

    public TeleporterBlock(Properties properties) {
        super(properties);
    }
}
