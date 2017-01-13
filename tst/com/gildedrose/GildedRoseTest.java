package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String OTHER = "Other";
    private Item item;
    private Item[] items;
    private GildedRose app;

    private void createItemArray() {
        items = new Item[]{item};
    }

    private void createAppAndUpdateItems() {
        app = new GildedRose(items);
        app.updateQuality();
    }

    private void assertEquals(String itemName, int expectedSellinAmount, int expectedQualityAmount) {
        Assert.assertEquals(itemName, app.items[0].name);
        Assert.assertEquals(expectedSellinAmount, app.items[0].sellIn);
        Assert.assertEquals(expectedQualityAmount, app.items[0].quality);
    }

    @Test
    public void agedBrieSellInDecreasesByOne() {
        item = new Item(AGED_BRIE, 0, 50);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(AGED_BRIE, -1, 50);
    }

    @Test
    public void agedBrieQualityIncreaseByOneWhenSellInIsGreaterThanZero() {
        item = new Item(AGED_BRIE, 1, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(AGED_BRIE, 0, 1);
    }

    @Test
    public void agedBrieQualityIncreaseByTwoWhenSellInIsLessThanOrEqualToZero() {
        item = new Item(AGED_BRIE, 0, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(AGED_BRIE, -1, 2);
    }

    @Test
    public void backstagePassSellInDecreasesByOne() {
        item = new Item(BACKSTAGE_PASS, 1, 50);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(BACKSTAGE_PASS, 0, 50);
    }

    @Test
    public void backstagePassQualityChangesToZeroWhenSellInIsEqualToZero() {
        item = new Item(BACKSTAGE_PASS, 0, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(BACKSTAGE_PASS, -1, 0);
    }

    @Test
    public void backstagePassQualityIncreasesByOneWhenSellInIsGreaterThanOrEqualToEleven() {
        item = new Item(BACKSTAGE_PASS, 11, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(BACKSTAGE_PASS, 10, 1);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInIsLessThanElevenAndGreaterThanOrEqualSix() {
        item = new Item(BACKSTAGE_PASS, 6, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(BACKSTAGE_PASS, 5, 2);
    }

    @Test
    public void backstagePassQualityIncreasesByThreeWhenSellInIsLessThan6() {
        item = new Item(BACKSTAGE_PASS, 5, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(BACKSTAGE_PASS, 4, 3);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenSellInEqualsZero() {
        item = new Item(SULFURAS, 0, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(SULFURAS, 0, 10);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenQualityEqualsZero() {
        item = new Item(SULFURAS, 5, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(SULFURAS, 5, 0);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenQualityEqualsFifty() {
        item = new Item(SULFURAS, -1, 50);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(SULFURAS, -1, 50);
    }

    @Test
    public void otherProductSellInAndQualityDecreasesByOneIfQualityIsGreaterThanZero() {
        item = new Item(OTHER, 10, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(OTHER, 9, 9);
    }

    @Test
    public void otherProductSellInDecreasesByOneAndQualityDoesNotChangeIfLessThanZero() {
        item = new Item(OTHER, 10, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(OTHER, 9, 0);
    }

    @Test
    public void otherProductSellInDecreasesByOneAndQualityDecreasesByTwoWhenSellInEqualsZero() {
        item = new Item(OTHER, 0, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(OTHER, -1, 8);
    }
}