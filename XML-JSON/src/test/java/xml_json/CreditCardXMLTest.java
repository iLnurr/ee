package xml_json;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CreditCardXMLTest {
    @Test
    public void shouldMarshallACreditCard() throws JAXBException, IOException {
        CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(CreditCard.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(creditCard, writer);

        System.out.println(writer);

        String source = "/home/ilnur/IdeaProjects/ee/XML-JSON/src/main/resources/creditCard.xml";
        Path xmlPath = Paths.get(source);
        String xmlString = new String(Files.readAllBytes(xmlPath), Charset.forName("UTF-8"));

        assertEquals(xmlString.trim(), writer.toString().trim());
    }

    @Test
    public void shouldUnmarshallACreditCard() throws JAXBException, IOException {
        String source = "/home/ilnur/IdeaProjects/ee/XML-JSON/src/main/resources/creditCard.xml";
        Path xmlPath = Paths.get(source);
        Reader reader = Files.newBufferedReader(xmlPath, Charset.forName("UTF-8"));

        JAXBContext context = JAXBContext.newInstance(CreditCard.class);
        Unmarshaller u = context.createUnmarshaller();
        CreditCard creditCard = (CreditCard) u.unmarshal(reader);

        assertEquals("12345678", creditCard.getNumber());
        assertEquals("10/14", creditCard.getExpiryDate());
        assertEquals((Object) 566, creditCard.getControlNumber());
        assertEquals("Visa", creditCard.getType());
    }
}
