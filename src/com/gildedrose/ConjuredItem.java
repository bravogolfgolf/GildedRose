package com.gildedrose;

class ConjuredItem extends Item {
    ConjuredItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    void UpdateQuality() {
        sellIn -= 1;

        quality -= 2;

        if (quality < 0)
            quality = 0;
    }
}
