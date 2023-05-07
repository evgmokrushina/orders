package ru.jenia.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Количество пассажиров: " + number);
    }

    @Override
    public double refuel(double oil, double price) {
        return oil * price;
    }
}
