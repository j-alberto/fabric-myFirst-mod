package net.jalberto.vanillae.painting;

import net.jalberto.vanillae.VanillaeMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {

    public static final PaintingVariant PKE1 = registerPainting("pke1", new PaintingVariant(32,32));
    public static final PaintingVariant PKE2 = registerPainting("pke2", new PaintingVariant(32,32));
    public static final PaintingVariant PKE3 = registerPainting("pke3", new PaintingVariant(32,32));

    public static void registerPaintings() {
        VanillaeMod.LOGGER.debug("Registering paintings for " + VanillaeMod.MOD_ID);
    }

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(VanillaeMod.MOD_ID, name), paintingVariant);
    }
}
