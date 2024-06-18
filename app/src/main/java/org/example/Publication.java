package org.example;

@GenerateLibrary()
public class Publication {
    @Validation(notEmpty = true)
    private String author;
    private String title;
    @Validation(min = 1500, max = 2024)
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

    @Override
    public String toString(){
        return "Author: " + author + "; Title: " + title + "; Year: " + year;
    }
}
