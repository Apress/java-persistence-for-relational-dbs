package com.apress.javapersist.chapter06.builder;

public class BuilderMain {
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

    String sql = SQLDirector.buildSQL( builder );
    System.out.println( sql );
  }
}
