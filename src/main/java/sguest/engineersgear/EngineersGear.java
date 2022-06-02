package sguest.engineersgear;

import net.minecraftforge.fml.common.Mod;
import sguest.engineersgear.common.items.ModItems;
import sguest.engineersgear.common.lootmodifiers.ModLootModifiers;

@Mod(EngineersGear.MODID)
public class EngineersGear {
    public static final String MODID = "engineersgear";

    public EngineersGear()
    {
        ModItems.init();
        ModLootModifiers.init();
    }
}
