package sguest.engineersgear;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import sguest.engineersgear.client.ClientProxy;
import sguest.engineersgear.common.CommonProxy;
import sguest.engineersgear.common.items.ModItems;
import sguest.engineersgear.common.lootmodifiers.ModLootModifiers;

@Mod(EngineersGear.MODID)
public class EngineersGear {
    public static final String MODID = "engineersgear";
    public static CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public EngineersGear()
    {
        ModItems.init();
        ModLootModifiers.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
    }

    public void loadComplete(FMLLoadCompleteEvent event) {
        proxy.loadComplete();
    }
}
