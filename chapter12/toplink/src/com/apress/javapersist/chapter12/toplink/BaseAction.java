package com.apress.javapersist.chapter12.toplink;


import oracle.toplink.sessions.DatabaseLogin;
import oracle.toplink.sessions.DatabaseSession;
import oracle.toplink.sessions.Project;
import oracle.toplink.tools.workbench.XMLProjectReader;

public abstract class BaseAction {
    private static Project project = null;
    
    protected DatabaseSession getSession() throws Exception {
        if (project == null) {
			project = XMLProjectReader.read("config/chapter12.xml");
        }
        DatabaseSession session = project.createDatabaseSession();
		DatabaseLogin login = session.getLogin();
		// user name is provided by configuration
		login.setPassword("password");

        session.login();
        return session;
    }

    public abstract void execute(String[] args) throws Exception;
    
    
    public abstract String exampleString();
}
