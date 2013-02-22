package net.jinius.trader.feature;

import com.google.common.collect.Lists;
import net.jinius.trader.Entity;
import net.jinius.trader.Trade;
import net.jinius.trader.feature.indexed.PricingFeature;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 */
public class SaleFeatureTest {



    @Test
    public void testSalesFeature(){
        String [] headers = new String[]{
                "PRODUCT_ID",
                "PRODUCT_DESCRIPTION",
                "BILL_TO_CUSTOMER_ID",
                "VENDOR_ID",
                "MFR_CODE",
                "BASE",
                "COL1",
                "COL2",
                "COL3",
                "LIST"
        };
        List<String[]> lines = Lists.newLinkedList();
        String [] formats = new String[]{
                "Prod-%d","Cool product # %d","Cust_%d","Vend_%d","MFR-%d",
                "%d.1","%d.2","%d.3","%d.4","%d.5" // base, col1,col2,col3,list
        };
        int lineCount = 600000;

        for(int i=0;i<lineCount; i++) {
            String [] line = new String[formats.length];
            for(int f=0;f<formats.length;f++) line[f] = String.format(formats[f],i);
            lines.add(line);
        }

        System.out.println("Lines ready");

        EntityFeature customerFeature = new EntityFeature("BILL_TO_CUSTOMER_ID",headers);
        EntityFeature vendorFeature = new EntityFeature("VENDOR_ID",headers);
        EntityFeature mfrFeature = new EntityFeature("MFR_CODE",headers);
        ProductFeature productFeature = new ProductFeature("PRODUCT_ID",
                new LinkedHashSet<String>(Arrays.asList("PRODUCT_DESCRIPTION")),headers);


        PricingFeature pricingFeature = new PricingFeature(headers,"BASE","COL1","COL2","COL3","LIST"  );
        TradeFeature saleFeature = new TradeFeature();
        Map<String,EntityFeature> entities = new LinkedHashMap<String, EntityFeature>();
        entities.put("customer",customerFeature);
        entities.put("vendor",vendorFeature);
        entities.put("manufacturer",mfrFeature);
        saleFeature.setEntityFeatures(entities);
        saleFeature.setPricingFeature(pricingFeature);
        saleFeature.setProductFeature(productFeature);

        List<Trade> trades = new ArrayList<Trade>();
        for(String[]line:lines) {
            Trade sale = saleFeature.scan(line);
            trades.add(sale);
        }

        //Assert.assertEquals(2, trades.size());

        String [] entitiesNames = new String []{"vendor","customer","manufacturer"};

        for(Trade t : trades) {
            Assert.assertNotNull(t);
            for(String n:entitiesNames) {
                Entity e = t.get(n);
                Assert.assertNotNull("Missing entity type "+n,e);
                Assert.assertNotNull(n+" should have an id ", e.getId());
                Assert.assertNotNull(n+" should have an id.code ", e.getId().getCode());
            }
        }


        Assert.assertNotNull(trades);

    }


    public static void main(String[] args) {
        SaleFeatureTest t = new SaleFeatureTest();
        t.testSalesFeature();
    }
}
