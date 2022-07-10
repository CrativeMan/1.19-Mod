package de.sebastian.tutorial.block.custom;

import com.mojang.realmsclient.util.WorldGenerationInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class TeleporterBlock extends Block {

    public long requiredXl;
    public long requiredYl;
    public long requiredZl;

    public double requiredXd;
    public double requiredYd;
    public double requiredZd;

    @Override
    public Optional<Vec3> getRespawnPosition(BlockState state, EntityType<?> type, LevelReader levelReader, BlockPos pos, float orientation, @Nullable LivingEntity entity) {
        return super.getRespawnPosition(state, type, levelReader, pos, orientation, entity);
    }
    String failed = "To low on levels";

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if(!level.isClientSide && interactionHand == InteractionHand.MAIN_HAND){
            if(player.experienceLevel > 1){
            player.giveExperienceLevels(-1);
//            player.teleportTo();
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
