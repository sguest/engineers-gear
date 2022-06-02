package sguest.engineersgear.client;

import blusunrize.immersiveengineering.api.ManualHelper;
import blusunrize.lib.manual.ManualElementCrafting;
import blusunrize.lib.manual.ManualEntry;
import blusunrize.lib.manual.ManualInstance;
import blusunrize.lib.manual.Tree.InnerNode;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sguest.engineersgear.EngineersGear;
import sguest.engineersgear.common.items.ModItems;

public class Manual {
    private static final String IE_MOD_ID = "immersiveengineering";
    private static final String TOOLS_CATEGORY_RESOURCE = "tools";

    public static void init() {
        ManualInstance manual = ManualHelper.getManual();
        InnerNode<ResourceLocation, ManualEntry> toolsCategory = manual.getRoot().getOrCreateSubnode(new ResourceLocation(IE_MOD_ID, TOOLS_CATEGORY_RESOURCE));

        ManualEntry.ManualEntryBuilder builder = new ManualEntry.ManualEntryBuilder(manual);
        builder.addSpecialElement("orecutter_recipe", 0, new ManualElementCrafting(manual, new ItemStack(ModItems.ORECUTTER)));
        builder.addSpecialElement("meatgrinder_recipe", 0, new ManualElementCrafting(manual, new ItemStack(ModItems.MEATGRINDER)));
        builder.addSpecialElement("rotors_recipe", 0, new ManualElementCrafting(manual, new ItemStack(ModItems.DRILL_SILK_UPGRADE)));
        builder.readFromFile(new ResourceLocation(EngineersGear.MODID, "drill_saw_extras"));
        manual.addEntry(toolsCategory, builder.create(), 20);
    }
}
