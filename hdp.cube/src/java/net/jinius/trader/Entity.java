package net.jinius.trader;

import net.jinius.trader.values.StringValues;

/**
 */
public class Entity extends StringValues {

    protected Identity id;

    public Entity(Identity id) {
        this.id = id;
    }

    public Entity(Identity id, Type type) {
        this.id = id;
        this.type = type;
    }

    public Identity getId() {
        return id;
    }

    public void setId(Identity id) {
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"").append("id").append("\":\"").append(id).append("\"");
        for(String k:getValues().keySet()){
            sb.append(",\"").append(k).append("\":\"").append(get(k)).append("\"");
        }
        sb.append("}");
        return sb.toString();
    }



}
