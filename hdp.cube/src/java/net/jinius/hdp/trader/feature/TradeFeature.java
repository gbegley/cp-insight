package net.jinius.hdp.trader.feature;

import net.jinius.hdp.trader.Pricing;
import net.jinius.hdp.trader.Product;
import net.jinius.hdp.trader.Trade;
import net.jinius.hdp.trader.feature.indexed.PricingFeature;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class TradeFeature implements Feature<Trade,String[]> {

    private Map<String,EntityFeature> entityFeatures;
    private ProductFeature productFeature;
    private PricingFeature pricingFeature;

    public TradeFeature() {
    }

    public TradeFeature(
            LinkedHashMap<String, EntityFeature> entityFeatures,
            ProductFeature productFeature,
            PricingFeature pricingFeature
    ) {
        this.entityFeatures = entityFeatures;
        this.productFeature = productFeature;
        this.pricingFeature = pricingFeature;
    }

    @Override
    public Trade scan(String[] record) {
        Product p = productFeature.scan(record);
        Pricing c = pricingFeature.scan(record);
        Trade s  = new Trade(p,c);
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
