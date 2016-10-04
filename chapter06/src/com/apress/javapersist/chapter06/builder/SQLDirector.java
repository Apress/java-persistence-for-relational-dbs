package com.apress.javapersist.chapter06.builder;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    March 21, 2002
 */
public class SQLDirector {
  /**
   *  Description of the Method
   *
   *@param  builder  SQLBuilder used to create the SQL
   *@return          SQL Statement generated from the builder
   *@since
   */
  public static String buildSQL( SQLBuilder builder ) {
    StringBuffer buffer = new StringBuffer();
    buffer.append( builder.getCommand() );
    buffer.append( builder.getTable() );
    buffer.append( builder.getWhat() );
    buffer.append( builder.getCriteria() );
    return buffer.toString();
  }


  /**
   *  The main program for the SQLDirector class
   *
   *@param  args  The command line arguments
   *@since
   */
  public static void main( String[] args ) {
    InsertBuilder builder = new InsertBuilder();
    builder.setTable( "employees" );
    builder.addColumnAndData( "employee_id", new Integer( 221 ) );
    builder.addColumnAndData( "first_name", "'Shane'" );
    builder.addColumnAndData( "last_name", "'Grinnell'" );
    builder.addColumnAndData( "email", "'al@yahoo.com'" );

    String sql = buildSQL( builder );
    System.out.println( sql );
  }
}

