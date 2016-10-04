package com.apress.javapersist.chapter12.cocobase;

import java.util.Properties;

import thought.CocoBase.CocoFactoryInterface;
import thought.CocoBase.CocoProxyM;

import com.apress.javapersist.chapter12.cocobase.bo.Address;
import com.apress.javapersist.chapter12.cocobase.bo.Employee;

public class BusinessObjectFactory implements CocoFactoryInterface {

    public Object getInstance(Object src, 
            Object propertiesIn, 
            String objectName) {
        Properties properties = (Properties) propertiesIn;
        try {
            // For each type with custom factory.
            if(BaseAction.EMPLOYEE_MAP.equals(objectName)) {
                Employee employee = new Employee();

                // the following shows how you can manage your own data that 
                // comes back from CocoBase
                Long id = (Long) properties.get("ID");
                employee.setId(id);
                
                CocoProxyM employeeProxy = new CocoProxyM(employee);
                employeeProxy.setPropObjectData(properties);
                
                return employee;
            }
            else if(BaseAction.ADDRESS_MAP.equals(objectName)) {
                Address address = new Address();
                
                CocoProxyM addressProxy = new CocoProxyM(address);
                addressProxy.setPropObjectData(properties);
                
                return address;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
