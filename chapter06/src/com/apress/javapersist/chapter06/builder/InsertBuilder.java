package com.apress.javapersist.chapter06.builder;

import java.util.*;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 19, 2002
 */
public class InsertBuilder extends SQLBuilder {
  private String table;
  private Map columnsAndData = new HashMap();
  private String criteria;


  /**
   *  Sets the table attribute of the InsertBuilder object
   *
   *@param  table  The new table value
   *@since
   */
  public void setTable( String table ) {
    this.table = table;
  }


  /**
   *  Gets the command attribute of the InsertBuilder object
   *
   *@return    The command value
   *@since
   */
  public String getCommand() {
    return "INSERT INTO ";
  }


  /**
   *  Gets the table attribute of the InsertBuilder object
   *
   *@return    The table value
   *@since
   */
  public String getTable() {
    return table;
  }


  /**
   *  Gets the what attribute of the InsertBuilder object
   *
   *@return    The what value
   *@since
   */
  public String getWhat() {
    StringBuffer columns = new StringBuffer();
    StringBuffer values = new StringBuffer();
    StringBuffer what = new StringBuffer();

    String columnName = null;
    Iterator iter = columnsAndData.keySet().iterator();
    while( iter.hasNext() ) {
      columnName = (String) iter.next();
      columns.append( columnName );
      values.append( columnsAndData.get( columnName ) );
      if( iter.hasNext() ) {
        columns.append( ',' );
        values.append( ',' );
      }
    }

    what.append( " (" );
    what.append( columns );
    what.append( ") VALUES (" );
    what.append( values );
    what.append( ") " );
    return what.toString();
  }


  /**
   *  Gets the criteria attribute of the InsertBuilder object
   *
   *@return    The criteria value
   *@since
   */
  public String getCriteria() {
    return "";
  }


  /**
   *  Adds a feature to the ColumnAndData attribute of the InsertBuilder object
   *
   *@param  columnName  The feature to be added to the ColumnAndData attribute
   *@param  value       The feature to be added to the ColumnAndData attribute
   *@since
   */
  public void addColumnAndData( String columnName, Object value ) {
    if( value != null ) {
      columnsAndData.put( columnName, value );
    }
  }
}

