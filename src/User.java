
import java.util.ArrayList;

public class User {

    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Library library, String title) {
        library.borrowBook(this, title);
    }

    public void returnBook(Library library, Book book) {
        library.returnBook(this, book);
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");

        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
    }
}
