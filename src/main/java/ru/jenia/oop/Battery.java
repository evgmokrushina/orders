package ru.jenia.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public String about() {
        return "My charge: " + load + "%";
    }

    public void exchange(Battery another) {
        if ((another.load + this.load) > 100) {
            this.load = another.load + this.load - 100;
            another.load = 100;
        } else {
            another.load += this.load;
            this.load = 0;
        }
    }

    public static void main(String[] args) {
        Battery first = new Battery(80);
        Battery second = new Battery(80);
        System.out.println("First." + first.about());
        System.out.println("Second." + second.about());
        first.exchange(second);
        System.out.println("First. " + first.about());
        System.out.println("Second. " + second.about());
    }
}
