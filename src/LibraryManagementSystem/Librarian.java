package LibraryManagementSystem;

class Librarian extends User {
    public Librarian(String name, String userId) {
        super(name, userId);
    }

    public void addBook(Book book, LibraryManagementSystem library) {
        library.addBook(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Book book, LibraryManagementSystem library) {
        library.removeBook(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    @Override
    public UserType getUserType() {
        return UserType.LIBRARIAN;
    }
}
