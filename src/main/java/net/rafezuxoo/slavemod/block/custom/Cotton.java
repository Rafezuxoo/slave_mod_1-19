package net.rafezuxoo.slavemod.block.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class Cotton extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age",0,6);
    public Cotton(Properties properties) {
        super(properties);
    }


    @java.lang.Override
    protected ItemLike getBaseSeedId() {
        return super.getBaseSeedId();
    }

    @java.lang.Override
    public IntegerProperty getAgeProperty() {
        return super.getAgeProperty();
    }

    @java.lang.Override
    public int getMaxAge() {
        return super.getMaxAge();
    }

    @java.lang.Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.createBlockStateDefinition(builder);
    }
}
