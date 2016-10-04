           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
*  OJB can be obtained from http://jakarta.apache.org/

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql.
* Copy all OJB jars to lib/ext
* Build the files by running ant.

For this example I have created a manage.bat file that will execute the Manage 
class with any passed arguments.

The commands to run examples are code are:
manage add Employee 10 FName LName eMail
manage add Address  11 line1 line2 city state
manage list Employee all
manage list Employee lastName equals LName
manage assoc Employee id equals 10 Address id equals 11
manage remove Employee lastName equals LName