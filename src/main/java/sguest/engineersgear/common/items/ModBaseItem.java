package sguest.engineersgear.common.items;

import blusunrize.immersiveengineering.ImmersiveEngineering;
import net.minecraft.item.Item;
import sguest.engineersgear.EngineersGear;

public class ModBaseItem extends Item {

    public ModBaseItem(String name) {
        this(name, new Properties());
    }

    public ModBaseItem(String name, Properties props) {
        super(props.tab(ImmersiveEngineering.ITEM_GROUP));

        setRegistryName(EngineersGear.MODID, name);
        ModItems.registryItems.add(this);
    }
}
