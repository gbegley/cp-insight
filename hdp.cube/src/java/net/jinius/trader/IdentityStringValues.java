package net.jinius.trader;

import net.jinius.trader.values.StringValues;
import net.jinius.trader.values.Values;

/**
 *
 */
public class IdentityStringValues extends StringValues {

    protected Identity identity;

    public IdentityStringValues() {
    }

    public IdentityStringValues(Identity identity) {
        this.identity = identity;
    }

    public IdentityStringValues(Identity identity, StringValues sv) {
        this.identity = identity;
        setValues(sv.getValues());
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
}
