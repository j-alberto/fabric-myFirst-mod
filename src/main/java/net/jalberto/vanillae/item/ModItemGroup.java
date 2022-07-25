package net.jalberto.vanillae.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.jalberto.vanillae.VanillaeMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MICHIORITE = FabricItemGroupBuilder.build(new Identifier(VanillaeMod.MOD_ID, "michiorite"), () -> new ItemStack(ModItems.MICHIORITE));
}
