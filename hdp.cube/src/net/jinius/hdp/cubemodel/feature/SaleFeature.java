package net.jinius.hdp.cubemodel.feature;

import net.jinius.hdp.cubemodel.Entity;
import net.jinius.hdp.cubemodel.Pricing;
import net.jinius.hdp.cubemodel.Product;
import net.jinius.hdp.cubemodel.Sale;
import net.jinius.hdp.cubemodel.feature.indexed.EntityFeature;
import net.jinius.hdp.cubemodel.feature.indexed.PricingFeature;
import net.jinius.hdp.cubemodel.feature.indexed.ProductFeature;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class SaleFeature implements Feature<Sale,String[]> {

    private Map<String,EntityFeature> entityFeatures;
    private ProductFeature productFeature;
    private PricingFeature pricingFeature;

    public SaleFeature() {
    }

    public SaleFeature(
            LinkedHashMap<String, EntityFeature> entityFeatures,
            ProductFeature productFeature,
            PricingFeature pricingFeature
    ) {
        this.entityFeatures = entityFeatures;
        this.productFeature = productFeature;
        this.pricingFeature = pricingFeature;
    }

    @Override
    public Sale scan(String[] record) {
        Product p = productFeature.scan(record);
        Pricing c = pricingFeature.scan(record);
        Sale s  = new Sale(p,c);
        for(String k:entityFeatures.keySet()) {
            EntityFeature ef = entityFeatures.get(k);
            s.put(k,ef.scan(record));
        }
        return s;
    }

    public Map<String, EntityFeature> getEntityFeatures() {
        return entityFeatures;
    }

    public void setEntityFeatures(Map<String, EntityFeature> entityFeatures) {
        this.entityFeatures = entityFeatures;
    }

    public ProductFeature getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(ProductFeature productFeature) {
        this.productFeature = productFeature;
    }

    public PricingFeature getPricingFeature() {
        return pricingFeature;
    }

    public void setPricingFeature(PricingFeature pricingFeature) {
        this.pricingFeature = pricingFeature;
    }
}
