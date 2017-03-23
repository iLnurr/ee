package cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by ilnur on 23.03.17.
 */
public class BookService {
    @Inject
    Logger log;
    @Inject @Default
    private NumberGenerator numberGenerator;
    @Inject
    private EntityManager em;
    private Date instanciationDate;
    @PostConstruct
    private void initDate(){
        instanciationDate = new Date();
    }
    @Transactional
    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setIsbn(numberGenerator.generateNumber());
        book.setInstanciationDate(instanciationDate);
        em.persist(book);
        return book;
    }
}
