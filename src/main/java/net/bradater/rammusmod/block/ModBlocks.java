package net.bradater.rammusmod.block;

import net.bradater.rammusmod.RammusMod;
import net.bradater.rammusmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RammusMod.MOD_ID);

    public static final RegistryObject<Block> RAMMUS_BLOCK = registerBlock("rammus_block",
            () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAMMUS_ORE_BLOCK = registerBlock("rammus_ore_block",
            () -> new Block(BlockBehaviour.Properties.m_308003_(Blocks.IRON_BLOCK).sound(SoundType.WOOD)));

    private static<T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        //registers the block
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        //registers the block item
        registerBlockItem(name, toReturn);
        //returns the block for this particular method
        return toReturn;
    }

    //defines that T placed in this registry object is a block
    //associated an item with the block
    private static<T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    //register method for the deferred register blocks list to be called in RammusMod constructor
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
