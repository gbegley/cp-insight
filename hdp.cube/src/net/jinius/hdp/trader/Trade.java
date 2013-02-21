package net.jinius.hdp.trader;

import java.util.LinkedHashMap;

/**
 *
 */
public class Trade extends LinkedHashMap<String,Entity> {

    private Product product;
    private Pricing pricing;

    public Trade() {
    }

    public Trade(Product product, Pricing pricing) {
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
