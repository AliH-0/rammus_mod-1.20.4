package net.bradater.rammusmod.item;


import net.bradater.rammusmod.RammusMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//holds all the items that will be used in mod
public class ModItems {
    //DeferredRegister is a long list of whats in <>, in this cames items or type items
    // then is registered at a certain time when forge loads the items (more complex definition)
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RammusMod.MOD_ID);

    public static final RegistryObject<Item> RAMMUS = ITEMS.register("rammus",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAMBALL = ITEMS.register("ramball",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAMSHELL = ITEMS.register("ramshell",
            () -> new Item(new Item.Properties()));
    //also need to register the deferreregister
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}
