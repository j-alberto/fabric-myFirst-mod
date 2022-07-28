package net.jalberto.vanillae.world.feature;

import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_MICHIORITE_ORES = List.of(
      OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MICHIORITE_ORE.getDefaultState()),
      OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MICHIORITE_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> MICHIORITE_ORE_FEATURE = ConfiguredFeatures.register("michiorite_ore_feature",
            Feature.ORE,
            new OreFeatureConfig((OVERWORLD_MICHIORITE_ORES), 9));

    public static void registerConfiguredFeatures() {
        VanillaeMod.LOGGER.debug("Registering Configured Features for " + VanillaeMod.MOD_ID);
    }
}
