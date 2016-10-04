           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Build the files by running ant.
* Create the database by running sql/createdb.sql

The commands to run examples are code are:
run com.apress.javapersist.chapter05.ExerciseDAO root password
run com.apress.javapersist.chapter05.dao.VMIDTest
