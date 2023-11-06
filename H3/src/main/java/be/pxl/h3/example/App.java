package be.pxl.h3.example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Gardens of the Moon", "Stephen Erikson", 712, LocalDate.of(1999,4,1)));
        books.add(new Book("The Hitchhikers Guide to the Galaxy", "Douglas Adams", 216, LocalDate.of(1979,10,12)));
        books.add(new Book("The Gunslinger", "Stephen King", 224, LocalDate.of(1982,6,30)));

        for(Book book:books) {
            System.out.println(book);
        }
    }
}
