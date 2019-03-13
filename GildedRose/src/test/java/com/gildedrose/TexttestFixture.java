package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.services.InventoryService;
import com.gildedrose.services.ItemUpdateService;
import org.junit.Test;

import java.util.List;

public class TexttestFixture {

    private ItemUpdateService itemUpdateService = new ItemUpdateService();

    @Test
    public void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] newItems = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};
        InventoryService inventoryService = new InventoryService(itemUpdateService, newItems);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            List<Item> items = inventoryService.getItems();
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            inventoryService.updateQuality();
        }
    }

}
