package ru.jenia.orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Orders {
    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean replacement = index != -1;
        if (replacement) {
            item.setId(id);
            items.set(index, item);
        }
        return replacement;
    }

    public List<Item> findAll() {
       return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean replacement = index != -1;
        if (replacement) {
            items.remove(index);
        }
        return replacement;
    }
}