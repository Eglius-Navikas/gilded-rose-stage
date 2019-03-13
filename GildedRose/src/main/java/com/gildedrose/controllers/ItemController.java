package com.gildedrose.controllers;

import com.gildedrose.Item;
import com.gildedrose.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/items")
public class ItemController {

    private InventoryService inventoryService;

    @Autowired
    public ItemController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Item> getItems() {
        return this.inventoryService.getItems();
    }
}
