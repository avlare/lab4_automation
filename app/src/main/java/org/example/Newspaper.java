package org.example;

public class Newspaper extends Publication {
    private int releaseNumber;

    public Newspaper(String author, String title, int year, int releaseNumber) {
        super(author, title, year);
        this.releaseNumber = releaseNumber;
    }

    public int getIssueNumber() {
        return releaseNumber;
    }

    public void setIssueNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }
}
