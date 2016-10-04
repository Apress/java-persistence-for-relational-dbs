package com.apress.javapersistence.chapter07.bo;

public class USMoney {
    private int dollars;
    private int cents;

    public USMoney( int dollars, int cents ) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public USMoney addTo( USMoney money ) {
        int newCents = cents + money.cents;
        int newDollars = dollars + money.dollars + newCents / 100;
        newCents = newCents % 100;
        return new USMoney( newDollars, newCents );
    }

    public boolean equals( Object o ) {
        if( ! ( o instanceof USMoney ) )
            return false;
        USMoney money = (USMoney) o;
        return dollars == money.dollars && cents == money.cents;
    }
}
