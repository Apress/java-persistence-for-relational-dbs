           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
* CastorJDO can be obtained from http://castor.exolab.org/
* Xerces XML libraries can be downloaded from http://xml.apache.org/xerces2-j/index.html

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql.
* Copy all of the castor jars to lib/ext
* Copy the xerces jars to lib/ext
* Build the files by running ant.

For this example I have created a manage.bat file that will execute the Manage 
class with any passed arguments.

The commands to run examples are code are:
manage add Employee 10 FName LName eMail
manage add Address  11 line1 line2 city state
Manage list Employee "select e from com.apress.javapersist.chapter11.castorjdo.bo.Employee e where e.id=10"
manage assoc Employee "select e from com.apress.javapersist.chapter11.castorjdo.bo.Employee e where e.id=10" Address "select a from com.apress.javapersist.chapter11.castorjdo.bo.Address a where a.id=11"
manage remove Employee "select e from com.apress.javapersist.chapter11.castorjdo.bo.Employee e where e.id=10"