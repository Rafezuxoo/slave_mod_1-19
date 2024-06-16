package net.rafezuxoo.slavemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rafezuxoo.slavemod.Slavemod;
import net.rafezuxoo.slavemod.item.custom.WOODOO_DOLL;

public class ModItems {
    public static final DeferredRegister<Item> ITMES =
            DeferredRegister.create(ForgeRegistries.ITEMS, Slavemod.MOD_ID);
    public static void register(IEventBus eventBus){

        ITMES.register(eventBus);
    }

    public static final RegistryObject<Item> SPEAR =  ITMES.register("spear",
            ()-> new SwordItem(Tiers.WOOD, 12, -2.0F, (new Item.Properties()).tab(ModCreativeModeTab.SLAVEMOD_TAB)));
    public static final RegistryObject<Item> WOODOO_DOLL =  ITMES.register("woodoo_doll",
            ()-> new WOODOO_DOLL(new Item.Properties()
                    .tab(ModCreativeModeTab.SLAVEMOD_TAB)
                    .stacksTo(2)
            ));
}
