package net.jalberto.vanillae.entity.client;

import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.entity.custom.HerobrineEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class HerobrineModel extends AnimatedGeoModel<HerobrineEntity> {
    @Override
    public Identifier getModelResource(HerobrineEntity object) {
        return new Identifier(VanillaeMod.MOD_ID, "geo/herobrine.geo.json");
    }

    @Override
    public Identifier getTextureResource(HerobrineEntity object) {
        return new Identifier(VanillaeMod.MOD_ID, "textures/entity/herobrine/herobrine.png");
    }

    @Override
    public Identifier getAnimationResource(HerobrineEntity animatable) {
        return new Identifier(VanillaeMod.MOD_ID, "animations/herobrine.animation.json");
    }


    @Override
    public void setLivingAnimations(HerobrineEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180f));
            head.setRotationY(extraData.netHeadYaw  * ((float) Math.PI / 180f));
        }
    }
}
