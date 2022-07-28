package net.jalberto.vanillae.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OrePlacedFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> MICHIORITE_ORE_PLACED = PlacedFeatures.register("michiorite_ore_placed",
            ModConfiguredFeatures.MICHIORITE_ORE_FEATURE,
            modifiersWithCount(9 , HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-20), YOffset.belowTop(20))));


    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    /**
     *
     * @param count number of veins per chunk
     * @param heightModifier defines distribution across the chunk
     * @return
     */
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return ModPlacedFeatures.modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return ModPlacedFeatures.modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

}
