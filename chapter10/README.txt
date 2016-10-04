           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

The JDO Reference Implementation requires very specific versions of libraries to 
work.  Most of these versions are far out of date.  Unless you know something 
that Sun doesn't I recommend using the versions listed here.

* JDO Reference Implementation from 
http://jcp.org/aboutJava/communityprocess/final/jsr012/index.html
* JDNI File System implementation, you need fscontext.jar and providerutil.jar 
from http://java.sun.com/products/jndi/index.html
* Java Transaction API (jta.jar) from http://java.sun.com/products/jta/index.html
* xerces.jar 1.4.3 from http://xml.apache.org/xerces-j/
* Antlr 2.7.0 from http://www.antlr.org/

INSTALLATION

* Copy the JDO RI files src/jdo.jar, src/jdori.jar and lib/btree.jar to lib/ext
* Copy the JNDI jars to lib/ext
* Copy the jta.jar to lib/ext
* Copy xerces.jar to lib/ext
* Build the files by running ant.

For this example I have created a manage.bat file that will execute 
com.apress.javapersist.chapter10.Manage with any passed arguments.  I have also 
provided a batch file to wrap the Reference Implementation's byte code enhancer. 
To run the enhancer simply run enhancer.bat.

The commands to run examples are code are:
manage create jdori
enhancer -v -s classes -d classes com.apress.javapersist.chapter10.bo.Employee 
enhancer -v -s classes -d classes com.apress.javapersist.chapter10.bo.Address 
enhancer -v -s classes -d classes com.apress.javapersist.chapter10.bo.ZipCode
manage add Employee 10 FName LName eMail
manage list Employee extent
manage add Address  11 line1 line2 city state
manage list Employee extent
manage list Address extent
manage assoc Employee "id==10" Address "id==11"
manage remove Employee "id==10"