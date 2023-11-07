package be.pxl.h3.example;

import java.time.LocalDate;
import java.util.Random;

public class Book {

    private String title;
    private String author;
    private int numberOfPages;
    private LocalDate releaseDate;

    public Book() {
        this("", "");
    }

    public Book(String title, String author) {
        this(title, author, 0);
    }

    public Book(String title, String author, int numberOfPages) {
        this(title, author, numberOfPages, LocalDate.of(2020,4,30));
    }

    public Book(String title, String author, int numberOfPages, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getRandomPage() {
        Random random = new Random();
        return random.nextInt(0, numberOfPages);
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", title, author);
    }
}
