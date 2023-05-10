package ru.jenia.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд передвигается по рельсам");
    }

    @Override
    public void passengers() {
        System.out.println("Поезд \"Ласточка\" вмещает 400 пассажиров");
    }
}
