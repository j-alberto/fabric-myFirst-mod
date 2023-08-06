package net.jalberto.vanillae.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.block.ModBlocks;
import net.jalberto.vanillae.entity.ModEntities;
import net.jalberto.vanillae.item.custom.EightBallItem;
import net.minecraft.entity.EquipmentSlot;
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
    public static final Item MICHIORITE_TRIDENT = registerItem("michiorite_trident",
            new TridentItem(new Item.Settings().maxDamage(250).group(ItemGroup.COMBAT)));

    public static final Item EMERALD_HELMET = registerItem("emerald_helmet",
            new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate",
            new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings",
            new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item EMERALD_BOOTS = registerItem("emerald_boots",
            new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.HEAD, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.CHEST, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.LEGS, new FabricItemSettings().group(ItemGroup.COMBAT)));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.FEET, new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item RACCOON_SPAWN_EGG = registerItem("raccoon_spawn_egg",
            new SpawnEggItem(ModEntities.RACCOON, 0x626867, 0x2b2c2c, new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item HEROBRINE_SPAWN_EGG = registerItem("herobrine_spawn_egg",
            new SpawnEggItem(ModEntities.HEROBRINE, 0x11aba8, 0x6120cf, new FabricItemSettings().group(ItemGroup.MISC)));

    public static void registerModItems() {
        VanillaeMod.LOGGER.debug("Registering Mod Items for " + VanillaeMod.MOD_ID);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(VanillaeMod.MOD_ID, name), item);
    }
}
