package com.apress.javapersistence.chapter07.dao;

import com.apress.javapersistence.chapter07.bo.*;
import java.sql.*;
import java.util.*;

public class ShoppingCartDAO {
    static final String FIND_UID_SQL = "SELECT * "
    + "FROM shopping_carts WHERE uid = ?";
    static final String DELETE_ITEM_ASSOCS = "DELETE "
    + "FROM shopping_cart_items_assoc WHERE cart_uid = ?";
    static final String INSERT_ITEM_ASSOC = "INSERT "
    + "INTO shopping_cart_items_assoc (cart_uid, item_uid)  VALUES (?, ?)";
    
    private static ShoppingCartDAO instance = new ShoppingCartDAO();
    
    private ShoppingCartDAO() {
    }
    
    public static ShoppingCartDAO getInstance() {
        return instance;
    }
    
    public ShoppingCart findFor( String uid ) throws FindException {
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
    
    ShoppingCart findFor( Connection connection, String uid )
    throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement( FIND_UID_SQL );
            statement.setString( 1, uid );
            resultSet = statement.executeQuery();
            if( resultSet.next() )
                return loadShoppingCartFrom( connection, resultSet );
            return null;
        }
        finally {
            ConnectionManager.closeAll( resultSet, statement );
        }
    }
    
    public ShoppingCart store( ShoppingCart cart ) throws StoreException {
        Connection connection = null;
        try {
            connection = ConnectionManager.getConnection();
            return store( connection, cart );
        }
        catch( SQLException e ) {
            throw new StoreException( e.getMessage() );
        }
        finally {
            ConnectionManager.close( connection );
        }
    }
    
    ShoppingCart store( Connection connection, ShoppingCart cart )
    throws SQLException {
        if( cart.getUid() == null )
            return insert( connection, cart );
        else
            return update( connection, cart );
    }
    
    ShoppingCart insert( Connection connection, ShoppingCart cart )
    throws SQLException {
        return null;
    }
    
    ShoppingCart update( Connection connection, ShoppingCart cart )
    throws SQLException {
        deleteItemAssocs( connection, cart );
        insertItemAssocs( connection, cart );
        return cart;
    }
    
    void deleteItemAssocs( Connection connection, ShoppingCart cart )
    throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( DELETE_ITEM_ASSOCS );
            statement.setString( 1, cart.getUid() );
            statement.executeUpdate();
        }
        finally {
            ConnectionManager.close( statement );
        }
    }
    
    void insertItemAssocs( Connection connection, ShoppingCart cart )
    throws SQLException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement( INSERT_ITEM_ASSOC );
            for( int i = 0; i < cart.getNumberItems(); i++ ) {
                statement.setString( 1, cart.getUid() );
                statement.setString( 2, cart.getItem( i ).getUid() );
                statement.executeUpdate();
            }
        }
        finally {
            ConnectionManager.close( statement );
        }
    }
    
    ShoppingCart loadShoppingCartFrom( Connection connection, ResultSet resultSet )
    throws SQLException {
        ShoppingCart cart = createShoppingCart(resultSet);
        List items = ItemDAO.getInstance().findFor( connection, cart );
        for( Iterator i = items.iterator(); i.hasNext(); )
            cart.addItem( (Item) i.next() );
        return cart;
    }
    
    ShoppingCart createShoppingCart( ResultSet resultSet )
    throws SQLException {
        return new ShoppingCart( resultSet.getString( "uid" ) );
    }
}
