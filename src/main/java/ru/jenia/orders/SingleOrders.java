package ru.jenia.orders;

public class SingleOrders {
    private static Orders oreders = null;

    private SingleOrders() {
    }

    public static Orders getOreders() {
        if (oreders == null) {
            oreders = new Orders();
        }
        return oreders;
    }

    public Item add(Item item) {
        return oreders.add(item);
    }

    public Item findById(int id) {
        return null;
    }

    public boolean replace(int id, Item item) {
        return oreders.replace(id, item);
    }

    public Item[] findAll() {
        return oreders.findAll();
    }

    public Item[] findByName(String key) {
        return oreders.findByName(key);
    }

    public boolean delete(int id) {
        return oreders.delete(id);
    }
}
