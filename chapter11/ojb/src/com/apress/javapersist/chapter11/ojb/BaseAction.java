package com.apress.javapersist.chapter11.ojb;


import java.util.Iterator;

import org.apache.ojb.broker.PBKey;
import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.PersistenceBrokerFactory;

public abstract class BaseAction {
    private PersistenceBroker broker = null;
    
    protected PersistenceBroker getPersistenceBroker() throws Exception {
        if (broker == null) {
        	// Loads hibernate.properties from the classpath
        	broker = PersistenceBrokerFactory.createPersistenceBroker(new PBKey("chapter11"));
        }
        return broker;
    }

    public abstract void execute(String[] args) throws Exception;
    
    public abstract String exampleString();
}
