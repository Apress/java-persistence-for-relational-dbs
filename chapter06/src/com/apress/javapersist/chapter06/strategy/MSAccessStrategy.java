package com.apress.javapersist.chapter06.strategy;

import java.text.*;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 21, 2002
 */
public class MSAccessStrategy extends DatabaseStrategy {
  private SimpleDateFormat dateFormat =
      new SimpleDateFormat( "#MM-dd-yyyy HH:mm:ss#" );


  /**
   *  Description of the Method
   *
   *@exception  ClassNotFoundException  Description of Exception
   *@since
   */
  public void loadDriver() throws ClassNotFoundException {
    Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
  }


  /**
   *  Description of the Method
   *
   *@param  server    Description of Parameter
   *@param  database  Description of Parameter
   *@param  user      Description of Parameter
   *@param  passwd    Description of Parameter
   *@return           Description of the Returned Value
   *@since
   */
  public String generateURL( String server, String database, String user, String passwd ) {
    return "jdbc:odbc:" + database;
  }


  /**
   *  Description of the Method
   *
   *@param  value  Description of Parameter
   *@return        Description of the Returned Value
   *@since
   */
  public String format( Object value ) {
    if( value == null ) {
      return null;
    }
    Class clazz = value.getClass();
    if( Character.class.equals( clazz ) || char.class.equals( clazz ) ) {
      value = value.toString();
    }
    if( value instanceof String ) {
      StringBuffer stringVal = new StringBuffer( (String) value );
      for( int i = 0; i < stringVal.length(); i++ ) {
        if( stringVal.charAt( i ) == '\'' ) {
          stringVal.insert( i, '\'' );
          i++;
        }
      }
      return "\'" + stringVal + "\'";
    }
    if( value instanceof java.util.Date ) {
      return dateFormat.format( value );
    }
    return value.toString();
  }
}

