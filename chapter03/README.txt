           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Build the files by running ant.

The commands to run the code are:
run com.apress.javapersistence.chapter03.database.CreateDatabase root password
run com.apress.javapersistence.chapter03.database.CreateTable root password
run com.apress.javapersistence.chapter03.database.PopulateTable root password
run com.apress.javapersistence.chapter03.database.PrintDatabase root password
run com.apress.javapersistence.chapter03.database.DemoTransaction root password