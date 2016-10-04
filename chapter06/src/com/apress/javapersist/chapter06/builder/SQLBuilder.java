package com.apress.javapersist.chapter06.builder;

public abstract class SQLBuilder {
  /**
   *  Gets the command attribute of the SQLBuilder object
   *
   *@return    The command value or what type of Builder this is.  This will
   return a SQL command.
   *@since
   */
  public abstract String getCommand();


  /**
   *  Gets the table attribute of the SQLBuilder object
   *
   *@return    The table name value
   *@since
   */
  public abstract String getTable();


  /**
   *  Gets the what value of the SQLBuilder object.  This attribute will
   differ based on what type of object we are using.  This could be a list of
   columns and data.
   *
   *@return    The what value
   *@since
   */
  public abstract String getWhat();


  /**
   *  Gets the criteria attribute of the SQLBuilder object
   *
   *@return    The criteria value
   *@since
   */
  public abstract String getCriteria();
}

