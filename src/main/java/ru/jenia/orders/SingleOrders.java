package ru.jenia.orders;

import java.util.List;

public class SingleOrders {
    private static Orders orders = null;

    private SingleOrders() {
    }

    public static Orders getOrders() {
        if (orders == null) {
            orders = new Orders();
        }
        return orders;
    }

    public Item add(Item item) {
        return orders.add(item);
    }

    public Item findById(int id) {
        return orders.findById(id);
    }

    public boolean replace(int id, Item item) {
        return orders.replace(id, item);
    }

    public List<Item> findAll() {
        return orders.findAll();
    }

    public List<Item> findByName(String key) {
        return orders.findByName(key);
    }

    public boolean delete(int id) {
        return orders.delete(id);
    }
}
