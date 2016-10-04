           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
* TopLink which can be downloaded from http://www.oracle.com/

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql.
* Download and install TopLink as per the TopLink instructions
* Edit build.properties correcting paths for TopLink install
* Edit the env.bat file correcting paths for TopLink install and driver location
* Build the files by running ant.

For this example I have created a manage.bat file that will execute the Manage 
class with any passed arguments.

The commands to run examples are code are:
Manage remove Employee lastName equals LName
Manage list Employee firstName equals LName
Manage list Employee all
Manage add Employee id FName LName eMail
Manage add Address id line1 line2 city state
Manage assoc Employee id equals 0 Address id equals 1