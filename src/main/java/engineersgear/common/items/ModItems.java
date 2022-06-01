package engineersgear.common.items;

import java.util.ArrayList;
import java.util.List;

import engineersgear.EngineersGear;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = EngineersGear.MODID, bus = Bus.MOD)
public class ModItems {
    public static List<Item> registryItems = new ArrayList<Item>();
    public static void init()
    {
        // This extends IE's base item (since Buzzsaw won't accept a blade that's not an instance of SawbladeItem)
        // Therefore this will get registered as an IE item. Not ideal, but I'm not sure how else to accomplish this
        new OrecutterItem("orecutter", 5000, 5f, 9f);
        
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
