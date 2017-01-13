package com.gildedrose;

class OtherItem extends Item {
    OtherItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    void UpdateQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = quality - 1;
        }
    }
}
