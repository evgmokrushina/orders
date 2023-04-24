package ru.jenia.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code", 100);
        Book theOmen = new Book("The Omen", 500);
        Book psychology = new Book("Psychology", 300);
        Book flock = new Book("Flock", 320);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = theOmen;
        books[2] = psychology;
        books[3] = flock;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Книга: " + bk.getName()
                    + "; Количество страниц: " + bk.getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Книга: " + bk.getName()
                    + "; Количество страниц: " + bk.getPages());
        }
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals(books[3].getName())) {
                System.out.println("Книга: " + bk.getName()
                        + "; Количество страниц: " + bk.getPages());
            }
        }
    }
}
