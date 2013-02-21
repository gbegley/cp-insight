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

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"product\":").append(product);
        sb.append(",");
        sb.append("\"pricing\":").append(pricing);
        sb.append("}");
        return sb.toString();
    }
}
