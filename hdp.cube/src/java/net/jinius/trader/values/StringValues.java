package net.jinius.trader.values;

/**
 * 
 */
public class StringValues implements HasValues<String> {

    protected Values<String> values = new BasicValues<String>();

    @Override
    public Values<String> getValues() {
        return values;
    }

    public void setValues(Values<String> values) {
        this.values = values;
    }

    @Override
    public String get(String s) {
        return values.get(s);
    }

    @Override
    public void setValue(String k, String s) {
        values.put(k,s);
    }

}

