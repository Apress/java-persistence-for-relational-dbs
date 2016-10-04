package com.apress.javapersist.chapter11.castorjdo.bo;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;

    public Employee() {}

    public Employee(Long id) { this.id = id; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return this.firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return this.lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }
    
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public String toString() {
        return "id: " + id + "; "
            + "firstName: " + firstName + "; "
            + "lastName: " + lastName + "; "
            + "email: " + email + "; "
            + "address: [" + address + "]";
    }
}
