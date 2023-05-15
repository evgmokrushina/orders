package ru.jenia.orders;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Orders orders = new Orders();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(in, orders, actions);
        assertThat(orders.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenEditItem() {
        Orders orders = new Orders();
        Item item = orders.add(new Item("Replaced item"));
        String editedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), editedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(),
                new ExitAction()
        };
        new StartUI().init(in, orders, actions);
        assertThat(orders.findById(item.getId()).getName()).isEqualTo(editedName);
    }

    @Test
    public void whenDeleteItem() {
        Orders orders = new Orders();
        Item item = orders.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(in, orders, actions);
        assertThat(orders.findById(item.getId())).isNull();
    }
}