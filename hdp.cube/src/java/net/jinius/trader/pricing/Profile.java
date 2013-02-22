package net.jinius.trader.pricing;

import net.jinius.trader.Product;

/**
 *
 */
public class Profile {

    private Product product;
    private Costs costs;
    private Pricing pricing;

    public Profile(Product product, Costs costs, Pricing pricing) {
        this.costs = costs;
        this.pricing = pricing;
    }

    public Costs getCosts() {
        return costs;
    }

    public void setCosts(Costs costs) {
        this.costs = costs;
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
}
