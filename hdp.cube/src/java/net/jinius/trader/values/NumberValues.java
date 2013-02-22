package net.jinius.trader.values;

/**
 * 
 */
public class NumberValues<N extends Number> implements HasValues<N> {

    protected Values<N> values = new BasicValues<N>();

    @Override
    public Values<N> getValues() {
        return values;
    }

    @Override
    public N get(String s) {
        return values.get(s);
    }

    @Override
    public void setValue(String k, N number) {
        values.put(k,number);
    }

}

