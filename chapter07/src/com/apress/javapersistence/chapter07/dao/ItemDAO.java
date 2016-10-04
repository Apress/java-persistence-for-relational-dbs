package com.apress.javapersistence.chapter07.dao;

import java.util.*;
import java.sql.*;
import com.apress.javapersistence.chapter07.bo.*;

public class ItemDAO {
    static final String FIND_ITEMS_FOR_CART_SQL =
	"SELECT * FROM shopping_cart_items_assoc assoc, "
	+ "items i "
	+ "WHERE assoc.item_uid = i.uid "
        + "AND assoc.cart_uid = ?";
    static final String FIND_UID_SQL = "SELECT * "
	+ "FROM items WHERE uid = ?";
    private static ItemDAO instance = new ItemDAO();
    
    private ItemDAO() {}
    
    public static ItemDAO getInstance() {
        return instance;
    }
    
    public Item findFor( String uid ) throws FindException {
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            return findFor( connection, uid );
        }
        catch( SQLException e ) {
            throw new FindException( e.getMessage() );
        }
        finally {
            ConnectionManager.close( connection );
        }
    }
    
    Item findFor( Connection connection, String uid ) throws SQLException {
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    statement = connection.prepareStatement( FIND_UID_SQL );
	    statement.setString( 1, uid );
	    resultSet = statement.executeQuery();
            if( resultSet.next() )
                return loadItemFrom( resultSet );
            return null;
	}
	finally {
	    ConnectionManager.closeAll( resultSet, statement );
	}
    }
    
    public List findFor( ShoppingCart cart ) throws FindException {
	try {
	    return findFor( ConnectionManager.getConnection(), cart );
	}
	catch( SQLException e ) {
	    throw new FindException( e.getMessage() );
	}
    }

    List findFor( Connection connection, ShoppingCart cart )
	throws SQLException {
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	try {
	    statement = connection.prepareStatement( FIND_ITEMS_FOR_CART_SQL );
	    statement.setString( 1, cart.getUid() );
	    resultSet = statement.executeQuery();
	    return loadItemsFrom( resultSet );
	}
	finally {
	    ConnectionManager.closeAll( resultSet, statement );
	}
    }
    
    List loadItemsFrom( ResultSet resultSet ) throws SQLException {
	List items = new ArrayList();
	while( resultSet.next() ) {
	    items.add( loadItemFrom( resultSet ) );
	}
	return items;
    }

    Item loadItemFrom( ResultSet resultSet ) throws SQLException {
	Item newItem = new Item();
	newItem.setUid( resultSet.getString( "uid" ) );
	newItem.setDescription( resultSet.getString( "description" ) );
	int dollars = resultSet.getInt( "dollars" );
	int cents = resultSet.getInt( "cents" );
	newItem.setPrice( new USMoney( dollars, cents ) );
	return newItem;
    }
}
