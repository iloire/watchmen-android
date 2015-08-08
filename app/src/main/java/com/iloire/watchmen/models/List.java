
package com.iloire.watchmen.models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class List {

    private long t;
    private double l;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The timestamp
     */
    public long getT() {
        return t;
    }

    /**
     * 
     * @param t
     *     The timetamp
     */
    public void setT(long t) {
        this.t = t;
    }

    /**
     * 
     * @return
     *     The latency
     */
    public double getL() {
        return l;
    }

    /**
     * 
     * @param l
     *     The latency
     */
    public void setL(double l) {
        this.l = l;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
