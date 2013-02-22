package net.jinius.trader.feature.indexed;

/**
 *
 */
public class StringFeature extends AbstractIndexedFeature<String,String[]> {


    protected StringFeature(String key, String[] keys) {
        super(key, keys);
    }

    @Override
    public String scan(String[] record) {
        return findTarget(record);
    }
}
