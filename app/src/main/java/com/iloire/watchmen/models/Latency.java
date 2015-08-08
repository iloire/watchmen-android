
package com.iloire.watchmen.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Latency {

    private java.util.List<com.iloire.watchmen.models.List> list = new ArrayList<com.iloire.watchmen.models.List>();
    private int mean;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<com.iloire.watchmen.models.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<com.iloire.watchmen.models.List> list) {
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
