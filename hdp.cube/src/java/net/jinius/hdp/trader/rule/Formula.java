package net.jinius.hdp.trader.rule;

import net.jinius.hdp.trader.Values;

/**
 *
 */
public interface Formula<T> {

    public T evaluate(Values v);

}
