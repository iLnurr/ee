---------------------
Install GlassFish 4  on Ubuntu 16.04:
1. cd /opt
2. wget http://download.java.net/glassfish/4.1.1/release/glassfish-4.1.1.zip
3. unzip glassfish-4.1.1.zip
4. rm glassfish-4.1.1.zip
5. sudo useradd glassfish -U -s /bin/false
6. sudo chown -R glassfish:glassfish /opt/glassfish4
---------------------------------------------
Start GlassFish
7. /opt/glassfish4/bin/asadmin start-domain

then open http://localhost:4848/

---------------------------------------------
Stop GlassFish
8. /opt/glassfish4/bin/asadmin stop-domain

---------------------------------------------

Change pass and login (fisrt in)
9. /opt/glassfish4/bin/asadmin change-admin-password

I set: login - `admin` and password - `admin`

10. /opt/glassfish4/bin/asadmin enable-secure-admin

Restart
11. /opt/glassfish4/bin/asadmin restart-domain

---------------------------------------------

To run these examples you must have GlassFish running and create the following administered objects :

To manage JMS connection factories using the command-line utility, use create-jms-resource, list-jms-resources, or delete-jms-resource command

> create-jms-resource --restype javax.jms.ConnectionFactory jms/ee/ConnectionFactory
> create-jms-resource --restype javax.jms.Topic jms/ee/Topic
> create-jms-resource --restype javax.jms.Queue jms/ee/Queue

asadmin> list-jms-resources
jms/ee/Topic
jms/ee/ConnectionFactory

After building with Maven, deploy the MDB with the following command
> asadmin deploy JMS-1.0.0-SNAPSHOT.jar

If the deployment is successful, the following command should return the name of the deployed jar
> asadmin list-components

_____________________________________________

Run example:

> java -cp JMS/target/classes/jms/first_variant OrderConsumer
> java -cp JMS/target/classes/jms/first_variant OrderProducer 2000
