package ru.jenia.orders;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Orders orders = new Orders();
        StartUI.createItem(input, orders);
        Item created = orders.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    public void whenEditItem() {
        Orders orders = new Orders();
        Item item = new Item("new item");
        orders.add(item);
        String[] answers = {
                String.valueOf(item.getId()), "edited item"
        };
        StartUI.editItem(new StubInput(answers), orders);
        Item edited = orders.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("edited item");
    }

    @Test
    public void whenDeleteItem() {
        Orders orders = new Orders();
        Item item = new Item("Delete item");
        orders.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        StartUI.deleteItem(new StubInput(answers), orders);
        Item deleted = orders.findById(item.getId());
        Assert.assertEquals(deleted, null);
    }
}