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
        String [] line = new String[]{
                "PRODUCT_ID",
                "PRODUCT_DESCRIPTION",
                "BILL_TO_CUSTOMER_ID",
                "VENDOR_ID",
                "2.0",    //"BASE",
                "2.1",    //"COL1",
                "2.2",    //"COL2",
                "2.3",    //"COL3",
                "2.4"    //"LIST"
        };


        EntityFeature customerFeature = new EntityFeature("BILL_TO_CUSTOMER_ID",headers);
        EntityFeature vendorFeature = new EntityFeature("BILL_TO_CUSTOMER_ID",headers);
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

        Sale sale = saleFeature.scan(line);
        System.out.println("Done");

    }


    public static void main(String[] args) {
        SaleFeatureTest t = new SaleFeatureTest();
        t.testSalesFeature();
    }
}
