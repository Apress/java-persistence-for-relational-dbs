           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
* An ODMG implimentation.  The code is currently set up for OJB, which can be 
obtained from http://jakarta.apache.org/

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql, this file contains the OJB 
required tables as well.
* Copy all OJB jars to lib/ext
* Build the files by running ant.

The commands to run examples are code are:
run com.apress.javapersist.chapter09.BindEmployees
run com.apress.javapersist.chapter09.LookupEmployees
run com.apress.javapersist.chapter09.ModifyEmployee
run com.apress.javapersist.chapter09.UnbindEmployees
run com.apress.javapersist.chapter09.PersistEmployee
run com.apress.javapersist.chapter09.SelectEmployees Dale
run com.apress.javapersist.chapter09.DeleteEmployees