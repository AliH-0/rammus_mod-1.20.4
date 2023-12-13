package net.bradater.rammusmod.item;

import net.bradater.rammusmod.RammusMod;
import net.bradater.rammusmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RammusMod.MOD_ID);

    //Add mod items or any item to my own custom Creative Mode Tab
    public static final RegistryObject<CreativeModeTab> RAMMUS_TAB = CREATIVE_MODE_TABS.register("rammus_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAMMUS.get()))
                    .title(Component.translatable("creativetab.rammus_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAMMUS.get());
                        pOutput.accept(ModItems.RAMBALL.get());
                        pOutput.accept(ModItems.RAMSHELL.get());

                        pOutput.accept(ModBlocks.RAMMUS_BLOCK.get());
                        pOutput.accept(ModBlocks.RAMMUS_ORE_BLOCK.get());
                    })
                    .build());



    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
