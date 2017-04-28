package jms.cdi_variant;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;

@MessageDriven(mappedName = "jms/ee/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000")
})
public class BillingMDB implements MessageListener{
    @Inject
    @JMSConnectionFactory("jms/ee/ConnectionFactory")
    @JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
    private JMSContext context;

    @Resource(lookup = "jms/ee/Queue")
    private Destination printingQueue;
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + message.getBody(String.class));
            sendMessage();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        context.createProducer().send(printingQueue, "Message was received and sending again");
    }
}
