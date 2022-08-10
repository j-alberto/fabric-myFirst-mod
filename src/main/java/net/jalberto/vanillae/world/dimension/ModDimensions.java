package net.jalberto.vanillae.world.dimension;

import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.item.ModItems;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.kyrptonaught.customportalapi.event.CPASoundEventData;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> CRISTALLUM_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY, new Identifier(VanillaeMod.MOD_ID, "cristallum"));
    public static final RegistryKey<DimensionType> CRISTALLUM_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, CRISTALLUM_DIMENSION_KEY.getValue());

    public static void register() {
        VanillaeMod.LOGGER.debug("Registering ModDimensions for " + VanillaeMod.MOD_ID);

        CustomPortalBuilder.beginPortal()
                .frameBlock(Blocks.REINFORCED_DEEPSLATE)
                .destDimID(ModDimensions.CRISTALLUM_DIMENSION_KEY.getValue())
                .tintColor(0x128c8f)
                .lightWithItem(ModItems.RUBY)
                .onlyLightInOverworld()
                .registerIgniteEvent((player, world, portalPos, framePos, portalIgnitionSource) -> {
                    world.playSound(player, portalPos, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS,0.7f , 0.9f);
                })
                .registerInPortalAmbienceSound(player ->
                        new CPASoundEventData(SoundEvents.BLOCK_PORTAL_TRIGGER, 0.9f, 0.5f))
                .registerPostTPPortalAmbience(player ->
                        new CPASoundEventData(SoundEvents.BLOCK_PORTAL_TRAVEL, 0.9f, 0.5f))
                .forcedSize(1,1)
                .registerPortal();

    }
}
