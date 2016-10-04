package com.apress.javapersist.chapter06.strategy;

import java.sql.*;
import java.text.*;

import com.apress.javapersist.chapter06.bo.Employee;
import com.apress.javapersist.chapter06.builder.InsertBuilder;
import com.apress.javapersist.chapter06.builder.SQLDirector;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 21, 2002
 */
public class StrategyMain {

  /**
   *  The main program for the StrategyMain class
   *
   *@param  args  The command line arguments
   *@since
   */
  public static void main( String[] args ) {
    Employee employee = buildTestEmployee();
    Connection con = null;
    try {
      JDBCHelper helper = new JDBCHelper( "localhost", "chapter06", "root", "password" );

      InsertBuilder builder = new InsertBuilder();
      builder.setTable( "employees" );
      builder.addColumnAndData( "oid",
          helper.format( employee.getGuid() ) );
      builder.addColumnAndData( "first_name",
          helper.format( employee.getFirstName() ) );
      builder.addColumnAndData( "last_name",
          helper.format( employee.getLastName() ) );
      builder.addColumnAndData( "employed",
          helper.format( employee.getEmployed() ) );
      builder.addColumnAndData( "date_of_birth",
          helper.format( employee.getDateOfBirth() ) );
      builder.addColumnAndData( "num_dependants",
          helper.format( employee.getNumDependants() ) );

      con = helper.getConnection();

      Statement statement = con.createStatement();

      System.out.println( SQLDirector.buildSQL( builder ) );

      statement.executeUpdate( SQLDirector.buildSQL( builder ) );
    }
    catch( Exception e ) {
      e.printStackTrace();
    }
    finally {
      if( con != null ) {
        try {
          con.close();
        }
        catch( SQLException e ) {
        }
      }
    }
  }


  /**
   *  Description of the Method
   *
   *@return    Description of the Returned Value
   *@since
   */
  private static Employee buildTestEmployee() {
    SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );
    Employee employee = new Employee();
    employee.setGuid( Long.toString( System.currentTimeMillis() ) );
    employee.setFirstName( "Dave" );
    employee.setLastName( "Glyzewski" );
    employee.setEmployed( true );
    try {
      employee.setDateOfBirth( format.parse( "01/01/1920" ) );
    }
    catch( ParseException e ) {
    }
    employee.setNumDependants( 3 );
    return employee;
  }
}

