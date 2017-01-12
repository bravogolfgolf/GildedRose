package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void agedBrieSellInDecreasesByOne() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void agedBrieQualityIncreaseByOneWhenSellInIsGreaterThanZero() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void agedBrieQualityIncreaseByTwoWhenSellInIsLessThanOrEqualToZero() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void backstagePassSellInDecreasesByOne() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void backstagePassQualityChangesToZeroWhenSellInIsEqualToZero() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstagePassQualityIncreasesByOneWhenSellInIsGreaterThanOrEqualToEleven() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInIsLessThanElevenAndGreaterThanOrEqualSix() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void backstagePassQualityIncreasesByThreeWhenSellInIsLessThan6() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenSellInEqualsZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenQualityEqualsZero() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenQualityEqualsFifty() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void otherProductSellInAndQualityDecreasesByOneIfQualityIsGreaterThanZero() {
        Item[] items = new Item[]{new Item("Other", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    public void otherProductSellInDecreasesByOneAndQualityDoesNotChangeIfLessThanZero() {
        Item[] items = new Item[]{new Item("Other", 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void otherProductSellInDecreasesByOneAndQualityDoesNotChangeIfLessThanZero1() {
        Item[] items = new Item[]{new Item("Other", 0,  10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Other", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
}