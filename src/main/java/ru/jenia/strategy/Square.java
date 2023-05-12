package ru.jenia.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    " ______ " + ln
                + "|      |" + ln
                + "|      |" + ln
                + " ------ " + ln;
    }
}
