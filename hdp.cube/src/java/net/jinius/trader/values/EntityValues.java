package net.jinius.trader.values;

import net.jinius.trader.Entity;

/**
 * 
 */
public class EntityValues<E extends Entity> implements HasValues<E> {

    protected Values<E> values = new BasicValues<E>();

    @Override
    public Values<E> getValues() {
        return values;
    }

    @Override
    public E get(String s) {
        return values.get(s);
    }

    @Override
    public void setValue(String k, E number) {
        values.put(k,number);
    }

}

