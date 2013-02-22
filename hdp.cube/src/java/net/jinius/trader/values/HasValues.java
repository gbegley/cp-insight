package net.jinius.trader.values;

/**
 *
 */
public interface HasValues<T> {

    public Values<T> getValues();

    public T get(String s);

    public void setValue(String k,T t);

}
