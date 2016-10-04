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
public class CreateTable {
    private String username;
    private String password;
    
    /** Creates a new instance of CreateDatabase */
    public CreateTable(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length < 2 ) {
            System.out.println( "usage: CreateTable username password" );
            return;
        }
        
        CreateTable createTable = new CreateTable( args[ 0 ], args[ 1 ] );
        createTable.execute();
    }
    
    public void execute() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName( "org.gjt.mm.mysql.Driver" ).newInstance();
            String url = "jdbc:mysql://localhost/hrapp";
            connection = DriverManager.getConnection( url, username, password );

            statement = connection.createStatement();
            String employeesSQL = "CREATE TABLE employees ( "
                + "employee_id      INTEGER          NOT NULL,"
                + "last_name        VARCHAR(128)     NOT NULL,"
                + "first_name       VARCHAR(128)     NOT NULL,"
                + "num_dependants   SMALLINT         NULL )";
            statement.executeUpdate( employeesSQL );
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
