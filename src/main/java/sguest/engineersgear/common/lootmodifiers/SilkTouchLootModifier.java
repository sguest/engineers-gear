package sguest.engineersgear.common.lootmodifiers;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

public class SilkTouchLootModifier extends LootModifier {

    protected SilkTouchLootModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    // https://github.com/MinecraftForge/MinecraftForge/blob/4e47eab41e57460f06342c634309a16e16a72b3f/src/test/java/net/minecraftforge/debug/gameplay/loot/GlobalLootModifiersTest.java#L177
    @Nonnull
    @Override
    public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        ItemStack ctxTool = context.getParamOrNull(LootParameters.TOOL);
        //return early if silk-touch is already applied (otherwise we'll get stuck in an infinite loop).
        if(EnchantmentHelper.getEnchantments(ctxTool).containsKey(Enchantments.SILK_TOUCH)) return generatedLoot;
        ItemStack fakeTool = ctxTool.copy();
        fakeTool.enchant(Enchantments.SILK_TOUCH, 1);
        LootContext.Builder builder = new LootContext.Builder(context);
        builder.withParameter(LootParameters.TOOL, fakeTool);
        LootContext ctx = builder.create(LootParameterSets.BLOCK);
        LootTable loottable = context.getLevel().getServer().getLootTables().get(context.getParamOrNull(LootParameters.BLOCK_STATE).getBlock().getLootTable());
        return loottable.getRandomItems(ctx);
    }

    public static class Serializer extends GlobalLootModifierSerializer<SilkTouchLootModifier> {
        @Override
        public SilkTouchLootModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
            return new SilkTouchLootModifier(conditionsIn);
        }

        @Override
        public JsonObject write(SilkTouchLootModifier instance) {
            return makeConditions(instance.conditions);
        }
    }
}