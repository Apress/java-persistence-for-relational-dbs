/*
 * CreateDatabase.java
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
public class CreateDatabase {
    private String username;
    private String password;
    
    /** Creates a new instance of CreateDatabase */
    public CreateDatabase(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length < 2 ) {            
            System.out.println( "usage: CreateDatabase username password" );
            return;
        }
        
        CreateDatabase createDatabase = new CreateDatabase( args[ 0 ], args[ 1 ] );
        createDatabase.execute();
    }
    
    public void execute() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName( "org.gjt.mm.mysql.Driver" ).newInstance();
            String url = "jdbc:mysql://localhost/mysql";
            connection = DriverManager.getConnection( url, username, password );

            statement = connection.createStatement();
            String hrappSQL = "CREATE DATABASE hrapp";
            statement.executeUpdate( hrappSQL );
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
