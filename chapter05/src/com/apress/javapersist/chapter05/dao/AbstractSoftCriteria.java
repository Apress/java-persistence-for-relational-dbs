/*
 * AbstractCriteria.java
 *
 * Created on September 4, 2002, 9:22 PM
 */

package com.apress.javapersist.chapter05.dao;

import java.util.*;

/**
 *
 * @author  rsperko
 */
public class AbstractSoftCriteria {
    public static final int EQUALS = 1;
    public static final int LIKE = 2;
    public static final int BETWEEN = 3;
    public static final int NULL = 4;
    
    private Map criteria = new HashMap();
    public void addEquals(String attribute, Object value) {
        criteria.put( attribute, new CriteriaEntry(EQUALS, value) );
    }
    
    public void addLike(String attribute, Object value) {
        criteria.put( attribute, new CriteriaEntry(LIKE, value) );
    }
    
    public void addBetween(String attribute, Object value1, Object value2) {
        criteria.put( attribute,
        new CriteriaEntry(BETWEEN,
        new Object[]{ value1, value2 } ) );
    }
    
    public void addNull(String attribute) {
        criteria.put( attribute, new CriteriaEntry(NULL, null) );
    }
    
    public Set getAttributes() {
        return Collections.unmodifiableSet(criteria.keySet());
    }
    
    public Object getValue(String attribute) {
        return ((CriteriaEntry) criteria.get(attribute)).getValue();
    }
    
    public int getType(String attribute) {
        return ((CriteriaEntry) criteria.get(attribute)).getType();
    }
    
    public static class CriteriaEntry {
        private int type;
        private Object value;
        
        private CriteriaEntry(int type, Object value) {
            this.type = type;
            this.value = value;
        }
        
        public int getType() {
            return type;
        }
        
        public Object getValue() {
            return value;
        }
    }
}
