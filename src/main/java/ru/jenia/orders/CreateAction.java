package ru.jenia.orders;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Orders orders) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        orders.add(item);
        System.out.println("Добавленная заявка: " + item);
        return true;
    }
}
