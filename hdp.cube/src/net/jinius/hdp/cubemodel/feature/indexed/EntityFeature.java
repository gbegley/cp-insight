package net.jinius.hdp.cubemodel.feature.indexed;

import net.jinius.hdp.cubemodel.Entity;
import net.jinius.hdp.cubemodel.feature.Feature;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static net.jinius.hdp.cubemodel.feature.indexed.AbstractIndexedFeature.findIndex;
import static net.jinius.hdp.cubemodel.feature.indexed.AbstractIndexedFeature.findTarget;

/**
 *
 */
public class EntityFeature implements Feature<Entity,String[]> {

    String idKey;
    Integer idIndex;
    LinkedHashMap<String,Integer> nameToIndexMap = new LinkedHashMap<String,Integer>();

    public EntityFeature(String idKey,String [] keys ) {
        this(idKey, null, keys);
    }
    public EntityFeature(String idKey, Set<String> names, String [] keys ) {
        this.idKey = idKey;
        idIndex = findIndex(idKey,keys);
        if(names!=null) for(String n:names) {
            Integer i = findIndex(n,keys);
            if(i>=0) nameToIndexMap.put(n,i);
        }
    }

    @Override
    public Entity scan(String[] record) {
        String id = findTarget(idIndex,record);
        Entity e = new Entity(id);
        for(Map.Entry<String,Integer> me : nameToIndexMap.entrySet()) {
            Integer i = me.getValue();
            String v = i!=null && i > 0 && i < record.length ? record[i] : null;
            if(v!=null) {
                e.put(me.getKey(),v);
            }
        }
        return e;
    }
}
