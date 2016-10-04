package com.apress.javapersist.chapter1.xml;

import java.io.*;
import java.util.*;
import org.exolab.castor.xml.*;

public class XMLMain {
    public static void write() {
        FileWriter writer = null;
        try {
          writer = new FileWriter("employees.xml");
    
          Employee employee = new Employee();
          employee.setFirstName( "Bob" );
          employee.setLastName( "Smith" );
          employee.setEmployeeId( 0003450025 );
          employee.setNumDependants( 2 );
          Marshaller.marshal(employee, writer);
        }
        catch( Exception e ) {
          e.printStackTrace();
        }
        finally {
          if( writer != null ) {
            try { writer.close(); }
            catch( IOException e ){}
          }
        }
    }
    
    public static void read() {
        FileReader reader = null;
        try {
          reader = new FileReader("employees.xml");
    
          Employee savedEmployee 
            = (Employee) Unmarshaller.unmarshal(Employee.class, reader);
          System.out.println( savedEmployee.getFirstName() );
        }
        catch( Exception e ) {
          e.printStackTrace();
        }
        finally {
          if( reader != null ) {
            try { reader.close(); }
            catch( IOException e ){}
          }
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
       System.out.println("Usage: XMLMain [read|write]");
    }
}
