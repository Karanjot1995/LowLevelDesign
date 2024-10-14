package LibraryManagementSystem;

class ReservationNotifier implements ReservationObserver {
    @Override
    public void update(Book book) {
        System.out.println("Notification: Book " + book.getTitle() + " is now available.");
    }
}
