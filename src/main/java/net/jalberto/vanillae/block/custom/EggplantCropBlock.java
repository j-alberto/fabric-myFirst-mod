package net.jalberto.vanillae.block.custom;

import net.jalberto.vanillae.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class EggplantCropBlock extends CropBlock {

    public static final IntProperty AGE = IntProperty.of("age", 0, 6);

    public EggplantCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.EGGPLANT_SEEDS;
    }
}
