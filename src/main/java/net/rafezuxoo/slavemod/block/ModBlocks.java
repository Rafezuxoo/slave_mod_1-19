package net.rafezuxoo.slavemod.block;

import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rafezuxoo.slavemod.Slavemod;
import net.rafezuxoo.slavemod.block.custom.Cotton;
import net.rafezuxoo.slavemod.block.custom.JUMPY_N_BLOCK;
import net.rafezuxoo.slavemod.block.custom.N_lamp;
import net.rafezuxoo.slavemod.item.ModCreativeModeTab;
import net.rafezuxoo.slavemod.item.ModItems;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Slavemod.MOD_ID);
    public static void register(IEventBus eventBus){

        BLOCKS.register(eventBus);
    }

    public static final RegistryObject<Block> N_WORD_BLOCK = registerBlock("n_word_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL)
                    .instabreak()
                    ), ModCreativeModeTab.SLAVEMOD_TAB);
    public static final RegistryObject<Block> JUMPY_N_BLOCK = registerBlock("jumpy_n_block",
            () -> new JUMPY_N_BLOCK(BlockBehaviour.Properties.of(Material.WOOL)
                    .instabreak()
            ), ModCreativeModeTab.SLAVEMOD_TAB);

    public static final RegistryObject<Block> N_LAMP = registerBlock("n_lamp",
            () -> new N_lamp(BlockBehaviour.Properties.of(Material.WOOL)
                    .instabreak()
                    .lightLevel(state -> state.getValue(N_lamp.LIT) ? 15 : 5)
            ), ModCreativeModeTab.SLAVEMOD_TAB);

    private static <T extends Block> RegistryObject<T>  registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITMES.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .tab(tab)
                .stacksTo(63)
        ));
    }
}