package org.example;

public class Newspaper extends Publication {

    private int releaseNumber;

    public Newspaper(String author, String title, int year, int releaseNumber) {
        super(author, title, year);
        this.releaseNumber = releaseNumber;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }
}
