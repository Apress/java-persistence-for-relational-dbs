/*
 *  Employee.java
 *
 *  Created on August 21, 2002, 9:13 PM
 */
package com.apress.javapersist.chapter09.bo;

/**
 *@author     rsperko
 *@created    April 19, 2003
 */
public class Employee {
    private long id;

    /**
     *  Holds value of property firstName.
     */
    private String firstName;

    /**
     *  Holds value of property lastName.
     */
    private String lastName;

    /**
     *  Holds value of property email.
     */
    private String email;

    private Address address;

    private long addressId;


    /**
     *  Creates a new instance of Employee
     */
    public Employee() { }


    /**
     *  Sets the id attribute of the Employee object
     *
     *@param  id  The new id value
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     *  Gets the id attribute of the Employee object
     *
     *@return    The id value
     */
    public long getId() {
        return id;
    }


    /**
     *  Getter for property firstName.
     *
     *@return    Value of property firstName.
     */
    public String getFirstName() {
        return this.firstName;
    }


    /**
     *  Setter for property firstName.
     *
     *@param  firstName  New value of property firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     *  Getter for property lastName.
     *
     *@return    Value of property lastName.
     */
    public String getLastName() {
        return this.lastName;
    }


    /**
     *  Setter for property lastName.
     *
     *@param  lastName  New value of property lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     *  Getter for property email.
     *
     *@return    Value of property email.
     */
    public String getEmail() {
        return this.email;
    }


    /**
     *  Setter for property email.
     *
     *@param  email  New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public String toString() {
        return "firstName: " + firstName + "; "
                + "lastName: " + lastName + "; "
                + "email: " + email + "; "
                + "address: [" + address + "]";
    }


    /**
     *  Getter for property address.
     *
     *@return    Value of property address.
     */
    public Address getAddress() {
        return address;
    }


    /**
     *  Setter for property address.
     *
     *@param  address  New value of property address.
     */
    public void setAddress(Address address) {
        this.address = address;
    }


    /**
     *  Gets the addressId attribute of the Employee object
     *
     *@return    The addressId value
     */
    public long getAddressId() {
        return addressId;
    }


    /**
     *  Sets the addressId attribute of the Employee object
     *
     *@param  addressId  The new addressId value
     */
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
}
