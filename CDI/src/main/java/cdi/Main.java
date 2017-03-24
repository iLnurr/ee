package cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Created by ilnur on 23.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("JEE", 10.5f,"about java ee7");
        System.out.println(book);
        weld.shutdown();
    }
}
