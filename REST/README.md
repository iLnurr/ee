---------------------
Install derby on Ubuntu 16.04:
1. download db-derby-10.13.1.1-bin.tar.gz to home/<user>
2. mkdir /opt/Apache 
3. cp db-derby-10.13.1.1-bin.tar.gz /opt/Apache 
4. cd /opt/Apache 
5. tar xzvf db-derby-10.13.1.1-bin.tar.gz
6. export DERBY_INSTALL=/opt/Apache/db-derby-10.13.1.1-bin
7. export DERBY_HOME=/opt/Apache/home-database
8. export CLASSPATH=$DERBY_INSTALL/lib/derby.jar:$DERBY_INSTALL/lib/derbytools.jar:.
9. cd $DERBY_INSTALL/bin
10. . setEmbeddedCP
11. export CLASSPATH=$DERBY_INSTALL/lib/derbytools.jar:$DERBY_INSTALL/lib/derbynet.jar:.
12. cd $DERBY_INSTALL/bin 
13. . setNetworkServerCP
14. ./startNetworkServer
DO NOT close terminal - it is DERBY NETWORK SERVER

verify
1. java org.apache.derby.tools.sysinfo

check classpath 
1. echo $CLASSPATH

Startup ij
0. cd /opt/Apache/db-derby-10.13.1.1-bin/bin
1. ij

create database in ij
1. connect 'jdbc:derby://localhost:1527/REST-DB;create=true';
_______________________________________________________

Package war with maven
0.1. cd REST
0.2. mvn clean compile
0.3. mvn package

_______________________________________________________

3. Deploy and run application

variant #1: 
Start GlassFish:
sudo /opt/glassfish4/bin/asadmin start-domain
Deploy war file:
sudo /opt/glassfish4/bin/asadmin deploy /home/ilnur/IdeaProjects/ee/REST/target/REST-1.0.0-SNAPSHOT.war

variant #2:
using IntellijIdea configuration (GlassFish local)

4. go to http://localhost:8080/REST-1.0.0-SNAPSHOT/rs/book