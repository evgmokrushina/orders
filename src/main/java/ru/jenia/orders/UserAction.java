package ru.jenia.orders;

public interface UserAction {
    String name();

    boolean execute(Input input, Orders orders);
}
