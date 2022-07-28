package net.jalberto.vanillae.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.jalberto.vanillae.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID = new Identifier("minecraft", "blocks/grass");
    private static final Identifier IGLOO_STRUCTURE_CHEST_ID = new Identifier("minecraft", "chests/igloo_chest");
    private static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
              if( GRASS_BLOCK_ID.equals(id)) {
                  LootPool.Builder poolBuilder = LootPool.builder()
                          .rolls(ConstantLootNumberProvider.create(1f))
                          .conditionally(RandomChanceLootCondition.builder(0.05f))
                          .with(ItemEntry.builder(ModItems.EGGPLANT_SEEDS))
                          .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build());
                  tableBuilder.pool(poolBuilder.build());
              }

            if( IGLOO_STRUCTURE_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.EGGPLANT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if( CREEPER_ID.equals(id) && false) { //not used for now
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER,
                                new EntityPredicate.Builder().equipment(EntityEquipmentPredicate.Builder.create()
                                        .mainhand(ItemPredicate.Builder.create().items(Items.GOLDEN_SWORD).build()).build()).build()))
                        .with(ItemEntry.builder(ModItems.EGGPLANT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
