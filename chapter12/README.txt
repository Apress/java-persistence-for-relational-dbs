           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* MySQL JDBC Driver which can be downloaded from http://www.mysql.com
* MySQL run environment, either the MySQL Control Center from http://mysql.com
or the command line MysQL interface
* JUnit library which be obtained from http://www.junit.org
* MockObjects libraries which can be obtained from http://www.mockobjects.com

INSTALLATION

* Download and install JDBC driver.  Copy mysql-connector-java-<version>-bin.jar 
to lib/ext. 
* Create the database by running sql/createdb.sql
* Download and install junit.jar to lib/ext. 
* Download mockobjects.  Copy mockobjects-0.07-core.jar and mockobjects-0.07-
<jdk version>.jar to lib/ext
* Build the files by running ant.

The commands to run examples are code are:
run com.apress.javapersistence.chapter07.bo.TestPackage
run com.apress.javapersistence.chapter07.dao.TestShoppingCartDAO
run com.apress.javapersistence.chapter07.dao.TestMockShoppingCartDAO