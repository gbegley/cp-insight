package net.jinius.hdp.cubemodel;

import java.util.LinkedHashMap;

/**
 */
public class Entity extends LinkedHashMap<String, String>{

    protected Object id;

    public Entity(Object id) {
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    protected EntityType type;
    public EntityType getType() {
        return type;
    }
}
