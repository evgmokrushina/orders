package ru.jenia.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }

    @Override
    public void passengers() {
        System.out.println("Автобус вмещает 36 пассажиров");
    }
}
