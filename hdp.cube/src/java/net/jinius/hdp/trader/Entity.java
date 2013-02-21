package net.jinius.hdp.trader;

import java.util.LinkedHashMap;

/**
 */
public class Entity extends LinkedHashMap<String, String>{

    protected Object id;

    public Entity(Object id) {
        this.id = id;
    }

    public static enum Type {
        MANUFACTURER,
        VENDOR,
        SELLER,
        INSIDE,
        OUTSIDE(true),
        BROKER(true),
        BUYER(true),
        CUSTOMER(true)
        ;

        boolean buyer = false;

        Type(boolean t){
            this.buyer = t;
        }

        Type(){
            this(false);
        }
    }

    protected Type type;
    public Type getType() {
        return type;
    }

    public Object getId() {
        return id;
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
