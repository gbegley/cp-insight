package net.jinius.trader.rule;

import net.jinius.trader.pricing.Profile;
import net.jinius.trader.values.Values;

/**
 *
 */
public interface Formula<T> {

    public T evaluate(Profile profile);

}
