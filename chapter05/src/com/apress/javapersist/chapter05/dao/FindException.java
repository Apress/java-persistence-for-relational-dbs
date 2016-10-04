/*
 * StoreException.java
 *
 * Created on September 18, 2002, 9:44 PM
 */

package com.apress.javapersist.chapter05.dao;

/**
 *
 * @author  rsperko
 */
public class FindException extends com.apress.javapersist.chapter05.dao.WrapperException {
    
    /**
     * Creates a new instance of <code>StoreException</code> without detail message.
     */
    public FindException() {
    }
    
    
    /**
     * Constructs an instance of <code>StoreException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public FindException(Throwable wrapped, String msg) {
        super(wrapped, msg);
    }
}
