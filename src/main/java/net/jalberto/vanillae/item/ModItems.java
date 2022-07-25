package net.jalberto.vanillae.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.item.custom.EightBallItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_MICHIORITE  = registerItem("raw_michiorite",
            new Item(new FabricItemSettings()
                    .group(ModItemGroup.MICHIORITE)));
    public static final Item MICHIORITE = registerItem("michiorite",
            new Item(new FabricItemSettings()
                    .group(ModItemGroup.MICHIORITE)));

    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings()
                    .group(ModItemGroup.MICHIORITE)
                    .maxCount(1)));

    public static void registerModItems() {
        VanillaeMod.LOGGER.debug("Registering Mod Items for " + VanillaeMod.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(VanillaeMod.MOD_ID, name), item);
    }
}
