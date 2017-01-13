package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateItem() {
        for (Item item : items) {
            item.UpdateQuality();
        }
    }

}