package com.apress.javapersistence.chapter07.bo;

import java.util.*;

public class ShoppingCart {
    private String uid;
    private List items = new ArrayList();

    public ShoppingCart( String uid ) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }
    
    public void addItem( Item item ) {
        items.add( item );
    }
    
    public int getNumberItems() {
        return items.size();
    }
    
    public Item getItem( int index ) {
        return (Item) items.get( index );
    }
}
