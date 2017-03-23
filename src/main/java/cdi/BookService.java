package cdi;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;

/**
 * Created by ilnur on 23.03.17.
 */
public class BookService {
    @Inject
    private NumberGenerator numberGenerator;
    @Inject
    private EntityManager em;
    private Date instanciationDate;
    @PostConstruct
    private void initDate(){
        instanciationDate = new Date();
    }
}
