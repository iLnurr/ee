package jms.jndi_variant;

import jms.OrderDTO;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;

public class OrderProducer {
    public static void main(String[] args) throws NamingException {
        Float totalAmount;
        if (args.length == 1) {
            totalAmount = Float.valueOf(args[0]);
        } else {
            totalAmount = 0.0F;
        }
        OrderDTO order = new OrderDTO(1234L, new Date(), "to person", totalAmount);

        Context jndiContext = new InitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/ee/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/ee/Topic");
        try(JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.createProducer().setProperty("orderAmount", totalAmount).send(topic, order);
        }
    }
}
