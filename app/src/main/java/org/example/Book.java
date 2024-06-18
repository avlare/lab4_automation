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


    @Review(reviewer = "Kitty Cat", date = "01.01.2024", rating = 5)
    public void getReview() {
        System.out.println("Review: " + getTitle());
    }
}
