/**
 * Created on Jan 31, 2003
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.apress.javapersist.chapter10;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

/**
 * @author rsperko
 *
 * This class is the super class of all our JDO commands.  This class provides
 * utility methods for all our JDO work.  Specifically this is where we would 
 * obtain our connection to our persistence manager.
 */
public abstract class JDOAction {
    private static PersistenceManagerFactory factory = null;
    
    /**
     * Method getPersistenceManager returns a persistence manager object from
     * the class's static persistence manager factory object.
     */
    protected PersistenceManager getPersistenceManager() {
        if (factory == null) {
            Properties props = loadProperties();

            factory = JDOHelper.getPersistenceManagerFactory(props);
            
        }
        return factory.getPersistenceManager();
    }


    /**
     * Method loadProperties.
     * @return Properties
     */
    protected Properties loadProperties() {
        Properties props = new Properties();
        try {
            InputStream in =
                ClassLoader.getSystemResourceAsStream ("jdo.properties");
            props.load (in);
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return props;
    }


    /**
     * Method findAll.
     * @param className
     * @param string
     * @return Collection
     */
    protected Iterator findAll(PersistenceManager pm, String className,
         String queryStr) {
        try {
            if("extent".equals(queryStr)) {
                return pm.getExtent(getClass(className), false).iterator();
            }
            else {
                Query query = pm.newQuery(getClass(className), queryStr);
                return ((Collection) query.execute()).iterator();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Method getClass.
     * @param className
     */
    private static Class getClass(String className) 
        throws ClassNotFoundException {
        return Class.forName("com.apress.javapersist.chapter10.bo." 
            + className);
    }


    /**
     * Method all of our commands will override to do their work.
     */
    public abstract void execute(String typeName, String[] optional);
    
    
    /**
     * used by the help message to convey how this action will be used.
     */
    public abstract String exampleString();
}
