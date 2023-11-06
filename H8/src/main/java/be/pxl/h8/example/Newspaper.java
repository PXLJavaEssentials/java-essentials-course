package be.pxl.h8.example;

public class Newspaper implements Readable {

    private String name;

    public Newspaper(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void read() {
        System.out.println("Reading " + name);
    }
}
