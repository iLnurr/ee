package cdi;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Created by ilnur on 23.03.17.
 */
@Loggable
public class BookService {
    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;
    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
