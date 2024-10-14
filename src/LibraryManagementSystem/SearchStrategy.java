package LibraryManagementSystem;

import java.util.List;

interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}