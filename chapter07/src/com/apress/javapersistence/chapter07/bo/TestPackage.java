/*
 * TestPackage.java
 *
 * Created on October 7, 2002, 7:50 PM
 */

package com.apress.javapersistence.chapter07.bo;

import junit.framework.*;

public class TestPackage extends TestCase {
    public TestPackage(String s) {
      super(s);
    }

    public static Test suite() {
      TestSuite suite = new TestSuite();

      suite.addTest( TestShoppingCart.suite() );
      suite.addTest( TestUSMoney.suite() );

      return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
