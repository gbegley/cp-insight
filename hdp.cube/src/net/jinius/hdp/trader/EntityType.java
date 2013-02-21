package net.jinius.hdp.trader;

/**
 * 
 */
public enum EntityType {

    MANUFACTURER,
    VENDOR,
    SELLER,
    INSIDE,
    OUTSIDE(true),
    BROKER(true),
    BUYER(true),
    CUSTOMER(true)
    ;

    boolean buyer = false;

    EntityType(boolean t){
        this.buyer = t;
    }

    EntityType(){
        this(false);
    }
}
