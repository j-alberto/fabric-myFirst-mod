package net.jalberto.vanillae.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.item.custom.EightBallItem;
import net.jalberto.vanillae.item.custom.ModToolMaterials;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item RAW_MICHIORITE  = registerItem("raw_michiorite",
            new Item(new FabricItemSettings().group(ModItemGroup.MICHIORITE)));
    public static final Item MICHIORITE = registerItem("michiorite",
            new Item(new FabricItemSettings().group(ModItemGroup.MICHIORITE)));

    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings()
                    .group(ModItemGroup.MICHIORITE)
                    .maxCount(1)));

    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP, new FabricItemSettings().group(ModItemGroup.MICHIORITE)));

    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings()
                    .group(ModItemGroup.MICHIORITE)
                    .food(new FoodComponent.Builder()
                            .hunger(4)
                            .saturationModifier(4f)
                            .build())));

    public static final Item RUBY = registerItem("ruby",
            new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item EMERALD_SWORD = registerItem("emerald_sword",
            new SwordItem(ModToolMaterials.EMERALD,3,-2.4f,new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item RUBY_SWORD = registerItem("ruby_sword",
            new SwordItem(ModToolMaterials.RUBY,3,-2.4f,new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static void registerModItems() {
        VanillaeMod.LOGGER.debug("Registering Mod Items for " + VanillaeMod.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(VanillaeMod.MOD_ID, name), item);
    }
}
