package be.pxl.h4.example;

public class Book {

    private String title;
    private Author author;
    private int numberOfPages;

    public Book() {
        this("", new Author());
    }

    public Book(String title, Author author) {
        this(title, author, 0);
    }

    public Book(String title, Author author, int numberOfPages) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", title, author);
    }
}
