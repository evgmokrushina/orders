package ru.jenia.orders;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Orders orders) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = orders.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
