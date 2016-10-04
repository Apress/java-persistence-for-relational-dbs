/*
 * CreateDatabase.java
 *
 * Created on June 24, 2002, 9:41 PM
 */

package com.apress.javapersistence.chapter04.jdbc21;

import java.sql.*;
import java.io.*;

/**
 *
 * @author  rsperko
 */
public class PreparedStatementBatchUpdate {
    private String username;
    private String password;
    
    /** Creates a new instance of PreparedStatementBatchUpdate */
    public PreparedStatementBatchUpdate(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length < 2 ) {
            System.out.println( "usage: BatchUpdate username password" );
            return;
        }
        
        PreparedStatementBatchUpdate me 
            = new PreparedStatementBatchUpdate( args[ 0 ], args[ 1 ] );
        me.execute();
    }
    
    public void execute() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            String url = "jdbc:mysql://localhost/chapter04_jdbc21";
            connection = DriverManager.getConnection( url, username, password );

            String sql = "UPDATE employees SET email = ? WHERE employee_id = ?";
            statement = connection.prepareStatement( sql );

            statement.setString( 1, "dglyzewski@centare.com" );
            statement.setLong( 2, 1 );
            statement.addBatch();

            statement.setString( 1, "echaltry@centare.com" );
            statement.setLong( 2, 2 );
            statement.addBatch();

            statement.setString( 1, "dsmith@centare.com" );
            statement.setLong( 2, 3 );
            statement.addBatch();
            
            statement.executeBatch();
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
