package com.gildedrose.handlers;

import com.gildedrose.model.Item;

public interface ItemUpdateHandler {

    boolean conformsToType(Item item);
    void handleUpdate(Item item);
}
