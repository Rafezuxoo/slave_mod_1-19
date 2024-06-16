package net.rafezuxoo.slavemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab SLAVEMOD_TAB = new CreativeModeTab("slavemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SPEAR.get());
        }
    };
}
