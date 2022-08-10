package net.jalberto.vanillae;

import net.fabricmc.api.ModInitializer;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.entity.ModEntities;
import net.jalberto.vanillae.item.ModItems;
import net.jalberto.vanillae.networking.ModMessages;
import net.jalberto.vanillae.painting.ModPaintings;
import net.jalberto.vanillae.util.ModLootTableModifiers;
import net.jalberto.vanillae.villager.ModVillagers;
import net.jalberto.vanillae.world.dimension.ModDimensions;
import net.jalberto.vanillae.world.feature.ModConfiguredFeatures;
import net.jalberto.vanillae.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaeMod implements ModInitializer {
	public static final String MOD_ID = "vanillae";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//call before all other mod register methods
		ModConfiguredFeatures.registerConfiguredFeatures();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();

		ModOreGeneration.generateOres();

		ModLootTableModifiers.modifyLootTables();

		ModMessages.registerC2SPackets();

		ModDimensions.register();

		ModEntities.registerEntities();

	}
}
