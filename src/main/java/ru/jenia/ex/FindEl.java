package ru.jenia.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element Not Found.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] transport = {"car", "bus", "train"};
        try {
            System.out.println(indexOf(transport, "airplane"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
