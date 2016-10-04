/*
 * EmployeeDAO.java
 *
 * Created on August 21, 2002, 8:33 PM
 */

package com.apress.javapersist.chapter05.dao;

import com.apress.javapersist.chapter05.bo.Employee;
import java.util.*;
import java.sql.*;

/**
 *
 * @author  rsperko
 */
public class EmployeeDAO {
    static {
        try {
            Class.forName( "org.gjt.mm.mysql.Driver" ).newInstance();
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
    }
    
    public Employee findFor( Employee exampleCriteria ) throws FindException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            StringBuffer sql = new StringBuffer( "SELECT employee_id, first_name, "
            +"last_name, email "
            + "FROM employees "
            + "WHERE " );
            if( exampleCriteria.getOid() != 0 ) {
                sql.append( "employee_id = " );
                sql.append( exampleCriteria.getOid() );
                sql.append( " AND " );
            }
            if( exampleCriteria.getFirstName() != null ) {
                sql.append( "first_name = '" );
                sql.append( exampleCriteria.getFirstName() );
                sql.append( "' AND " );
            }
            if( exampleCriteria.getLastName() != null ) {
                sql.append( "last_name = '" );
                sql.append( exampleCriteria.getLastName() );
                sql.append( "' AND " );
            }
            if( exampleCriteria.getEmail() != null ) {
                sql.append( "email = '" );
                sql.append( exampleCriteria.getEmail() );
                sql.append( "' AND " );
            }
            sql.append( "'A' = 'A'" );
            resultSet = statement.executeQuery( sql.toString() );
            if( resultSet.next() ) {
                employee = newEmployeeFrom( resultSet );
            }
            return employee;
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new FindException( e, "finding Employee" );
        }
        finally {
            closeAll( connection, statement, resultSet );
        }
    }
    
    public Employee findFor( EmployeeCriteria exampleCriteria ) throws FindException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            StringBuffer sql = new StringBuffer( "SELECT employee_id, first_name, "
            + "last_name, email "
            + "FROM employees "
            + "WHERE " );
            if( exampleCriteria.getLastNameEquals() != null ) {
                sql.append( "last_name = '" );
                sql.append( exampleCriteria.getLastNameEquals() );
                sql.append( "' AND " );
            }
            if( exampleCriteria.getLastNameLike() != null ) {
                sql.append( "last_name LIKE '%" );
                sql.append( exampleCriteria.getLastNameLike() );
                sql.append( "%' AND " );
            }
            if( exampleCriteria.isLastNameNull() ) {
                sql.append( "last_name IS NULL AND " );
            }
            sql.append( "'A' = 'A'" );
            resultSet = statement.executeQuery( sql.toString() );
            if( resultSet.next() ) {
                employee = newEmployeeFrom( resultSet );
            }
            return employee;
        }
        catch( SQLException e ) {
            throw new FindException( e, "finding employee");
        }
        finally {
            closeAll( connection, statement, resultSet );
        }
    }
    
    public Employee findFor( SimpleSoftEmployeeCriteria criteria ) throws FindException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            StringBuffer sql = new StringBuffer( "SELECT employee_id, first_name, "
            +"last_name, email "
            + "FROM employees "
            + "WHERE " );
            String attribute = null;
            Object value = null;
            for( Iterator i = criteria.keySet().iterator(); i.hasNext(); ) {
                attribute = (String) i.next();
                value = criteria.get( attribute );
                if( SimpleSoftEmployeeCriteria.OID.equals( attribute ) )
                    sql.append( "employee_id = " + value + " AND " );
                else if( SimpleSoftEmployeeCriteria.FIRST_NAME.equals( attribute ) )
                    sql.append( "first_name = '" + value + "' AND " );
                else if( SimpleSoftEmployeeCriteria.LAST_NAME.equals( attribute ) )
                    sql.append( "last_name = '" + value + "' AND " );
                else if( SimpleSoftEmployeeCriteria.EMAIL.equals( attribute ) )
                    sql.append( "email = '" + value + "' AND " );
            }
            
            sql.append( "'A' = 'A'" );
            resultSet = statement.executeQuery( sql.toString() );
            if( resultSet.next() ) {
                employee = newEmployeeFrom( resultSet );
            }
            return employee;
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new FindException( e, "Finding employee" );
        }
        finally {
            closeAll( connection, statement, resultSet );
        }
    }
    
    
    public Employee findFor( SoftEmployeeCriteria criteria ) throws FindException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            StringBuffer sql = new StringBuffer( "SELECT employee_id, first_name, "
            +"last_name, email "
            + "FROM employees "
            + "WHERE " );
            String attribute = null;
            Object value = null;
            for( Iterator i = criteria.getAttributes().iterator(); i.hasNext(); ) {
                attribute = (String) i.next();
                value = criteria.getValue( attribute );
                if( SimpleSoftEmployeeCriteria.OID.equals( attribute ) )
                    sql.append( "employee_id = " + value + " AND " );
                else if( SimpleSoftEmployeeCriteria.FIRST_NAME.equals( attribute ) )
                    sql.append( "first_name = '" + value + "' AND " );
                else if( SimpleSoftEmployeeCriteria.LAST_NAME.equals( attribute ) )
                    sql.append( "last_name = '" + value + "' AND " );
                else if( SimpleSoftEmployeeCriteria.EMAIL.equals( attribute ) )
                    sql.append( "email = '" + value + "' AND " );
            }
            
            sql.append( "'A' = 'A'" );
            resultSet = statement.executeQuery( sql.toString() );
            if( resultSet.next() ) {
                employee = newEmployeeFrom( resultSet );
            }
            return employee;
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new FindException( e, "finding employee" );
        }
        finally {
            closeAll( connection, statement, resultSet );
        }
    }
    
    private String formatEntry(String attribute, int type, Object value) {
        StringBuffer buf = new StringBuffer(attribute);
        switch( type ) {
            case AbstractSoftCriteria.EQUALS:
                buf.append(" = ");
                buf.append( value );
            case AbstractSoftCriteria.LIKE:
                buf.append(" LIKE ");
                
        }
        return buf.toString();
    }
    
    public Employee findFor( long oid ) throws FindException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Employee employee = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            String sql = "SELECT employee_id, first_name, last_name, email "
            + "FROM employees "
            + "WHERE employee_id = " + oid;
            resultSet = statement.executeQuery( sql );
            if( resultSet.next() ) {
                employee = newEmployeeFrom( resultSet );
            }
            return employee;
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new FindException( e, "finding employee" );
        }
        finally {
            closeAll( connection, statement, resultSet );
        }
    }
    
    public Collection findForLastName( String lastName ) throws FindException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List employees = new ArrayList();
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            String sql = "SELECT employee_id, first_name, last_name, email "
            + "FROM employees "
            + "WHERE last_name = '" + lastName + "'";
            resultSet = statement.executeQuery( sql );
            while( resultSet.next() ) {
                employees.add( newEmployeeFrom( resultSet ) );
            }
            return employees;
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new FindException( e, "finding employee" );
        }
        finally {
            closeAll( connection, statement, resultSet );
        }
    }
    
    private Employee newEmployeeFrom( ResultSet resultSet ) throws SQLException {
        long oid = resultSet.getLong( "employee_id" );
        Employee employee = new Employee( oid );
        employee.setFirstName( resultSet.getString( "first_name" ) );
        employee.setLastName( resultSet.getString( "last_name" ) );
        employee.setEmail( resultSet.getString( "email" ) );
        return employee;
    }
    
    public synchronized Employee insert( Employee employee ) 
        throws PersistenceException {
        Connection connection = null;
        Statement statement = null;
        long oid = 0;
        int results = 0;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            oid = nextOid( statement );
            
            String sql = "INSERT INTO employees "
            + "(employee_id, first_name, last_name, email) "
            + "VALUES "
            + "("
            + oid + ", "
            + "'" + employee.getFirstName() + "', "
            + "'" + employee.getLastName() + "', "
            + "'" + employee.getEmail() + "' "
            + ")";
            results = statement.executeUpdate( sql );
            
            if( results == 1 ) {
                Employee newEmployee = new Employee( oid );
                newEmployee.setFirstName( employee.getFirstName() );
                newEmployee.setLastName( employee.getLastName() );
                newEmployee.setEmail( employee.getEmail() );
                return newEmployee;
            }
            else {
                throw new PersistenceException( "Unable to insert Employee" );
            }
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new PersistenceException( e.getMessage() );
        }
        finally {
            closeAll( connection, statement, null );
        }
    }
    
    private synchronized long nextOid( Statement statement ) throws SQLException {
        String sql = "SELECT MAX( employee_id ) FROM employees";
        ResultSet resultSet = statement.executeQuery( sql );
        resultSet.next();
        long lastOid = resultSet.getLong( 1 );
        return lastOid + 1;
    }
    
    public void update( Employee employee ) throws PersistenceException {
        Connection connection = null;
        Statement statement = null;
        int results = 0;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            String sql = "UPDATE employees SET "
            + "first_name = '" + employee.getFirstName() + "', "
            + "last_name = '" + employee.getLastName() + "', "
            + "email = '" + employee.getEmail() + "' "
            + "WHERE employee_id = " + employee.getOid();
            results = statement.executeUpdate( sql );
            
            if( results != 1 ) {
                throw new PersistenceException( "Unable to delete Employee" );
            }
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new PersistenceException( e.getMessage() );
        }
        finally {
            closeAll( connection, statement, null );
        }
    }
    
    public void delete( Employee employee ) throws PersistenceException {
        if( employee == null ) {
            return;
        }
        
        Connection connection = null;
        Statement statement = null;
        int results = 0;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            
            String sql = "DELETE FROM employees WHERE employee_id = "
            + employee.getOid();
            results = statement.executeUpdate( sql );
            
            if( results != 1 ) {
                throw new PersistenceException( "Unable to delete Employee" );
            }
        }
        catch( SQLException e ) {
            e.printStackTrace();
            throw new PersistenceException( e.getMessage() );
        }
        finally {
            closeAll( connection, statement, null );
        }
    }
    
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/chapter05_dao";
        String username = System.getProperty( "username" );
        String password = System.getProperty( "password" );
        return DriverManager.getConnection( url, username, password );
    }
    
    private void closeAll( Connection connection,
    Statement statement,
    ResultSet resultSet ) {
        if( resultSet != null ) {
            try { resultSet.close(); }
            catch( SQLException e ){}
        }
        if( statement != null ) {
            try { statement.close(); }
            catch( SQLException e ){}
        }
        if( connection != null ) {
            try { connection.close(); }
            catch( SQLException e ){}
        }
    }
}
