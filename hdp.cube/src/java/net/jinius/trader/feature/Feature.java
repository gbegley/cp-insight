package net.jinius.trader.feature;

/**
 *
 */
public interface Feature<T,R> {

    T scan(R record);

}
