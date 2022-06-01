package engineersgear;

import engineersgear.common.items.ModItems;
import engineersgear.common.lootmodifiers.ModLootModifiers;
import net.minecraftforge.fml.common.Mod;

@Mod(EngineersGear.MODID)
public class EngineersGear {
    public static final String MODID = "engineersgear";

    public EngineersGear()
    {
        ModItems.init();
        ModLootModifiers.init();
    }
}
