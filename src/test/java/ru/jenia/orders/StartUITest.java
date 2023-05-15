package ru.jenia.orders;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Orders orders = new Orders();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, orders, actions);
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
}