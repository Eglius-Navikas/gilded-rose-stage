package com.gildedrose.services;

import com.gildedrose.model.Item;
import com.gildedrose.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    private ItemUpdateService itemUpdateService;
    private ItemRepository itemRepository;
    private ElasticsearchOperations operations;

    @Autowired
    public InventoryService(ItemUpdateService itemUpdateService, Item[] startingInventory, ItemRepository itemRepository, ElasticsearchOperations elasticsearchOperations) {
        this.itemUpdateService = itemUpdateService;
        this.itemRepository = itemRepository;
        this.operations = elasticsearchOperations;
        operations.putMapping(Item.class);
        for (Item item: startingInventory) {
            itemRepository.save(item);
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateQuality() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            new Thread(() -> itemUpdateService.updateItem(item));
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemRepository.findAll());
    }
}
