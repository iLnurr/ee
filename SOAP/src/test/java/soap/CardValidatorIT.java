package soap;

import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardValidatorIT {
    @Test
    public void shouldCheckCreditCardValidity() throws MalformedURLException {
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator());
        assertTrue(endpoint.isPublished());
        assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

        URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
        String namespaceURI = "http://soap/";
        String servicePart = "CardValidatorService";
        String portName = "CardValidatorPort";
        QName serviceQN = new QName(namespaceURI, servicePart);
        QName portQN = new QName(namespaceURI, portName);

        Service service = Service.create(wsdlDocumentLocation, serviceQN);
        Validator cardValidator = service.getPort(portQN, Validator.class);

        CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");
        assertTrue("Credit card is valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertFalse("Credit card is not valid", cardValidator.validate(creditCard));

        endpoint.stop();
        assertFalse(endpoint.isPublished());
    }
}
