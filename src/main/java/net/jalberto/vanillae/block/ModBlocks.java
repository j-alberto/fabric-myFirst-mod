package net.jalberto.vanillae.block;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jalberto.vanillae.VanillaeMod;
import net.jalberto.vanillae.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks  {

    public static final Block MICHIORITE_BLOCK =  registerBlock("michiorite_block",
            new Block(FabricBlockSettings.of(Material.METAL)
                    .strength(4f)
                    .requiresTool()),
                ModItemGroup.MICHIORITE);
    public static final Block MICHIORITE_ORE =  registerBlock("michiorite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE)
                    .strength(4f)
                    .requiresTool(),
                UniformIntProvider.create(3, 7)),
            ModItemGroup.MICHIORITE);
    public static final Block DEEPSLATE_MICHIORITE_ORE =  registerBlock("deepslate_michiorite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE)
                    .strength(4f)
                    .requiresTool(),
                UniformIntProvider.create(3, 7)),
            ModItemGroup.MICHIORITE);

    public static void registerModBlocks() {
        VanillaeMod.LOGGER.debug("Registering mod blocks for " + VanillaeMod.MOD_ID);
    }

    private static Block registerBlock(String name, Block block, ItemGroup itemGroup) {
        registerBlockItem(name, block, itemGroup);
        return Registry.register(Registry.BLOCK, new Identifier(VanillaeMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup itemGroup) {
        return Registry.register(Registry.ITEM, new Identifier(VanillaeMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(itemGroup)));
    }
}
