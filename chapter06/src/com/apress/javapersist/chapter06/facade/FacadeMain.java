package com.apress.javapersist.chapter06.facade;

import java.sql.*;
import java.util.*;

import com.apress.javapersist.chapter06.bo.Employee;

public class FacadeMain {
  public static void main( String[] args ) {
    QueryFacade facade = new QueryFacade( new EmployeeResultSetMap() );
    try {
      Iterator iterator = facade.execute( "SELECT * FROM EMPLOYEES" );
      Employee employee = null;
      while( iterator.hasNext() ) {
        employee = (Employee) iterator.next();
        System.out.println( employee.getGuid() );
      }
    }
    catch( SQLException e ) {
      e.printStackTrace();
    }
    finally {
      facade.close();
    }
  }
}

class EmployeeResultSetMap implements ResultSetMap {
  public Object convert( ResultSet resultSet ) throws SQLException {
    Employee employee = new Employee();
    employee.setGuid( resultSet.getString( "oid" ) );
    employee.setFirstName( resultSet.getString( "first_name" ) );
    employee.setLastName( resultSet.getString( "last_name" ) );
    employee.setNumDependants( resultSet.getInt( "num_dependants" ) );
    employee.setDateOfBirth( resultSet.getDate( "date_of_birth" ) );
    employee.setEmployed( resultSet.getBoolean( "employed" ) );
    return employee;
  }
}
