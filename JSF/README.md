---------------------
Install derby on Ubuntu 16.04:
1. sudo apt-get install sun-javadb-client sun-javadb-core
2. sudo nano /etc/environment
    then add:
    export DERBY_HOME=/usr/share/javadb
3. source /etc/environment
4. echo $DERBY_HOME
5. add permission to socketConncetion on port 1527:
  in path $JAVA_HOME\jre\lib\security\java.policy add 
  grant {
    permission java.net.SocketPermission "localhost:1527", "listen";
  };
6. cd $DERBY_HOME/bin
7. sudo chmod 755 dblook ij NetworkServerControl 
7. sudo ./startNetworkServer

---------------------------------------------

1. Start Derby
1.1. cd $DERBY_HOME/bin
1.2. ./startNetworkServer

2. Create database
2.1. cd $DERBY_HOME/bin
2.2. ij
2.3. connect 'jdbc:derby:memory:lab11db;create=true'

3. Deploy and run application

  1 variant: Start GlassFish
sudo /home/ilnur/glassfish4/bin/asadmin start-domain
Deploy war file
sudo /home/ilnur/glassfish4/bin/asadmin deploy /home/ilnur/JSF.war

  2 variant:
using IntellijIdea configuration (GlassFish local)

4. go to localhost:8080/JSF-1.0.0-SNAPSHOT/newBook.faces




