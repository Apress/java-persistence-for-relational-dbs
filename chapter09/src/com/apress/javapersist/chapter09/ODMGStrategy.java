/*
 * InstanceFactory.java
 *
 * Created on October 29, 2002, 10:17 PM
 */

package com.apress.javapersist.chapter09;

import com.apress.javapersist.chapter09.bo.*;
import org.odmg.*;

/**
 *
 * @author  rsperko
 */
public class ODMGStrategy {
//    private static String url = "fastobjects://LOCAL/odmg_base";
    private static String url = "chapter09";
    private static Implementation impl = org.apache.ojb.odmg.OJB.getInstance();
    
    public static Implementation getImpl() {
        return impl;
    }
    
    public static String getDbIdentifier() {
        return url;
    }
    
    public static Employee createEmployee1() {
        ZipCode zipCode = new ZipCode();
        Address address = new Address();
        Employee employee = new Employee();

        zipCode.setFirstFive("55555");
        zipCode.setLastFour("4444");

        address.setCity("Chicago");
        address.setState("IL");
        address.setStreetLine1("123 N. West St.");
        address.setStreetLine2("Suite 134");
        address.setZip(zipCode);
        
        employee.setAddress(address);
        employee.setEmail("dave.glyzewski@centare.com");
        employee.setFirstName( "Dave" );
        employee.setLastName("Glyzewski");
        return employee;
    }
    
    public static Employee createEmployee2() {
        ZipCode zipCode = new ZipCode();
        Address address = new Address();
        Employee employee = new Employee();

        zipCode.setFirstFive("66666");
        zipCode.setLastFour("5555");

        address.setCity("Milwaukee");
        address.setState("WI");
        address.setStreetLine1("456 S. East St.");
        address.setStreetLine2("Suite 246");
        address.setZip(zipCode);
        
        employee.setAddress(address);
        employee.setEmail("ed.chaltry@centare.com");
        employee.setFirstName( "Ed" );
        employee.setLastName("Chaltry");
        return employee;
    }
    
    public static Employee createEmployee3() {
        ZipCode zipCode = new ZipCode();
        Address address = new Address();
        Employee employee = new Employee();

        zipCode.setFirstFive("77777");
        zipCode.setLastFour("6666");

        address.setCity("Milwaukee");
        address.setState("WI");
        address.setStreetLine1("789 E. North St.");
        address.setStreetLine2("Suite 789");
        address.setZip(zipCode);
        
        employee.setAddress(address);
        employee.setEmail("dale.busse@centare.com");
        employee.setFirstName( "Dale" );
        employee.setLastName("Busse");
        return employee;
    }
}
