package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

class LibraryManagementSystem {
    private static LibraryManagementSystem instance;
    private List<Book> catalog;
    private ReservationObserver reservationNotifier;

    private LibraryManagementSystem() {
        catalog = new ArrayList<>();
        reservationNotifier = new ReservationNotifier();
    }

    public static LibraryManagementSystem getInstance() {
        if (instance == null) {
            instance = new LibraryManagementSystem();
        }
        return instance;
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void removeBook(Book book) {
        catalog.remove(book);
    }

    public List<Book> searchBooks(SearchStrategy searchStrategy, String keyword) {
        return searchStrategy.search(catalog, keyword);
    }

    public void notifyReservation(Book book) {
        reservationNotifier.update(book);
    }
}


