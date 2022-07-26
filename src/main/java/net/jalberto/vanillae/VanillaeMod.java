package net.jalberto.vanillae;

import net.fabricmc.api.ModInitializer;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.item.ModItems;
import net.jalberto.vanillae.villager.ModVillagers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaeMod implements ModInitializer {
	public static final String MOD_ID = "vanillae";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTrades();

		LOGGER.info("vanillae mod initialized");
	}
}
