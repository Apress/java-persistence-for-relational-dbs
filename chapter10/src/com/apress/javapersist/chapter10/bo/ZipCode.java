/*
 * ZipCode.java
 *
 * Created on October 25, 2002, 8:59 PM
 */

package com.apress.javapersist.chapter10.bo;

/**
 *
 * @author  rsperko
 */
public class ZipCode {
    private long id;
    private String firstFive;
    private String lastFour;
    
    public ZipCode(){}
    
    /** Creates a new instance of ZipCode */
    public ZipCode(long id) {
        this.id = id;
    }

    public void setFirstFive(String firstFive) {
        this.firstFive = firstFive;
    }

    public void setLastFour(String lastFour) {
        this.lastFour = lastFour;
    }

    public long getId() {
        return id;
    }

    public String getFirstFive() {
        return firstFive;
    }
    
    public String getLastFour() {
        return lastFour;
    }
    
    public String toString() {
        return firstFive + "-" + lastFour;
    }
}
