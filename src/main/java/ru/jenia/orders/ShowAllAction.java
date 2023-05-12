package ru.jenia.orders;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Orders orders) {
        System.out.println("=== Show all items ===");
        Item[] items = orders.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище ещё не содержит заявок");
        }
        return true;
    }
}
