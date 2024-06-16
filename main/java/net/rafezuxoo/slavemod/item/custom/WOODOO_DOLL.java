package net.rafezuxoo.slavemod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WOODOO_DOLL extends Item {
    public WOODOO_DOLL(Properties properties) {
        super(properties);
    }

    @java.lang.Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
        }


        return super.use(level, player, hand);
    }

    @java.lang.Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, java.util.List<Component> componentList, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            componentList.add(Component.literal("Doll which droped from woodoo warlord").withStyle(ChatFormatting.AQUA));
        }else {
            componentList.add(Component.literal("Press SHISH for more daca").withStyle(ChatFormatting.DARK_GREEN));
        }


        super.appendHoverText(itemStack, level, componentList, tooltipFlag);
    }

    private void outputRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("U was black at " + get_RandomNunber() +  "pm."));
    }
    private int get_RandomNunber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);

    }
}
