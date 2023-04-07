package ru.jenia.orders;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OrdersTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Orders orders = new Orders();
        Item item = new Item();
        item.setName("test1");
        orders.add(item);
        Item result = orders.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
}