           Java Persistence for Relational Databases
           =========================================

INTRODUCTION 

This is the source code for the Apress book "Java Persistence for Relational 
Databases" by Richard Sperko.  All of the examples in the book are here with the 
supporting code.  Each directory contains not only the source code but also a 
readme that tells what libraries and tools are necessary for that chapter's 
code.
    
Additionally each directory contains an Ant build script that will, provided the 
required libraries are available, build the code for that chapter.  Ant is a 
build tool that is available from the Apache organization at 
http://ant.apache.org.  Each build.xml (Ant build script) is accompanied by a 
build.properties file.  This is the only file that should need editing. 
Essentially you will edit this file to set the paths for the required libraries. 


REQUIREMENTS
* Build mechanism, Ant or an IDE of your choice
* Each chapter has its own list of required libraries


INSTALLATION 

Installation is not an issue for most of the chapters' code.  Most applications 
are intended to be stand-along Java appications.  The one exception to this is 
chapter 8 on container managed persistence, see that chapter's readme file for a 
more complete explanation.
