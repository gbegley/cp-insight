package net.jinius.trader.feature;

import net.jinius.trader.Entity;
import net.jinius.trader.Identity;
import net.jinius.trader.IdentityStringValues;
import net.jinius.trader.values.StringValues;
import net.jinius.trader.values.Values;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static net.jinius.trader.feature.indexed.AbstractIndexedFeature.findIndex;
import static net.jinius.trader.feature.indexed.AbstractIndexedFeature.findTarget;

/**
 *
 */
public class IdentityStringValuesFeature implements Feature<IdentityStringValues,String[]> {

    String idKey;
    Integer idIndex;
    LinkedHashMap<String,Integer> nameToIndexMap = new LinkedHashMap<String,Integer>();

    public IdentityStringValuesFeature(String idKey, String[] keys) {
        this(idKey, null, keys);
    }
    public IdentityStringValuesFeature(String idKey, Set<String> names, String[] keys) {
        this.idKey = idKey;
        idIndex = findIndex(idKey,keys);
        if(names!=null) for(String n:names) {
            Integer i = findIndex(n,keys);
            if(i>=0) nameToIndexMap.put(n,i);
        }
    }

    @Override
    public IdentityStringValues scan(String[] record) {
        String id = findTarget(idIndex,record);
        Identity identity = new Identity(id);
        StringValues sv = new StringValues();
        for(Map.Entry<String,Integer> me : nameToIndexMap.entrySet()) {
            Integer i = me.getValue();
            String v = i!=null && i > 0 && i < record.length ? record[i] : null;
            if(v!=null) {
                sv.getValues().put(me.getKey(), v);
            }
        }
        return new IdentityStringValues(identity,sv);
    }
}
