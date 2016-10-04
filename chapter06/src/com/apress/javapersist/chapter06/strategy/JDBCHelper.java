package com.apress.javapersist.chapter06.strategy;

import java.sql.*;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 21, 2002
 */
public class JDBCHelper {
  private DatabaseStrategy strategy;
  private String server;
  private String databaseName;
  private String user;
  private String passwd;


  /**
   *  Constructor for the JDBCHelper object
   *
   *@param  server                      Description of Parameter
   *@param  databaseName                Description of Parameter
   *@param  user                        Description of Parameter
   *@param  passwd                      Description of Parameter
   *@exception  ClassNotFoundException  Description of Exception
   *@since
   */
  public JDBCHelper( String server,
      String databaseName,
      String user,
      String passwd ) throws ClassNotFoundException {
    this.server = server;
    this.databaseName = databaseName;
    this.user = user;
    this.passwd = passwd;
    strategy = new MySQLStrategy();
    strategy.loadDriver();
  }


  /**
   *  Gets the connection attribute of the JDBCHelper object
   *
   *@return                   The connection value
   *@exception  SQLException  Description of Exception
   *@since
   */
  public Connection getConnection() throws SQLException {
    String url = strategy.generateURL( server, databaseName, user, passwd );
    return DriverManager.getConnection( url );
  }


  /**
   *  Description of the Method
   *
   *@param  value  Description of Parameter
   *@return        Description of the Returned Value
   *@since
   */
  public String format( Object value ) {
    return strategy.format( value );
  }


  /**
   *  Description of the Method
   *
   *@param  value  Description of Parameter
   *@return        Description of the Returned Value
   *@since
   */
  public String format( boolean value ) {
    return format( new Boolean( value ) );
  }


  /**
   *  Description of the Method
   *
   *@param  value  Description of Parameter
   *@return        Description of the Returned Value
   *@since
   */
  public String format( int value ) {
    return format( new Integer( value ) );
  }
}

