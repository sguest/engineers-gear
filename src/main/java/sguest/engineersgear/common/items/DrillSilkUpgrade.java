package sguest.engineersgear.common.items;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;

import blusunrize.immersiveengineering.api.client.TextUtils;
import blusunrize.immersiveengineering.api.tool.IUpgrade;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DrillSilkUpgrade extends ModBaseItem implements IUpgrade {

    public DrillSilkUpgrade(String name) {
        super(name);
    }

    private static ImmutableSet<String> upgradeTypes = ImmutableSet.of("DRILL");

    @Override
    public void applyUpgrades(ItemStack target, ItemStack upgrade, CompoundNBT modifications) {
        modifications.putBoolean("silktouch", true);
    }

    @Override
    public boolean canApplyUpgrades(ItemStack target, ItemStack upgrade) {
        return true;
    }

    @Override
    public Set<String> getUpgradeTypes(ItemStack arg0) {
        return upgradeTypes;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag advanced)
    {
        tooltip.add(TextUtils.applyFormat(new TranslationTextComponent("item.engineersgear.drill-silk-upgrade.tooltip"), TextFormatting.GRAY));
    }
}
