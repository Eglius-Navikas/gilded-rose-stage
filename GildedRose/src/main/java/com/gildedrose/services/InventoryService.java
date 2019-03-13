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
    public InventoryService(ItemUpdateService itemUpdateService) {
        this.itemUpdateService = itemUpdateService;
        this.items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};
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
