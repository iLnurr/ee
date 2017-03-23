package cdi;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Created by ilnur on 23.03.17.
 */
@Default
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator{
    @Inject @ThirteenDigits
    private String prefix;
    @Inject @ThirteenDigits
    private int editorNumber;
    @Inject @Random
    private double postfix;
    public String generateNumber() {
        return prefix + editorNumber + postfix;
    }
}
