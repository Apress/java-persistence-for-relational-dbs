package com.apress.javapersist.chapter05.dao;

import java.rmi.dgc.VMID;

/*
 * VMIDTest.java
 *
 * Created on September 18, 2002, 9:48 PM
 */

/**
 *
 * @author  rsperko
 */
public class VMIDTest {
    
    /** Creates a new instance of VMIDTest */
    public VMIDTest() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String vmid = new VMID().toString();
        System.out.println( vmid );
    }
    
}
