package be.pxl.h7.example;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {

        String text = "06/11/23";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate date = LocalDate.parse(text, parser);

        System.out.println(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy");
        String s = formatter.format(date);

        System.out.println(s);
    }
}
