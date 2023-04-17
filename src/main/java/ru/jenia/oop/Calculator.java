package ru.jenia.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public static int sum(int y) {
        return y + x;
    }

    public int multiply(int y) {
        return y * x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + divide(y) + minus(y) + multiply(y);
    }

    public static void main(String[] args) {
        int substraction = Calculator.minus(10);
        int addition = Calculator.sum(10);
        Calculator calculator = new Calculator();
        int div = calculator.divide(10);
        int mult = calculator.multiply(10);
        int all = calculator.sumAllOperation(10);
    }
}
