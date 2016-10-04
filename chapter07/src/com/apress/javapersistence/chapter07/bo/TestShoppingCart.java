package com.apress.javapersistence.chapter07.bo;

import junit.framework.*;

public class TestShoppingCart extends TestCase {

    
    public TestShoppingCart(String testName) {
        super(testName);
    }
    
    public void testAddItem() throws Exception {
        ShoppingCart cart = new ShoppingCart("fakeuid");
        Item item = new Item();
        cart.addItem(item);
        assertEquals(1, cart.getNumberItems() );
        assertEquals(item, cart.getItem( 0 ) );
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(TestShoppingCart.class);
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
