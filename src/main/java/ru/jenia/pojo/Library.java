package ru.jenia.pojo;

public class Library {
    private void printInfo(Book[] books) {
        for (Book book : books) {
            System.out.println("Книга: " + book.getName()
                    + "; Количество страниц: " + book.getPages());
        }
    }

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
        Library bk = new Library();
        bk.printInfo(books);
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        bk.printInfo(books);
        System.out.println();
        String unknown = "Clean Code";
        for (Book book : books) {
            if (book.getName().equals(unknown)) {
                System.out.println("Книга: " + book.getName()
                        + "; Количество страниц: " + book.getPages());
                break;
            }
        }
    }
}
