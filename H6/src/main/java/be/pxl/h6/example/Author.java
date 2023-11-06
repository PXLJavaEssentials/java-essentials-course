package be.pxl.h6.example;

public class Author extends Person{

   private int numberOfBooks;

   public Author() {
       this(0);
   }

   public Author(int numberOfBooks) {
       this.numberOfBooks = numberOfBooks;
   }

   public Author(String firstName, String lastName, int numberOfBooks) {
       super(firstName, lastName);
       this.numberOfBooks = numberOfBooks;
   }

   public int getNumberOfBooks() {
       return numberOfBooks;
   }

   public void setNumberOfBooks(int numberOfBooks) {
       this.numberOfBooks = numberOfBooks;
   }
}
