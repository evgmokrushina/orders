package ru.jenia.orders;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Orders orders) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (orders.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
