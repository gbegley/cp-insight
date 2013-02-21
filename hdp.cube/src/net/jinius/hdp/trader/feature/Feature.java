package net.jinius.hdp.trader.feature;

/**
 *
 */
public interface Feature<T,R> {

    T scan(R record);

}
