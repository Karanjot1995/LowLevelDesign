package LibraryManagementSystem;
import java.util.List;

/*
Design Patterns Used:

Factory Pattern: The Factory Pattern is used to create users (members and librarians).
Where: UserFactory class for creating different types of users.

Strategy Pattern: The Strategy Pattern is used to allow different search strategies (by title, author, or ISBN).
Where: SearchStrategy interface and its implementations (SearchByTitle, SearchByAuthor, SearchByISBN).

Observer Pattern: The Observer Pattern is used to notify users when reserved books become available or when due dates are approaching.
Where: ReservationObserver interface and ReservationNotifier class.

Singleton Pattern: The Singleton Pattern ensures that there is only one instance of the LibraryManagementSystem class.

Where: LibraryManagementSystem class.
 */

public class LibraryManagementDemo {
    public static void main(String[] args) {
        // Initialize the library management system
        LibraryManagementSystem library = LibraryManagementSystem.getInstance();

        // Add books to the library catalog
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "987654321");
        library.addBook(book1);
        library.addBook(book2);

        // Create a librarian and add a new book to the library
        Librarian librarian = (Librarian) UserFactory.createUser(UserType.LIBRARIAN, "Libby", "L123");
        Book newBook = new Book("1984", "George Orwell", "1122334455");
        librarian.addBook(newBook, library);

        // Search for a book by title
        System.out.println("\nSearching for '1984':");
        List<Book> foundBooks = library.searchBooks(new SearchByTitle(), "1984");
        for (Book book : foundBooks) {
            System.out.println(book);
        }

        // Create a member and borrow a book
        Member member = (Member) UserFactory.createUser(UserType.MEMBER, "John Doe", "M456");
        System.out.println("\nJohn tries to borrow 'The Great Gatsby':");
        member.borrowBook(book1);

        // Attempt to borrow the same book again (should not be available)
        System.out.println("\nAttempting to borrow 'The Great Gatsby' again:");
        member.borrowBook(book1);

        // Return the borrowed book
        System.out.println("\nJohn returns 'The Great Gatsby':");
        member.returnBook(book1);

        // John tries to borrow the book again after returning
        System.out.println("\nJohn tries to borrow 'The Great Gatsby' again:");
        member.borrowBook(book1);

        // Reserve a book
        System.out.println("\nJohn reserves 'To Kill a Mockingbird':");
        book2.setStatus(BookStatus.RESERVED);
        library.notifyReservation(book2);

        // Librarian removes a book
        System.out.println("\nLibrarian removes '1984' from the library:");
        librarian.removeBook(newBook, library);
    }
}

