package com.gildedrose.handlers;

import com.gildedrose.model.Item;

public class ConjuredItemUpdateHandler implements ItemUpdateHandler {

    private static final int DAILY_QUALITY_DECREASE_VALUE = 2;

    @Override
    public boolean conformsToType(Item item) {
        return item.name.contains("Conjured");
    }

    @Override
    public void handleUpdate(Item item) {
        if (item.quality >= DAILY_QUALITY_DECREASE_VALUE) {
            item.quality -= DAILY_QUALITY_DECREASE_VALUE;
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            if (item.quality >= DAILY_QUALITY_DECREASE_VALUE) {
                item.quality -= DAILY_QUALITY_DECREASE_VALUE;
            } else {
                item.quality = 0;
            }
        }
    }
}
