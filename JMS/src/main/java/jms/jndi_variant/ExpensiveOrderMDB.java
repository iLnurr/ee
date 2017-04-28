package jms.jndi_variant;

import jms.OrderDTO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/ee/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000")
})
public class ExpensiveOrderMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Big order received: " + order.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
