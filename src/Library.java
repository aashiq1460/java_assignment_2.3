
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);

            System.out.println((i + 1) + ". Title: \"" + book.getTitle()
                    + "\", Author: \"" + book.getAuthor()
                    + "\", Year: " + book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Title: \"" + book.getTitle()
                        + "\", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Borrowed: " + title);
                return;
            }
        }

        System.out.println("Book not available: " + title);
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Returned: " + book.getTitle());
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }

        return false;
    }

    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0;
        }

        double totalRating = 0;

        for (Book book : books) {
            totalRating += book.getRating();
        }

        return totalRating / books.size();
    }

    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        Book mostReviewed = books.get(0);

        for (Book book : books) {
            if (book.getReviews().size() > mostReviewed.getReviews().size()) {
                mostReviewed = book;
            }
        }

        return mostReviewed;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }

        return null;
    }

    public void displayUsers() {
        System.out.println("Library Users:");

        for (User user : users) {
            System.out.println(user.getName() + ", Age: " + user.getAge());
        }
    }

    public void borrowBook(User user, String title) {

        if (!users.contains(user)) {
            System.out.println("User is not registered.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {

                books.remove(book);
                user.addBorrowedBook(book);

                System.out.println(user.getName() + " borrowed: " + title);
                return;
            }
        }

        System.out.println("Book not available: " + title);
    }

    public void returnBook(User user, Book book) {

        if (!users.contains(user)) {
            System.out.println("User is not registered.");
            return;
        }

        if (user.getBorrowedBooks().contains(book)) {

            user.removeBorrowedBook(book);
            books.add(book);

            System.out.println(user.getName() + " returned: " + book.getTitle());

        } else {
            System.out.println("This book was not borrowed by " + user.getName());
        }
    }
}
