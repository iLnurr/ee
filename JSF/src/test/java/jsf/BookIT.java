package jsf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookIT {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
    private EntityManager em;
    private EntityTransaction tx;
    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    @After
    public void closeEntityManager() throws Exception {
        if (em != null) em.close();
    }
    @Test
    public void shouldFindJavaee7Book() throws Exception {
        Book book = em.find(Book.class, 1001L);
        assertEquals("Beginning Java EE 7", book.getTitle());
    }
    @Test
    public void shouldCreateH2G2Book() throws Exception {
        Book book = new Book("H2G2", "Автостопом по галактике", 12.5F, 354, false);

        tx.begin();
        em.persist(book);
        tx.commit();

        assertNotNull("ID не должен быть null", book.getId());
        assertEquals("Автостопом по галактике", book.getDescription());
    }
    @Test(expected = ValidationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {
        Book book = new Book(null, "Пустое название - ошибка", 12.5F, 354, false);
        em.persist(book);
    }

}
