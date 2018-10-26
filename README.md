# JerseySocket

JerseySocket is a REST service to demonstrate websocket 

JerseySocket supports Tomcat password hashing using HashiCrop Vault

See: https://github.com/fhsiao/tomcat-vault


## Installation:

Add:
```
org.apache.tomcat.util.digester.PROPERTY_SOURCE=com.ztalk.tomcatvault.TomcatPropertyDecoder
```
To ${TOMCAT_HOME}/conf/catalina.properties


Add:

```
<user username="${-U res1=admin|-P res1=secret/user}" password="${-U res1=admin1|-P res1=secret/pass}" roles="manager-gui" />
```
To ${TOMCAT_HOME}/conf/tomcat-users.xml


Add:
```
    <Resource name="jdbc/mysql"
        auth="Container"
        url="jdbc:mysql://172.17.0.3:3306/test"
        username="${-U tomcat1=tomcat1|-P tomcat1=secret/user}"
        password="${-U tomcat2=tomcat1|-P tomcat2=secret/pass}"
        driverClassName="com.mysql.jdbc.Driver"
        type="javax.sql.DataSource"
        factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
        initialSize="10"
        maxActive="5"
        maxIdle="5"
        minIdle="2"
        testWhileIdle="true"
        removeAbandoned="false"
        removeAbandonedTimeout="600"
        logAbandoned="true"
        testOnBorrow="true"
        validationInterval="60000"
    />
 ```
To ${TOMCAT_HOME}/conf/context.xml


## Libraries:
Add vault-java-driver-3.1.0.jar to ${TOMCAT_HOME}/lib

Add commons-cli-1.4.jar to ${TOMCAT_HOME}/lib

Add mysql-connector-java-8.0.12.jar to ${TOMCAT_HOME}/lib                                                                                                                         
 
Add jersey-bundle-1.19.3.jar to ${TOMCAT_HOME}/lib
 
Add commons-cli-1.4.jar to ${TOMCAT_HOME}/lib

## Test

If the ROOT is applied in the ${TOMCAT_HOME}/webapps,

http://{host_ip}/tomcat-vault/vault/getVault is used to test password responded back from your Vault server.

