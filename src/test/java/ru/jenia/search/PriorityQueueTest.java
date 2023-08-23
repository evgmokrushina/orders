package ru.jenia.search;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("meow", 5));
        queue.put(new Task("mur", 1));
        queue.put(new Task("gav", 3));
        Task result = queue.take();
        assertThat(result.getDesc()).isEqualTo("mur");
    }

    @Test
    public void whenHigherPriorityEquals() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("meow", 5));
        queue.put(new Task("mur", 5));
        queue.put(new Task("gav", 5));
        Task result = queue.take();
        assertThat(result.getDesc()).isEqualTo("meow");
    }
}