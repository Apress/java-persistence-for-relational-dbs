/*
 * StoreException.java
 *
 * Created on August 21, 2002, 8:35 PM
 */

package com.apress.javapersist.chapter05.dao;

/**
 *
 * @author  rsperko
 */
public class PersistenceException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>StoreException</code> without detail message.
     */
    public PersistenceException() {
    }
    
    
    /**
     * Constructs an instance of <code>StoreException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public PersistenceException(String msg) {
        super(msg);
    }
}
