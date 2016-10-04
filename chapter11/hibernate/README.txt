           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
* Hibernate 2 can be obtained from http://hibernate.bluemars.net/

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql.
* Copy hibernate2.jar to lib/ext
* Copy the jars from hibernate/lib to lib/ext
* Build the files by running ant.

For this example I have created a manage.bat file that will execute the Manage 
class with any passed arguments.

The commands to run examples are code are:
manage add Employee 10 FName LName eMail
manage add Address  11 line1 line2 city state
manage list Employee "from emp in class com.apress.javapersist.chapter11.hibernate.bo.Employee where emp.id=10"
manage assoc Employee "from emp in class com.apress.javapersist.chapter11.hibernate.bo.Employee where emp.id=10" Address "from addr in class com.apress.javapersist.chapter11.hibernate.bo.Address where addr.id=11"
manage remove Employee "from emp in class com.apress.javapersist.chapter11.hibernate.bo.Employee where emp.id=10"