/*
 * SetupJNDIDataSource.java
 *
 * Created on August 12, 2002, 8:08 PM
 */

package com.apress.javapersistence.chapter04.jdbc20stdext;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import com.mysql.jdbc.jdbc2.optional.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;


/**
 *
 * @author  rsperko
 */
public class SetupJNDIDataSource {
    public static void main(String args[]) {
        if( args.length < 2 ) {
            System.out.println( "usage: SetupJNDIDataSource username password" );
            return;
        }
        
        try {
            startRegistry();
            
            ConnectionPoolDataSource dataSource = createDataSource(args[0], args[1]);

            InitialContext context = createContext();
            context.rebind("HrDS", dataSource);
            
        } catch (Exception e) {
            System.out.println("SetupJNDIDataSource err: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void startRegistry() throws RemoteException {
        LocateRegistry.createRegistry(1099);
        System.out.println("RMI registry ready.");
    }
    
    private static ConnectionPoolDataSource createDataSource(String username, String password) {
        MysqlConnectionPoolDataSource dataSource =
            new MysqlConnectionPoolDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setServerName("localhost");
        dataSource.setPort( 3306 );
        dataSource.setDatabaseName("chapter04_jdbc21");
        return dataSource;
    }
    
    private static InitialContext createContext() throws NamingException {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
            "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, "rmi://localhost:1099");
        InitialContext context = new InitialContext( env );
        return context;
    }
}

