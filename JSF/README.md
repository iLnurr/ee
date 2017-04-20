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

Start Derby
1. cd $DERBY_HOME/bin
2. ./startNetworkServer

Create database
1. cd $DERBY_HOME/bin
2. ij
3. connect 'jdbc:derby:memory:lab11db;create=true'

Start GlassFish
1.  sudo /home/ilnur/glassfish4/bin/asadmin start-domain

Deploy war file
1. sudo /home/ilnur/glassfish4/bin/asadmin deploy /home/ilnur/JSF.war


