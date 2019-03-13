package com.gildedrose.handlers;

import com.gildedrose.Item;

public class AgedBrieUpdateHandler implements ItemUpdateHandler {

    private static final int DAILY_QUALITY_INCREASE_VALUE = 1;
    private static final int MAXIMUM_ITEM_QUALITY = 50;

    @Override
    public boolean conformsToType(Item item) {
        return item.name.equals("Aged Brie");
    }

    @Override
    public void handleUpdate(Item item) {
        if (item.quality <= MAXIMUM_ITEM_QUALITY - DAILY_QUALITY_INCREASE_VALUE) {
            item.quality += DAILY_QUALITY_INCREASE_VALUE;
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            if (item.quality <= MAXIMUM_ITEM_QUALITY - DAILY_QUALITY_INCREASE_VALUE) {
                item.quality += DAILY_QUALITY_INCREASE_VALUE;
            } else {
                item.quality = MAXIMUM_ITEM_QUALITY;
            }
        }
    }
}
