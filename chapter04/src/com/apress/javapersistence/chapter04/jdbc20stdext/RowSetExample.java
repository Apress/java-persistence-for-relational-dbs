/*
 * CreateDatabase.java
 *
 * Created on June 24, 2002, 9:41 PM
 */

package com.apress.javapersistence.chapter04.jdbc20stdext;

import java.sql.*;
import java.io.*;
import javax.sql.*;

/**
 *
 * @author  rsperko
 */
public class RowSetExample {
    private String username;
    private String password;
    
    /** Creates a new instance of RowSetExample */
    public RowSetExample(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length < 2 ) {
            System.out.println( "usage: RowSetExample username password" );
            return;
        }
        
        RowSetExample printDb = new RowSetExample( args[ 0 ], args[ 1 ] );
        printDb.execute();
    }
    
    public void execute() {
        RowSet rowSet = null;
        
        
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String url = "jdbc:mysql://localhost/chapter04_jdbc21";
            connection = DriverManager.getConnection( url, username, password );

            statement = connection.createStatement( 
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE );

            String selectEmployeesSQL = "SELECT * FROM employees";
            resultSet = statement.executeQuery( selectEmployeesSQL );

            Navigate nav = new Navigate( resultSet );
            while( nav.navigate() );

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

class Navigate {
    private BufferedReader stdIn;
    private ResultSet resultSet;

    public Navigate( ResultSet resultSet ) {
        this.resultSet = resultSet;
        stdIn = new BufferedReader( new InputStreamReader( System.in ) );
    }

    public boolean navigate() throws SQLException, IOException {
        String menu 
            = "(f)irst (n)ext (p)rev (l)ast (g)oto (r)elative (u)pdate (i)nsert (d)elete (q)uit: ";
        String input = prompt( menu );
        if( "f".equals( input ) ) {
            first();
        }
        else if ( "n".equals( input ) ) {
            next();
        }
        else if( "p".equals( input )  ) {
            prev();
        }
        else if( "l".equals( input ) ) {
            last();
        }
        else if( "g".equals( input ) ) {
            goTo();
        }
        else if( "r".equals( input ) ) {
            relative();
        }
        else if( "u".equals( input ) ) {
            update();
        }
        else if( "i".equals( input ) ) {
            insert();
        }
        else if( "d".equals( input ) ) {
            delete();
        }
        else {
            return false;
        }
        return true;
    }

    void first() throws SQLException {
        resultSet.first();
        printRow();
    }

    void next() throws SQLException {
        if( ! resultSet.isLast() ) {
            resultSet.next();
        }
        printRow();
    }

    void prev() throws SQLException {
        if( ! resultSet.isFirst() ) {
            resultSet.previous();
        }
        printRow();
    }

    void last() throws SQLException {
        resultSet.last();
        printRow();
    }

    void goTo() throws SQLException, IOException {
        int pos = 1;
        try {
            pos = Integer.parseInt( prompt( "position: " ) );
        }
        catch( NumberFormatException e ) {
            System.out.println( "Bad number, setting back to 1" );
        }
        resultSet.absolute( pos );
        printRow();
    }

    void relative() throws SQLException, IOException {
        int pos = 1;
        try {
            pos = Integer.parseInt( prompt( "move relative: " ) );
        }
        catch( NumberFormatException e ) {
            System.out.println( "Bad number, setting back to 1" );
        }
        resultSet.relative( pos );
        printRow();
    }

    private void update() throws SQLException, IOException {
        setRowData();
        resultSet.updateRow();
        printRow();
    }

    private void delete() throws SQLException {
        resultSet.deleteRow();
    }
    
    private void insert() throws SQLException, IOException {
        resultSet.moveToInsertRow();
        resultSet.updateString( "employee_id", prompt( "id: " ) );
        setRowData();
        resultSet.insertRow();
        last();
    }
    
    private void setRowData() throws SQLException, IOException {
        resultSet.updateString( "last_name", prompt( "Last Name: " ) );
        resultSet.updateString( "first_name", prompt( "First Name: " ) );
        resultSet.updateString( "email", prompt( "Email: " ) );
    }

    private void printRow() throws SQLException {
        System.out.print( resultSet.getInt( "employee_id" ) );
        System.out.print( ", " );
        System.out.print( resultSet.getString( "last_name" ) );
        System.out.print( ", " );
        System.out.print( resultSet.getString( "first_name" ) );
        System.out.print( ", " );
        System.out.println( resultSet.getString( "email" ) );
    }

    private String prompt( String prompt ) throws IOException {
        System.out.print( prompt ); 
        return stdIn.readLine();
    }
}
