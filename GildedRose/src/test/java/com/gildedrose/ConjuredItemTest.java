package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredItemTest {

    @Test
    public void conjuredItemLosesQualityTwiceAsFastAsNormalDaily() {
        Item[] items = new Item[] { new Item("foo", 10, 10),
                new Item("Conjured Sweetroll", 10, 10)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        assertEquals(8, app.items[1].quality);
    }

    @Test
    public void conjuredItemPastExpirationLosesQualityTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Bananapie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }

    @Test
    public void qualityOfAConjuredItemDoesNotDegradeIntoNegative() {
        Item[] items = new Item[] {
                new Item("Conjured Replica of Thunderfury, Blessed Blade of the Windseeker", 10, 0)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
