package cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by ilnur on 23.03.17.
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
    @Inject
    private Logger logger;
    @Loggable
    public String generateNumber() {
        String mock = "mock";
        logger.info("gen-ted mock" + mock);
        return mock;
    }
}
