/*
 * CreateDatabase.java
 *
 * Created on June 24, 2002, 9:41 PM
 */

package com.apress.javapersistence.chapter03.database;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author  rsperko
 */
public class PrintDatabase {
    private String username;
    private String password;
    
    /** Creates a new instance of CreateDatabase */
    public PrintDatabase(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length < 2 ) {
            System.out.println( "usage: PrintDatabase username password" );
            return;
        }
        
        PrintDatabase printDb 
            = new PrintDatabase( args[ 0 ], args[ 1 ] );
        printDb.execute();
    }
    
    public void execute() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName( "org.gjt.mm.mysql.Driver" ).newInstance();
            String url = "jdbc:mysql://localhost/hrapp";
            connection = DriverManager.getConnection( url, username, password );

            statement = connection.createStatement();
            String selectEmployeesSQL = "SELECT * FROM employees";
            resultSet = statement.executeQuery( selectEmployeesSQL );

            while( resultSet.next() ) {
                System.out.print( resultSet.getInt( "employee_id" ) );
                System.out.print( ", " );
                System.out.print( resultSet.getString( "last_name" ) );
                System.out.print( ", " );
                System.out.print( resultSet.getString( "first_name" ) );
                System.out.print( ", " );
                System.out.println( resultSet.getByte( "num_dependants" ) );
            }
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        finally {
            if( resultSet != null ) {
                try {
                    resultSet.close();
                }
                catch( SQLException e ){} // nothing we can do
            }
            if( statement != null ) {
                try {
                    statement.close();
                }
                catch( SQLException e ){} // nothing we can do
            }
            if( connection != null ) {
                try {
                    connection.close();
                }
                catch( SQLException e ){} // nothing we can do
            }
        }
    }
    
}
