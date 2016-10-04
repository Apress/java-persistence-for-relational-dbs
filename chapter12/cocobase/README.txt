           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
* CocoBase which can be downloaded from http://www.thoughtinc.com/

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql.  NOTE: if you have run 
TopLink's createdb.sql make sure that you either drop the database or edit
the SQL script to not try to recreate the employee/address tables.
* Download and install CocoBase as per the installation instructions
* Edit build.properties correcting paths for CocoBase install
* Edit the env.bat file correcting paths for CocoBase install and driver location
* Build the files by running ant.

For this example I have created a manage.bat file that will execute the Manage 
class with any passed arguments.

The commands to run examples are code are:
Manage remove Employee "select object(e) from com.apress.javapersist.chapter12.cocobase.bo.Employee e where e.firstName='FName'"
Manage list Employee "select object(e) from com.apress.javapersist.chapter12.cocobase.bo.Employee e where e.firstName='FName'"
Manage add Employee id FName LName eMail
Manage add Address id line1 line2 city state
Manage assoc Employee "select object(e) from com.apress.javapersist.chapter12.cocobase.bo.Employee e where e.id='101'" Address "select object(a) from com.apress.javapersist.chapter12.cocobase.bo.Address a where a.id ='1'"