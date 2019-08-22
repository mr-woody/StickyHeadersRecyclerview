package com.okay.sampletamplate.sample;

import com.okay.sampletamplate.sample.modle.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemGenerator {

    private ItemGenerator() {

    }

    static List<Item> largeListWithHeadersAt(int... positions) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (inArray(positions, i)) {
                items.add(new Item("Header at " + i, ""));
            } else {
                items.add(new Item("Item at " + i, "Item description at " + i));
            }
        }
        return items;
    }

    static List<Item> twoWithHeader() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("header", ""));
        items.add(new Item("Item", ""));
        return items;
    }

    public static List<Item> demoList() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i==0 || i == 2 || (i % 4 == 0 && i > 0)) {
                items.add(new Item("Header at " + i, ""));
            } else {
                items.add(new Item("Item at " + i, "Item description at " + i));
            }
        }
        return items;
    }

    private static boolean inArray(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}
