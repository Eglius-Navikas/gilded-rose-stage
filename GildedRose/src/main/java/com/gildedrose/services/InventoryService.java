package com.gildedrose.services;

import com.gildedrose.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InventoryService {
    private Item[] items;
    private ItemUpdateService itemUpdateService;

    @Autowired
    public InventoryService(ItemUpdateService itemUpdateService, Item[] startingInventory) {
        this.itemUpdateService = itemUpdateService;
        this.items = startingInventory;
    }

    public void updateQuality() {
        for (Item item: items) {
            itemUpdateService.updateItem(item);
        }
    }

    public List<Item> getItems() {
        return Arrays.asList(this.items);
    }
}
