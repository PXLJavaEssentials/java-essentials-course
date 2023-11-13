package be.pxl.h3.example;

public class Mail {
    private String title;
    private String content;

    private Contact from;
    private Contact to;

    public Mail(String title, Contact from, Contact to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public Contact getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format("%s [-> %s]", title, to);
    }
}
