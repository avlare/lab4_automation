package org.example;

public class Book extends Publication {
    private String ISBN;

    public Book(String author, String title, int year, String ISBN) {
        super(author, title, year);
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
