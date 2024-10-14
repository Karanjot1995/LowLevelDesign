package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

class SearchByISBN implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(keyword)) {
                result.add(book);
            }
        }
        return result;
    }
}
