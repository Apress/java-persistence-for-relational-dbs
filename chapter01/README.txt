           Java Persistence for Relational Databases
           =========================================

REQUIREMENTS

* Castor is used for the object to XML conversion in this chapter Castor can be 
obtained from http://castor.exolab.org/
* Xerces XML library from http://xml.apache.org

INSTALLATION

Download and install Castor.  Copy castor-<version>.jar. Download and install 
Xerces.  Copy xml-api.jar and xercesImpl.jar to lib/ext. Build the files by 
running ant.

The commands to run the code are:
run.bat com.apress.javapersist.chapter1.xml.XMLMain write
run.bat com.apress.javapersist.chapter1.xml.XMLMain read
run.bat com.apress.javapersist.chapter1.serialization.SerializationMain write
run.bat com.apress.javapersist.chapter1.serialization.SerializationMain read