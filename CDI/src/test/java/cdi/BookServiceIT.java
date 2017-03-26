package cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by ilnur on 26.03.17.
 */
public class BookServiceIT {
    @Test
    public void shouldCheckNumberIsMock() {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();
        BookService bookService = weldContainer.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "book in test cases");
        assertTrue(book.getNumber().startsWith("MOCK"));
        weld.shutdown();
    }
}
