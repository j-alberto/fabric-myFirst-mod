package net.jalberto.vanillae.entity.client;

import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.entity.custom.HerobrineEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HerobrineRenderer extends GeoEntityRenderer<HerobrineEntity> {

    public HerobrineRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new HerobrineModel());
    }

    @Override
    public Identifier getTextureResource(HerobrineEntity instance) {
        return new Identifier(VanillaeMod.MOD_ID, "textures/entity/herobrine/herobrine.png");
    }
}
