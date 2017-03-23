package cdi;

import javax.enterprise.inject.Alternative;

/**
 * Created by ilnur on 23.03.17.
 */
@Alternative
public class MockGenerator implements NumberGenerator {
    public String generateNumber() {
        return "mock";
    }
}
