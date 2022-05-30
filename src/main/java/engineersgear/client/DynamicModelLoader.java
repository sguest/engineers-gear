package engineersgear.client;

import engineersgear.EngineersGear;
import engineersgear.common.items.OrecutterItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

//Loads models not referenced in any blockstates for rendering in TE(S)Rs
//Thanks to IE's class of the same name
@EventBusSubscriber(value = Dist.CLIENT, modid = EngineersGear.MODID, bus = Bus.MOD)
public class DynamicModelLoader {
    @SubscribeEvent
    public static void textureStitch(TextureStitchEvent.Pre evt)
    {
        evt.addSprite(OrecutterItem.texture);
    }
}
