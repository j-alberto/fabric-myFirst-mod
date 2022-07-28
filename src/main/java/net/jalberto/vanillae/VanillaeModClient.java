package net.jalberto.vanillae;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.event.KeyInputHandler;
import net.jalberto.vanillae.networking.ModMessages;
import net.minecraft.client.render.RenderLayer;

public class VanillaeModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());
        KeyInputHandler.register();
        ModMessages.registerS2CPackets();
    }
}
