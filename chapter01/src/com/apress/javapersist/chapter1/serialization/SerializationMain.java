package com.apress.javapersist.chapter1.serialization;

import java.io.*;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    April 22, 2002
 */
public class SerializationMain {
    public static void write() {
	FileOutputStream fout = null;
	ObjectOutputStream oout = null;
	
	try {
	    fout = new FileOutputStream( "employees.ser" );
	    oout = new ObjectOutputStream( fout );
	    
	    Employee employee = new Employee( "Bob", "Smith", 2230045 );
	    oout.writeObject( employee );
	}
	catch( Exception e ) {
	    e.printStackTrace();
	}
	finally {
	    try { if( oout != null ) oout.close(); }
	    catch( IOException e ) {}
	    try { if( fout != null ) fout.close(); }
	    catch( IOException e ) {}
	}
    }

    public static void read() {
	FileInputStream fin = null;
	ObjectInputStream oin = null;
	try {
	    fin = new FileInputStream( "employees.ser" );
	    oin = new ObjectInputStream( fin );

	    Employee savedEmployee = (Employee) oin.readObject();
	    System.out.println( savedEmployee.getFirstName() );
	}
	catch( Exception e ) {
	    e.printStackTrace();
	}
	finally {
	    try { if( oin != null ) oin.close(); }
	    catch( IOException e ) {}
	    try { if( fin != null ) fin.close(); }
	    catch( IOException e ) {}
	}
    }

    public static void main( String[] args ) {
        if(args.length < 1) {
            usage();
        }
        else if("write".equals(args[0])) {
            write();
        }
        else if("read".equals(args[0])){
            read();
        }
        else {
            usage();
        }
    }
    
    private static void usage() {
       System.out.println("Usage: SerializationMain [read|write]");
    }
}
