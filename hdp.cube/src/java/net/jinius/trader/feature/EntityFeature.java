package net.jinius.trader.feature;

import net.jinius.trader.Entity;
import net.jinius.trader.Identity;
import net.jinius.trader.IdentityStringValues;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static net.jinius.trader.feature.indexed.AbstractIndexedFeature.findIndex;
import static net.jinius.trader.feature.indexed.AbstractIndexedFeature.findTarget;

/**
 *
 */
public class EntityFeature implements Feature<Entity,String[]>{

    private IdentityStringValuesFeature isvFeature;

    public EntityFeature(String idKey,String [] keys ) {
        this(idKey, null, keys);
    }
    public EntityFeature(String idKey, Set<String> names, String [] keys ) {
        isvFeature = new IdentityStringValuesFeature(idKey,names, keys);
    }

    public Entity scan(String[] record) {
        IdentityStringValues isv = isvFeature.scan(record);
        Entity e = new Entity(isv.getIdentity());
        e.setValues(isv.getValues());
        return e;
    }
}
