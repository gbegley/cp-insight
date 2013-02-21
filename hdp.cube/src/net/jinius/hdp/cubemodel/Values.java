package net.jinius.hdp.cubemodel;

import java.util.LinkedHashMap;

/**
 *
 */
public class Values extends LinkedHashMap<String,Number> {

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int i=0;
        for(String k:keySet()){
            if(i>0) sb.append(",");
            sb.append("\"").append(k).append("\":\"").append(get(k)).append("\"");
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

}
