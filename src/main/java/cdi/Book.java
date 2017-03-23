package cdi;

import java.util.Date;

/**
 * Created by ilnur on 23.03.17.
 */
public class Book {
    private String title;
    private Float price;
    private String description;
    private String isbn;
    private Date instanciationDate;

    public Book(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setInstanciationDate(Date instanciationDate) {
        this.instanciationDate = instanciationDate;
    }

}
