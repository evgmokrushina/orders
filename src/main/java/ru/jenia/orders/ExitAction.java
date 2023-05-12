package ru.jenia.orders;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Orders orders) {
        return false;
    }
}
