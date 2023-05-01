package ru.jenia.orders;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item one = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String created = one.getCreated().format(formatter);
        System.out.println(created);
        Item two = new Item(1, "second");
        System.out.println(two);
    }
}
