---------------------
Install GlassFish 4  on Ubuntu 16.04:
1. cd /opt
2. wget http://download.java.net/glassfish/4.1.1/release/glassfish-4.1.1.zip
3. unzip glassfish-4.1.1.zip
4. rm glassfish-4.1.1.zip
5. sudo useradd glassfish -U -s /bin/false
6. sudo chown -R glassfish:glassfish /opt/glassfish4
---------------------------------------------
Start GlassFish:

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

Init DB

