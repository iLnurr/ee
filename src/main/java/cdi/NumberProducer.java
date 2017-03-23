package cdi;

import javax.enterprise.inject.Produces;
import java.util.Random;

/**
 * Created by ilnur on 23.03.17.
 */
public class NumberProducer {
    @Produces @ThirteenDigits
    private String prefix13digit = "13-";
    @Produces @ThirteenDigits
    private int editorNumber = 65498;
    @Produces @cdi.Random
    public double random(){
        return Math.abs(new Random().nextInt());
    }
}
