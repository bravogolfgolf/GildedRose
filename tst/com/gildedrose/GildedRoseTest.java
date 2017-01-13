package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

    private Item item;
    private Item[] items;
    private GildedRose app;

    private void createItemArray() {
        items = new Item[]{item};
    }

    private void createAppAndUpdateItems() {
        app = new GildedRose(items);
        app.updateItem();
    }

    private void assertEquals(String itemName, int expectedSellinAmount, int expectedQualityAmount) {
        Assert.assertEquals(itemName, app.items[0].name);
        Assert.assertEquals(expectedSellinAmount, app.items[0].sellIn);
        Assert.assertEquals(expectedQualityAmount, app.items[0].quality);
    }

    @Test
    public void agedBrieSellInDecreasesByOne() {
        item = new CheeseItem(Item.AGED_BRIE, 0, 50);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.AGED_BRIE, -1, 50);
    }

    @Test
    public void agedBrieQualityIncreaseByOneWhenSellInIsGreaterThanZero() {
        item = new CheeseItem(Item.AGED_BRIE, 1, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.AGED_BRIE, 0, 1);
    }

    @Test
    public void agedBrieQualityIncreaseByTwoWhenSellInIsLessThanOrEqualToZero() {
        item = new CheeseItem(Item.AGED_BRIE, 0, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.AGED_BRIE, -1, 2);
    }

    @Test
    public void backstagePassSellInDecreasesByOne() {
        item = new BackstageItem(Item.BACKSTAGE_PASS, 1, 50);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.BACKSTAGE_PASS, 0, 50);
    }

    @Test
    public void backstagePassQualityChangesToZeroWhenSellInIsEqualToZero() {
        item = new BackstageItem(Item.BACKSTAGE_PASS, 0, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.BACKSTAGE_PASS, -1, 0);
    }

    @Test
    public void backstagePassQualityIncreasesByOneWhenSellInIsGreaterThanOrEqualToEleven() {
        item = new BackstageItem(Item.BACKSTAGE_PASS, 11, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.BACKSTAGE_PASS, 10, 1);
    }

    @Test
    public void backstagePassQualityIncreasesByTwoWhenSellInIsLessThanElevenAndGreaterThanOrEqualSix() {
        item = new BackstageItem(Item.BACKSTAGE_PASS, 6, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.BACKSTAGE_PASS, 5, 2);
    }

    @Test
    public void backstagePassQualityIncreasesByThreeWhenSellInIsLessThan6() {
        item = new BackstageItem(Item.BACKSTAGE_PASS, 5, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.BACKSTAGE_PASS, 4, 3);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenSellInEqualsZero() {
        item = new SulfurasItem(Item.SULFURAS, 0, 80);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.SULFURAS, 0, 80);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenQualityEqualsZero() {
        item = new SulfurasItem(Item.SULFURAS, 5, 80);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.SULFURAS, 5, 80);
    }

    @Test
    public void sulfurasSellInAndQualityNeverChangesWhenQualityEqualsFifty() {
        item = new SulfurasItem(Item.SULFURAS, -1, 80);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.SULFURAS, -1, 80);
    }

    @Test
    public void otherProductSellInAndQualityDecreasesByOneIfQualityIsGreaterThanZero() {
        item = new OtherItem(Item.OTHER, 10, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.OTHER, 9, 9);
    }

    @Test
    public void otherProductSellInDecreasesByOneAndQualityDoesNotChangeIfLessThanZero() {
        item = new OtherItem(Item.OTHER, 10, 0);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.OTHER, 9, 0);
    }

    @Test
    public void otherProductSellInDecreasesByOneAndQualityDecreasesByTwoWhenSellInEqualsZero() {
        item = new OtherItem(Item.OTHER, 0, 10);
        createItemArray();
        createAppAndUpdateItems();
        assertEquals(Item.OTHER, -1, 8);
    }
}