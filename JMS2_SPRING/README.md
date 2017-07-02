Application Overview

We have two Spring based java-applications. 

First one is a Spring MVC application [A Web-shop] where you can buy a product online. Once you have placed your order [means order status is 'created'], Web-shop application sends this order to an Inventory application [which is a Spring MVC based application, deployed as war] using JMS queue [named as 'order-queue'] via ActiveMQ Message broker, and configures a Listener on response queue [named as 'order-response-queue'] to get the order confirmation from Inventory application. Inventory application, which was listing on order queue ['order-queue'], gets the order, and process it. It then sends the confirmation on the response queue ['order-response-queue']. On receiving the order response, the Web-shop updates the order status in it’s repository.


1. Download acive mq from http://activemq.apache.org/
2. cd ${ACTIVEMQ_HOME}
3. start it: ./bin/activemq start
4. deploy both apps to container - tomcat
5. check activeMQ from http://localhost:8161/admin/ with credentials: admin/admin and both apps

