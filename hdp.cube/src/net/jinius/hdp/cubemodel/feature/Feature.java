package net.jinius.hdp.cubemodel.feature;

/**
 *
 */
public interface Feature<T,R> {

    T scan(R record);

}
