package net.jalberto.vanillae.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final PointOfInterestType JUMPY_POI = registerPOI("jumper_poi", ModBlocks.JUMPY_BLOCK);
    public static final VillagerProfession JUMPER = registerProfession("jumper", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(VanillaeMod.MOD_ID, "jumper_poi")));


    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(VanillaeMod.MOD_ID, name), 1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        VanillaeMod.LOGGER.debug("Registering villagers for " + VanillaeMod.MOD_ID);
    }

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(VanillaeMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(VanillaeMod.MOD_ID, name))
                        .workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(JUMPER,1,factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ModItems.EGGPLANT, 2),
                    12,
                    2, 0.02f));
        });
    }
}
