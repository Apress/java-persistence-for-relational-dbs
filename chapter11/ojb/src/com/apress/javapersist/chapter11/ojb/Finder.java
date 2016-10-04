package com.apress.javapersist.chapter11.ojb;

import java.util.Iterator;

import org.apache.ojb.broker.PersistenceBroker;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.Query;
import org.apache.ojb.broker.query.QueryByCriteria;

public class Finder {
	public Iterator find(PersistenceBroker broker, String[] args) throws Exception {
		Class clazz = getClass(args[0]);
		
		Criteria criteria = new Criteria();
		if(args.length == 2) { // class and command
			String cmd = args[1];
			if("all".equals(cmd)) {
				// add no criteria want to return all
			}
		}
		else if(args.length > 2){ 
			String attribute = args[1];
			String comparison = args[2];
			String value = args[3];
			if("equals".equals(comparison)) {
				criteria.addEqualTo(attribute, value);
			}
			else if("notEquals".equals(comparison)) {
				criteria.addNotEqualTo(attribute, value);
			}
		}
		
		Query query = new QueryByCriteria(clazz,criteria);
		return broker.getIteratorByQuery(query);
	}

    private static Class getClass(String className) 
        throws ClassNotFoundException {
        return Class.forName("com.apress.javapersist.chapter11.ojb.bo." 
            + className);
    }
}
