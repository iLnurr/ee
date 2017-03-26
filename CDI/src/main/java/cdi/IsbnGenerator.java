package cdi;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by ilnur on 23.03.17.
 */
@ThirteenDigits
@Loggable
public class IsbnGenerator implements NumberGenerator{
    @Inject
    Logger logger;
    @Inject @ThirteenDigits
    private String prefix;
    @Inject @ThirteenDigits
    private int editorNumber;
    @Inject @Random
    private double postfix;
    public String generateNumber() {
        String result= prefix + editorNumber + postfix;
        logger.info("gen-ted isbn" + result);
        return result;
    }
}
