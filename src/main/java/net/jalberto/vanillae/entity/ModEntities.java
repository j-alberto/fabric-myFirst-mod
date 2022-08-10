package net.jalberto.vanillae.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.entity.client.RaccoonRenderer;
import net.jalberto.vanillae.entity.custom.RaccoonEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {

    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(VanillaeMod.MOD_ID, "raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RaccoonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f))
                    .build());

    public static void registerEntities() {
        EntityRendererRegistry.register(RACCOON, RaccoonRenderer::new);
        FabricDefaultAttributeRegistry.register(RACCOON, RaccoonEntity.setAttributes());
    }
}
