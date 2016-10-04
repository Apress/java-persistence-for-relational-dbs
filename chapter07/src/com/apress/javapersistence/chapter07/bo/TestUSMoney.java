package com.apress.javapersistence.chapter07.bo;

import junit.framework.*;

/**
 *
 * @author rsperko
 */
public class TestUSMoney extends TestCase {
    public TestUSMoney(String s) {
	super( s );
    }

    public void testAddTo() throws Exception {
	USMoney money1 = new USMoney( 1, 50 );
	USMoney money2 = new USMoney( 1, 75 );
	
	USMoney money3 = money1.addTo( money2 );

	assertEquals( 3, money3.getDollars() );
	assertEquals( 25, money3.getCents() );
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(TestUSMoney.class);
        return suite;
    }
}
