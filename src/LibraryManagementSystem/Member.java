package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

class Member extends User {
    private List<Book> borrowedBooks;

    public Member(String name, String userId) {
        super(name, userId);
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (book.getStatus() == BookStatus.AVAILABLE) {
            borrowedBooks.add(book);
            book.setStatus(BookStatus.BORROWED);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setStatus(BookStatus.AVAILABLE);
            System.out.println("Book returned: " + book.getTitle());
        }
    }

    @Override
    public UserType getUserType() {
        return UserType.MEMBER;
    }
}
