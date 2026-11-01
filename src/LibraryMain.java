
public class LibraryMain {

    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("Anna", 20);
        User user2 = new User("David", 22);

        library.addUser(user1);
        library.addUser(user2);

        library.displayUsers();

        System.out.println();
        library.displayBooks();

        System.out.println();
        user1.borrowBook(library, "Data Structures and Algorithms");

        System.out.println();
        user1.displayBorrowedBooks();

        System.out.println();
        System.out.println("Is the book available? "
                + library.isBookAvailable("Data Structures and Algorithms"));

        System.out.println();
        user1.returnBook(library, book2);

        System.out.println();
        user1.displayBorrowedBooks();

        System.out.println();
        System.out.println("Is the book available? "
                + library.isBookAvailable("Data Structures and Algorithms"));

        System.out.println();
        library.displayBooks();
    }
}
