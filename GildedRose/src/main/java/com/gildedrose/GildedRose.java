package com.gildedrose;

import com.gildedrose.handlers.*;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    Item[] items;
    private List<ItemUpdateHandler> updateHandlerList;

    public GildedRose(Item[] items) {
        this.items = items;
        this.updateHandlerList = new ArrayList<>();
        populateHandlerList();
    }

    private void populateHandlerList() {
        this.updateHandlerList.add(new AgedBrieUpdateHandler());
        this.updateHandlerList.add(new SulfurasUpdateHandler());
        this.updateHandlerList.add(new BackstagePassesUpdateHandler());
        this.updateHandlerList.add(new ConjuredItemUpdateHandler());

        //has to be last
        this.updateHandlerList.add(new DefaultItemUpdateHandler());
    }

    public void updateQuality() {
        for (Item item : items) {
            for (ItemUpdateHandler handler : updateHandlerList) {
                if (handler.conformsToType(item)) {
                    handler.handleUpdate(item);
                    break;
                }
            }
        }
    }

    public Item[] getItems() {
        return this.items;
    }
}