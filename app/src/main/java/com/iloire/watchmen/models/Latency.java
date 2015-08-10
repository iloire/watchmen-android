
package com.iloire.watchmen.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Latency {

    private java.util.List<LatencyRecord> list = new ArrayList<LatencyRecord>();
    private int mean;

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<LatencyRecord> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<LatencyRecord> list) {
        this.list = list;
    }

    /**
     * 
     * @return
     *     The mean
     */
    public int getMean() {
        return mean;
    }

    /**
     * 
     * @param mean
     *     The mean
     */
    public void setMean(int mean) {
        this.mean = mean;
    }
}
