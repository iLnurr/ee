package rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ilnur on 24.05.17.
 * при получении списка книг из базы - JAXB маршаллинг напрямую не проходит, поэтому
 * чтобы иметь xml-представление списка книг - создается POJO class Books аннотированный JAXB
 */
@XmlRootElement
@XmlSeeAlso(Book.class)
public class Books extends ArrayList<Book> {
    public Books() {
        super();
    }
    public Books(Collection<? extends Book> c) {
        super(c);
    }
    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return this;
    }
    public void setBooks(List<Book> books) {
        this.addAll(books);
    }
}
