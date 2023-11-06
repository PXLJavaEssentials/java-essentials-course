package be.pxl.h8.example;

public class Book implements Readable {

    private String title;
    private Author author;
    private int numberOfPages;
    private Genre genre;

    public Book() {
        this("", new Author());
    }

    public Book(String title, Author author) {
        this(title, author, 0);
    }

    public Book(String title, Author author, int numberOfPages) {
        this(title, author, numberOfPages, Genre.DRAMA);
    }

    public Book(String title, Author author, int numberOfPages, Genre genre) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) [%s]", title, genre, author);
    }

    @Override
    public void read() {
        System.out.println("Reading " + title + " by " + author);
    }
}
