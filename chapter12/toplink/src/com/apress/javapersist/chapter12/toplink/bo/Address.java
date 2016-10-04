package com.apress.javapersist.chapter12.toplink.bo;

import java.util.*;

public class Address {
    private Long id;
    private String streetLine1;
    private String streetLine2;
    private String city;
    private String state;
    private Set residents = new TreeSet();

    private Address() {}

    public Address(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }    
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getStreetLine1() {
        return streetLine1;
    }
    
    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }
    
    public String getStreetLine2() {
        return streetLine2;
    }
    
    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }
    
    private void setResidents(Set residents) {
        this.residents = residents;
    }
    
    public Set getResidents() {
        return residents;
    }

    public void addResident(Employee resident) {
        this.residents.add(resident);
    }

    public String toString() {
        return  "id: " + id + "; "
            + "line 1: " + streetLine1 + "; "
            + "line 2: " + streetLine2 + "; "
            + "city: " + city + "; "
            + "state: " + state + "; "
            + "residents: " + residents.size() + ";";
    }
}
