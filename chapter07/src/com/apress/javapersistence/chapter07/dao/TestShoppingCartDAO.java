/*
 * TestItemDAO.java
 * JUnit based test
 *
 * Created on October 22, 2002, 11:22 AM
 */

package com.apress.javapersistence.chapter07.dao;

import junit.framework.*;
import com.apress.javapersistence.chapter07.bo.*;

/**
 *
 * @author rsperko
 */
public class TestShoppingCartDAO extends TestCase {
    private ShoppingCartDAO dao = ShoppingCartDAO.getInstance();
    
    public TestShoppingCartDAO(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(TestShoppingCartDAO.class);
        return suite;
    }

    public void testFindFor() throws Exception {
        String cartUid = "1";
        int expectedItems = 2;
        ShoppingCart cart = dao.findFor( cartUid );
        assertEquals( expectedItems, cart.getNumberItems() );
    }
    
    public void testAddItem() throws Exception {
        String cartUid = "1";
        String itemUid = "2";
        int expectedItems = 3;

        ShoppingCart cart = dao.findFor( cartUid );
        Item rollerBlades = ItemDAO.getInstance().findFor( itemUid );
        
        cart.addItem( rollerBlades );
        dao.store( cart );
        
        cart = dao.findFor( cartUid );
        
        assertEquals( expectedItems, cart.getNumberItems() );
    }
}
