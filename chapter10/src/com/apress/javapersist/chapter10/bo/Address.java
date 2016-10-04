/*
 * Address.java
 *`
 * Created on October 25, 2002, 8:58 PM
 */

package com.apress.javapersist.chapter10.bo;

import java.util.*;

/**
 *
 * @author  rsperko
 */
public class Address {
    private long id;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String state;
    private ZipCode zip;
    private ArrayList residents = new ArrayList();

    public Address() {}

    public Address(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    /** Getter for property city.
     * @return Value of property city.
     *
     */
    public String getCity() {
        return city;
    }    
    
    /** Setter for property city.
     * @param city New value of property city.
     *
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /** Getter for property state.
     * @return Value of property state.
     *
     */
    public String getState() {
        return state;
    }
    
    /** Setter for property state.
     * @param state New value of property state.
     *
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /** Getter for property streetLine1.
     * @return Value of property streetLine1.
     *
     */
    public String getStreetLine1() {
        return streetLine1;
    }
    
    /** Setter for property streetLine1.
     * @param streetLine1 New value of property streetLine1.
     *
     */
    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }
    
    /** Getter for property streetLine2.
     * @return Value of property streetLine2.
     *
     */
    public String getStreetLine2() {
        return streetLine2;
    }
    
    /** Setter for property streetLine2.
     * @param streetLine2 New value of property streetLine2.
     *
     */
    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }
    
    /** Getter for property zip.
     * @return Value of property zip.
     *
     */
    public ZipCode getZip() {
        return zip;
    }
    
    /** Setter for property zip.
     * @param zip New value of property zip.
     *
     */
    public void setZip(ZipCode zip) {
        this.zip = zip;
    }

    /**
     * Returns the resident.
     * @return Employee
     */
    public Collection getResidents() {
        return residents;
    }

    /**
     * Sets the resident.
     * @param resident The resident to set
     */
    public void addResident(Employee resident) {
        this.residents.add(resident);
    }

    public String toString() {
        return  "id: " + id + "; "
            + "line 1: " + streetLine1 + "; "
            + "line 2: " + streetLine2 + "; "
            + "city: " + city + "; "
            + "state: " + state + "; "
            + "residents: " + residents.size() + "; "
            + "zip: [" + zip + "]";
    }
}
