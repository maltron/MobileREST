# Creating Database and inserting some data in it
mysql -u mauricio -p < create-database.sql
# Symbolic link for MySQL Driver into GlassFish
ln -sv /home/mauricio/java/api/jdbc/mysql/mysql.jar /home/mauricio/java/server/AS/glassfish/open/current/glassfish/domains/domain1/lib/
# Creating JDBC Connection Pool
asadmin create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=mauricio:password=maltron:DatabaseName=PERSON_DATA:ServerName=localhost:port=3306 PersonPool
# Creating JNDI regarding the Connection Pool
asadmin create-jdbc-resource --connectionpoolid PersonPool "jdbc/Person"
# Creating JMS for Notification
#asadmin create-jms-resource --restype javax.jms.Queue jms/QueueNotification
#asadmin create-jms-resource --restype javax.jms.QueueConnectionFactory jms/QueueConnectionNotification 
