package com.gildedrose;

class CheeseItem extends Item {
    CheeseItem(String name, int sellin, int quality) {
        super(name, sellin, quality);
    }

    @Override
    void UpdateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}

