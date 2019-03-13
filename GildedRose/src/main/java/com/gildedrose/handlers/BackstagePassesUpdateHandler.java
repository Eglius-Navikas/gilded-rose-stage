package com.gildedrose.handlers;

import com.gildedrose.Item;

public class BackstagePassesUpdateHandler implements ItemUpdateHandler {

    private static final int DAILY_QUALITY_INCREASE_VALUE = 1;
    private static final int DAYS_FOR_HIGHER_INCREASE = 10;
    private static final int DAYS_FOR_HIGHEST_INCREASE = 5;
    private static final int MAXIMUM_ITEM_QUALITY = 50;

    @Override
    public boolean conformsToType(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void handleUpdate(Item item) {
        item.sellIn--;
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else {
            increaseItemQuality(item);
            if (item.sellIn <= DAYS_FOR_HIGHER_INCREASE) {
                increaseItemQuality(item);
            }
            if (item.sellIn <= DAYS_FOR_HIGHEST_INCREASE) {
                increaseItemQuality(item);
            }
        }
    }

    private void increaseItemQuality(Item item) {
        if (item.quality <= MAXIMUM_ITEM_QUALITY - DAILY_QUALITY_INCREASE_VALUE) {
            item.quality += DAILY_QUALITY_INCREASE_VALUE;
        } else {
            item.quality = MAXIMUM_ITEM_QUALITY;
        }
    }
}
