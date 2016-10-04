package com.apress.javapersist.chapter06.strategy;

import java.sql.*;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 21, 2002
 */
public abstract class DatabaseStrategy {
  /**
   *  Description of the Method
   *
   *@exception  ClassNotFoundException  Description of Exception
   *@since
   */
  public abstract void loadDriver() throws ClassNotFoundException;


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
  public abstract String generateURL( String server, String database, String user, String passwd );


  /**
   *  Description of the Method
   *
   *@param  value  Description of Parameter
   *@return        Description of the Returned Value
   *@since
   */
  public abstract String format( Object value );
}

