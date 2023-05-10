package ru.jenia.orders;

public class StartUI {
    public static void createItem(Input input, Orders orders) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        orders.add(item);
        System.out.println("Добавленная заявка: " + item);
    }

    public static void showAllItems(Orders orders) {
        System.out.println("=== Show all items ===");
        Item[] items = orders.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище ещё не содержит заявок");
        }
    }

    public static void editItem(Input input, Orders orders) {
        System.out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (orders.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
    }

    public static void deleteItem(Input input, Orders orders) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (orders.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
    }

    public static void findItemById(Input input, Orders orders) {
        System.out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = orders.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
    }

    public static void findItemByName(Input input, Orders orders) {
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
    }

    public void init(Input input, Orders orders) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, orders);
            } else if (select == 1) {
                StartUI.showAllItems(orders);
            } else if (select == 2) {
                StartUI.editItem(input, orders);
            } else if (select == 3) {
                StartUI.deleteItem(input, orders);
            } else if (select == 4) {
                StartUI.findItemById(input, orders);
            } else if (select == 5) {
                StartUI.findItemByName(input, orders);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Orders orders = new Orders();
        new StartUI().init(input, orders);
    }
}
