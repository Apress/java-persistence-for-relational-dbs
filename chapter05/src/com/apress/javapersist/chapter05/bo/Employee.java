/*
 * Employee.java
 *
 * Created on August 21, 2002, 9:13 PM
 */

package com.apress.javapersist.chapter05.bo;

/**
 *
 * @author  rsperko
 */
public class Employee {
    
    /** Holds value of property oid. */
    private long oid;
    
    /** Holds value of property firstName. */
    private String firstName;
    
    /** Holds value of property lastName. */
    private String lastName;
    
    /** Holds value of property email. */
    private String email;
    
    /** Creates a new instance of Employee */
    public Employee() {
    }
    
    /** Creates a new instance of Employee */
    public Employee( long oid ) {
        this.oid = oid;
    }
    
    /** Getter for property oid.
     * @return Value of property oid.
     */
    public long getOid() {
        return this.oid;
    }
    
    /** Getter for property firstName.
     * @return Value of property firstName.
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /** Setter for property firstName.
     * @param firstName New value of property firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /** Getter for property lastName.
     * @return Value of property lastName.
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /** Setter for property lastName.
     * @param lastName New value of property lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /** Getter for property email.
     * @return Value of property email.
     */
    public String getEmail() {
        return this.email;
    }
    
    /** Setter for property email.
     * @param email New value of property email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return "oid: " + oid + "; "
            + "firstName: " + firstName + "; "
            + "lastName: " + lastName + "; "
            + "email: " + email;
    }
}
