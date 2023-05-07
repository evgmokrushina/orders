package ru.jenia.poly;

public interface Transport {
    void go();

    void passengers(int number);

    double refuel(double oil, double price);
}
