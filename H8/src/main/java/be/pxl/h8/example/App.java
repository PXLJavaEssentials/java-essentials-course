package be.pxl.h8.example;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Readable> reads = new ArrayList<>();
        reads.add(new Book("Gardens of the Moon", new Author("Stephen", "Erikson", 12), 712, Genre.FANTASY));
        reads.add(new Newspaper("The Daily Mirror"));

        for(Readable read:reads) {
            read.read();
        }
    }
}
