package com.apress.javapersistence.chapter07.dao;

import java.sql.*;

class ConnectionManager {
    static {
        try {
            Class.forName( "org.gjt.mm.mysql.Driver" ).newInstance();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/strong_brownbag";
        String username = "strong";
        String password = "strong";
        return DriverManager.getConnection( url, username, password );
    }

    static void closeAll( ResultSet resultSet, Statement statement ) {
        close( resultSet );
        close( statement );
    }
    
    static void closeAll( ResultSet resultSet, Statement statement, Connection connection ) {
        closeAll( resultSet, statement );
        close( connection );
    }
    
    static void close( Connection connection ) {
	if( connection != null ) {
	    try {
		connection.close();
	    }
	    catch( SQLException e ){}
	}
    }
    
    static void close( Statement statement ) {
	if( statement != null ) {
	    try {
		statement.close();
	    }
	    catch( SQLException e ){}
	}
    }
    
    static void close( ResultSet resultSet ) {
	if( resultSet != null ) {
	    try {
		resultSet.close();
	    }
	    catch( SQLException e ){}
	}
    }
}
