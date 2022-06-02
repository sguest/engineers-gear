package sguest.engineersgear.common.items;

import blusunrize.immersiveengineering.common.items.SawbladeItem;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;

// Mostly copied from RockcutterItem in IE
public class MeatgrinderItem extends SawbladeItem {
    private static Material[] validMaterials = {Material.WEB};
    private static ListNBT enchants = new ListNBT();
    public static ResourceLocation texture = new ResourceLocation("engineersgear:item/meatgrinder_blade");

    static
    {
        CompoundNBT tag = new CompoundNBT();
        tag.putString("id", "looting");
        tag.putInt("lvl", 3);
        enchants.add(tag);
    }

    public MeatgrinderItem(String name, int maxDamage, float sawbladeSpeed, float sawbladeDamage) {
        super(name, maxDamage, sawbladeSpeed, sawbladeDamage);
    }

    @Override
    public boolean canSawbladeFellTree()
    {
        return false;
    }

    @Override
    public ListNBT getSawbladeEnchants()
    {
        return enchants.copy();
    }

    @Override
    public Material[] getSawbladeMaterials()
    {
        return validMaterials;
    }

    @Override
    public ResourceLocation getSawbladeTexture()
    {
        return texture;
    }
}
