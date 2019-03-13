package com.gildedrose.handlers;

import com.gildedrose.Item;

public interface ItemUpdateHandler {

    boolean conformsToType(Item item);
    void handleUpdate(Item item);
}
