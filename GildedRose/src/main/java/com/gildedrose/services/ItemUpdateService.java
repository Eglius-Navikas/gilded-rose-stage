package com.gildedrose.services;

import com.gildedrose.handlers.*;
import com.gildedrose.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemUpdateService {

    private List<ItemUpdateHandler> updateHandlerList;

    public ItemUpdateService() {
        this.updateHandlerList = new ArrayList<>();
        populateHandlerList();
    }

    private void populateHandlerList() {
        this.updateHandlerList.add(new AgedBrieUpdateHandler());
        this.updateHandlerList.add(new SulfurasUpdateHandler());
        this.updateHandlerList.add(new BackstagePassesUpdateHandler());
        this.updateHandlerList.add(new ConjuredItemUpdateHandler());

        this.updateHandlerList.add(new DefaultItemUpdateHandler());
    }

    public void updateItem(Item item) {
        for (ItemUpdateHandler handler : updateHandlerList) {
            if (handler.conformsToType(item)) {
                handler.handleUpdate(item);
                break;
            }
        }
    }
}
