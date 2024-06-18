package org.example;
public class Publication {
    private String author;
    private String title;
    private int year;

    public Publication(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return year;
    }

    public void setYearPublished(int year) {
        this.year = year;
    }
}
