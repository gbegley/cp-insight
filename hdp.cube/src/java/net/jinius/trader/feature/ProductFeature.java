package net.jinius.trader.feature;

import net.jinius.trader.Entity;
import net.jinius.trader.IdentityStringValues;
import net.jinius.trader.Product;

import java.util.Set;

/**
 *
 */
public class ProductFeature implements Feature<Product,String[]>{

    private IdentityStringValuesFeature isvFeature;

    public ProductFeature(String idKey, String[] keys) {
        this(idKey, null, keys);
    }
    public ProductFeature(String idKey, Set<String> names, String[] keys) {
        isvFeature = new IdentityStringValuesFeature(idKey,names, keys);
    }

    public Product scan(String[] record) {
        IdentityStringValues isv = isvFeature.scan(record);
        Product p = new Product(isv.getIdentity());
        p.setValues(isv.getValues());
        return p;
    }
}
