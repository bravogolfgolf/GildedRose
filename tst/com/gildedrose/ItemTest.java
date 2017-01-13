package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void agedBrieSellInChangesProperly() {
        Item item = new CheeseItem("Aged Brie", 10, 50);
        assertEquals("Aged Brie, 10, 50", item.toString());
    }

}
