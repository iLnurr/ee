package soap;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardValidatorTest {
    @Test
    public void shouldCheckCreditCardValidity() {
        CardValidator cardValidator = new CardValidator();
        CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
        assertTrue("Credit card is valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertFalse("Credit card is not valid", cardValidator.validate(creditCard));
    }
}
