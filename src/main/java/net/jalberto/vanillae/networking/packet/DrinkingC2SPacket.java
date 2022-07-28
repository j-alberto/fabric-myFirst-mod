package net.jalberto.vanillae.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class DrinkingC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
        ServerWorld world = player.getWorld();

        if(isAroundWaterThem(player, world, 2)) {
            world.playSound(null,player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS, 0.5f, world.random.nextFloat() *.01f + 0.9f);
        }
    }

    private static boolean isAroundWaterThem(ServerPlayerEntity player, ServerWorld world, int distance) {
        return BlockPos.stream(player.getBoundingBox().expand(distance))
                .map(world::getBlockState)
                .filter(blockState -> blockState.isOf(Blocks.WATER))
                .toArray().length > 0;
    }


}
