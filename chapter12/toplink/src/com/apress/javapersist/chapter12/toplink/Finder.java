package com.apress.javapersist.chapter12.toplink;

import java.util.Iterator;
import java.util.Vector;

import oracle.toplink.expressions.Expression;
import oracle.toplink.expressions.ExpressionBuilder;
import oracle.toplink.sessions.DatabaseSession;

public class Finder {
	public Iterator find(DatabaseSession session, String[] args) throws Exception {
		Class clazz = getClass(args[0]);
		
		if(args.length == 2) { // class and command
			String cmd = args[1];
			if("all".equals(cmd)) {
				// add no criteria want to return all
				return findAll(session, clazz);
			}
		}
		else if(args.length > 2){ 
			Expression expression = buildExpression(args);
			Vector results = session.readAllObjects(clazz, expression);
			return results.iterator();
		}
		// Don't recognize what was requested, return null.  Should throw exception.
		return null;
	}
	
	private Iterator findAll(DatabaseSession session, Class clazz) {
		Vector results = session.readAllObjects(clazz);
		return results.iterator();
	}
	
	private Expression buildExpression(String[] args) {
		String attribute = args[1];
		String comparison = args[2];
		String value = args[3];

		ExpressionBuilder builder = new ExpressionBuilder();
		Expression expression = null;
		if("equals".equals(comparison)) {
			expression = builder.get(attribute).equal(value);
		}
		else if("notEquals".equals(comparison)) {
			expression = builder.get(attribute).notEqual(value);
		}
		
		return expression;
	}

    private static Class getClass(String className) 
        throws ClassNotFoundException {
        return Class.forName("com.apress.javapersist.chapter12.toplink.bo." 
            + className);
    }
}