package sguest.engineersgear.common.lootmodifiers;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import sguest.engineersgear.EngineersGear;

public class ModLootModifiers {
    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, EngineersGear.MODID);

    public static final RegistryObject<SilkTouchLootModifier.Serializer> SILK_TOUCH_DRILL = GLM.register("silk_touch_drill", SilkTouchLootModifier.Serializer::new);

    public static void init()
    {
        GLM.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
