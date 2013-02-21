package net.jinius.hdp.cubemodel;

import java.util.LinkedHashMap;
import java.util.Map;

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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"").append("id").append("\":\"").append(id).append("\"");
        for(String k:keySet()){
            sb.append(",\"").append(k).append("\":\"").append(get(k)).append("\"");
        }
        sb.append("}");
        return sb.toString();
    }
}
