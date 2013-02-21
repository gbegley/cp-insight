package net.jinius.hdp.cubemodel;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class Sale extends LinkedHashMap<String,Entity> {

    private Product product;
    private Pricing pricing;

    public Sale() {
    }

    public Sale(Product product, Pricing pricing) {
        this.product = product;
        this.pricing = pricing;
    }


}
