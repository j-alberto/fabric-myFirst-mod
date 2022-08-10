package net.jalberto.vanillae.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.world.feature.ModPlacedFeatures;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration  {

    public static final RegistryKey<Biome> CRISTALLI_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(VanillaeMod.MOD_ID,"cristalli"));

    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.MICHIORITE_ORE_PLACED.getKey().get());


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(CRISTALLI_KEY),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.MICHIORITE_ORE_PLACED.getKey().get());


    }
}
