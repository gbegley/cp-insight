package net.jinius.hdp.cubemodel.feature.indexed;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 */
public class NumberFeature extends AbstractIndexedFeature<Number,String[]>{

    private NumberFormat format;

    public NumberFeature(String key, String[] keys) {
        this(key, keys,NumberFormat.getInstance());
    }

    public NumberFeature(String key, String[] keys, NumberFormat format) {
        super(key, keys);
        this.format = format;
    }


    @Override
    public Number scan(String[] record) {
        String k = findTarget(record);
        Number n = null;
        if(k!=null) {
            try {
                n = format.parse(k);
            } catch (ParseException e) {
                throw new IllegalArgumentException(k);
            }
        }
        return n;
    }
}
