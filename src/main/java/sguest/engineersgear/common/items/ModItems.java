package sguest.engineersgear.common.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import sguest.engineersgear.EngineersGear;

@Mod.EventBusSubscriber(modid = EngineersGear.MODID, bus = Bus.MOD)
public class ModItems {
    public static List<Item> registryItems = new ArrayList<Item>();
    public static void init()
    {
        // These extend IE's base item (since Buzzsaw won't accept a blade that's not an instance of SawbladeItem)
        // Therefore they will get registered as IE items. Not ideal, but I'm not sure how else to accomplish this
        new OrecutterItem("orecutter", 5000, 5f, 9f);
        new MeatgrinderItem("meatgrinder", 5000, 5f, 13f);
        
        new DrillSilkUpgrade("drill-silk-upgrade");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        for(Item item : registryItems) {
            event.getRegistry().register(item);
        }
    }
}
