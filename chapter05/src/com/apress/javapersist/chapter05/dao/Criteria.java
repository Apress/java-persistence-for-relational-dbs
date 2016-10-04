/*
 *  Criteria.java
 *
 *  Created on September 17, 2002, 8:31 PM
 */
package com.apress.javapersist.chapter05.dao;

import java.util.Collection;

/**
 *@author     rsperko
 *@created    September 17, 2002
 */
public interface Criteria {
    /**
     *  Adds a value that the attribute must match
     *
     *@param  attribute  Attribute to compare
     *@param  value      Value it must be equal to
     */
    public void addEquals(String attribute, Object value);


    /**
     *  Adds a value that the attribute must be like (globbing with % for sql)
     *
     *@param  attribute  Attribute to compare
     *@param  value      Value to compare to
     */
    public void addLike(String attribute, Object value);


    /**
     *  Sets values that the attribute must be between
     *
     *@param  attribute  Attribute to compare
     *@param  from       Low end of comparison
     *@param  to         High end of comparison
     */
    public void addBetween(String attribute, Object from, Object to);


    /**
     *  Sets a list of values that the attribute must be contained in
     *
     *@param  attribute  Attribute to compare
     *@param  values     Attribute must match one of the values included
     */
    public void addIn(String attribute, Collection values);


    /**
     *  Adds a feature to the Null attribute of the Criteria object
     *
     *@param  attribute  The feature to be added to the Null attribute
     */
    public void addNull(String attribute);
}

