package net.jinius.hdp.cubemodel.feature.indexed;

import net.jinius.hdp.cubemodel.Entity;
import net.jinius.hdp.cubemodel.Pricing;
import net.jinius.hdp.cubemodel.feature.Feature;
import net.jinius.hdp.cubemodel.feature.indexed.NumberFeature;

import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static net.jinius.hdp.cubemodel.feature.indexed.AbstractIndexedFeature.findIndex;

/**
 *
 */
public class PricingFeature implements Feature<Pricing,String[]> {

    private LinkedHashMap<String,NumberFeature> nameToNumberFeatures = new LinkedHashMap<String, NumberFeature>();

    public PricingFeature( Map<String,String> keyToFormats, String [] rec ) {
        for(Map.Entry<String,String> k2f : keyToFormats.entrySet()) {
            String k = k2f.getKey();
            int index = 0, i = 0;
            for(String key : keyToFormats.keySet()) {
                String format = keyToFormats.get(key);
                if(format!=null) {
                    NumberFeature nf = new NumberFeature(key,rec);
                    nameToNumberFeatures.put(key,nf);
                }
            }
        }
    }

    public PricingFeature( String [] rec, String ... keys ) {
        for(String key : keys) {
            NumberFeature nf = new NumberFeature(key,rec);
            nameToNumberFeatures.put(key,nf);
        }
    }

    @Override
    public Pricing scan(String[] record) {
        Pricing p = new Pricing();
        for(String k:nameToNumberFeatures.keySet()) {
            NumberFeature nf = nameToNumberFeatures.get(k);
            Number n = nf.scan(record);
            p.put(k,n);
        }
        return p;
    }
}
