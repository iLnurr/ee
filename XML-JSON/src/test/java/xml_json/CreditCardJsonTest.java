package xml_json;

import org.junit.Test;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CreditCardJsonTest {
    @Test
    public void shouldGenerateACreditCard() throws IOException {

        CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");

        StringWriter writer = new StringWriter();
        JsonGenerator generator = Json.createGenerator(writer);
        generator.writeStartObject()
                .writeStartObject("creditCard")
                .write("number", creditCard.getNumber())
                .write("expiryDate", creditCard.getExpiryDate())
                .write("controlNumber", creditCard.getControlNumber())
                .write("type", creditCard.getType())
                .writeEnd()
                .writeEnd()
                .close();

        System.out.println(writer);

        String source = "/home/ilnur/IdeaProjects/ee/XML-JSON/src/main/resources/creditCard.json";
        Path jsonPath = Paths.get(source);
        String jsonString = new String(Files.readAllBytes(jsonPath), Charset.forName("UTF-8"));

        assertEquals(jsonString.trim(), writer.toString().trim());

    }
}
