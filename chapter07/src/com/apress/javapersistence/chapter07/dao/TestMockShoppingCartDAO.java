/*
 * TestItemDAO.java
 * JUnit based test
 *
 * Created on October 22, 2002, 11:22 AM
 */

package com.apress.javapersistence.chapter07.dao;

import junit.framework.*;
import com.mockobjects.sql.*;
import com.apress.javapersistence.chapter07.bo.*;
import java.sql.Connection;

/**
 *
 * @author rsperko
 */
public class TestMockShoppingCartDAO extends TestCase {
    private ShoppingCartDAO dao = ShoppingCartDAO.getInstance();
    
    public TestMockShoppingCartDAO(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(TestMockShoppingCartDAO.class);
        return suite;
    }
    
    public void setUp() {
    }
    
    public void testFindFor() throws Exception {
        MockJDBCHarness harness = new FindCartOneHarness();
        int expectedItems = 2;
        ShoppingCart cart = dao.findFor( harness.getConnection(),
        FindCartOneHarness.CART_UID );
        assertEquals( expectedItems, cart.getNumberItems() );
        harness.verify();
    }
    
    public void testAddItem() throws Exception {
        String cartUid = "1";
        int expectedItems = 3;
        AddItemHarness harness = new AddItemHarness();
        
        ShoppingCart cart = dao.findFor( AddItemHarness.CART_UID );
        
        cart.addItem( harness.ITEM3 );
        
        Connection connection = harness.getConnection();
        dao.store( connection, cart );
        
        cart = dao.findFor( connection, cartUid );
        
        assertEquals( expectedItems, cart.getNumberItems() );
        
        harness.verify();
    }
    
    public void testCreateShoppingCart() throws Exception {
        String uid = "1";
        MockSingleRowResultSet resultSet = new MockSingleRowResultSet();
        resultSet.addExpectedNamedValues( new String[]{ "uid" }, 
            new Object[]{ uid } );
        
        ShoppingCart cart = dao.createShoppingCart(resultSet);
        assertNotNull(cart);
        assertEquals( uid, cart.getUid() );
        
        resultSet.verify();
    }
}

abstract class MockJDBCHarness {
    protected MockConnection connection = new MockConnection();
    public Connection getConnection() {
        build();
        return connection;
    }
    public abstract void build();
    public abstract void verify();
}

class FindCartOneHarness extends MockJDBCHarness {
    public static final String CART_UID = "1";
    public static final String ITEM1_UID = "1";
    public static final String ITEM2_UID = "3";
    
    protected MockPreparedStatement prepStatement1 = new MockPreparedStatement();
    protected MockPreparedStatement prepStatement2 = new MockPreparedStatement();
    protected MockSingleRowResultSet resultSet1 = new MockSingleRowResultSet();
    protected MockMultiRowResultSet resultSet2 = new MockMultiRowResultSet();
    
    public void build() {
        connection.addExpectedPreparedStatementString( ShoppingCartDAO.FIND_UID_SQL );
        connection.addExpectedPreparedStatement( prepStatement1 );
        
        prepStatement1.addExpectedSetParameters( new Object[]{ CART_UID } );
        prepStatement1.addResultSet( resultSet1 );
        
        resultSet1.addExpectedNamedValues(
        new String[]{ "uid" },
        new Object[]{ "1" } );
        
        connection.addExpectedPreparedStatementString( ItemDAO.FIND_ITEMS_FOR_CART_SQL );
        connection.addExpectedPreparedStatement( prepStatement2 );
        
        prepStatement2.addExpectedSetParameter( 1, CART_UID );
        prepStatement2.addResultSet( resultSet2 );
        
        resultSet2.setupColumnNames( new String[] { "cart_uid", "item_uid", "uid", "description", "dollars", "cents" } );
        resultSet2.setupRows( new Object[][] {
            { CART_UID, ITEM1_UID, ITEM1_UID, "Ping Pong Table", new Integer( 100 ), new Integer( 50 ) },
            { CART_UID, ITEM2_UID, ITEM2_UID, "Running Shoes", new Integer( 89 ), new Integer( 75 ) }
        } );
    }
    
    public void verify() {
        connection.verify();
        prepStatement1.verify();
        prepStatement2.verify();
        resultSet1.verify();
        resultSet2.verify();
    }
}


class AddItemHarness extends FindCartOneHarness {
    public static final String ITEM3_UID = "2";
    public static final String ITEM3_DESC = "Roller Blades";
    public static final Integer dollars = new Integer( 99 );
    public static final Integer cents = new Integer( 95 );
    public static final Item ITEM3;
    static {
        ITEM3 = new Item();
        ITEM3.setUid( ITEM3_UID );
        ITEM3.setDescription(ITEM3_DESC );
        ITEM3.setPrice( new USMoney(dollars.intValue(), cents.intValue() ) );
    }
    private MockPreparedStatement prepStatement1 = new MockPreparedStatement();
    private MockPreparedStatement prepStatement2 = new MockPreparedStatement();

    public void build() {
        connection.addExpectedPreparedStatementString( ShoppingCartDAO.DELETE_ITEM_ASSOCS );
        connection.addExpectedPreparedStatement( prepStatement1 );
        
        prepStatement1.addExpectedSetParameters( new Object[]{ CART_UID } );
        
        connection.addExpectedPreparedStatementString( ShoppingCartDAO.INSERT_ITEM_ASSOC );
        connection.addExpectedPreparedStatement( prepStatement2 );
        
        prepStatement2.addExpectedSetParameters( new Object[]{ CART_UID, ITEM1_UID } );
        prepStatement2.addExpectedSetParameters( new Object[]{ CART_UID, ITEM2_UID } );
        prepStatement2.addExpectedSetParameters( new Object[]{ CART_UID, ITEM3_UID } );
        
        super.build();
        
        resultSet2.setupRows( new Object[][] {
            { CART_UID, ITEM1_UID, ITEM1_UID, "Ping Pong Table", new Integer( 100 ), new Integer( 50 ) },
            { CART_UID, ITEM3_UID, ITEM3_UID, "Roller Blades", new Integer( 99 ), new Integer( 95 ) },
            { CART_UID, ITEM2_UID, ITEM2_UID, "Running Shoes", new Integer( 89 ), new Integer( 75 ) }
        } );
    }
    
    public void verify() {
        prepStatement1.verify();
        prepStatement2.verify();
        super.verify();
    }
}
