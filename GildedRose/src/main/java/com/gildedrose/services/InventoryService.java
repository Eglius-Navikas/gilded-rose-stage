package com.gildedrose.services;

import com.gildedrose.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Scheduled(cron = "0 0 0 * * *")
    public void updateQuality() {
        for (Item item : items) {
            new Thread(() -> itemUpdateService.updateItem(item));
        }
    }

    public List<Item> getItems() {
        return Arrays.asList(this.items);
    }
}
