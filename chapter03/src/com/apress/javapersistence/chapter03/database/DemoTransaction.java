/*
 * DemoTransaction.java
 *
 * Created on June 24, 2002, 9:41 PM
 */

package com.apress.javapersistence.chapter03.database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 *
 * @author  rsperko
 */
public class DemoTransaction {
    private String username;
    private String password;
    
    /** Creates a new instance of DemoTransaction */
    public DemoTransaction(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length < 2 ) {
            System.out.println( "usage: DemoTransaction username password" );
            return;
        }
        
        DemoTransaction DemoTransaction 
            = new DemoTransaction( args[ 0 ], args[ 1 ] );
        DemoTransaction.execute();
    }
    
    public void execute() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName( "org.gjt.mm.mysql.Driver" ).newInstance();
            String url = "jdbc:mysql://localhost/hrapp";
            connection = DriverManager.getConnection( url, username, password );

            statement = connection.createStatement();
            String employees1SQL = "UPDATE employees SET "
                + "num_dependants = 4 "
                + "WHERE employee_id = 123456";
            statement.executeUpdate( employees1SQL );
            String employees2SQL = "UPDATE employees SET "
                + "num_dependants = 4 "
                + "WHERE employee_id = 123457";
            statement.executeUpdate( employees2SQL );
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        finally {
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
