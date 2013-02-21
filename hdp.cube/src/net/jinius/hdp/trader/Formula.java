package net.jinius.hdp.trader;

/**
 *
 */
public interface Formula<T> {

    public T evaluate(Values v);

}
