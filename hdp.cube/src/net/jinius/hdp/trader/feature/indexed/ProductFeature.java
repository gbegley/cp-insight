package net.jinius.hdp.trader.feature.indexed;

import net.jinius.hdp.trader.Product;

import java.util.Map;
import java.util.Set;

/**
 *
 */
public class ProductFeature extends EntityFeature {


    public ProductFeature(String idKey, Set<String> names, String[] keys) {
        super(idKey,names,keys);
    }

    @Override
    public Product scan(String[] record) {
        Product e = new Product(record[idIndex]);
        for(Map.Entry<String,Integer> me : nameToIndexMap.entrySet()) {
            Integer i = me.getValue();
            String v = i!=null && i > 0 && i < record.length ? record[i] : null;
            if(v!=null) {
                e.put(me.getKey(),v);
            }
        }
        return e;
    }
}
