package net.jinius.hdp.cubemodel.feature;

import net.jinius.hdp.cubemodel.Sale;
import net.jinius.hdp.cubemodel.feature.indexed.EntityFeature;
import net.jinius.hdp.cubemodel.feature.indexed.PricingFeature;
import net.jinius.hdp.cubemodel.feature.indexed.ProductFeature;

import javax.swing.*;
import java.util.*;

/**
 */
public class SaleFeatureTest {




    public void testSalesFeature(){
        String [] headers = new String[]{
                "PRODUCT_ID",
                "PRODUCT_DESCRIPTION",
                "BILL_TO_CUSTOMER_ID",
                "VENDOR_ID",
                "BASE",
                "COL1",
                "COL2",
                "COL3",
                "LIST"
        };
        String [][] lines = new String[][]{
            {
                    "PROD-111",
                    "111 - A really cool product",
                    "CUST_111",
                    "VEND-111",
                    "2.0",    //"BASE",
                    "2.1",    //"COL1",
                    "2.2",    //"COL2",
                    "2.3",    //"COL3",
                    "2.4"    //"LIST"
            },{
                    "PROD-222",
                    "222 - A really cool product",
                    "CUST_222",
                    "VEND-222",
                    "4.0",    //"BASE",
                    "4.1",    //"COL1",
                    "4.2",    //"COL2",
                    "4.3",    //"COL3",
                    "4.4"    //"LIST"
            }
        };


        EntityFeature customerFeature = new EntityFeature("BILL_TO_CUSTOMER_ID",headers);
        EntityFeature vendorFeature = new EntityFeature("VENDOR_ID",headers);
        EntityFeature mfrFeature = new EntityFeature("MFR_CODE",headers);
        ProductFeature productFeature = new ProductFeature("PRODUCT_ID",
                new LinkedHashSet<String>(Arrays.asList("PRODUCT_DESCRIPTION")),headers);


        PricingFeature pricingFeature = new PricingFeature(headers,"BASE","COL1","COL2","COL3","LIST"  );
        SaleFeature saleFeature = new SaleFeature();
        Map<String,EntityFeature> entities = new LinkedHashMap<String, EntityFeature>();
        entities.put("customer",customerFeature);
        entities.put("vendor",vendorFeature);
        entities.put("manufacturer",mfrFeature);
        saleFeature.setEntityFeatures(entities);
        saleFeature.setPricingFeature(pricingFeature);
        saleFeature.setProductFeature(productFeature);

        List<Sale> sales = new ArrayList<Sale>();
        for(String[]line:lines) {
            Sale sale = saleFeature.scan(line);
            sales.add(sale);
        }
        System.out.println("Done - results : [");
        for(Sale s : sales) {
            System.out.println(s);
        }
        System.out.println("]");

    }


    public static void main(String[] args) {
        SaleFeatureTest t = new SaleFeatureTest();
        t.testSalesFeature();
    }
}
