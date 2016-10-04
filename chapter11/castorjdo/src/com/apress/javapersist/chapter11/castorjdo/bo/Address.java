package com.apress.javapersist.chapter11.castorjdo.bo;

import java.util.*;

/**
 *  Description of the Class
 *
 *@author     rsperko
 *@created    April 20, 2003
 */
public class Address {
    private Long id;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String state;
    private Set residents = new HashSet();


    /**
     *  Constructor for the Address object
     */
    public Address() { }


    /**
     *  Constructor for the Address object
     *
     *@param  id  Description of the Parameter
     */
    public Address(Long id) {
        this.id = id;
    }


    /**
     *  Gets the id attribute of the Address object
     *
     *@return    The id value
     */
    public Long getId() {
        return id;
    }


    /**
     *  Sets the id attribute of the Address object
     *
     *@param  id  The new id value
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     *  Gets the city attribute of the Address object
     *
     *@return    The city value
     */
    public String getCity() {
        return city;
    }


    /**
     *  Sets the city attribute of the Address object
     *
     *@param  city  The new city value
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     *  Gets the state attribute of the Address object
     *
     *@return    The state value
     */
    public String getState() {
        return state;
    }


    /**
     *  Sets the state attribute of the Address object
     *
     *@param  state  The new state value
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     *  Gets the streetLine1 attribute of the Address object
     *
     *@return    The streetLine1 value
     */
    public String getStreetLine1() {
        return streetLine1;
    }


    /**
     *  Sets the streetLine1 attribute of the Address object
     *
     *@param  streetLine1  The new streetLine1 value
     */
    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }


    /**
     *  Gets the streetLine2 attribute of the Address object
     *
     *@return    The streetLine2 value
     */
    public String getStreetLine2() {
        return streetLine2;
    }


    /**
     *  Sets the streetLine2 attribute of the Address object
     *
     *@param  streetLine2  The new streetLine2 value
     */
    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }


    /**
     *  Sets the residents attribute of the Address object
     *
     *@param  residents  The new residents value
     */
    public void setResidents(Set residents) {
        this.residents = residents;
    }

    public void setResidents(Employee resident) {
    }

    /**
     *  Gets the residents attribute of the Address object
     *
     *@return    The residents value
     */
    public Set getResidents() {
        return residents;
    }


    /**
     *  Adds a feature to the Resident attribute of the Address object
     *
     *@param  resident  The feature to be added to the Resident attribute
     */ 
    public void addResident(Employee resident) { this.residents.add(resident); }

    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public String toString() {
        return "id: " + id + "; "
                + "line 1: " + streetLine1 + "; "
                + "line 2: " + streetLine2 + "; "
                + "city: " + city + "; "
                + "state: " + state + "; "
                + "residents: " + residents.size() + ";";
    }
}
