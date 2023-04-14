package ru.jenia.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        Error error = new Error(true, 1, "Конструктор работает");
        Error error1 = new Error(false, 2, "Конструктор работает");
        errorDefault.printInfo();
        error.printInfo();
        error1.printInfo();
    }
}
