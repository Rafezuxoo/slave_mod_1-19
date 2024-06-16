package net.rafezuxoo.slavemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class N_lamp extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public N_lamp(Properties properties) {
        super(properties);
    }

    @java.lang.Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            level.setBlock(blockPos, blockState.cycle(LIT), 3);
        }
        return super.use(blockState, level, blockPos, player, hand, blockHitResult);
    }

    @java.lang.Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
        super.createBlockStateDefinition(builder);
    }
}
