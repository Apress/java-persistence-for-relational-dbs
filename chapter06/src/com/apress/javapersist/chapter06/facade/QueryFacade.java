package com.apress.javapersist.chapter06.facade;

import java.sql.*;
import java.util.*;

public class QueryFacade {
  private Connection connection;
  private ResultSetMap map;
  private Statement statement;
  private ResultSet resultSet;
  
  public QueryFacade( ResultSetMap map ) {
    this.map = map;
    try {
      Class.forName( "com.mysql.jdbc.Driver" );
    }
    catch( ClassNotFoundException e ) {
      e.printStackTrace();
    }
  }

  public Iterator execute( String query ) throws SQLException {
    connection = getConnection();
	  statement = connection.createStatement();
	  resultSet = statement.executeQuery(query);
	  return new FacadeIterator();
  }

  /**
 	 * Closes the connection, statement, AND result set that was created.
	 * there is no need to close the result set again.
	 */
  public void close() {
    if( resultSet != null ) {
      try {
        resultSet.close();
      }
      catch( SQLException e ){}
    }
    if( statement != null ) {
      try{
        statement.close();
      }
      catch( SQLException e ) {}
    }
    if( connection != null ) {
      try {
        connection.close();
      }
      catch( SQLException e ){}
    }
  }
  
  private Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/chapter06?user=root&password=password";
    return DriverManager.getConnection( url );
  }
  
  private class FacadeIterator implements Iterator {
    private Object next;
    FacadeIterator() {
      next();
    }
    
    public boolean hasNext() {
      return next != null;
    }
    
    public Object next() {
      Object current = next;
      try {
        if( resultSet.next() ) {
          next = map.convert( resultSet );
        }
        else {
          next = null;
        }
        return current;
      }
      catch( SQLException e ) {
        throw new NoSuchElementException( e.getMessage() );
      }
    }
    
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}

