package ru.jenia.orders;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Orders orders = new Orders();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        assertThat(orders.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        Orders orders = new Orders();
        Item item = orders.add(new Item("Replaced item"));
        String editedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), editedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, orders, actions);
        assertThat(orders.findById(item.getId()).getName()).isEqualTo(editedName);
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Orders orders = new Orders();
        Item item = orders.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, orders, actions);
        assertThat(orders.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Orders orders = new Orders();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        );
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Item one = orders.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Item one = orders.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Item one = orders.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", one.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Item one = orders.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenShowAllIsNull() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Хранилище ещё не содержит заявок" + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByNameNotFound() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Item one = orders.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "test2", "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявки с именем: test2 не найдены." + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByIdNotFound() {
        Output out = new StubOutput();
        Orders orders = new Orders();
        Item one = orders.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(2), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, orders, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с введенным id: 2 не найдена." + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
        );
    }
}