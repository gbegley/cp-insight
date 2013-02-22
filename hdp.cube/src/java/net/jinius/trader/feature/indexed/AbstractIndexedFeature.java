package net.jinius.trader.feature.indexed;

import net.jinius.trader.feature.Feature;

/**
 *
 */
public abstract class AbstractIndexedFeature<T,R> implements Feature<T,R> {

    protected String key;
    protected Integer index;

    protected AbstractIndexedFeature(String key, String [] keys) {
        this.key = key;
        index = findIndex(key,keys);
    }


    protected String findTarget(String [] recs){
        if(index==null||index==-1||recs.length<index) return null;
        return recs[index];
    }

    public static String findTarget(Integer index, String [] recs){
        if(index==null||index==-1||recs.length<index) return null;
        return recs[index];
    }

    public static Integer findIndex( String key, String [] keys ) {
        Integer I = -1;
        for(int i=0;i<keys.length;i++){
            if(key.equalsIgnoreCase( keys[i])) {
                I = i;
                break;
            }
        }
        return I;
    }

}
