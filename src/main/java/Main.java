import cdi.NumberGenerator;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * Created by ilnur on 23.03.17.
 */
public class Main {
    @Inject @Default
    private NumberGenerator numberGenerator;
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numberGenerator.generateNumber());
    }
}
