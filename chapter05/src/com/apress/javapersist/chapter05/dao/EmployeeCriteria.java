/*
 * EmployeeCriteria.java
 *
 * Created on August 28, 2002, 8:59 PM
 */

package com.apress.javapersist.chapter05.dao;

/**
 *
 * @author  rsperko
 */
public class EmployeeCriteria {
    String lastNameEquals = null;
    String lastNameLike = null;
    boolean lastNameNull = false;
    
    /** Creates a new instance of EmployeeCriteria */
    public EmployeeCriteria() {
    }
    
    /** Getter for property lastNameEquals.
     * @return Value of property lastNameEquals.
     */
    public String getLastNameEquals() {
        return lastNameEquals;
    }
    
    /** Setter for property lastNameEquals.
     * @param lastNameEquals New value of property lastNameEquals.
     */
    public void setLastNameEquals(String lastNameEquals) {
        this.lastNameEquals = lastNameEquals;
    }
    
    /** Getter for property lastNameLike.
     * @return Value of property lastNameLike.
     */
    public String getLastNameLike() {
        return lastNameLike;
    }
    
    /** Setter for property lastNameLike.
     * @param lastNameLike New value of property lastNameLike.
     */
    public void setLastNameLike(String lastNameLike) {
        this.lastNameLike = lastNameLike;
    }
    
    /** Getter for property lastNameNull.
     * @return Value of property lastNameNull.
     */
    public boolean isLastNameNull() {
        return lastNameNull;
    }
    
    /** Setter for property lastNameNull.
     * @param lastNameNull New value of property lastNameNull.
     */
    public void setLastNameNull(boolean lastNameNull) {
        this.lastNameNull = lastNameNull;
    }
}
