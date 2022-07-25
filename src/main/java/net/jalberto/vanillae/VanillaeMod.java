package net.jalberto.vanillae;

import net.fabricmc.api.ModInitializer;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaeMod implements ModInitializer {
	public static final String MOD_ID = "vanillae";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.info("vanillae mod initialized");
	}
}
