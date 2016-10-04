/*
 * ExerciseDAO.java
 *
 * Created on August 21, 2002, 9:50 PM
 */

package com.apress.javapersist.chapter05;

import java.util.*;
import com.apress.javapersist.chapter05.bo.Employee;
import com.apress.javapersist.chapter05.dao.*;

/**
 *
 * @author  rsperko
 */
public class ExerciseDAO {
    private static EmployeeDAO dao = new EmployeeDAO();
    
    public static void main( String[] args ) {
        if( args.length < 2 ) {
            System.out.println( "usage: ExerciseDAO username password" );
            return;
        }
        
        System.setProperty( "username", args[ 0 ] );
        System.setProperty( "password", args[ 1 ] );
        
        findEmployee();
        findEmployees();
        insertEmployee();
        updateEmployee();
        deleteEmployee();
        findEmployeeByExample();
        findEmployeeByExampleCriteria();
        findEmployeeBySoftCriteria();
    }
    
    private static void findEmployee() {
        System.out.println( "\n\n**** findEmployee ****" );
        try {
            Employee employee = dao.findFor( 1 );
            System.out.println( employee );
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }
    
    private static void findEmployees() {
        System.out.println( "\n\n**** findEmployees ****" );
        try {
            Employee employee = null;
            Collection employees = dao.findForLastName( "Glyzewski" );
            
            for( Iterator i = employees.iterator(); i.hasNext(); ) {
                employee = (Employee) i.next();
                System.out.println( employee );
            }
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }
    
    private static void findEmployeeByExample() {
        System.out.println( "\n\n**** findEmployeesByExample ****" );
        try {
            Employee exampleCriteria = new Employee();
            exampleCriteria.setLastName( "Chaltry" );
            Employee employee = dao.findFor( exampleCriteria );
            
            System.out.println( employee );
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }
    
    private static void findEmployeeByExampleCriteria() {
        System.out.println( "\n\n**** findEmployeeByExampleCriteria ****" );
        try {
            EmployeeCriteria exampleCriteria = new EmployeeCriteria();
            exampleCriteria.setLastNameEquals( "Chaltry" );
            Employee employee = dao.findFor( exampleCriteria );
            
            System.out.println( employee );

            exampleCriteria = new EmployeeCriteria();
            exampleCriteria.setLastNameLike( "haltr" );
            employee = dao.findFor( exampleCriteria );
            
            System.out.println( employee );

            exampleCriteria = new EmployeeCriteria();
            exampleCriteria.setLastNameNull(true);
            employee = dao.findFor( exampleCriteria );
            
            System.out.println( employee );
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }
    
    private static void findEmployeeBySoftCriteria() {
        System.out.println( "\n\n**** findEmployeeBySoftCriteria ****" );
        try {
            SimpleSoftEmployeeCriteria criteria 
                = new SimpleSoftEmployeeCriteria();
            criteria.put( SimpleSoftEmployeeCriteria.FIRST_NAME, "Dale" );
            Employee employee = dao.findFor( criteria );
            
            System.out.println( employee );
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }

    private static void insertEmployee() {
        System.out.println( "\n\n**** insertEmployee ****" );
        Employee newEmployee = new Employee();
        Employee insertedEmployee = null;
        newEmployee.setFirstName( "Wilbur" );
        newEmployee.setLastName( "Surfer" );
        newEmployee.setEmail( "wilbur.surfer@centare.com" );
        System.out.println( newEmployee );
        try {
            insertedEmployee = dao.insert( newEmployee );
            System.out.println( insertedEmployee );
        }
        catch( PersistenceException e ) {
            e.printStackTrace();
        }
    }
    
    private static void updateEmployee() {
        System.out.println( "\n\n**** updateEmployee ****" );
        Employee employee = null;
        try {
            employee = dao.findFor( 1 );
            System.out.println( employee );
            
            employee.setEmail( "dglyzewski@centare.com" );
            dao.update( employee );
            
            employee = dao.findFor( 1 );
            System.out.println( employee );
        }
        catch( PersistenceException e ) {
            e.printStackTrace();
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }
    
    private static void deleteEmployee() {
        System.out.println( "\n\n**** deleteEmployee ****" );
        Employee employee = null;
        try {
            employee = dao.findFor( 4 );
            System.out.println( employee );
            
            dao.delete( employee );
            
            employee = dao.findFor( 4 );
            System.out.println( employee );
        }
        catch( PersistenceException e ) {
            e.printStackTrace();
        }
        catch( FindException e ) {
            e.printStackTrace();
        }
    }
}
