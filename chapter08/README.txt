           Java Persistence for Relational Databases
           =========================================

This chapter's code has too many variables to create a simple install script. 
How this is built and deployed depends on what tools you have available.  Ant 
does not provide any simple tools for building the EJB or EAR files you need.  I 
used WebSphere Studio Application Developer 5 (based on the open source Eclipse 
2).

The steps however are the same, using your favorite EJB creation tool create the 
EJB jar file from the files in EJBs/.  Then create a WAR file from the files in 
UnitTestWebApp/.  Put both of these together in an EAR file and deploy to the 
J2EE RI Server as described in the chapter.
