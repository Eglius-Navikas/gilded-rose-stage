package com.gildedrose.handlers;

import com.gildedrose.Item;

public class SulfurasUpdateHandler implements ItemUpdateHandler {

    private static final int SULFURAS_QUALITY = 80;

    @Override
    public boolean conformsToType(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void handleUpdate(Item item) {
        item.quality = SULFURAS_QUALITY;
    }
}