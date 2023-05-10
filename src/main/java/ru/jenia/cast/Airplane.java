package ru.jenia.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void passengers() {
        System.out.println("Самолет вмещает 100 пассажиров");
    }
}
