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
public class BatchUpdate {
    private String username;
    private String password;
    
    /** Creates a new instance of CreateDatabase */
    public BatchUpdate(String username, String password) {
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
        
        BatchUpdate printDb 
            = new BatchUpdate( args[ 0 ], args[ 1 ] );
        printDb.execute();
    }
    
    public void execute() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            String url = "jdbc:mysql://localhost/chapter04_jdbc21";
            connection = DriverManager.getConnection( url, username, password );

            statement = connection.createStatement();
            
            String update1 = "UPDATE employees "
                + "SET email = 'dglyzewski@centare.com' "
                + "WHERE email = 'dave.glyzewski@centare.com'";
            statement.addBatch( update1 );

            String update2 = "UPDATE employees "
                + "SET email = 'echaltry@centare.com' "
                + "WHERE email = 'ed.chaltry@centare.com'";
            statement.addBatch( update2 );

            String update3 = "UPDATE employees "
                + "SET email = 'dsmith@centare.com' "
                + "WHERE email = 'dustin.smith@centare.com'";
            statement.addBatch( update3 );
            
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
