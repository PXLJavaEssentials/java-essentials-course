package be.pxl.h2.example;

import be.pxl.guts.junit_5.GutsFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@GutsFixture(courseCode = "javaEss1", chapterCode = "H2", exerciseCode = "Example", sourceCodeRelativeFilePaths = "Book.java")
public class BookTest {

    @Test
    @DisplayName("Book - default constructor should store empty string as title & author")
    public void testBook_DefaultConstructor() {
        Book book = new Book();

        assertEquals("", book.getTitle());
        assertEquals("", book.getAuthor());
    }

    @Test
    @DisplayName("Book - constructor with 2 parameters should store title & author")
    public void testBook_Constructor2() {
        Book book = new Book("The Bonehunters", "Steven Erikson");

        assertEquals("The Bonehunters", book.getTitle());
        assertEquals("Steven Erikson", book.getAuthor());
    }

    @Test
    @DisplayName("Book - setters and getters")
    public void testBook_SettersAdnGetters() {
        Book book = new Book();

        book.setTitle("The Bonehunters");
        book.setAuthor("Steven Erikson");
        book.setNumberOfPages(1200);

        assertEquals("The Bonehunters", book.getTitle());
        assertEquals("Steven Erikson", book.getAuthor());
        assertEquals(1200, book.getNumberOfPages());
    }

    @Test
    @DisplayName("Book - toString should show book title and author correctly")
    public void testBook_ToString() {
        Book book = new Book();

        book.setTitle("The Bonehunters");
        book.setAuthor("Steven Erikson");
        book.setNumberOfPages(1200);

        assertEquals("The Bonehunters [Steven Erikson]", book.toString());
    }
}
