package com.apress.javapersist.chapter11.castorjdo;

import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.JDO;
import org.exolab.castor.jdo.Query;
import org.exolab.castor.jdo.QueryResults;

public abstract class BaseAction {
    private JDO castorJDO = null;
    
    protected Database getDatabase() throws Exception {
        if (castorJDO == null) {
            castorJDO = new JDO();
            castorJDO.setDatabaseName( "chapter11" );
            castorJDO.setConfiguration( "config/database.xml" );
            castorJDO.setClassLoader( getClass().getClassLoader() );
        }
        return castorJDO.getDatabase();
    }

    protected QueryResults findAll(Database database, String queryStr) throws Exception {
        Query query = database.getOQLQuery(queryStr);
        return query.execute();
    }

    public abstract void execute(String[] args) throws Exception;
    
    public abstract String exampleString();
}
