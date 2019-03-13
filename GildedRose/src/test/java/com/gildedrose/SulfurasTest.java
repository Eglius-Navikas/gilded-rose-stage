package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasTest {

    @Test
    public void sulfurasQualityNeverAlters() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(80, app.items[1].quality);
    }

}
