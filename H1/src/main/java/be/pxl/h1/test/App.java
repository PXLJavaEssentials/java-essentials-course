package be.pxl.h1.test;

import java.util.Random;

public class App {

    public static void main(String[] args) {

        System.out.println("Checking systems...");
        Random random = new Random();
        for(int i=0;i<10;i++) {
            String module = "";
            for(int m=0;m<6;m++) {
                module += (char) ('a'+random.nextInt(26));
            }
            System.out.printf("   > [%s] initialized%n", module);
        }
        System.out.println("All systems initialized. Ready to go!");

        char c = 'S';

        System.out.println(c);
        System.out.println(c+1);
        c = (char) (c+1);
        System.out.println(c);
    }
}
