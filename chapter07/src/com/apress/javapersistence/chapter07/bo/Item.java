/*
 * Item.java
 *
 * Created on October 1, 2002, 8:57 PM
 */

package com.apress.javapersistence.chapter07.bo;

/**
 *
 * @author  rsperko
 */
public class Item {
    private String uid;
    private String description;
    private USMoney price;
    
    /** Creates a new instance of Item */
    public Item() {
    }
    
    /** Getter for property uid.
     * @return Value of property uid.
     *
     */
    public String getUid() {
        return uid;
    }
    
    /** Setter for property uid.
     * @param uid New value of property uid.
     *
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    /** Getter for property description.
     * @return Value of property description.
     *
     */
    public String getDescription() {
        return description;
    }
    
    /** Setter for property description.
     * @param description New value of property description.
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /** Getter for property price.
     * @return Value of property price.
     *
     */
    public USMoney getPrice() {
        return price;
    }
    
    /** Setter for property price.
     * @param price New value of property price.
     *
     */
    public void setPrice(USMoney price) {
        this.price = price;
    }
    
}
