package net.jinius.trader;

import net.jinius.trader.values.StringValues;

/**
 * 
 */
public class Product extends StringValues {

    protected Identity identity;

    public Product() {
    }

    public Product(Identity identity) {
        this.identity = identity;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
}
